package com.mohammed.cars.data

import com.mohammed.cars.R
import  com.mohammed.cars.model.Name
class DataSource {
    fun books():List<Name>{
        return listOf(
            Name(R.string.hello)
            ,Name(R.string.hello)
            ,Name(R.string.hello)
            ,Name(R.string.hello)
            ,Name(R.string.hello)
            ,Name(R.string.hello)
        )
    }
}