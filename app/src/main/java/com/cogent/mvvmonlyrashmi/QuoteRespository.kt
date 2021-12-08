package com.cogent.mvvmonlyrashmi

class QuoteRespository private constructor(private  val quoteDao: FakeQuoteDao){
    fun addQuote(quote :Quote){
        quoteDao.addQuote(quote)
    }
    fun getQuotes()=quoteDao.getQuote()

    companion object {
        @Volatile
        private var instance: QuoteRespository? = null
        fun getInstance(quoteDao: FakeQuoteDao) = instance ?: synchronized(lock = this) {
            instance ?: QuoteRespository(quoteDao).also { instance = it }
        }
    }
}