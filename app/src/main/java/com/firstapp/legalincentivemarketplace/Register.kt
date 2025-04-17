package com.firstapp.legalincentivemarketplace

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.legalservices.marketplace.ui.dashboard.Dashboard
class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        val btn = findViewById<Button>(R.id.submitButton)
        val signIn = findViewById<Button>(R.id.textView)
        val name = findViewById<EditText>(R.id.nameInput)
        val email = findViewById<EditText>(R.id.emailInput)
        val phone = findViewById<EditText>(R.id.phoneInput)
        val providertype=findViewById<EditText>(R.id.providerType)


        btn.setOnClickListener {
            if (name.text.toString().isNotEmpty() && email.text.toString().isNotEmpty() && phone.text.toString().isNotEmpty()) {
                // Corrected Intent code
                val sharedPref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

                val editor = sharedPref.edit()
                editor.putString("username", name.text.toString())
                editor.putString("email", email.text.toString())
                editor.putString("password", 123456.toString())
                editor.putString("providerType", providertype.text.toString())

                editor.apply() // or editor.commit()

                val intent = Intent(this@Register, MainActivity::class.java)
                intent.putExtra("USER_NAME", name.text.toString()) // Pass the actual user name
                startActivity(intent)
            } else {
                showCustomToast("Fill the Credentials")
            }
        }

        signIn.setOnClickListener {
            // Hide the form layout
            val formLayout = findViewById<LinearLayout>(R.id.formLayout)
            formLayout?.visibility = View.GONE

            // Show the fragment container
            val container = findViewById<FrameLayout>(R.id.fragmentContainer)
            container?.visibility = View.VISIBLE

            loadFragment(LoginFragment.newInstance())
        }
    }

    private fun loadFragment(fragment: Fragment): Boolean {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
        return true
    }
    private fun showCustomToast(message: String) {
        val inflater = layoutInflater
        val layout = inflater.inflate(R.layout.custom_toast, findViewById(R.id.toastContainer))

        // Set the message to the TextView inside the custom toast
        val toastMessage: TextView = layout.findViewById(R.id.toastMessage)
        toastMessage.text = message

        // Create and show the custom Toast
        val customToast = Toast(applicationContext)
        customToast.duration = Toast.LENGTH_SHORT
        customToast.view = layout
        customToast.setGravity(android.view.Gravity.CENTER, 0, 0)
        customToast.show()
    }
}
