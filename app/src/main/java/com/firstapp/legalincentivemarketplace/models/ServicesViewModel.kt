package com.firstapp.legalincentivemarketplace.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ServicesViewModel : ViewModel() {

    private val _services = MutableLiveData<List<LegalService>>(emptyList())
    val services: LiveData<List<LegalService>> = _services

    fun addService(service: LegalService) {
        val currentList = _services.value ?: emptyList()
        _services.value = currentList + service
    }
}
