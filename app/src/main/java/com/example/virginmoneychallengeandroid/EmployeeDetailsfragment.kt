package com.example.virginmoneychallengeandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.virginmoneychallengeandroid.databinding.FragmentEmployeeDetailsfragmentBinding
import com.example.virginmoneychallengeandroid.viewmodel.VmViewModel

class EmployeeDetailsfragment : Fragment() {

    private var _binding: FragmentEmployeeDetailsfragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var imageView: ImageView
    private val viewModel: VmViewModel by activityViewModels {
        VmViewModel.VmViewmodelFactory()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentEmployeeDetailsfragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView = binding.avatarDetailsImg

        viewModel.currentEmployee.observe(viewLifecycleOwner) {
            binding.apply {
                Glide.with(imageView.context).load(it.avatar).error(R.drawable.ic_launcher_foreground).into(imageView)
                idDetailsTv.text = getString(R.string.id, it.id)
                nameDetailsTv.text = getString(R.string.name, it.firstName, it.lastName)
                roleDetailsTv.text = getString(R.string.jobtitle, it.jobTitle)
                emailDetailsTv.text = getString(R.string.email, it.email)
                favouriteDetailsTv.text = getString(R.string.favouritecolor, it.favouriteColor)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}