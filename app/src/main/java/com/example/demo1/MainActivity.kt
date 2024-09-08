package com.example.demo1
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.demo1.model.UserManager

class MainActivity : Activity() {

    private lateinit var authService: UserManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        authService = UserManager

        val etUsername = findViewById<EditText>(R.id.etUsername)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val username = etUsername.text.toString()
            val password = etPassword.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter both username and password", Toast.LENGTH_SHORT).show()
            } else {
                if (authService.login(username, password)) {
                    val intent = Intent(this, UserHomeActivity::class.java)
                    intent.putExtra("username", username)
                    startActivity(intent)
                    Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()

                    // Proceed to the next screen or activity
                } else {
                    Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

