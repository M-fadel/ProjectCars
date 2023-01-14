package com.mohammed.cars

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mohammed.cars.domain.DevByteVehicles
//import com.mohammed.cars.ui.home.VehiclesListAdapter

import com.mohammed.cars.ui.home.VehiclesListAdapter


@BindingAdapter("imageUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    Glide.with(imgView.context).load(imgUrl).into(imgView)
//    imgUrl?.let {
//        val imgUri = imgUrl.toUri().buildUpon().scheme("https").build()
//        imgView.load(imgUri) {
//            placeholder(R.drawable.loading_animation)
//            error(R.drawable.ic_broken_image)

//    }
}
//@BindingAdapter("isNetworkError", "playlist")
//fun hideIfNetworkError(view: View, isNetWorkError: Boolean, playlist: Any?) {
//    view.visibility = if (playlist != null) View.GONE else View.VISIBLE
//
//    if(isNetWorkError) {
//        view.visibility = View.GONE
//    }
//}
@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<DevByteVehicles>?) {


    val adapter = recyclerView.adapter as VehiclesListAdapter
    adapter.submitList(data)
}

/**
 * This binding adapter displays the [AmphibianApiStatus] of the network request in an image view.
 * When the request is loading, it displays a loading_animation.  If the request has an error, it
 * displays a broken image to reflect the connection error.  When the request is finished, it
 * hides the image view.
 */

//@BindingAdapter("apiStatus")
//fun bindStatus(statusImageView: ImageView, status: CarsApiStatus?) {
//    when(status) {
//        CarsApiStatus.LOADING -> {
//            statusImageView.visibility = View.VISIBLE
////            statusImageView.setImageResource(R.drawable.loading_animation)
//        }
//        CarsApiStatus.DONE -> {
//            statusImageView.visibility = View.GONE
//        }
//        CarsApiStatus.ERROR -> {
//            statusImageView.visibility = View.VISIBLE
////            statusImageView.setImageResource()
//        }
//        else -> {
//            print("===========================================================================")
//        }
//    }
//}
