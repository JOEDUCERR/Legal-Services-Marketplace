package com.firstapp.legalincentivemarketplace


import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.firstapp.legalincentivemarketplace.services.ServicesFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.legalservices.marketplace.ui.dashboard.Dashboard


class MainActivity : AppCompatActivity() {

    private lateinit var bottomNav: BottomNavigationView
    private var username: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNav = findViewById(R.id.bottomNav)
        username = intent.getStringExtra("USER_NAME")

        setupBottomNavigation()
        showCustomToast("Welcome, $username!")


        if (savedInstanceState == null) {
            loadFragment(Dashboard.newInstance(username ?: "User"))
        }
    }

    private fun setupBottomNavigation() {
        bottomNav.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_dashboard -> loadFragment(Dashboard.newInstance(username ?: "User"))
                R.id.nav_services -> loadFragment(ServicesFragment.newInstance())
                R.id.nav_profile -> loadFragment(Profile.newInstance(username ?: "User"))
            }
            true
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
