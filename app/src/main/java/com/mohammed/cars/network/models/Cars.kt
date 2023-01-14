package com.mohammed.cars.network.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Cars(
    @DrawableRes val carImage: Int,
    @StringRes val carName: Int,
    val year: Int,
    val fuel: Int,
    val Passenger: Int
) {
    //------------


}
//data class Name(var name :Int)