package com.example.mvvmapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.mvvmapp.viewmodel.MainViewModel
import com.example.mvvmapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        title = "Quotes app"
        mainViewModel.getRandomQuote()
        mainViewModel.randomQuote.observe(this,Observer{
            binding.loader.visibility = View.GONE
            binding.randomQuote.text = it.en
            binding.author.text = it.author
        })

        mainViewModel.error.observe(this,Observer{
            binding.loader.visibility = View.GONE
            binding.randomQuote.text = it
            binding.author.text = ""
        })
        binding.randomQuote.setOnClickListener {
            binding.loader.visibility = View.VISIBLE
            mainViewModel.getRandomQuote()
        }
        binding.btnAllQuotes.setOnClickListener {
            val i = Intent(this,QuotesList::class.java)
           startActivity(i)
        }
    }
}