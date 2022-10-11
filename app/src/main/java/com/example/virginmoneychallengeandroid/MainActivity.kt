package com.example.virginmoneychallengeandroid

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.virginmoneychallengeandroid.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity(), NavigationBarView.OnItemSelectedListener {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.bnvMainActivity.setOnItemSelectedListener(this)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.contact_details -> {
                supportFragmentManager.commit {
                    replace(R.id.fcv_main_activity,EmployeeDetailsFragment())
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