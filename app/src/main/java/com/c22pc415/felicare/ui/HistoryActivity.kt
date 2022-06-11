package com.c22pc415.felicare.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.c22pc415.felicare.MainActivity
import com.c22pc415.felicare.R
import com.c22pc415.felicare.ui.register.RegisterActivity

class HistoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history)

        val btnBacktoHome : Button = findViewById(R.id.btn_home)

        btnBacktoHome.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}