package com.example.tugastablayout

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.StringRes
import com.example.tugastablayout.databinding.FragmentLoginBinding

class Login : Fragment() {
    private lateinit var binding: FragmentLoginBinding

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Gunakan FragmentLoginBinding.inflate di sini
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            btnLogin.setOnClickListener {
                val username = binding.userLogin.text.toString()
                val password = binding.passLogin.text.toString()

                if (username.isNotEmpty() && password.isNotEmpty()) {
                    val intent = Intent(activity, MainActivity2::class.java)
                    intent.putExtra("USERNAME", username)
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
            userLogin.text?.clear()
            passLogin.text?.clear()
            checkboxLogin.isChecked = false
        }
    }
}
