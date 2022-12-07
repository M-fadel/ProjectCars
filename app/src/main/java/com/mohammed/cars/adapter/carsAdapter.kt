package com.mohammed.cars.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mohammed.cars.R
import com.mohammed.cars.model.Name

class CarsAdapter(private val context: Context,private val dataset: List<Name>): RecyclerView.Adapter<CarsAdapter .ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemLayout =LayoutInflater.from(parent.context).inflate(R.layout.item_vehichle,parent,false)
        return ViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item =dataset[position]
        holder.Name.text = context.resources.getString(item.name)

    }

    override fun getItemCount()= dataset.size


    class ViewHolder(private val View:View) :RecyclerView.ViewHolder(View){
val Name: TextView=View.findViewById(R.id.text)
    }




}