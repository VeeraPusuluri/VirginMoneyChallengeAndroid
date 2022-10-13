package com.example.virginmoneychallengeandroid

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.example.virginmoneychallengeandroid.adapter.VmRecyclerviewEmployeesAdapter
import com.example.virginmoneychallengeandroid.databinding.FragmentEmployeeBinding
import com.example.virginmoneychallengeandroid.viewmodel.VmViewModel
import kotlinx.coroutines.launch

private  const val TAG = "EmployeeDetailsFragment"
class EmployeeFragment : Fragment() {

    private var _binding: FragmentEmployeeBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerview:RecyclerView
    private lateinit var slidingpaneLayout: SlidingPaneLayout
    private lateinit var adapter:VmRecyclerviewEmployeesAdapter

    private val viewModel: VmViewModel by activityViewModels {
        VmViewModel.VmViewmodelFactory()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentEmployeeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.title = "Employees"
        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            recyclerview = recyclerviewEmployees
            slidingpaneLayout = slidingpanelayoutEmploye
        }

        attachSidingPaneLayout()
        observeEmployeeData()
    }

    private fun attachSidingPaneLayout() {
        slidingpaneLayout.lockMode = SlidingPaneLayout.LOCK_MODE_LOCKED
        // Connect the SlidingPaneLayout to the system back button.
        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            VmOnBackPressedCallback(slidingpaneLayout)
        )

    }

    private fun observeEmployeeData() {
        val adapter = VmRecyclerviewEmployeesAdapter {
            viewModel.setCurrentEmployeeData(it)
            slidingpaneLayout.openPane()
        }
        viewModel.getEmployeeDetails()
        activity?.lifecycleScope?.launch {
            viewModel.employeeDetails.observe(requireActivity()) {
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

//sliding pane layout listener that displays employee details in new fragment
class VmOnBackPressedCallback(private val slidingPaneLayout: SlidingPaneLayout) : OnBackPressedCallback(slidingPaneLayout.isSlideable && slidingPaneLayout.isOpen),SlidingPaneLayout.PanelSlideListener {
    init {
        slidingPaneLayout.addPanelSlideListener(this)
    }
    override fun handleOnBackPressed() {
        slidingPaneLayout.closePane()
    }

    override fun onPanelSlide(panel: View, slideOffset: Float) {}

    override fun onPanelOpened(panel: View) {
        isEnabled = true
    }

    override fun onPanelClosed(panel: View) {
        isEnabled =false
    }

}
