package com.example.repeat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import android.widget.Button
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.repeat.R
import com.google.firebase.auth.FirebaseAuth


class RegisterFragment : Fragment(R.layout.fragment_register) {

    private lateinit var editTextEmail: EditText
    private lateinit var editTextPassword: EditText
    private lateinit var buttonRegister: Button
    private lateinit var checkBox: CheckBox
    private lateinit var buttonBack4: Button


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        init()
        registerListeners()
    }

    private fun init() {
        editTextEmail = view?.findViewById(R.id.editTextEmail)!!
        editTextPassword = view?.findViewById(R.id.editTextPassword)!!
        buttonRegister = view?.findViewById(R.id.buttonRegister)!!
        checkBox = view?.findViewById(R.id.checkBox)!!
        buttonBack4 = view?.findViewById(R.id.buttonBack4)!!
    }

    private fun registerListeners() {
        buttonRegister.setOnClickListener {
            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(activity, "Empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (checkBox.isChecked) {
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            Toast.makeText(activity, "REGISTRATION SUCCESSFUL", Toast.LENGTH_SHORT).show()
                            Navigation.findNavController(requireView())
                                .navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
                        } else {
                            Toast.makeText(activity, "ERROR!", Toast.LENGTH_SHORT).show()
                        }

                    }

            } else {

                Toast.makeText(activity, "ERROR!", Toast.LENGTH_SHORT).show()
            }
        }

        buttonBack4.setOnClickListener {
            Navigation.findNavController(requireView())
                .navigate(RegisterFragmentDirections.actionRegisterFragmentToLoginFragment())
        }
    }
}