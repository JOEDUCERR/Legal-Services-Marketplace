package com.firstapp.legalincentivemarketplace.models

enum class ServiceStatus {
    ACTIVE,
    COMPLETED,
    PENDING
}
// Assuming you have a Service class that LegalService should implement or extend
data class Service(
    val id: String,
    val title: String,
    val description: String,
    val providerId: String,
    val providerName: String,
    val status: ServiceStatus,
    val price: Double, // This also needs to be passed
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)


data class LegalService(
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
