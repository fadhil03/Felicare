package com.c22pc415.felicare.ui.result

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.c22pc415.felicare.ui.main.MainActivity
import com.c22pc415.felicare.databinding.ActivityResultCheckBinding
import com.c22pc415.felicare.ui.healthcheck.HealthCheckActivity
import com.c22pc415.felicare.ui.history.HistoryActivity

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