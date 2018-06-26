package com.architecture.clean.rxandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.architecture.clean.rxandroid.data.api.GitHubApi
import com.architecture.clean.rxandroid.datamodel.GitHubDataModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {
    private val TAG = "MAINACTIVITY"
    private val repoList = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //get retrofit instance

        val retrofit = Retrofit
                .Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(MoshiConverterFactory.create()).build()

        val client = retrofit.create(GitHubApi::class.java)
        val call = client.repos("dilipMaharjan")
        call.enqueue(object : Callback<List<GitHubDataModel>> {
            override fun onResponse(call: Call<List<GitHubDataModel>>?, response: Response<List<GitHubDataModel>>?) {
                if (response != null) {
                    val response = response.body()
                    if (response != null) {
                        for (repo in response) {
                            repoList.add(repo.name)

                        }
                    }
                }
            }

            override fun onFailure(call: Call<List<GitHubDataModel>>?, t: Throwable?) {
                Log.i(TAG, t!!.message.toString())
            }
        })
    }
}
