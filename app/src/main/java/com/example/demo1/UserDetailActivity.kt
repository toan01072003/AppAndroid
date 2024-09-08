package com.example.demo1

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.demo1.model.User
import com.example.demo1.model.UserManager

class UserDetailActivity : Activity() {

    private lateinit var usernameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var saveButton: Button
    private lateinit var deleteButton: Button
    private lateinit var currentUser: User

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.userdetailactivity)

        usernameEditText = findViewById(R.id.usernameEditText)
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        saveButton = findViewById(R.id.saveButton)
        deleteButton = findViewById(R.id.deleteButton)
        val backButton: Button = findViewById(R.id.buttonBack)

        // Get user data from intent
        val username = intent.getStringExtra("username")
        currentUser = UserManager.getUserByUsername(username!!)

        // Populate fields with current user data
        usernameEditText.setText(currentUser.username)
        emailEditText.setText(currentUser.email)
        passwordEditText.setText(currentUser.password)

        // Save button click listener
        saveButton.setOnClickListener {
            val newEmail = emailEditText.text.toString()
            val newPassword = passwordEditText.text.toString()
            UserManager.updateUser(currentUser.username, newEmail, newPassword)
            Toast.makeText(this, "User updated", Toast.LENGTH_SHORT).show()
        }

        backButton.setOnClickListener {
            finish()  // This will close the current activity and go back to the previous one
        }


        // Delete button click listener
        deleteButton.setOnClickListener {
            UserManager.deleteUser(currentUser.username)
            Toast.makeText(this, "User deleted", Toast.LENGTH_SHORT).show()
            finish() // Close activity and return to previous screen
        }
    }
}

