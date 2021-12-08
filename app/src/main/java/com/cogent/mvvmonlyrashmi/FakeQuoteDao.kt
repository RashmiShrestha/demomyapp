package com.cogent.mvvmonlyrashmi

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeQuoteDao {
    private val quotList= mutableListOf<Quote>()
    private val quotes= MutableLiveData<List<Quote>>()
    init {
        quotes.value =quotList
    }
    fun addQuote(quote: Quote){
        quotList.add(quote)
        quotes.value= quotList
    }
    fun getQuote() = quotes as LiveData<List<Quote>>

}