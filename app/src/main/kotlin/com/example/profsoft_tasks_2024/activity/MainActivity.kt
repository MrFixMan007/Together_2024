package com.example.profsoft_tasks_2024.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.profsoft_tasks_2024.R

const val EXTRA_KEY = "extra_key"

class MainActivity : AppCompatActivity() {
    private lateinit var buttonNavigate: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonNavigate = findViewById(R.id.buttonMainActivityNavigate)
        buttonNavigate.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra(EXTRA_KEY, getString(R.string.extra_message))
            }
            startActivity(intent)
        }
    }
}