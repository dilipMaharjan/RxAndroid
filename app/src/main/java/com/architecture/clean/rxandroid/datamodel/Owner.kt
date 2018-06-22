package com.architecture.clean.rxandroid.datamodel

import com.squareup.moshi.Json

data class Owner(@Json(name = "avatar_url") val avatar_url: String, @Json(name = "html_url") val html_url: String)