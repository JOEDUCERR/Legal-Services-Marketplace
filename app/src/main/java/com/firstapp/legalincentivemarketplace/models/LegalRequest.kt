package com.firstapp.legalincentivemarketplace.models

data class LegalRequest(
    val id: String,
    val title: String,
    val description: String,
    val providerId: String,
    val providerName: String,
    val providerType: ProviderType,  // This is fine; it's a ProviderType
    val status: ServiceStatus,  // This is the status field that should be a ServiceStatus
    val price: Double,  // Price is a Double
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)