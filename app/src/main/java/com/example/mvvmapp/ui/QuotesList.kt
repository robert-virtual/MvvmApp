package com.example.mvvmapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mvvmapp.adapters.QuotesAdapter
import com.example.mvvmapp.databinding.ActivityQuotesListBinding
import com.example.mvvmapp.model.Quote
import com.example.mvvmapp.viewmodel.MainViewModel

class QuotesList : AppCompatActivity() {

    private lateinit var binding: ActivityQuotesListBinding
    private val mainViewModel: MainViewModel by viewModels()
    private var quotes = mutableListOf<Quote>()
    private val adapter = QuotesAdapter(quotes)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuotesListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Quotes list"

        mainViewModel.getAllQuotes()
        initRecyclerView()

        mainViewModel.quotes.observe(this,Observer{
            binding.loader.visibility = View.GONE
            quotes.clear()
            quotes.addAll(it)
            adapter.notifyDataSetChanged()

            title = "Quotes: ${it.size}"
        })
    }
    private fun initRecyclerView(){
        binding.quotesList.adapter = adapter
        binding.quotesList.layoutManager = LinearLayoutManager(this)
    }
}