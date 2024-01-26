package com.example.proyecto

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

    class UserAdapter(private val userList: List<String>) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_user, parent, false)
            return UserViewHolder(view)
        }

        override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
            val userName = userList[position]
            holder.bind(userName)
        }

        override fun getItemCount(): Int {
            return userList.size
        }

        inner class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            private val userNamesTextView: TextView = itemView.findViewById(R.id.userNamesTextView)

            fun bind(userName: String) {
                userNamesTextView.text = userName
            }
        }
    }


