package com.example.profsoft_2024_task5_recycler.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.profsoft_2024_task5_recycler.R
import com.example.profsoft_2024_task5_recycler.databinding.TextItemBinding
import com.example.profsoft_2024_task5_recycler.databinding.TextItemWithBackgroundBinding
import com.example.profsoft_2024_task5_recycler.presentation.adapter.SimpleAdapter.Companion.WITHOUT_BACKGROUND

class SimpleAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val list = mutableListOf<TextViewItem>()

    companion object {
        const val WITHOUT_BACKGROUND = 1
        const val WITH_BACKGROUND = 2
    }

    class TextViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = TextItemBinding.bind(item)
        fun bind(textViewItem: TextViewItem) = with(binding) {
            textView.text = textViewItem.text
        }
    }

    class TextViewHolderWithBackground(item: View) : RecyclerView.ViewHolder(item) {
        private val binding = TextItemWithBackgroundBinding.bind(item)
        fun bind(textViewItem: TextViewItem) = with(binding) {
            textView.text = textViewItem.text
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            WITHOUT_BACKGROUND -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.text_item, parent, false)
                TextViewHolder(view)
            }

            WITH_BACKGROUND -> {
                val view =
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.text_item_with_background, parent, false)
                TextViewHolderWithBackground(view)
            }

            else -> throw IllegalArgumentException("Invalid view type")
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is TextViewHolder -> holder.bind(list[position])
            is TextViewHolderWithBackground -> holder.bind(list[position])
        }
    }

    fun addItem(textViewItem: TextViewItem) {
        list.add(textViewItem)
        notifyItemInserted(list.size - 1)
    }

    fun addItems(itemList: List<TextViewItem>) {
        val oldSize = list.size
        list.addAll(itemList)
        notifyItemRangeInserted(oldSize - 1, list.size - oldSize)
    }

    override fun getItemViewType(position: Int): Int {
        return list[position].type
    }
}

data class TextViewItem(
    val text: String,
    val type: Int = WITHOUT_BACKGROUND
)