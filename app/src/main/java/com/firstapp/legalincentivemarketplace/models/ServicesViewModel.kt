package com.firstapp.legalincentivemarketplace.models

import android.app.Service
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ServicesViewModel : ViewModel() {

    private val _services = MutableLiveData<List<LegalService>>()
    val services: LiveData<List<LegalService>> get() = _services

    fun addService(service: LegalService) {
        val currentList = _services.value ?: emptyList()
        _services.value = currentList + service
    }
}

