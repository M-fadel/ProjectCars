package com.mohammed.cars.ui.home

import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBindings
import com.mohammed.cars.R
import com.mohammed.cars.bindRecyclerView
import com.mohammed.cars.databinding.FragmentHomeBinding
import com.mohammed.cars.databinding.FragmentVehiclesBinding
import com.mohammed.cars.databinding.ItemVehichleBinding
import com.mohammed.cars.domain.DevByteVehicles
import com.mohammed.cars.network.models.NetworkVehicle
import com.mohammed.cars.ui.vehicles.VehiclesViewModel
import kotlinx.coroutines.launch


class HomeFragment : Fragment() {

//
//    private val viewModel: VehiclesViewModel by lazy {
//        val activity = requireNotNull(this.activity) {
//            "You can only access the viewModel after onActivityCreated()"
//        }
//
//        ViewModelProvider(this, VehiclesViewModel.Factory(activity.application))
//            .get(VehiclesViewModel::class.java)
//    }
//    private var viewModelAdapter: DevByteAdapter? = null

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
////        Log.d("dev", "====================beee============================")
////        viewModel.vehicleslist.observe(viewLifecycleOwner) {
////            viewModelAdapter?.vehicles = it
////            Log.d("dev", it.toString())
//        }
//    }
private val viewModel: VehiclesViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        viewModel.getNewlyAddedList()
        binding.lifecycleOwner = this
        binding.viewModel = VehiclesViewModel()
        binding.newAddedView.adapter = VehiclesListAdapter(VehicleListener { NetworkVehicle ->
            viewModel.onVehicleClicked(NetworkVehicle)
            findNavController().navigate(R.id.action_homeFragment_to_carDetails) })

//        binding.root.findViewById<RecyclerView>(R.id.recycler_view).apply {
////            layoutManager = LinearLayoutManager(context)
//            adapter = VehiclesListAdapter
//        }



//        viewLifecycleOwner.lifecycleScope.launch {
//            viewModel.vehicleRepo.insertVehicles()
//            binding.mySwipeRefreshLayout.isRefreshing = false
//        }
        return binding.root
    }
}

//    private fun onNetworkError() {
//        if (!viewModel.isNetworkErrorShown.value!!) {
//            Toast.makeText(activity, "Network Error", Toast.LENGTH_LONG).show()
//            viewModel.onNetworkErrorShown()
//        }
//    }
//}
//    class VehicleClick(val block: (NetworkVehicle) -> Unit) {
//
//        fun onClick(Vehicle: NetworkVehicle) = block(Vehicle)
//    }


//
//class DevByteAdapter(val callback: VehicleClick) : RecyclerView.Adapter<DevByteViewHolder>()
//{
//
//    /**
//     * The videos that our Adapter will show
//     */
//    var vehicles: List<DevByteVehicles> = emptyList()
//        set(value) {
//            field = value
//            // For an extra challenge, update this to use the paging library.
//
//            // Notify any registered observers that the data set has changed. This will cause every
//            // element in our RecyclerView to be invalidated.
//            notifyDataSetChanged()
//        }
//
//    /**
//     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
//     * an item.
//     */
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DevByteViewHolder {
//        val withDataBinding: ItemVehichleBinding = DataBindingUtil.inflate(
//            LayoutInflater.from(parent.context),
//            DevByteViewHolder.LAYOUT,
//            parent,
//            false)
//
//        return DevByteViewHolder(withDataBinding)
//
//    }
//
//    override fun getItemCount() = vehicles.size
//
//    /**
//     * Called by RecyclerView to display the data at the specified position. This method should
//     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
//     * position.
//     */
//    override fun onBindViewHolder(holder: DevByteViewHolder, position: Int) {
//        holder.viewDataBinding.also {
//            it.vehicle = vehicles[position]
//            it.clickListener = callback
//
//
//        }
//    }
//
//}


//class DevByteViewHolder(val viewDataBinding: ItemVehichleBinding) :
//    RecyclerView.ViewHolder(viewDataBinding.root) {
//    companion object {
//        @LayoutRes
//        val LAYOUT = R.layout.item_vehichle
//    }
//}