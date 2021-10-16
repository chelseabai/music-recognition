package com.example.aikeyboard

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val queue = Volley.newRequestQueue(this)
//        val url = "http://10.0.2.2:5000/api/api-all"
        var url = "https://api.punkapi.com/v2/beers/1"
        val postBtn = findViewById<Button>(R.id.post_button)
        postBtn.setOnClickListener {
            val jsonArrayRequest = JsonArrayRequest(
                Request.Method.GET, url, null,
                Response.Listener { response ->
                    Log.d("Response", response.toString())
                },
                Response.ErrorListener { error ->
                    Log.d("Error", "Error occurred")
                }
            )
            queue.add(jsonArrayRequest)
        }

    }


}

