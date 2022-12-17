package com.mohammed.cars.adapter

import android.content.Context
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.accessibility.AccessibilityNodeInfo
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.mohammed.cars.R
import com.mohammed.cars.model.Cars
import androidx.annotation.RequiresApi
import androidx.navigation.findNavController
import com.mohammed.cars.CarsFragmentDirections


class CarsAdapter(private val context: Context, private val dataset: List<Cars>) :
    RecyclerView.Adapter<CarsAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val itemLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.item_vehichle, parent, false)
        itemLayout.accessibilityDelegate = Accessibility
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
            val action = CarsFragmentDirections.actionCarsFragmentToCarDetails(name = holder.carName.text.toString(),item.carImage)
            holder.view.findNavController().navigate(action)
//            val intent = Intent(context,CarDetailsActivity::class.java)
//            .putExtra("name",holder.carName.text.toString()).putExtra("img",item.carImage)
//            context.startActivity(intent)
//        carDetailsActivity()
            //project context to access the activity
//        holder.like.isChecked
        //project create intent

        }



    }

    override fun getItemCount() = dataset.size


    class ViewHolder( val view: View) : RecyclerView.ViewHolder(view) {


        val carImage: ImageView = view.findViewById(R.id.imageView)
        val carName: TextView = view.findViewById(R.id.textView)
        val year: TextView = view.findViewById(R.id.year)
        val fuel: TextView = view.findViewById(R.id.fuel)
        val passengers: TextView = view.findViewById(R.id.Passengers)
//        val like :CheckBox = view.findViewById(R.id.Like)
        val card :CardView =view.findViewById(R.id.card)


    }

    companion object Accessibility : View.AccessibilityDelegate() {
        @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
        override fun onInitializeAccessibilityNodeInfo(
            host: View,
            info: AccessibilityNodeInfo
        ) {
            super.onInitializeAccessibilityNodeInfo(host, info)
            // With `null` as the second argument to [AccessibilityAction], the
            // accessibility service announces "double tap to activate".
            // If a custom string is provided,
            // it announces "double tap to <custom string>".
            val customString = host.context?.getString(R.string.carDeatails)
            val customClick =
                AccessibilityNodeInfo.AccessibilityAction(
                    AccessibilityNodeInfo.ACTION_CLICK,
                    customString
                )
            info.addAction(customClick)
        }
    }

}