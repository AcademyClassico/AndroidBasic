package com.digitalcreative.coronaapps.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.digitalcreative.coronaapps.data.pagingsource.GetCovidPagingSource
import com.digitalcreative.coronaapps.data.repository.NetworkRepository
import kotlinx.coroutines.Dispatchers

class CovidViewModel(private val networkRepository: NetworkRepository) : ViewModel() {
    private val districtsPagingSource = GetCovidPagingSource(networkRepository)

    val covidData = liveData(Dispatchers.IO) {
        val res = networkRepository.getCovidData()
        emit(res)
    }

    val covidDataPaging = Pager(
        PagingConfig(GetCovidPagingSource.PER_PAGE)
    ) {
        districtsPagingSource
    }.flow

    val totalCovid = liveData(Dispatchers.IO) {
        val res = networkRepository.getTotal()
        emit(res)
    }
}