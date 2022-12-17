package com.mohammed.cars

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wordsapp.constants.Constants
import com.mohammed.cars.adapter.CarsAdapter
import com.mohammed.cars.databinding.FragmentCarDetailsBinding
import com.mohammed.cars.databinding.FragmentCarsBinding


class carDetails : Fragment() {
    private var _binding: FragmentCarDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var name: String
    private lateinit var img: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        arguments?.let {
            name = it.getString("name").toString()
            img = it.getInt("img").toString()

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCarDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val carName = binding.textView2
        val carImage =binding.imageView2
        carName.text=name.toString()
        carImage.setImageResource(img.toInt())



        binding.imageView2.setOnClickListener {

            val queryUrl: Uri = Uri.parse("${Constants.SEARCH_PREFIX + name}")

            val intent = Intent(Intent.ACTION_VIEW, queryUrl)
            this.startActivity(intent)
        }



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}