//package com.mohammed.cars.network.services
//
//
//import com.mohammed.cars.network.models.Vehicle
//import com.mohammed.cars.network.models.VehiclesContainer
//import com.squareup.moshi.Moshi
//import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
//import retrofit2.Retrofit
//import retrofit2.converter.moshi.MoshiConverterFactory
//import retrofit2.http.GET
////-------------------------------------------
//private const val BASE_URL =
////    "http://10.20.40.188:8000"
//    "http://192.168.8.160:8000"
//
////-------------------------------------------
//
//
//
//
//private val moshi = Moshi.Builder()
//    .add(KotlinJsonAdapterFactory())
//    .build()
//
//private val retrofit = Retrofit.Builder()
//    .addConverterFactory(MoshiConverterFactory.create(moshi))
//    .baseUrl(BASE_URL)
//    .build()
//
//object CarsAPI {
//    val retrofitService: CarsAPIService by lazy { retrofit.create(CarsAPIService::class.java) }
//}
//
////private val retrofit = Retrofit.Builder()
////    .addConverterFactory(ScalarsConverterFactory.create()).baseUrl(BASE_URL)
////    .build()
//
//interface CarsAPIService {
//    @GET("getall/cars")
//    suspend fun vehicle(): VehiclesContainer
//    @GET("get/newlyAdded")
//    suspend fun newlyAdded():List<Vehicle>
//}
