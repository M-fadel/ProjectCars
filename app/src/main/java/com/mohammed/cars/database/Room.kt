package com.mohammed.cars.database

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface VehicleDao{
    @Query("select * from databaseVehicle")
    fun getVehicles():LiveData<List<DatabaseVehicle>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(Vehicles:List<DatabaseVehicle>)
}

@Database(entities = [DatabaseVehicle::class], version = 1)
abstract class VehicleDatabase: RoomDatabase() {
    abstract val VehicleDao: VehicleDao
}

private lateinit var INSTANCE: VehicleDatabase

fun getDatabase(context: Context): VehicleDatabase {
    synchronized(VehicleDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(context.applicationContext,
                VehicleDatabase::class.java,
                "Vehicles").build()
        }
    }
    return INSTANCE
}