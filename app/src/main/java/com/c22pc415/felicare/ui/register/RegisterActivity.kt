package com.c22pc415.felicare.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import com.c22pc415.felicare.MainActivity
import com.c22pc415.felicare.R
import com.c22pc415.felicare.databinding.ActivityRegisterBinding
import com.c22pc415.felicare.ui.component.CustomDialog
import com.c22pc415.felicare.ui.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        binding.btnRegister.setOnClickListener {
            val email = binding.etEmailRegister.text.toString().trim()
            val pass = binding.etPasswordRegister.text.toString().trim()
            val confirmPass = binding.etNameCat.text.toString().trim()

            CustomDialog.showLoading(this)
            if (checkValidation(email, pass, confirmPass)){
                registerToServer(email, pass)
            }
        }

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun registerToServer(email: String, pass: String) {
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener{task ->
                CustomDialog.hideLoading()
                if (task.isSuccessful){
                    startActivity(Intent(this, MainActivity::class.java))
                    finishAffinity()
                }
            }
            .addOnFailureListener{
                CustomDialog.hideLoading()
                Toast.makeText(this, "Authentication failed", Toast.LENGTH_SHORT).show()
            }
    }

    private fun checkValidation(email: String, pass: String, confirmPass: String): Boolean {
        if (email.isEmpty()){
            binding.etEmailRegister.error = "Please field your email"
            binding.etEmailRegister.requestFocus()
        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.etEmailRegister.error = "Please use valida email"
            binding.etEmailRegister.requestFocus()
        }else if (pass.isEmpty()){
            binding.etPasswordRegister.error = "Please field your password"
            binding.etPasswordRegister.requestFocus()
        }else if (confirmPass.isEmpty()){
            binding.etNameCat.error = "Please field your confirm password"
            binding.etNameCat.requestFocus()
        }else if (pass != confirmPass){
            binding.etPasswordRegister.error = "Your pass didnt match"
            binding.etNameCat.error = "Your confirm pass didnt match"

            binding.etPasswordRegister.requestFocus()
            binding.etNameCat.requestFocus()
        }else{
            binding.etPasswordRegister.error = null
            binding.etNameCat.error = null
            return true
        }
        CustomDialog.hideLoading()
        return false
    }

}