package com.architecture.clean.rxandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.architecture.clean.rxandroid.api.BookApi
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MAINACTIVITY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Observable.just(BookApi().getBookList())
                .flatMap({
                    Observable.fromIterable(it)
                })
                .filter { it.slug == "ex" }
                .subscribe {
                    Log.i(TAG, it.name)
                    tv.text = it.name
                }
    }
}
