package com.example.cloudhotelroomreservationapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.cloudhotelroomreservationapp.databinding.FragmentProfileBinding


class ProfileFragment : Fragment() {

    private lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentProfileBinding.inflate(inflater,container,false)

        binding.logout.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_loginFragment)
        }


        binding.Reservations.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_reservationFragment2)
        }

        binding.About.setOnClickListener {
            findNavController().navigate(R.id.action_profileFragment_to_aboutFragment)
        }


        return binding.root
    }
}