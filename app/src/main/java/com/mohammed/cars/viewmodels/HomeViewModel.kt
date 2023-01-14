//package com.mohammed.cars.viewmodels
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.mohammed.cars.network.models.Vehicle
//import com.mohammed.cars.network.services.CarsAPI
//import kotlinx.coroutines.launch
//
//enum class CarsApiStatus {LOADING, ERROR, DONE}
//
//class HomeViewModel : ViewModel() {
//    private val _status = MutableLiveData<CarsApiStatus>()
//    val status: LiveData<CarsApiStatus> = _status
//
//    private val _vehicles  = MutableLiveData<List<Vehicle>>()
//    val cars: LiveData<List<Vehicle>> = _vehicles
//
//    private val _vehicle  = MutableLiveData<Vehicle>()
//    val vehicle : LiveData <Vehicle> = _vehicle
//    fun getVehicleList() {
//        viewModelScope.launch {
//
//            _status.value = CarsApiStatus.LOADING
//            try {
//                _vehicles.value = CarsAPI.retrofitService.newlyAdded()
//                _status.value = CarsApiStatus.DONE
//
//            } catch (e: Exception) {
//                _status.value = CarsApiStatus.ERROR
//                _vehicles.value = listOf()
//            }
//        }
//    }
//    fun onVehicleClicked(vehicle: Vehicle) {
//        _vehicle.value= vehicle
//    }
//
//    }