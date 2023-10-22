package com.example.cloudhotelroomreservationapp

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.cloudhotelroomreservationapp.databinding.FragmentSignupBinding


class SignupFragment : Fragment() {

    private lateinit var binding: FragmentSignupBinding
    private lateinit var navController: NavController
    private lateinit var db: LogInSignUpDatabase


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignupBinding.inflate(inflater,container,false)
        binding.backbutton.setOnClickListener {
            findNavController().navigate(R.id.action_signupFragment_to_mainFragment)
        }

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        db = LogInSignUpDatabase(requireContext())

        binding.btnSignup.setOnClickListener {
            val fnametext = binding.firstnameInput.text.toString()
            val unametext = binding.usernameInput.text.toString()
            val pwordtext = binding.passwordInput.text.toString()
            val cpwordtext = binding.confirmPasswordInput.text.toString()
            val savedata = db.insertdata(fnametext,unametext, pwordtext)

            if (TextUtils.isEmpty(fnametext) || TextUtils.isEmpty(unametext) || TextUtils.isEmpty(pwordtext) || TextUtils.isEmpty(cpwordtext)) {
                Toast.makeText(requireContext(), "Add Username or Password", Toast.LENGTH_SHORT).show()
            } else {
                if (pwordtext == cpwordtext) {
                    if (savedata) {
                        Toast.makeText(requireContext(), "User Exist", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(requireContext(), "Sign Up Successful", Toast.LENGTH_SHORT).show()
                        findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
                    }
                } else {
                    Toast.makeText(requireContext(), "Password does not match", Toast.LENGTH_SHORT).show()
                }
            }
        }

        binding.textViewLogin.setOnClickListener {
            findNavController().navigate(R.id.action_signupFragment_to_loginFragment)
        }

    }
}