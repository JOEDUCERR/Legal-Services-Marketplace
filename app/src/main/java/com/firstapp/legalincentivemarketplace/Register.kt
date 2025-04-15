package com.firstapp.legalincentivemarketplace

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)
        var btn=findViewById<Button>(R.id.submitButton);
        btn.setOnClickListener{
            var intent= Intent(this,MainActivity::class.java)
            startActivity(intent);
        }
    }
}