package com.example.tmdb.ui.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.tmdb.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpNavigation()
    }

    private fun setUpNavigation() {
        NavigationUI.setupWithNavController(bottomNavView, navHostView.findNavController())
        setupActionBarWithNavController(navHostView.findNavController())

        bottomNavView.setOnNavigationItemReselectedListener {
            navHostView.findNavController().popBackStack(it.itemId, false)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        navHostView.findNavController().navigateUp()
        return true
    }
}