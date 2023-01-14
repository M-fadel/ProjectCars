package com.mohammed.cars.ui.vehicles

import android.app.Application
import androidx.lifecycle.*
import com.mohammed.cars.database.getDatabase
import com.mohammed.cars.domain.DevByteVehicles
import com.mohammed.cars.network.models.Vehicle
import com.mohammed.cars.network.services.CarsAPI
import com.mohammed.cars.repository.VehiclesRepo
import kotlinx.coroutines.launch
import java.io.IOException

enum class CarsApiStatus {LOADING, ERROR, DONE}

class VehiclesViewModel(application: Application) :AndroidViewModel(application){
//==================================================================================================

    private val _vehicleRepo = VehiclesRepo(getDatabase(application))
    val vehicleRepo get() = _vehicleRepo

    private var _eventNetworkError = MutableLiveData<Boolean>(false)
    private var _isNetworkErrorShown = MutableLiveData<Boolean>(false)
    val isNetworkErrorShown: LiveData<Boolean>
        get() = _isNetworkErrorShown

    val eventNetworkError: LiveData<Boolean>
        get() = _eventNetworkError
    //change this
    val vehicleslist = _vehicleRepo.vehicles


//==================================================================================================
//    private val _status = MutableLiveData<CarsApiStatus>()
//    val status: LiveData<CarsApiStatus> = _status
//    private val _vehicles  = MutableLiveData<List<Vehicle>>()
//    val cars: LiveData<List<Vehicle>> = _vehicles
//
//    private val _vehicle  = MutableLiveData<DevByteVehicles>()
//    val vehicle : LiveData <DevByteVehicles> = _vehicle
//==================================================================================================


    init {
        refreshDataFromRepository()
    }


    private fun refreshDataFromRepository() = viewModelScope.launch {
        try{
            _vehicleRepo.refreshVideos()
            _eventNetworkError.value = false
            _isNetworkErrorShown.value = false
        }catch (networkError: IOException){
            // Show a Toast error message and hide the progress bar.
            if(vehicleslist.value.isNullOrEmpty())
                _eventNetworkError.value = true
        }
    }

    fun onNetworkErrorShown() {
        _isNetworkErrorShown.value = true
    }
    class Factory(val app: Application) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(VehiclesViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return VehiclesViewModel(app) as T
            }
            throw IllegalArgumentException("Unable to construct view model")
        }
    }

//==================================================================================================

//    fun getVehicleList() {
//        viewModelScope.launch {
//
//            _status.value = CarsApiStatus.LOADING
//            try {
//                //here  it will try to get newly added vehicle
//                _vehicles.value = vehicleslist
//                _status.value = CarsApiStatus.DONE
//
//            } catch (e: Exception) {
//                _status.value = CarsApiStatus.ERROR
//                _vehicles.value = listOf()
//            }
//        }
//    }
//    fun getNewlyAddedList() {
//        viewModelScope.launch {
//
//            _status.value = CarsApiStatus.LOADING
//            try {
//                _vehicles.value = vehicleslist.
//                _status.value = CarsApiStatus.DONE
//
//            } catch (e: Exception) {
//                _status.value = CarsApiStatus.ERROR
//                _vehicles.value = listOf()
//            }
//        }
//    }
//    fun onVehicleClicked(vehicle: DevByteVehicles) {
//        _vehicle.value= vehicle
//    }





}