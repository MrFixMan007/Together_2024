package com.example.profsoft_2024_task5_recycler.presentation

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.util.TypedValue
import android.util.TypedValue.COMPLEX_UNIT_DIP
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
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
        addItemDecoration(firstRecyclerView)

        secondRecyclerView.layoutManager = LinearLayoutManager(context)
        secondRecyclerView.adapter = secondAdapter
        addItemDecoration(secondRecyclerView)

        buttonAddToRecycler.setOnClickListener {
            firstAdapter.addItem(TextViewItem(text = "Hi!!!"))
            secondAdapter.addItem(TextViewItem(text = "Lol", type = SimpleAdapter.WITH_BACKGROUND))
        }
    }

    private fun addItemDecoration(recyclerView: RecyclerView) {
        recyclerView.addItemDecoration(object : ItemDecoration() {
            override fun getItemOffsets(
                outRect: Rect,
                view: View,
                parent: RecyclerView,
                state: RecyclerView.State
            ) {
                super.getItemOffsets(outRect, view, parent, state)
                outRect.top = TypedValue.applyDimension(
                    COMPLEX_UNIT_DIP,
                    6 + 0.5f,
                    resources.displayMetrics
                ).toInt()
            }
        })
    }
}