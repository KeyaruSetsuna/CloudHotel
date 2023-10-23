package com.example.cloudhotelroomreservationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.cloudhotelroomreservationapp.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private lateinit var binding: FragmentAboutBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentAboutBinding.inflate(inflater,container,false)

        binding.button2.setOnClickListener {
            findNavController().navigate(R.id.action_aboutFragment_to_profileFragment)
        }

        return binding.root
    }
}