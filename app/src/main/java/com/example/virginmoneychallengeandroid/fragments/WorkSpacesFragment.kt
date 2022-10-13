package com.example.virginmoneychallengeandroid.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.virginmoneychallengeandroid.MainActivity
import com.example.virginmoneychallengeandroid.adapter.VmRecyclerviewRoomsAdapter
import com.example.virginmoneychallengeandroid.databinding.FragmentWorkSpacesBinding
import com.example.virginmoneychallengeandroid.viewmodel.VmViewModel
import kotlinx.coroutines.launch

private const val TAG = "WorkSpacesFragment"
class WorkSpacesFragment : Fragment() {

    private var _binding: FragmentWorkSpacesBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerview:RecyclerView
    private val viewmodel: VmViewModel by activityViewModels {
        VmViewModel.VmViewmodelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkSpacesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title="Work Spaces"
        recyclerview = binding.workspacesRecyclerview

        observeWorkSpaceData()
    }

    private fun observeWorkSpaceData() {
        val adapterr = VmRecyclerviewRoomsAdapter{}
        viewmodel.getWorkSpacesDetails()

        activity?.lifecycleScope?.launch {
            viewmodel.workSpaces.observe(requireActivity()){
                Log.d(TAG,"list = $it")
                recyclerview.layoutManager = LinearLayoutManager(requireContext())
                recyclerview.adapter = adapterr
                adapterr.submitList(it)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}