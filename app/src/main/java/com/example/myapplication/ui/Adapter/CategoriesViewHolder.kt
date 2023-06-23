package com.example.myapplication.ui.Adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemCategoryRowBinding

class CategoriesViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    val binding = ItemCategoryRowBinding.bind(view)

    fun render (category: String,  onClickListener:(String) -> Unit){
        binding.tvItemCategory.text = category
        itemView.setOnClickListener{
             onClickListener(category)
        }
    }
}