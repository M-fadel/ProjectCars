package com.mohammed.cars

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
//import com.mohammed.cars.adapter.CarsAdapter
import android.content.Context
import android.net.Uri
import com.example.wordsapp.constants.Constants


class CarDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.details)
        val name= intent?.extras?.getString("name").toString()
        val img = intent?.extras?.getInt("img").toString().toInt()
        val carName :TextView = findViewById<TextView?>(R.id.textView2)
        carName.text = name
        val carImg : ImageView = findViewById<ImageView>(R.id.imageView2)
        carImg.setImageResource(img)
        carImg.setOnClickListener{

            val queryUrl : Uri = Uri.parse("${Constants.SEARCH_PREFIX+name}")

            val intent = Intent(Intent.ACTION_VIEW,queryUrl)
            this.startActivity(intent)
        }
//        val intent

    }

}