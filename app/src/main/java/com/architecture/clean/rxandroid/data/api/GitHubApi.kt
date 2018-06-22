package com.architecture.clean.rxandroid.data.api

import com.architecture.clean.rxandroid.datamodel.GitHubDataModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubApi {
    @GET("/users/{user}/repos")
    fun repos(@Path("user") user: String): Call<List<GitHubDataModel>>

}