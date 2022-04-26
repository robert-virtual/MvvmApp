package com.example.mvvmapp.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmapp.databinding.QuoteItemBinding
import com.example.mvvmapp.model.Quote

class QuotesViewHolder(view:View):RecyclerView.ViewHolder(view){
    private val binding = QuoteItemBinding.bind(view)
    fun render(quote:Quote){
        binding.author.text = quote.author
        binding.quote.text = quote.en
    }
}