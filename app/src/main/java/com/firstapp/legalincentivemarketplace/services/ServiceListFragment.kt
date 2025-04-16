package com.firstapp.legalincentivemarketplace.services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.firstapp.legalincentivemarketplace.R
import com.firstapp.legalincentivemarketplace.models.LegalService
import com.firstapp.legalincentivemarketplace.models.ProviderType
import com.firstapp.legalincentivemarketplace.models.ServiceStatus
import com.legalservices.marketplace.ui.services.ServiceAdapter

class ServiceListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var adapter: ServiceAdapter
    private var status: ServiceStatus? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_service_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.servicesRecyclerView)
        swipeRefreshLayout = view.findViewById(R.id.swipeRefresh)
        setupRecyclerView()
        setupSwipeRefresh()
        loadServices()
    }

    private fun setupRecyclerView() {
        adapter = ServiceAdapter(emptyList()) { service ->
            // TODO: Handle service click
            Toast.makeText(context, "Selected: ${service.title}", Toast.LENGTH_SHORT).show()
        }
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter
    }

    private fun setupSwipeRefresh() {
        swipeRefreshLayout.setOnRefreshListener {
            loadServices()
        }
    }

    private fun loadServices() {
        // TODO: Replace with actual API call
        val mockServices = createMockServices()
        val filteredServices = if (status != null) {
            mockServices.filter { it.status == status }
        } else {
            mockServices
        }
        adapter.updateServices(filteredServices)
        swipeRefreshLayout.isRefreshing = false
    }

    private fun createMockServices(): List<LegalService> {
        return listOf(
            LegalService(
                id = "1",
                title = "Legal Document Review",
                description = "Professional review of legal documents and contracts",
                providerId = "p1",
                providerName = "John Doe",
                providerType = ProviderType.ADVOCATE,
                status = ServiceStatus.ACTIVE,
                price = 5000.0
            ),
            LegalService(
                id = "1",
                title = "Contract Drafting",
                description = "Service for drafting legally binding contracts for various purposes",
                providerId = "p11",
                providerName = "John Carter",
                providerType = ProviderType.CONTRACT_LAWYER,
                status = ServiceStatus.PENDING,
                price = 1800.0
            ),

            LegalService(
                id = "1",
                title = "Tax Consultation",
                description = "Legal consultation for individual and business tax-related matters",
                providerId = "p12",
                providerName = "Rachel Green",
                providerType = ProviderType.TAX_LAWYER,
                status = ServiceStatus.COMPLETED,
                price = 3500.0
            ),

            LegalService(
                id = "1",
                title = "Estate Planning",
                description = "Legal services for planning and distributing estates after death",
                providerId = "p13",
                providerName = "Daniel Evans",
                providerType = ProviderType.ESTATE_LAWYER,
                status = ServiceStatus.COMPLETED,
                price = 4000.0
            ),

            LegalService(
                id = "1",
                title = "Civil Litigation",
                description = "Service for representing clients in civil lawsuits and disputes",
                providerId = "p14",
                providerName = "Jessica Taylor",
                providerType = ProviderType.LITIGATOR,
                status = ServiceStatus.PENDING,
                price = 5000.0
            ),

            LegalService(
                id = "1",
                title = "Personal Injury Claim",
                description = "Legal assistance for filing personal injury claims",
                providerId = "p15",
                providerName = "Oliver Miller",
                providerType = ProviderType.PERSONAL_INJURY_LAWYER,
                status = ServiceStatus.ACTIVE,
                price = 3000.0
            ),

            LegalService(
                id = "2",
                title = "Criminal Defense",
                description = "Legal representation for clients accused of criminal offenses",
                providerId = "p16",
                providerName = "Sophia Wilson",
                providerType = ProviderType.CRIMINAL_LAWYER,
                status = ServiceStatus.COMPLETED,
                price = 6000.0
            ),

            LegalService(
                id = "2",
                title = "Business Litigation",
                description = "Representation for businesses in disputes, contracts, and more",
                providerId = "p17",
                providerName = "James White",
                providerType = ProviderType.BUSINESS_LAWYER,
                status = ServiceStatus.PENDING,
                price = 4500.0
            ),

            LegalService(
                id = "2",
                title = "Family Law Consultation",
                description = "Legal consultation for family-related issues like child custody, divorce, etc.",
                providerId = "p18",
                providerName = "Emily Garcia",
                providerType = ProviderType.FAMILY_LAWYER,
                status = ServiceStatus.PENDING,
                price = 2500.0
            ),

            LegalService(
                id = "2",
                title = "Bankruptcy Filing",
                description = "Service for individuals and businesses filing for bankruptcy",
                providerId = "p19",
                providerName = "David Harris",
                providerType = ProviderType.BANKRUPTCY_LAWYER,
                status = ServiceStatus.COMPLETED,
                price = 4000.0
            ),

            LegalService(
                id = "2",
                title = "Real Estate Transactions",
                description = "Legal assistance for buying, selling, or leasing real estate properties",
                providerId = "p20",
                providerName = "Olivia King",
                providerType = ProviderType.REAL_ESTATE_LAWYER,
                status = ServiceStatus.PENDING,
                price = 5000.0
            ),

            LegalService(
                id = "2",
                title = "Trademark Registration",
                description = "Service to assist businesses and individuals in registering trademarks",
                providerId = "p21",
                providerName = "Lucas Scott",
                providerType = ProviderType.INTELLECTUAL_PROPERTY_LAWYER,
                status = ServiceStatus.COMPLETED,
                price = 3500.0
            ),

            LegalService(
                id = "2",
                title = "Mediation Services",
                description = "Mediation for resolving disputes outside of the courtroom",
                providerId = "p22",
                providerName = "Chloe Martinez",
                providerType = ProviderType.MEDIATOR,
                status = ServiceStatus.COMPLETED,
                price = 2000.0
            ),

            LegalService(
                id = "2",
                title = "Non-Disclosure Agreements",
                description = "Service for drafting and reviewing non-disclosure agreements (NDAs)",
                providerId = "p23",
                providerName = "Ethan Lewis",
                providerType = ProviderType.CONTRACT_LAWYER,
                status = ServiceStatus.PENDING,
                price = 2200.0
            ),

            LegalService(
                id = "2",
                title = "Legal Advice for Startups",
                description = "Legal counsel and advice for newly established startups",
                providerId = "p24",
                providerName = "Liam Clark",
                providerType = ProviderType.STARTUP_LAWYER,
                status = ServiceStatus.ACTIVE,
                price = 4500.0
            ),

            LegalService(
                id = "2",
                title = "Consumer Rights Protection",
                description = "Legal services to protect consumer rights in business transactions",
                providerId = "p25",
                providerName = "Isabella Allen",
                providerType = ProviderType.CONSUMER_LAWYER,
                status = ServiceStatus.COMPLETED,
                price = 1800.0
            ),

            LegalService(
                id = "2",
                title = "Product Liability Claims",
                description = "Legal assistance in filing claims for defective product injuries",
                providerId = "p26",
                providerName = "Mason Young",
                providerType = ProviderType.PRODUCT_LIABILITY_LAWYER,
                status = ServiceStatus.PENDING,
                price = 4000.0
            ),

            LegalService(
                id = "2",
                title = "Environmental Law Consultation",
                description = "Consultation regarding legal matters on environmental regulations and compliance",
                providerId = "p27",
                providerName = "Ava Walker",
                providerType = ProviderType.ENVIRONMENTAL_LAWYER,
                status = ServiceStatus.ACTIVE,
                price = 3500.0
            ),

            LegalService(
                id = "2",
                title = "Adoption Services",
                description = "Legal services for families looking to adopt children",
                providerId = "p28",
                providerName = "Henry Nelson",
                providerType = ProviderType.FAMILY_LAWYER,
                status = ServiceStatus.COMPLETED,
                price = 2800.0
            ),

            LegalService(
                id = "2",
                title = "Legal Advice on Data Privacy",
                description = "Service providing legal advice on data protection and privacy laws",
                providerId = "p29",
                providerName = "Ella King",
                providerType = ProviderType.DATA_PRIVACY_LAWYER,
                status = ServiceStatus.PENDING,
                price = 3000.0
            ),
            LegalService(
                id = "3",
                title = "Franchise Agreement Drafting",
                description = "Legal service for drafting franchise agreements for businesses",
                providerId = "p30",
                providerName = "Daniel Moore",
                providerType = ProviderType.FRANCHISE_LAWYER,
                status = ServiceStatus.ACTIVE,
                price = 3200.0
            ),
               LegalService (
                id = "3",
                title = "Property Documentation",
                description = "Complete property documentation services",
                providerId = "p2",
                providerName = "Jane Smith",
                providerType = ProviderType.DOCUMENT_WRITER,
                status = ServiceStatus.PENDING,
                price = 3000.0
            ),
            LegalService(
                id = "3",
                title = "Will Preparation",
                description = "Service for drafting a legally binding will and testament",
                providerId = "p4",
                providerName = "Alice Johnson",
                providerType = ProviderType.ATTORNEY,
                status = ServiceStatus.PENDING,
                price = 1500.0
            ),

            LegalService(
                id = "3",
                title = "Property Dispute Resolution",
                description = "Resolution service for resolving property-related legal disputes",
                providerId = "p5",
                providerName = "James Smith",
                providerType = ProviderType.LITIGATOR,
                status = ServiceStatus.PENDING,
                price = 5000.0
            ),

            LegalService(
                id = "3",
                title = "Divorce Consultation",
                description = "Legal consultation for individuals seeking divorce and related matters",
                providerId = "p6",
                providerName = "Samantha Brown",
                providerType = ProviderType.FAMILY_LAWYER,
                status = ServiceStatus.COMPLETED,
                price = 3000.0
            ),

            LegalService(
                id = "3",
                title = "Business Incorporation",
                description = "Service for registering a business and completing the incorporation process",
                providerId = "p7",
                providerName = "Michael Lee",
                providerType = ProviderType.CORPORATE_LAWYER,
                status = ServiceStatus.PENDING,
                price = 3500.0
            ),

            LegalService(
                id = "3",
                title = "Intellectual Property Registration",
                description = "Service for registering trademarks, copyrights, or patents",
                providerId = "p8",
                providerName = "Linda Davis",
                providerType = ProviderType.INTELLECTUAL_PROPERTY_LAWYER,
                status = ServiceStatus.ACTIVE,
                price = 4000.0
            ),

            LegalService(
                id = "3",
                title = "Immigration Application Assistance",
                description = "Assistance in filing immigration and visa applications",
                providerId = "p9",
                providerName = "David Martinez",
                providerType = ProviderType.IMMIGRATION_LAWYER,
                status = ServiceStatus.COMPLETED,
                price = 2500.0
            ),

            LegalService(
                id = "3",
                title = "Debt Collection",
                description = "Legal services for recovering owed debts",
                providerId = "p10",
                providerName = "Emily Roberts",
                providerType = ProviderType.COLLECTION_LAWYER,
                status = ServiceStatus.PENDING,
                price = 2000.0
            ),

        )
    }

    companion object {
        fun newInstance(status: ServiceStatus? = null) =
            ServiceListFragment().apply {
                this.status = status
            }
    }
}
