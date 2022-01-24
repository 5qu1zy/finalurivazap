package com.example.repeat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.repeat.R
import com.google.firebase.auth.FirebaseAuth

class PasswordChangeFragment : Fragment(R.layout.fragment_password_change) {

    private lateinit var editTextPassword: EditText
    private lateinit var buttonChangePassword: Button
    private lateinit var buttonBack2: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_password_change, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        registerListeners()
    }

    private fun init() {
        editTextPassword = view?.findViewById(R.id.editTextPassword)!!
        buttonChangePassword = view?.findViewById(R.id.buttonChangePassword)!!
        buttonBack2 = view?.findViewById(R.id.buttonBack2)!!
    }

    private fun registerListeners() {
        buttonChangePassword.setOnClickListener{
            val newPassword = editTextPassword.text.toString()
            if (newPassword.isEmpty() || newPassword.length < 7){
                Toast.makeText(activity, "Type at least 7 character!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            FirebaseAuth.getInstance().currentUser?.updatePassword(newPassword)
                ?.addOnCompleteListener { task ->
                    if (task.isSuccessful){
                        Toast.makeText(activity, "Success", Toast.LENGTH_SHORT).show()
                        Navigation.findNavController(requireView()).navigate(PasswordChangeFragmentDirections.actionPasswordChangeFragmentToProfileFragment())
                         
                    } else {
                        Toast.makeText(activity, "ERROR!", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        buttonBack2.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(PasswordChangeFragmentDirections.actionPasswordChangeFragmentToProfileFragment())
        }
    }
}