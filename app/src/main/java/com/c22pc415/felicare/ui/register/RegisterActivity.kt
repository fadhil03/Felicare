package com.c22pc415.felicare.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import com.c22pc415.felicare.MainActivity
import com.c22pc415.felicare.R
import com.c22pc415.felicare.databinding.ActivityRegisterBinding
import com.c22pc415.felicare.ui.component.CustomDialog
import com.c22pc415.felicare.ui.login.LoginActivity
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    //private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        //binding = ActivityRegisterBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        setContentView(R.layout.activity_register)
        super.onCreate(savedInstanceState)

        val btnRegister : Button = findViewById(R.id.btn_register)
        val etEmailRegister : EditText = findViewById(R.id.et_email_register)
        val etPasswordRegister : EditText = findViewById(R.id.et_password_register)
        val etPasswordReenter : EditText = findViewById(R.id.et_password_reenter)
        val btnBack : ImageButton = findViewById(R.id.btn_backtologin)

        btnRegister.setOnClickListener {
            val email = etEmailRegister.text.toString().trim()
            val pass = etPasswordRegister.text.toString().trim()
            val confirmPass = etPasswordReenter.text.toString().trim()

            CustomDialog.showLoading(this)
            if (checkValidation(email, pass, confirmPass)){
                registerToServer(email, pass)
            }
        }

        btnBack.setOnClickListener {
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
        val etEmailRegister : EditText = findViewById(R.id.et_email_register)
        val etPasswordRegister : EditText = findViewById(R.id.et_password_register)
        val etPasswordReenter : EditText = findViewById(R.id.et_password_reenter)
        if (email.isEmpty()){
            etEmailRegister.error = "Please field your email"
            etEmailRegister.requestFocus()
        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            etEmailRegister.error = "Please use valida email"
            etEmailRegister.requestFocus()
        }else if (pass.isEmpty()){
            etPasswordRegister.error = "Please field your password"
            etPasswordRegister.requestFocus()
        }else if (confirmPass.isEmpty()){
            etPasswordReenter.error = "Please field your confirm password"
            etPasswordReenter.requestFocus()
        }else if (pass != confirmPass){
            etPasswordRegister.error = "Your pass didnt match"
            etPasswordReenter.error = "Your confirm pass didnt match"

            etPasswordRegister.requestFocus()
            etPasswordReenter.requestFocus()
        }else{
            etPasswordRegister.error = null
            etPasswordReenter.error = null
            return true
        }
        CustomDialog.hideLoading()
        return false
    }

}