package com.digitalcreative.coronaapps.data.model

import com.google.gson.annotations.SerializedName

data class MainCovid(
    @SerializedName("totalCovid")
    val totalCovid: TotalCovid,

    @SerializedName("covids")
    val districts: List<District>
)