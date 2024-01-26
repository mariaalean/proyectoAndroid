package com.example.proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle



import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject


import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: UserAdapter // Necesitas crear un adaptador para el RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        fetchDataFromApi()
    }

    private fun fetchDataFromApi() {
        // Tu lógica para obtener los datos del API y manejar la respuesta
    }

    private fun handleApiResponse(response: JSONArray) {
        val userList = mutableListOf<String>()

        for (i in 0 until response.length()) {
            val userObject: JSONObject = response.getJSONObject(i)
            val userName = userObject.getString("first_name")
            userList.add(userName)
        }

        // Configura el adaptador del RecyclerView
        adapter = UserAdapter(userList)
        recyclerView.adapter = adapter
    }
}