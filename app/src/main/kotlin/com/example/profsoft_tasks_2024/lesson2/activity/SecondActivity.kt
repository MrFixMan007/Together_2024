package com.example.profsoft_tasks_2024.lesson2.activity

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.profsoft_tasks_2024.R

class SecondActivity : Activity() {
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