package com.architecture.clean.rxandroid.data.database

import com.architecture.clean.rxandroid.datamodel.Book

class BookApi {
    fun getBookList(): List<Book> {
        return listOf(
                Book("Genesis", "gen"),
                Book("Exodus", "ex"),
                Book("Leviticus", "lev")
        )
    }
}