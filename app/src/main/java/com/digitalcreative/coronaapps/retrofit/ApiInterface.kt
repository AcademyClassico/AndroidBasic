package com.digitalcreative.coronaapps.retrofit

import com.digitalcreative.coronaapps.data.model.District
import com.digitalcreative.coronaapps.data.model.MainCovid
import com.digitalcreative.coronaapps.data.model.TotalCovid
import com.digitalcreative.coronaapps.data.response.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("covid/")
    suspend fun getCovidData(): Response<MainCovid>

    @GET("covid/page/{page}")
    suspend fun getCovidData(@Path("page") page: Int): Response<List<District>>

    @GET("covid/total/")
    suspend fun getTotal(): Response<TotalCovid>
}