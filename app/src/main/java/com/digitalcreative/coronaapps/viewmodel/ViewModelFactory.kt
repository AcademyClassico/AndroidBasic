package com.digitalcreative.coronaapps.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.digitalcreative.coronaapps.data.repository.NetworkRepository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory : ViewModelProvider.NewInstanceFactory() {
    private val networkRepository = NetworkRepository()

    companion object {
        fun getInstance(): ViewModelFactory {
            return ViewModelFactory()
        }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(CovidViewModel::class.java) -> CovidViewModel(networkRepository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel Class ${modelClass.name}")
        }
    }
}