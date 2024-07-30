package com.example.profsoft_2024_task5_recycler.presentation

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.profsoft_2024_task5_recycler.databinding.ActivityMainBinding
import com.example.profsoft_2024_task5_recycler.presentation.adapter.SimpleAdapter
import com.example.profsoft_2024_task5_recycler.presentation.adapter.TextViewItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = SimpleAdapter()
    private lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = binding.main.context
        init()
    }

    private fun init() = with(binding) {
        firstRecyclerView.layoutManager = LinearLayoutManager(context)
        firstRecyclerView.adapter = adapter
        buttonAddToRecycler.setOnClickListener {
            adapter.addItem(TextViewItem(text = "Hi!!!"))
        }
    }
}