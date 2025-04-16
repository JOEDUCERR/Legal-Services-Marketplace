package com.legalservices.marketplace.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firstapp.legalincentivemarketplace.R
import com.firstapp.legalincentivemarketplace.models.LegalRequest
import com.firstapp.legalincentivemarketplace.models.LegalService
import com.firstapp.legalincentivemarketplace.models.ProviderType
import com.firstapp.legalincentivemarketplace.models.RequestsAdapter
import com.firstapp.legalincentivemarketplace.models.ServiceStatus

class Dashboard : Fragment() {

    private lateinit var welcomeText: TextView
    private lateinit var pointsText: TextView
    private lateinit var requestsRecyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        welcomeText = view.findViewById(R.id.welcomeText)
        pointsText = view.findViewById(R.id.pointsText)
        requestsRecyclerView = view.findViewById(R.id.requestsRecyclerView)

        val username = arguments?.getString("USER_NAME") // Retrieve username from arguments
        welcomeText.text = "Welcome back, $username!" // Display the username in the TextView

        setupRecyclerView()
        loadDashboardData()
    }

    private fun setupRecyclerView() {
        val dummyRequests = listOf(
            LegalRequest(
                id = "3",
                title = "Franchise Agreement Drafting",
                description = "Legal service for drafting franchise agreements for businesses",
                providerId = "p30",
                providerName = "Daniel Moore",
                providerType = ProviderType.FRANCHISE_LAWYER,
                status = ServiceStatus.ACTIVE,
                price = 3200.0
            ),
            LegalRequest(
                id = "2",
                title = "Legal Advice on Data Privacy",
                description = "Service providing legal advice on data protection and privacy laws",
                providerId = "p29",
                providerName = "Ella King",
                providerType = ProviderType.DATA_PRIVACY_LAWYER,
                status = ServiceStatus.PENDING,
                price = 3000.0
            ),
            LegalRequest(
                id = "2",
                title = "Adoption Services",
                description = "Legal services for families looking to adopt children",
                providerId = "p28",
                providerName = "Henry Nelson",
                providerType = ProviderType.FAMILY_LAWYER,
                status = ServiceStatus.COMPLETED,
                price = 2800.0
            ),
        )
        requestsRecyclerView.layoutManager = LinearLayoutManager(context)
        requestsRecyclerView.adapter = RequestsAdapter(dummyRequests)
    }

    private fun loadDashboardData() {
        // TODO: Load user data and update UI
        pointsText.text = "Your Incentive Points: 350"
    }

    companion object {
        fun newInstance(username: String): Dashboard {
            val fragment = Dashboard()
            val bundle = Bundle()
            bundle.putString("USER_NAME", username)
            fragment.arguments = bundle
            return fragment
        }
    }
}
