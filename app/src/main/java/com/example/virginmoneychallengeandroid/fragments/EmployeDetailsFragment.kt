package com.example.virginmoneychallengeandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide
import com.example.virginmoneychallengeandroid.R
import com.example.virginmoneychallengeandroid.databinding.FragmentEmployeDetailsBinding
import com.example.virginmoneychallengeandroid.viewmodel.VmViewModel


class EmployeDetailsFragment : Fragment() {

    private var _binding: FragmentEmployeDetailsBinding? = null
    private val binding get() = _binding!!
    private lateinit var imageView: ImageView
    private val viewModel: VmViewModel by activityViewModels {
        VmViewModel.VmViewmodelFactory()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEmployeDetailsBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        imageView = binding.avatarEmployeImg

        viewModel.currentEmployee.observe(viewLifecycleOwner) {
            binding.apply {
                Glide.with(imageView.context).load(it.avatar).error(R.drawable.ic_launcher_foreground).into(imageView)
                idEmployeTv.text = getString(R.string.id, it.id)
                nameEmployeTv.text = getString(R.string.name, it.firstName, it.lastName)
                roleEmployeTv.text = getString(R.string.jobtitle, it.jobTitle)
                emailEmployeTv.text = getString(R.string.email, it.email)
                colorEmployeTv.text = getString(R.string.favouritecolor, it.favouriteColor)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}
