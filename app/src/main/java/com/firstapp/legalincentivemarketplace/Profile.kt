package com.firstapp.legalincentivemarketplace

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.firstapp.legalincentivemarketplace.models.LegalServiceProvider
import com.firstapp.legalincentivemarketplace.models.ProviderType
import com.google.android.material.button.MaterialButton
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import com.google.android.material.imageview.ShapeableImageView
import com.legalservices.marketplace.ui.dashboard.Dashboard
class Profile : Fragment() {

    private lateinit var profileImage: ImageView
    private lateinit var nameText: TextView
    private lateinit var providerTypeText: TextView
    private lateinit var specializationChips: ChipGroup
    private lateinit var totalCasesText: TextView
    private lateinit var incentivePointsText: TextView
    private lateinit var ratingBar: RatingBar
    private lateinit var editProfileButton: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeViews(view) // Initialize views first

//        val username = arguments?.getString("USER_NAME")
// Retrieve username from arguments
        val sharedPref = requireActivity().getSharedPreferences("MyPrefs", MODE_PRIVATE)
        val username = sharedPref.getString("username", "defaultUser")
        val providerType = sharedPref.getString("providerType", "defaultUser")

//
        nameText.text = "Hello, $username!"
        providerTypeText.text =providerType
// Now set the username text

        setupEditButton()
        loadProfileData()
    }

    private fun initializeViews(view: View) {
        profileImage = view.findViewById(R.id.profileImage)
        nameText = view.findViewById(R.id.nameText)
        providerTypeText = view.findViewById(R.id.providerTypeText)
        specializationChips = view.findViewById(R.id.specializationChips)
        totalCasesText = view.findViewById(R.id.totalCasesText)
        incentivePointsText = view.findViewById(R.id.incentivePointsText)
        ratingBar = view.findViewById(R.id.ratingBar)
        editProfileButton = view.findViewById(R.id.editProfileButton)
    }

    private fun setupEditButton() {
        editProfileButton.setOnClickListener {
            // Navigate to EditProfileFragment
            val editProfileFragment = EditProfileFragment.newInstance()
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, editProfileFragment)
                .addToBackStack(null)  // Optionally, add this transaction to the back stack
                .commit()
        }
    }

    private fun loadProfileData() {
        // TODO: Load actual profile data from backend
        val mockProvider = LegalServiceProvider(
            id = "1",
            name = "John Doe",
            type = ProviderType.ADVOCATE,
            experience = 5,
            qualifications = listOf("LLB", "Bar Council"),
            barCouncilNumber = "ABC123",
            specializations = listOf("Criminal Law", "Corporate Law", "Family Law"),
            ratings = 4.5f,
            totalCases = 50,
            incentivePoints = 350,
            verified = true
        )

        updateUI(mockProvider)
    }

    private fun updateUI(provider: LegalServiceProvider) {
        totalCasesText.text = provider.totalCases.toString()
        incentivePointsText.text = provider.incentivePoints.toString()
        ratingBar.rating = provider.ratings

        specializationChips.removeAllViews()
        provider.specializations.forEach { specialization ->
            val chip = Chip(context).apply {
                text = specialization
                isCheckable = false
            }
            specializationChips.addView(chip)
        }
    }

    companion object {
        fun newInstance(username: String): Profile {
            val fragment = Profile()
            val bundle = Bundle()
            bundle.putString("USER_NAME", username)
            fragment.arguments = bundle
            return fragment
        }
    }
}
