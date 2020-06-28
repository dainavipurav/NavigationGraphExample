package com.example.navigationgraphexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationMenu
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity(), NavController.OnDestinationChangedListener {

    private lateinit var mNavControllerMain: NavController
    private lateinit var mBottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mNavControllerMain = this@MainActivity.findNavController(R.id.nav_host)
        mBottomNavigationView = findViewById(R.id.bottomNavigationView)
        mBottomNavigationView.setupWithNavController(mNavControllerMain)

        NavigationUI.setupActionBarWithNavController(this@MainActivity, mNavControllerMain)
        mNavControllerMain.addOnDestinationChangedListener(this@MainActivity)


        setupActionBarWithNavController(
            mNavControllerMain, AppBarConfiguration(
                topLevelDestinationIds = setOf(
                    R.id.red,
                    R.id.green,
                    R.id.blue
                )
            )
        )
    }

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
        when (destination.id) {
            R.id.formFragment -> {
                supportActionBar?.show()
                mBottomNavigationView.visibility = View.GONE
            }
        }
    }
}
