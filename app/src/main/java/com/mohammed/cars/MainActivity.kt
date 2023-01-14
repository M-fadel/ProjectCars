package com.mohammed.cars

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.mohammed.cars.R

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController
        NavigationUI.setupActionBarWithNavController(this, navController)

    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        inflater.inflate(R.menu.layout_menu, menu)
//
//        val layoutButton = menu.findItem(R.id.action_switch_layout)
//        setIcon(layoutButton)
//    }
override fun onCreateOptionsMenu(menu: Menu): Boolean {
    val inflater: MenuInflater = menuInflater
    inflater.inflate(R.menu.layout_menu, menu)
    return true
}
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {
            R.id.homeButton -> {

                findNavController(R.id.nav_host_fragment).navigate(R.id.homeFragment)

                true
            }
            R.id.vehicle -> {
                findNavController(R.id.nav_host_fragment).navigate(R.id.vehiclesFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}