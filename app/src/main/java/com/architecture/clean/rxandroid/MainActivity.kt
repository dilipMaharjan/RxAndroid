package com.architecture.clean.rxandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.reactivex.Observable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val observable = Observable.create<Int> { subscriber ->
            subscriber.onNext(5)
            subscriber.onNext(6)
            subscriber.onComplete()
        }
        observable.subscribe {
            println("next: $it")
        }

        Observable.just(5, 6, 7)
                .map { it * 2 }
                .filter { it > 10 }
                .subscribe { println(it) }
    }
}
