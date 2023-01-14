package com.mohammed.cars.network.models


import com.mohammed.cars.database.DatabaseVehicle
import com.mohammed.cars.domain.DevByteVehicles
//import com.mohammed.cars.database.DatabaseVehicle
//import com.mohammed.cars.domain.DevByteVehicles
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass


@JsonClass(generateAdapter = true)
data class NetworkVehiclesContainer(val Cars: List<NetworkVehicle>)

@JsonClass(generateAdapter = true)
data class NetworkVehicle(


    @Json(name = "_id") val id: String
    , @Json(name = "imge") val imge: String,
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
    val Year: String,
    val __v: Int
)

fun NetworkVehiclesContainer.asDomainModel(): List<DevByteVehicles> {
    return Cars.map {
        DevByteVehicles(
            id = it.id,
            imge = it.imge,
            model = it.model,
            vehicle = it.vehicle,
            availableFrom = it.availableFrom,
            availableTo = it.availableTo,
            Color = it.Color,
            Doors = it.Doors,
            Fuel = it.Fuel,
            Manufacturer = it.Manufacturer,
            Mileage = it.Mileage,
            Passenger = it.Passenger,
            Price = it.Price,
            Type = it.Type,
            Year = it.Year,
            updatedAt = it.updatedAt,
            createdAt = it.createdAt
        )
    }
}
    fun NetworkVehiclesContainer.asDatabaseModel(): List<DatabaseVehicle> {
        return Cars.map {
            DatabaseVehicle(
                id = it.id,
                imge = it.imge,
                model = it.model,
                vehicle = it.vehicle,
                availableFrom = it.availableFrom,
                availableTo = it.availableTo,
                Color = it.Color,
                Doors = it.Doors,
                Fuel = it.Fuel,
                Manufacturer = it.Manufacturer,
                Mileage = it.Mileage,
                Passenger = it.Passenger,
                Price = it.Price,
                Type = it.Type,
                Year = it.Year,
                __v = it.__v,
                updatedAt = it.updatedAt,
                createdAt = it.createdAt)
        }
}