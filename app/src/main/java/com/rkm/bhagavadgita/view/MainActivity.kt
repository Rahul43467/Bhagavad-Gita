package com.rkm.bhagavadgita.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.rkm.bhagavadgita.R
import com.rkm.bhagavadgita.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var toolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        toolbar = findViewById(R.id.toolbar) // Assuming your toolbar has ID "toolbar"
        setSupportActionBar(toolbar) // Make the Toolbar the action bar

        navController = findNavController(R.id.fragment_container) // Assuming container ID

        setupActionBarWithNavController(navController) // Important for navigation integration
    }
    }
