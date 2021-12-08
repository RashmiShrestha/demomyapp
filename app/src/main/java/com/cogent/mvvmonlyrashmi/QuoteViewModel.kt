package com.cogent.mvvmonlyrashmi

import androidx.lifecycle.ViewModel

class QuoteViewModel(private val quoteRespository: QuoteRespository): ViewModel(){
    fun getQuotes()=quoteRespository.getQuotes()
    fun addQuote(quote:Quote)=quoteRespository.addQuote(quote)

}