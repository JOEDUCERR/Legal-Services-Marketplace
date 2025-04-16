package com.firstapp.legalincentivemarketplace.models

enum class ProviderType {
    ADVOCATE,
    ARBITRATOR,
    MEDIATOR,
    NOTARY,
    DOCUMENT_WRITER,
    IMMIGRATION_LAWYER,
    COLLECTION_LAWYER,
    INTELLECTUAL_PROPERTY_LAWYER,
    CORPORATE_LAWYER,
    FAMILY_LAWYER,
    LITIGATOR,
    ATTORNEY,
    CONTRACT_LAWYER,
    TAX_LAWYER,
    ESTATE_LAWYER,
    PERSONAL_INJURY_LAWYER,
    CRIMINAL_LAWYER,
    BUSINESS_LAWYER,
    REAL_ESTATE_LAWYER,
    BANKRUPTCY_LAWYER,
    STARTUP_LAWYER,
    CONSUMER_LAWYER,
    PRODUCT_LIABILITY_LAWYER,
    ENVIRONMENTAL_LAWYER,
    DATA_PRIVACY_LAWYER,
    FRANCHISE_LAWYER
}

data class LegalServiceProvider(
    val id: String,
    val name: String,
    val type: ProviderType,
    val experience: Int,
    val qualifications: List<String>,
    val barCouncilNumber: String? = null,
    val specializations: List<String>,
    val ratings: Float = 0f,
    val totalCases: Int = 0,
    val incentivePoints: Int = 0,
    val verified: Boolean = false
)
