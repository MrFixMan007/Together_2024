package com.example.profsoft_2024_task5_recycler.presentation

import android.content.Context
import android.graphics.Rect
import android.os.Bundle
import android.util.TypedValue
import android.util.TypedValue.COMPLEX_UNIT_DIP
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.profsoft_2024_task5_recycler.R
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
    private var isAnimating = false
    private lateinit var indicators: Array<ImageView>
    private var selectedIndicator = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        context = binding.root.context
        init()
    }

    private fun init() = with(binding) {
        recyclerView.layoutManager = LinearLayoutManager(context)
        val concatAdapter = ConcatAdapter(firstAdapter, secondAdapter)
        recyclerView.adapter = concatAdapter
        addItemDecoration(recyclerView)

        indicators = arrayOf(
            indicator1,
            indicator2,
            indicator3,
            indicator4,
            indicator5,
        )

        buttonAddToRecycler.setOnClickListener {
            firstAdapter.addItem(TextViewItem(text = "item "))
            secondAdapter.addItem(TextViewItem(text = "item", type = SimpleAdapter.WITH_BACKGROUND))
        }

        swipeRefreshLayout.setOnRefreshListener {
            refreshContent()
            swipeRefreshLayout.isRefreshing = false
        }

        val inAnimation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.slide_in_right)
        val outAnimation = AnimationUtils.loadAnimation(this@MainActivity, R.anim.slide_out_left)
        inAnimation.setAnimationListener(MyAnimationListener(this@MainActivity))

        viewFlipper.inAnimation = inAnimation
        viewFlipper.outAnimation = outAnimation
        viewFlipper.setOnClickListener {
            if (!isAnimating) {
                viewFlipper.showNext()
                setIndicator(selectedIndicator + 1)
            }
        }
    }

    private fun setIndicator(index: Int = 0) {
        val localIndex = if (index >= indicators.size) 0 else index
        for (i in indicators.indices) {
            indicators[i].setImageResource(if (i == localIndex) R.drawable.indicator_selected else R.drawable.indicator_unselected)
        }
        selectedIndicator = localIndex
    }

    private fun refreshContent() = with(binding) {
        firstAdapter.clearAll()
        secondAdapter.clearAll()
        if (viewFlipper.displayedChild != 0) {
            viewFlipper.displayedChild = 0
            setIndicator()
        }
    }

    private fun addItemDecoration(recyclerView: RecyclerView, padding: Int = 6) {
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
                    padding + 0.5f,
                    resources.displayMetrics
                ).toInt()
            }
        })
    }

    private class MyAnimationListener(private val activity: MainActivity) :
        Animation.AnimationListener {
        override fun onAnimationStart(animation: Animation) {
            activity.isAnimating = true
        }

        override fun onAnimationEnd(animation: Animation) {
            activity.isAnimating = false
        }

        override fun onAnimationRepeat(animation: Animation) {}
    }
}