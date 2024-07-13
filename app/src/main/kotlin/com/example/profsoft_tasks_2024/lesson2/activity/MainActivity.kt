package com.example.profsoft_tasks_2024.lesson2.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.profsoft_tasks_2024.R
import com.example.profsoft_tasks_2024.lesson3.ProfileActivity

const val EXTRA_KEY = "extra_key"

class MainActivity : AppCompatActivity() {
    private lateinit var btnNavigateToSecondActivity: Button
    private lateinit var btnNavigateToProfile: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNavigateToSecondActivity = findViewById(R.id.btnMainNavToSecondActivity)
        btnNavigateToSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java).apply {
                putExtra(EXTRA_KEY, getString(R.string.extra_message))
            }
            startActivity(intent)
        }

        btnNavigateToProfile = findViewById(R.id.btnMainNavToProfile)
        btnNavigateToProfile.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}