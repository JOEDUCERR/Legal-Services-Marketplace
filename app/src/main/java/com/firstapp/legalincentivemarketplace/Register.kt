package com.firstapp.legalincentivemarketplace

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

        btn.setOnClickListener {
            if (name.text.toString().isNotEmpty() && email.text.toString().isNotEmpty() && phone.text.toString().isNotEmpty()) {
                // Corrected Intent code
                val intent = Intent(this@Register, MainActivity::class.java)
                intent.putExtra("USER_NAME", name.text.toString()) // Pass the actual user name
                startActivity(intent)
            } else {
                Toast.makeText(this, "Enter all the credentials", Toast.LENGTH_SHORT).show()
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
}
