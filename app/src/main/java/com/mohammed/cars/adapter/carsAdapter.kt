package com.mohammed.cars.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.mohammed.cars.R
import com.mohammed.cars.model.Cars
import android.widget.Toast
import com.mohammed.cars.CarDetailsActivity


class CarsAdapter(private val context: Context, private val dataset: List<Cars>) :
    RecyclerView.Adapter<CarsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_vehichle, parent, false)
        return ViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item = dataset[position]
        holder.carImage.setImageResource(item.carImage)
        holder.carName.text = context.resources.getString(item.carName)
        holder.year.text = item.year.toString()
        holder.fuel.text = item.fuel.toString()
        holder.passengers.text = item.Passenger.toString()
        val context =holder.itemView.context
        holder.card.setOnClickListener{

            val intent = Intent(context,CarDetailsActivity::class.java)
            .putExtra("name",holder.carName.text.toString()).putExtra("img",item.carImage)
            context.startActivity(intent)
//        carDetailsActivity()
            //project context to access the activity
//        holder.like.isChecked

            onCardClick()
            //project create intent

        }



    }

    override fun getItemCount() = dataset.size


    class ViewHolder(private val View: View) : RecyclerView.ViewHolder(View) {


        val carImage: ImageView = View.findViewById(R.id.imageView)
        val carName: TextView = View.findViewById(R.id.textView)
        val year: TextView = View.findViewById(R.id.year)
        val fuel: TextView = View.findViewById(R.id.fuel)
        val passengers: TextView = View.findViewById(R.id.Passengers)
        val like :CheckBox = View.findViewById(R.id.Like)
        val card :CardView =View.findViewById(R.id.card)


    }
    fun onCardClick(){
//        val toast = Toast.makeText(context,"you clicked a card",Toast.LENGTH_SHORT)
//        toast.show()


//        val intent =
    }

}