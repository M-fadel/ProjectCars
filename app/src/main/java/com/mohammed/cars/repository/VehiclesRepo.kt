package com.mohammed.cars.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.mohammed.cars.database.DatabaseVehicle
import com.mohammed.cars.database.VehicleDatabase
import com.mohammed.cars.database.asDomainModel
import com.mohammed.cars.domain.DevByteVehicles
import com.mohammed.cars.network.services.CarsAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import com.mohammed.cars.network.models.asDatabaseModel

class VehiclesRepo(private val database: VehicleDatabase) {


    val vehicles: LiveData<List<DevByteVehicles>> = Transformations.map(database.VehicleDao.getVehicles()) {
        it.asDomainModel()
    }

    // to load and refresh data from API
    suspend fun refreshVideos() {
        withContext(Dispatchers.IO){
            // result from api
            val playlist = CarsAPI.retrofitService.vehicle()
            // send result to room and covert to room model
            // copy from data coming from server ( offline caching )

            database.VehicleDao.insertAll(playlist.asDatabaseModel())
        }
    }
//    suspend fun newlyAdded() {
//        withContext(Dispatchers.IO){
//            // result from api
//            val playlist = CarsAPI.retrofitService.newlyAdded()
//            // send result to room and covert to room model
//            // copy from data coming from server ( offline caching )
//            database.VehicleDao.insertAll(playlist.asDatabaseModel(     ))
//        }
//    }




}


