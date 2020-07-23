package com.digitalcreative.coronaapps.data.repository

import com.digitalcreative.coronaapps.data.model.District
import com.digitalcreative.coronaapps.data.model.MainCovid
import com.digitalcreative.coronaapps.data.model.TotalCovid
import com.digitalcreative.coronaapps.data.response.Response
import com.digitalcreative.coronaapps.retrofit.ApiClient
import com.digitalcreative.coronaapps.retrofit.ApiInterface

class NetworkRepository {
    private val apiInterface = ApiClient.getClient().create(ApiInterface::class.java)

    suspend fun getCovidData(): Response<MainCovid> {
        return apiInterface.getCovidData()
    }

    suspend fun getCovidDataPaging(page: Int): Response<List<District>> {
        return apiInterface.getCovidData(page)
    }

    suspend fun getTotal(): Response<TotalCovid> {
        return apiInterface.getTotal()
    }
}