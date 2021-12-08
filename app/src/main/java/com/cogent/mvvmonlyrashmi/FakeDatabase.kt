package com.cogent.mvvmonlyrashmi

class FakeDatabase private constructor() {
    val quoteDao = FakeQuoteDao()

    companion object {
        @Volatile
        private var instance: FakeDatabase? = null
        fun getInstance() = instance ?: synchronized(lock = this) {
            instance ?: FakeDatabase().also { instance = it }
        }
    }

}