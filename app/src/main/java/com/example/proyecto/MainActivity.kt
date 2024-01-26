package com.example.proyecto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


import android.widget.TextView
import android.widget.Toast

import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {


    private lateinit var textViewUserName: TextView


    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewUserName = findViewById(R.id.textViewUserName)

        fetchDataFromApi()


    }
    private fun fetchDataFromApi() {
        val url = "https://reqres.in/api/users/1" // Obtener solo el primer usuario

        val requestQueue: RequestQueue = Volley.newRequestQueue(this)

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener { response ->
                // Procesar la respuesta JSON
                handleApiResponse(response)
            },
            Response.ErrorListener { error ->
                // Manejar errores de la solicitud
                Toast.makeText(this, "Error: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        )

        // Agregar la solicitud a la cola de solicitudes
        requestQueue.add(jsonObjectRequest)
    }

    private fun handleApiResponse(response: JSONObject) {
        val userObject = response.getJSONObject("data")
        val userName = userObject.getString("first_name")

        // Mostrar el nombre del usuario en el TextView
        textViewUserName.text = "Nombre del usuario: $userName"
    }




}