package com.c22pc415.felicare.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.c22pc415.felicare.R

class HealthCheckActivity : AppCompatActivity() {
    //private lateinit var binding: ActivityHealthCheckBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        //binding = ActivityHealthCheckBinding.inflate(layoutInflater)
        //setContentView(binding.root)
        setContentView(R.layout.activity_health_check)
        super.onCreate(savedInstanceState)

        val btnDiagnosis : Button = findViewById(R.id.btn_diagnosis)

        btnDiagnosis.setOnClickListener {
            startActivity(Intent(this, ResultCheckActivity::class.java))
        }
    }
}