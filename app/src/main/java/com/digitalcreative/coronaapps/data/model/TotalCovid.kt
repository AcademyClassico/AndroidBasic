package com.digitalcreative.coronaapps.data.model

import com.google.gson.annotations.SerializedName

data class TotalCovid(
    @SerializedName("total_penduduk_positif")
    val positive: Int,

    @SerializedName("total_penduduk_pulih")
    val recovered: Int,

    @SerializedName("total_penduduk_wafat")
    val dead: Int
)