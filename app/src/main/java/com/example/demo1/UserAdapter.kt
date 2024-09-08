package com.example.demo1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.demo1.model.User

class UserAdapter(private val context: Context, private var users: List<User>) : BaseAdapter() {

    override fun getCount(): Int = users.size

    override fun getItem(position: Int): Any = users[position]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflater = LayoutInflater.from(context)
        val view = convertView ?: inflater.inflate(R.layout.user_item, parent, false)

        val user = getItem(position) as User
        val usernameTextView: TextView = view.findViewById(R.id.usernameTextView)
        val emailTextView: TextView = view.findViewById(R.id.emailTextView)

        usernameTextView.text = user.username
        emailTextView.text = user.email

        return view
    }

    // Update the list of users in the adapter
    fun updateUserList(newUsers: List<User>) {
        users = newUsers
        notifyDataSetChanged()
    }
}
