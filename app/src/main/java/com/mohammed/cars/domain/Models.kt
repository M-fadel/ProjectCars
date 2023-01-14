package com.mohammed.cars.domain

import com.squareup.moshi.Json



    data class DevByteVehicles(
        val id: String,
        val imge: String,
        val model: String,
        val updatedAt: String,
        val vehicle: String,
        val availableFrom: String,
        val availableTo: String,
        val createdAt: String,
        val Color: String,
        val Doors: String,
        val Fuel: String,
        val Manufacturer: String,
        val Mileage: String,
        val Passenger: String,
        val Price: Int,
        val Type: String,
        val Year: String) {

        /**
         * Short description is used for displaying truncated descriptions in the UI
         */
//        val shortDescription: String
//            get() = description.smartTruncate(200)
    }
