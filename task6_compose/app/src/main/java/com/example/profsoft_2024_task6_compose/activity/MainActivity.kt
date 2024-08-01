package com.example.profsoft_2024_task6_compose.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.profsoft_2024_task6_compose.R

const val EXTRA_KEY = "extra_key"

class MainActivity : AppCompatActivity() {
    private lateinit var btnNavigateToSecondActivity: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNavigateToSecondActivity = findViewById(R.id.buttonMainNavToSecondActivity)
        btnNavigateToSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra(EXTRA_KEY, getString(R.string.extra_message))
            }
            startActivity(intent)
        }
    }
}