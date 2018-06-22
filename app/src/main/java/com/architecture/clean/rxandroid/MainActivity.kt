package com.architecture.clean.rxandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import org.reactivestreams.Subscriber

class MainActivity : AppCompatActivity() {
    private val TAG = "MAINACTIVITY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val observable = Observable.create<Int> { subscriber ->
            subscriber.onNext(2)
            subscriber.onNext(4)
            subscriber.onNext(5)
        }
        observable.subscribeOn(Schedulers.newThread())
        observable.observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        object : Observer<Int> {
                            override fun onComplete() {
                                Log.i(TAG, "Completed")
                            }

                            override fun onError(e: Throwable) {
                                Log.i(TAG, "Error : ${e.message}")
                            }

                            override fun onNext(t: Int) {
                                if (t == 4) {
                                    Log.i(TAG, t.toString())
                                    tv.textSize = 30.0F
                                    tv.text = t.toString()
                                }
                            }

                            override fun onSubscribe(d: Disposable) {
                                Log.i(TAG, d.toString())
                            }
                        }
                )

        Observable.just(5, 6, 7)
                .map { it * 2 }
                .filter { it > 10 }
                .subscribe { Log.i("Next : ", it.toString()) }
        Observable.fromArray("apple", "ball", "cat", "dog")
                .subscribeOn(Schedulers.newThread())
                .filter { item -> item == "apple" }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe { item ->
                    tv.textSize = 40.0F
                    tv.text = item
                }
    }
}
