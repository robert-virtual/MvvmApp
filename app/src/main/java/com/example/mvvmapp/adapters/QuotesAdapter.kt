package com.example.mvvmapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmapp.R
import com.example.mvvmapp.model.Quote

class QuotesAdapter(private val quotes:List<Quote>):RecyclerView.Adapter<QuotesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return QuotesViewHolder(layoutInflater.inflate(R.layout.quote_item,parent,false))
    }

    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {
        holder.render(quotes[position])
    }

    override fun getItemCount(): Int {
        return quotes.size
    }
}