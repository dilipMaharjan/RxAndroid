package com.architecture.clean.rxandroid.api

import com.architecture.clean.rxandroid.data.Book

class BookApi {
    fun getBookList(): List<Book> {
        return listOf(
                Book("Genesis", "gen"),
                Book("Exodus", "ex"),
                Book("Leviticus", "lev")
        )
    }
}