package com.digitalcreative.coronaapps.data.model

import com.google.gson.annotations.SerializedName

data class District(
    @SerializedName("id")
    val id: String,

    @SerializedName("kecamatan")
    val name: String,

    @SerializedName("jumlah_penduduk_positif")
    val positive: Int,

    @SerializedName("jumlah_penduduk_pulih")
    val recovered: Int,

    @SerializedName("jumlah_penduduk_wafat")
    val dead: Int
)