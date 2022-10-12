package com.example.virginmoneychallengeandroid

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmoneychallengeandroid.adapter.VmRecyclerviewEmployeesAdapter
import com.example.virginmoneychallengeandroid.databinding.FragmentEmployeeDetailsBinding
import com.example.virginmoneychallengeandroid.viewmodel.VmViewModel
import kotlinx.coroutines.launch

private  const val TAG = "EmployeeDetailsFragment"
class EmployeeDetailsFragment : Fragment() {

    private var _binding: FragmentEmployeeDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerview:RecyclerView
    private lateinit var adapter:VmRecyclerviewEmployeesAdapter

    private val viewModel: VmViewModel by activityViewModels {
        VmViewModel.VmViewmodelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmployeeDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        recyclerview = binding.recyclerviewEmployees

        val adapter = VmRecyclerviewEmployeesAdapter{ }

        viewModel.getEmployeeDetails()
        activity?.lifecycleScope?.launch {
            viewModel.employeeDetails.observe(requireActivity()){

                recyclerview.layoutManager = LinearLayoutManager(requireContext())
                recyclerview.adapter = adapter
                adapter.submitList(it)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}