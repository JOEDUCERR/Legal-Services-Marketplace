package com.firstapp.legalincentivemarketplace

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.*
import android.widget.*
import com.firstapp.legalincentivemarketplace.services.ServicesFragment

class EditProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_edit_profile, container, false)

        val nameInput = view.findViewById<EditText>(R.id.nameInput)
        val emailInput = view.findViewById<EditText>(R.id.emailInput)
        val providerInput = view.findViewById<EditText>(R.id.providerType)
        val submitButton = view.findViewById<Button>(R.id.submitButton)

        submitButton.setOnClickListener {
            val name = nameInput.text.toString()
            val email = emailInput.text.toString()
            val provider = providerInput.text.toString()

            val sharedPref = requireActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()

            if (name.isNotEmpty()) editor.putString("username", name)
            if (email.isNotEmpty()) editor.putString("email", email)
            if (provider.isNotEmpty()) editor.putString("providerType", provider)

            editor.apply()
            showCustomToast("Profile Updated")
        }

        return view
    }

    private fun showCustomToast(message: String) {
        val inflater = requireActivity().layoutInflater
        val layout = inflater.inflate(R.layout.custom_toast, requireView().findViewById(R.id.toastContainer))

        val toastMessage: TextView = layout.findViewById(R.id.toastMessage)
        toastMessage.text = message

        val customToast = Toast(requireContext())
        customToast.duration = Toast.LENGTH_SHORT
        customToast.view = layout
        customToast.setGravity(Gravity.CENTER, 0, 0)
        customToast.show()
    }

    companion object {
        fun newInstance(): EditProfileFragment {
            return EditProfileFragment()
        }
    }
}
