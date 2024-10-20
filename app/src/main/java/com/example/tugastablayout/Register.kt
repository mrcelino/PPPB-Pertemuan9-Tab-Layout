package com.example.tugastablayout

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.example.tugastablayout.databinding.FragmentRegisterBinding


class Register : Fragment() {
    private lateinit var binding: FragmentRegisterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnRegis.setOnClickListener {
                val username = userRegis.text.toString()
                val password = passRegis.text.toString()
                val email = emailRegis.text.toString()
                val phone = phoneRegis.text.toString()

                if (username.isNotEmpty() && password.isNotEmpty()) {
                    val intent = Intent(activity, MainActivity2::class.java)
                    intent.putExtra("USERNAME", username)
                    intent.putExtra("EMAIL", email)
                    intent.putExtra("PHONE", phone)
                    intent.putExtra("PASSWORD", password)
                    startActivity(intent)
                } else {
                    Toast.makeText(requireContext(), "Input tidak boleh kosong", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        with(binding) {
            userRegis.text?.clear()
            emailRegis.text?.clear()
            phoneRegis.text?.clear()
            passRegis.text?.clear()
            checkboxRegis.isChecked = false
        }
    }
}