package com.example.demo1
import android.app.Activity
import android.content.Intent
import android.os.Bundle

import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import com.example.demo1.model.User
import com.example.demo1.model.UserManager


class Search : Activity() {

    private lateinit var userAdapter: ArrayAdapter<User>
    private val userList = UserManager.userList // Get all users from UserManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.search)

        val searchEditText: EditText = findViewById(R.id.searchEditText)
        val searchButton: Button = findViewById(R.id.searchButton)
        val userListView: ListView = findViewById(R.id.userListView)
        val backButton: Button = findViewById(R.id.buttonBack)

        // Set up the ListView with the user adapter
        userAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, userList)
        userListView.adapter = userAdapter

        // Handle item clicks
        userListView.setOnItemClickListener { _, _, position, _ ->
            val selectedUser = userList[position]
            val intent = Intent(this, UserDetailActivity::class.java)
            intent.putExtra("username", selectedUser.username)
            startActivity(intent)
        }

        // Back button click listener
        backButton.setOnClickListener {
            finish()  // This will close the current activity and go back to the previous one
        }

        // Search button click listener
        searchButton.setOnClickListener {
            val searchTerm = searchEditText.text.toString().lowercase()
            val filteredUsers = userList.filter {
                it.username.lowercase().contains(searchTerm)
            }
            userAdapter.clear()
            userAdapter.addAll(filteredUsers)
            userAdapter.notifyDataSetChanged()
        }
    }
}
