package com.example.demo1
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.demo1.model.UserManager

class Adduser : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.adduser)

        val usernameEditText: EditText = findViewById(R.id.username)
        val emailEditText: EditText = findViewById(R.id.email)
        val passwordEditText: EditText = findViewById(R.id.password)
        val fullNameEditText: EditText = findViewById(R.id.fullname)
        val registerButton: Button = findViewById(R.id.registerButton)
        val resetButton: Button = findViewById(R.id.resetButton)

        // Set up the Register button click listener
        registerButton.setOnClickListener {
            val fullName = fullNameEditText.text.toString()
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val email = emailEditText.text.toString()

            // Validate input
            if (fullName.isBlank() || username.isBlank() || password.isBlank() || email.isBlank()) {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Call the register function from UserManager
            val isRegistered = UserManager.register(username, password, email, fullName)

            if (isRegistered) {
                Toast.makeText(this, "Registration successful", Toast.LENGTH_SHORT).show()

                // Redirect to UserHomeActivity after registration
                val intent = Intent(this, Adduser::class.java)
                intent.putExtra("username", username)
                startActivity(intent)

                // Finish this activity to remove it from back stack
                finish()
            } else {
                Toast.makeText(this, "Registration failed. User might already exist.", Toast.LENGTH_SHORT).show()
            }
        }

        val backButton: Button = findViewById(R.id.buttonBack)
        backButton.setOnClickListener {
            // Go back to the previous activity
            finish()  // This will close the current activity and go back to the previous one
        }

        // Set up the Reset button click listener
        resetButton.setOnClickListener {
            // Clear all input fields
            usernameEditText.text.clear()
            emailEditText.text.clear()
            passwordEditText.text.clear()
            fullNameEditText.text.clear()
        }



    }
}