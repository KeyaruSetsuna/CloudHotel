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
import com.example.cloudhotelroomreservationapp.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private lateinit var dbh: LogInSignUpDatabase
    private lateinit var navController: NavController
    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater,container,false)

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_mainFragment)
        }

        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        dbh = LogInSignUpDatabase(requireContext())

        binding.btnLogin.setOnClickListener {

            val useredtx = binding.usernameInput.text.toString()
            val passedtx = binding.loginpasswordInput.text.toString()

            if (TextUtils.isEmpty(useredtx) || TextUtils.isEmpty(passedtx)) {
                Toast.makeText(requireContext(), "Add Username & Password", Toast.LENGTH_SHORT).show()
            } else {
                val checkuser = dbh.checkuserpass(useredtx, passedtx)
                if (checkuser == true) {
                    Toast.makeText(requireContext(), "Log In Successful", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_loginFragment_to_homepageFragment)
                } else {
                    Toast.makeText(requireContext(), "Wrong Password & Username", Toast.LENGTH_SHORT).show()
                }
            }

        }
        binding.textViewSignup.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }

    }
}