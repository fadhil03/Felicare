package com.c22pc415.felicare.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.c22pc415.felicare.MainActivity
import com.c22pc415.felicare.R
import com.c22pc415.felicare.databinding.ActivityLoginBinding
import com.c22pc415.felicare.databinding.ActivityRegisterBinding
import com.c22pc415.felicare.databinding.ActivityResultCheckBinding
import com.c22pc415.felicare.ui.register.RegisterActivity

class ResultCheckActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultCheckBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityResultCheckBinding.inflate(layoutInflater)
        setContentView(binding.root)
        super.onCreate(savedInstanceState)

        binding.btnHistory.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }

        binding.btnBack.setOnClickListener {
            startActivity(Intent(this, HealthCheckActivity::class.java))
        }

        binding.btnHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }

        binding.btnTelp.setOnClickListener {
            val dialIntent = Intent(Intent.ACTION_DIAL)
            dialIntent.data = Uri.parse("tel:" + "+6281908800368")
            startActivity(dialIntent)
        }
    }
}