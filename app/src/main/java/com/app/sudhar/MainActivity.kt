package com.app.sudhar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import com.app.sudhar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
        navController = navHostFragment.navController

        setupWithNavController(binding.bottomNavigationView, navController)
        binding.bottomNavigationView.itemIconTintList = null
        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    navController.navigate(R.id.home)
                    true
                }
                R.id.about -> {
                    navController.navigate(R.id.about)
                    true
                }
                R.id.registration -> {
                    navController.navigate(R.id.registration)
                    true
                }
                R.id.dashboard -> {
                    navController.navigate(R.id.dashboard)
                    true
                }
                R.id.contact -> {
                    navController.navigate(R.id.contact)
                    true
                }
                else -> false
            }
        }
        val topLevelDestinationIds: Set<Int> = setOf(
            R.id.home,
            R.id.about,
            R.id.contact,
            R.id.dashboard,
            R.id.registration
        )
        navController.addOnDestinationChangedListener { _, destination, _ ->
            binding.bottomNavigationView.isVisible =
                topLevelDestinationIds.contains(destination.id)
        }
    }
}