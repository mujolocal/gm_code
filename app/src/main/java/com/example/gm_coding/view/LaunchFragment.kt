package com.example.gm_coding.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.gm_coding.R
import com.example.gm_coding.databinding.FragmentLaunchBinding
import com.example.gm_coding.util.ApiState
import com.example.gm_coding.viewModel.LaunchViewModel


class LaunchFragment : Fragment(R.layout.fragment_launch) {

    private val launchVM by viewModels<LaunchViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        FragmentLaunchBinding.bind(view).apply {
            lifecycleOwner = viewLifecycleOwner
            launchViewModel = launchVM
        }
        launchVM.apiState.observe(viewLifecycleOwner) { response ->
            if (response is ApiState.Success) {
                val action = LaunchFragmentDirections.actionLaunchFragmentToArtistListFragment(
                    response.tracks.toTypedArray()
                )
                findNavController().navigate(action)
                launchVM.toggleCompletedState()
            }
        }
    }
}