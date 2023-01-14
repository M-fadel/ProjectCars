package com.mohammed.cars.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.mohammed.cars.domain.DevByteVehicles


@Entity
data class DatabaseVehicle constructor(
    @PrimaryKey val id: String,
    val imge: String,
    val model: String,
    val vehicle: String,
    val availableFrom: String,
    val availableTo: String,
    val Color: String,
    val Doors: String,
    val Fuel: String,
    val Manufacturer: String,
    val Mileage: String,
    val Passenger: String,
    val Price: Int,
    val Type: String,
    val Year: String,
    val updatedAt: String,
    val createdAt: String,
    val __v: Int

)

fun List<DatabaseVehicle>.asDomainModel(): List<DevByteVehicles> {
    return map {
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