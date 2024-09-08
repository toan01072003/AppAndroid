package com.example.demo1.model

data class User(val username: String, var password: String, var email: String, var fullName: String)

object UserManager {
   val userList = mutableListOf(
        User("admin", "123", "example@email.com", "John Doe"),
        User("loveplant", "123", "example@email.com", "John Doe"),
        User("toan", "123", "example@email.com", "John Doe"),
       User("abcde", "123", "example@email.com", "John Doe"),
       User("abcdef", "123", "example@email.com", "John Doe"),
       User("abcdefg", "123", "example@email.com", "John Doe")
    )

    // Function to validate if the user exists in the list
    fun login(username: String, password: String): Boolean {
        return userList.any { it.username == username && it.password == password }
    }

    // Function to filter users based on their username
    fun filter(username: String): List<User> {
        return userList.filter { it.username.startsWith(username) }
    }
    fun getAllUserNames(): List<String> {
            return userList.map { it.username }
        }

        // Function to register a new user (with constraints checking)
    fun register(username: String, password: String, email: String, fullName: String): Boolean {
            // Check if the username already exists
            if (userList.any { it.username == username }) {
                return false
            }

            // Check password constraints (>=8 symbols, at least one numeric, one capital letter, one special character)
//            val passwordPattern = Regex("^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%&*!]).{8,}$")
//            if (!passwordPattern.matches(password)) {
//                return false
//            }

            // Add new user to the list
            userList.add(User(username, password, email, fullName))
            return true
        }
    fun getUserByUsername(username: String): User {
        return userList.find { it.username == username } ?: throw NoSuchElementException("User not found")
    }


    fun updateUser(username: String, newEmail: String, newPassword: String) {
        val user = getUserByUsername(username)
        user.email = newEmail
        user.password = newPassword
    }

    fun deleteUser(username: String) {
        val user = getUserByUsername(username)
        userList.remove(user)
    }
    }
