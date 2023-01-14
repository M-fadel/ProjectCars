package com.mohammed.cars.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mohammed.cars.databinding.ItemVehichleBinding
import com.mohammed.cars.domain.DevByteVehicles
import com.mohammed.cars.network.models.NetworkVehicle

class VehiclesListAdapter(val clickListener: VehicleListener) :
    ListAdapter<NetworkVehicle, VehiclesListAdapter.HomeViewHolder>(DiffCallback) {

//    var videos: List<DevByteAdapter> = emptyList()
//        set(value) {
//            field = value
//            // For an extra challenge, update this to use the paging library.
//
//            // Notify any registered observers that the data set has changed. This will cause every
//            // element in our RecyclerView to be invalidated.
//            notifyDataSetChanged()
//        }

    class HomeViewHolder(
        var binding: ItemVehichleBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(clickListener: VehicleListener, NetworkVehicle: NetworkVehicle) {
            binding.vehicle= NetworkVehicle
            binding.imageView
            binding.clickListener = clickListener
            binding.executePendingBindings()

        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<NetworkVehicle>() {

        override fun areItemsTheSame(oldItem: NetworkVehicle, newItem: NetworkVehicle): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NetworkVehicle, newItem: NetworkVehicle): Boolean {
            return oldItem.imge == newItem.imge
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return HomeViewHolder(
            ItemVehichleBinding.inflate(layoutInflater, parent, false)
        )
    }
//    var vehicle: List<DevByteVehicles> = emptyList()
//        set(value) {
//            field = value
//            // For an extra challenge, update this to use the paging library.
//
//            // Notify any registered observers that the data set has changed. This will cause every
//            // element in our RecyclerView to be invalidated.
//            notifyDataSetChanged()
//        }

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
//        holder.binding.also {
//        }
        val vehicle = getItem(position)
        holder.bind(clickListener, vehicle)

    }
}
class VehicleListener (val clickListener: (NetworkVehicle: NetworkVehicle) -> Unit){
        fun onClick(NetworkVehicle: NetworkVehicle) = clickListener(NetworkVehicle)
}