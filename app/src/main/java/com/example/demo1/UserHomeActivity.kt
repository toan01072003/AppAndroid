package com.example.demo1

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class UserHomeActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.userhome)

        val welcomeTextView: TextView = findViewById(R.id.welcomeTextView)

        // Set text or perform other operations
        val username = intent.getStringExtra("username")
        welcomeTextView.text = "Hello, welcome $username"


        val openNewActivityButton: Button = findViewById(R.id.btnadduser)
        openNewActivityButton.setOnClickListener {
            // Create an Intent to start SecondActivity
            val intent = Intent(this, Adduser::class.java);
            startActivity(intent)
        }

        val openEdit: Button = findViewById(R.id.btnedituser)
        openEdit.setOnClickListener {
            // Create an Intent to start SecondActivity
            val intent = Intent(this, Search::class.java);
            startActivity(intent)
        }
    }


    }
