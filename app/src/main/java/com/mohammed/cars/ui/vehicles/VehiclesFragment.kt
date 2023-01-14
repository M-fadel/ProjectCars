//package com.mohammed.cars.ui.vehicles
//
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.GridLayout
//import androidx.fragment.app.activityViewModels
//import androidx.navigation.fragment.findNavController
//import com.mohammed.cars.R
//import com.mohammed.cars.databinding.FragmentVehiclesBinding
//import com.mohammed.cars.domain.DevByteVehicles
//import com.mohammed.cars.ui.home.VehicleListener
//import com.mohammed.cars.ui.home.VehiclesListAdapter
//
//
//class VehiclesFragment : Fragment() {
//    private val viewModel: VehiclesViewModel by activityViewModels()
//
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        val binding = FragmentVehiclesBinding.inflate(inflater, container, false)
//        viewModel.vehicleslist
//        binding. lifecycleOwner = this
////        binding.viewModel = viewModel
////        binding.vehiclesView.adapter = VehiclesListAdapter(VehicleListener { vehicle ->
////            viewModel.onVehicleClicked(vehicle)
////            findNavController()
////                .navigate(R.id.action_vehiclesFragment_to_carDetails)
////        })
//
//
//        return binding.root
//    }
//
//}