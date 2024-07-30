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
    private val firstAdapter = SimpleAdapter()
    private val secondAdapter = SimpleAdapter()
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
        firstRecyclerView.adapter = firstAdapter

        secondRecyclerView.layoutManager = LinearLayoutManager(context)
        secondRecyclerView.adapter = secondAdapter

        buttonAddToRecycler.setOnClickListener {
            firstAdapter.addItem(TextViewItem(text = "Hi!!!"))
            secondAdapter.addItem(TextViewItem(text = "Lol", type = SimpleAdapter.WITH_BACKGROUND))
        }
    }
}