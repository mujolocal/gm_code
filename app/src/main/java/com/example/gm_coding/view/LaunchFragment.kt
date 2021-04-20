package com.example.gm_coding.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.gm_coding.R
import com.example.gm_coding.databinding.ActivityMainBinding
import com.example.gm_coding.databinding.FragmentLaunchBinding
import com.example.gm_coding.viewModel.LaunchViewModel


class LaunchFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentLaunchBinding = FragmentLaunchBinding.inflate(inflater,container,false)
        binding.launchViewModel = ViewModelProvider(this).get(LaunchViewModel::class.java)
        return binding.root
    }


}