package com.legalservices.marketplace.ui.services

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.firstapp.legalincentivemarketplace.R
import com.firstapp.legalincentivemarketplace.models.LegalService
import com.firstapp.legalincentivemarketplace.models.ProviderType
import com.firstapp.legalincentivemarketplace.models.ServiceStatus
import com.firstapp.legalincentivemarketplace.models.ServicesViewModel

class AddServiceFragment : Fragment() {

    private lateinit var serviceTitleInput: EditText
    private lateinit var serviceDescriptionInput: EditText
    private lateinit var submitServiceButton: Button

    private val viewModel: ServicesViewModel by activityViewModels()  // Shared ViewModel for adding services

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_service, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Initialize the views
        serviceTitleInput = view.findViewById(R.id.serviceTitleInput)
        serviceDescriptionInput = view.findViewById(R.id.serviceDescriptionInput)
        submitServiceButton = view.findViewById(R.id.submitServiceButton)

        // Submit button action
        submitServiceButton.setOnClickListener {
            val title = serviceTitleInput.text.toString().trim()
            val description = serviceDescriptionInput.text.toString().trim()

            if (title.isNotEmpty() && description.isNotEmpty()) {
                // Create a service object and add to ViewModel
                val newService = LegalService(
                    id = "some_unique_id", // You can generate a unique ID or get it from a source
                    title = title,
                    description = description,
                    providerId = "provider_id", // Placeholder for providerId
                    providerName = "provider_name", // Placeholder for providerName
                    providerType = ProviderType.ADVOCATE, // Placeholder for providerType
                    status = ServiceStatus.PENDING,
                    price = 100.0 // Placeholder for price
                )
                viewModel.addService(newService)

                // Show success message
                Toast.makeText(context, "Service added successfully!", Toast.LENGTH_SHORT).show()

                // Navigate back to ServicesFragment (pop back stack)
// Send result to parent fragment
                parentFragmentManager.setFragmentResult("service_added", Bundle())

// Pop the fragment
                parentFragmentManager.popBackStack()
            }
            else {
                Toast.makeText(context, "Please fill in all fields.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        fun newInstance() = AddServiceFragment()
    }
}
