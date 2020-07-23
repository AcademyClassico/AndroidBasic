package com.digitalcreative.coronaapps.data.response

data class Response<T>(
    val status: String,
    val message: String,
    val data: T
)