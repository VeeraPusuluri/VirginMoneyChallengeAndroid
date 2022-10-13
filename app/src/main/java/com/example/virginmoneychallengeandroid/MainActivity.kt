package com.example.virginmoneychallengeandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.commit
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.virginmoneychallengeandroid.databinding.ActivityMainBinding
import com.example.virginmoneychallengeandroid.fragments.WorkSpacesFragment
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bnvMainActivity.setOnItemSelectedListener(this)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fcv_main_activity) as NavHostFragment
        navController = navHostFragment.navController
        setupActionBarWithNavController(navController)
    }

    override fun onNavigateUp(): Boolean {
        return super.onNavigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.contact_details -> {
                supportFragmentManager.commit {
                    replace(R.id.fcv_main_activity,EmployeeFragment())
                    addToBackStack("employee")
                }
                true
            }
            R.id.work_spaces -> {
                supportFragmentManager.commit {
                    replace(R.id.fcv_main_activity,WorkSpacesFragment())
                    addToBackStack("spaces")
                }
                true
            }
            else -> true
        }
    }
}