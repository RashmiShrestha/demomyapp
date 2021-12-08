package com.cogent.mvvmonlyrashmi

object InjectorUtils {
    fun provideQuoteViewModelFactoru():QuotesViewModelFactory
    {
        val quoteRespository= QuoteRespository.getInstance(FakeDatabase.getInstance().quoteDao)
        return  QuotesViewModelFactory(quoteRespository)
    }



}