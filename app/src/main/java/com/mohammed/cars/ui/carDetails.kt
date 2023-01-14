//package com.mohammed.cars.ui
//
//import android.content.Intent
//import android.net.Uri
//import android.os.Bundle
//import androidx.fragment.app.Fragment
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.activityViewModels
//import com.example.wordsapp.constants.Constants
//import com.mohammed.cars.databinding.FragmentCarDetailsBinding
//import com.mohammed.cars.ui.vehicles.VehiclesViewModel
//
//
//class carDetails : Fragment() {
//    private val viewModel:VehiclesViewModel by activityViewModels()
////    private var _binding: FragmentCarDetailsBinding? = null
////    private val binding get() = _binding!!
////    private lateinit var name: String
////    private lateinit var img: String
//
////    override fun onCreate(savedInstanceState: Bundle?) {
////        super.onCreate(savedInstanceState)
//
//
////        arguments?.let {
////            name = it.getString("name").toString()
////            img = it.getInt("img").toString()
////
////        }
//
////    }
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val binding = FragmentCarDetailsBinding.inflate(inflater)
//        binding.lifecycleOwner = this
//        binding.viewModel = viewModel
//        return binding.root
//    }
////    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
////
////        binding.imageView2.setOnClickListener {
////
////            val queryUrl: Uri = Uri.parse("${Constants.SEARCH_PREFIX + name}")
////
////            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
////            this.startActivity(intent)
////        }
//
//
//
////    }
////
////    override fun onDestroyView() {
////        super.onDestroyView()
////        _binding = null
////    }
//}