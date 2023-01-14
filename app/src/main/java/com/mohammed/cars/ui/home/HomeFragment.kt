package com.mohammed.cars.ui.home

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.mohammed.cars.R
import com.mohammed.cars.databinding.FragmentHomeBinding
import com.mohammed.cars.databinding.ItemVehichleBinding
import com.mohammed.cars.domain.DevByteVehicles
import com.mohammed.cars.ui.vehicles.VehiclesViewModel


class HomeFragment : Fragment() {

    private val viewModel: VehiclesViewModel by lazy {
        val activity = requireNotNull(this.activity) {
            "You can only access the viewModel after onActivityCreated()"
        }
        ViewModelProvider(this, VehiclesViewModel.Factory(activity.application))
            .get(VehiclesViewModel::class.java)
    }
    private var viewModelAdapter: DevByteAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.vehicleslist.observe(
            viewLifecycleOwner,
            Observer<List<DevByteVehicles>> { vehicles ->
                vehicles?.apply {
                    viewModelAdapter?.videos = vehicles
                }

            })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
//        binding.newAddedView.adapter = VehiclesListAdapter(
//            VehicleListener { vehicle ->
//                viewModel.onVehicleClicked(vehicle)
//                findNavController()
//                    .navigate(R.id.action_homeFragment_to_carDetails)
//            })
        return binding.root
    }

    private fun onNetworkError() {
        if (!viewModel.isNetworkErrorShown.value!!) {
            Toast.makeText(activity, "Network Error", Toast.LENGTH_LONG).show()
            viewModel.onNetworkErrorShown()
        }
    }
}
    class VehicleClick(val block: (DevByteVehicles) -> Unit) {

        fun onClick(Vehicle: DevByteVehicles) = block(Vehicle)
    }



class DevByteAdapter(val callback: VehicleListener) : RecyclerView.Adapter<DevByteViewHolder>() {

    /**
     * The videos that our Adapter will show
     */
    var videos: List<DevByteVehicles> = emptyList()
        set(value) {
            field = value
            // For an extra challenge, update this to use the paging library.

            // Notify any registered observers that the data set has changed. This will cause every
            // element in our RecyclerView to be invalidated.
            notifyDataSetChanged()
        }

    /**
     * Called when RecyclerView needs a new {@link ViewHolder} of the given type to represent
     * an item.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DevByteViewHolder {
        val withDataBinding: ItemVehichleBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            DevByteViewHolder.LAYOUT,
            parent,
            false)
        return DevByteViewHolder(withDataBinding)
    }

    override fun getItemCount() = videos.size

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the {@link ViewHolder#itemView} to reflect the item at the given
     * position.
     */
    override fun onBindViewHolder(holder: DevByteViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.vehicle = videos[position]
            it.clickListener = callback
        }
    }

}

/**
 * ViewHolder for DevByte items. All work is done by data binding.
 */
class DevByteViewHolder(val viewDataBinding: ItemVehichleBinding) :
    RecyclerView.ViewHolder(viewDataBinding.root) {
    companion object {
        @LayoutRes
        val LAYOUT = R.layout.item_vehichle
    }
}