package com.cogent.mvvmonlyrashmi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializedUI()
    }

    private fun initializedUI() {
        val factory = InjectorUtils.provideQuoteViewModelFactoru()
        val viewModel = ViewModelProviders.of(this, factory).get(QuoteViewModel::class.java)
        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }

            txt_quotes.text = stringBuilder.toString()
        })
        buttonAdd.setOnClickListener {
            val quote = Quote(etQuote.text.toString(), etAuthor.text.toString())
            viewModel.addQuote(quote)
            etAuthor.setText("")
            etQuote.setText("")
        }

    }
}