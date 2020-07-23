package com.digitalcreative.coronaapps.data.pagingsource

import android.util.Log
import androidx.paging.PagingSource
import com.digitalcreative.coronaapps.data.model.District
import com.digitalcreative.coronaapps.data.repository.NetworkRepository

class GetCovidPagingSource(private val repository: NetworkRepository) :
    PagingSource<Int, District>() {
    companion object {
        const val PER_PAGE = 10
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, District> {
        return try {
            val nextPageNumber = params.key ?: 1
            Log.e("TAG", "load: $nextPageNumber")
            val res = repository.getCovidDataPaging(nextPageNumber)
            LoadResult.Page(res.data, null, nextPageNumber + 1)
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

}