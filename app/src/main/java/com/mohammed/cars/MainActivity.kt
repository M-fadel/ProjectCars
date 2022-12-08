package com.mohammed.cars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mohammed.cars.adapter.CarsAdapter
import com.mohammed.cars.data.DataSource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataset = DataSource().cars()

        val recyclerView = findViewById<RecyclerView>(R.id.coffee)

        val adapter = CarsAdapter(this, dataset)

        recyclerView.adapter = adapter

        recyclerView.setHasFixedSize(true)
        val layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = layoutManager

//        val onCardClick :cardView
    }

}