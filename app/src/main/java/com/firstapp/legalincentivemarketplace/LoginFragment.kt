package com.firstapp.legalincentivemarketplace

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        val name = view.findViewById<EditText>(R.id.nameInput)
        val email = view.findViewById<EditText>(R.id.emailInput)
        val password = view.findViewById<EditText>(R.id.password)
        val signInButton = view.findViewById<Button>(R.id.button)

        // Set up click listener
        signInButton.setOnClickListener {
            val nameText = name.text.toString().trim()
            val emailText = email.text.toString().trim()
            val passwordText = password.text.toString().trim()

            if (nameText.isNotEmpty() && emailText.isNotEmpty() && passwordText.isNotEmpty()) {
                val intent = Intent(activity, MainActivity::class.java)
                intent.putExtra("USER_NAME", nameText)
                startActivity(intent)
            } else {
                Toast.makeText(context, "Enter all the credentials", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }

    companion object {
        fun newInstance() = LoginFragment()
    }
}
