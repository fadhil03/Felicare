package com.c22pc415.felicare.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.c22pc415.felicare.MainActivity
import com.c22pc415.felicare.databinding.ActivityLoginBinding
import com.c22pc415.felicare.ui.component.CustomDialog
import com.c22pc415.felicare.ui.register.RegisterActivity
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.EmailAuthProvider
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private lateinit var auth : FirebaseAuth
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

     //   initActionBar()
        initFirebaseAuth()

        binding.btnLogin.setOnClickListener {
            val email = binding.etEmail.text.toString().trim()
            val pass = binding.etPassword.text.toString().trim()

            if (checkValidation(email, pass)){
                loginToServer(email, pass)
            }
        }


/*        binding.tbLogin.setNavigationOnClickListener {
            finish()
        }*/

        binding.tvOrRegis.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }



    private fun loginToServer(email: String, pass: String) {
        val credential = EmailAuthProvider.getCredential(email, pass)
        fireBaseAuth(credential)
    }

    private fun fireBaseAuth(credential: AuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener { task ->
                CustomDialog.hideLoading()
                if (task.isSuccessful) {
                    startActivity(Intent(this, MainActivity::class.java))
                    finishAffinity()
                } else {
                    Toast.makeText(this, "Sign-In failed", Toast.LENGTH_SHORT).show()
                }
            }
            .addOnFailureListener { exception ->
                CustomDialog.hideLoading()
                Toast.makeText(this, exception.message, Toast.LENGTH_SHORT).show()
            }
    }

    private fun checkValidation(email: String, pass: String): Boolean {
        if (email.isEmpty()){
            binding.etEmail.error = "Please field your email"
            binding.etEmail.requestFocus()
        }else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            binding.etEmail.error = "Please use valid email"
            binding.etEmail.requestFocus()
        }else if (pass.isEmpty()){
            binding.etEmail.error = "Please field your password"
            binding.etEmail.requestFocus()
        }else{
            return true
        }
        CustomDialog.hideLoading()
        return false
    }

    private fun initFirebaseAuth() {
        auth = FirebaseAuth.getInstance()
    }


  /*  private fun initActionBar() {
        setSupportActionBar(binding.tbLogin)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = ""
    }*/
}