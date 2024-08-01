package com.example.profsoft_2024_task6_compose.activity

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.profsoft_2024_task6_compose.R

class SecondActivity : AppCompatActivity() {
    private lateinit var buttonNotify: Button
    private lateinit var extra: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        extra = intent.extras?.getString(EXTRA_KEY).orEmpty()
        buttonNotify = findViewById(R.id.buttonSecondActivityNotify)
        buttonNotify.setOnClickListener {
            Toast.makeText(this, extra, Toast.LENGTH_LONG).show()
        }
    }
}