package com.legalservices.marketplace.ui.dashboard

import android.content.Context
import android.content.Context.MODE_PRIVATE
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
import com.firstapp.legalincentivemarketplace.models.ServiceStatus

class Dashboard : Fragment() {

    private lateinit var welcomeText: TextView
    private lateinit var pointsText: TextView

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

//        val username = arguments?.getString("USER_NAME")

        val sharedPref = requireActivity().getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val username = sharedPref.getString("username", "defaultUser")
// Retrieve username from arguments
        welcomeText.text = "Welcome back, $username!" // Display the username in the TextView


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
