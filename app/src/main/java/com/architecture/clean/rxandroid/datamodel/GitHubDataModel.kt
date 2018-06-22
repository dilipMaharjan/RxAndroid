package com.architecture.clean.rxandroid.datamodel

import com.squareup.moshi.Json

data class GitHubDataModel(val name: String, val description: String, @Json(name = "created_at") val created_at: String, val owner: Owner)