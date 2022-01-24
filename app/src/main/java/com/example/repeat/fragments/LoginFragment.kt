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

class LoginFragment : Fragment(R.layout.fragment_login) {

   private lateinit var editTextEmail: EditText
   private lateinit var editTextPassword: EditText
   private lateinit var buttonLogin: Button
   private lateinit var buttonRegister: Button
   private lateinit var buttonForgotPassword: Button
   private lateinit var buttonAboutApp: Button


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

        registerListeners()

    }

    private fun init() {
        editTextEmail = view?.findViewById(R.id.editTextEmail)!!
        editTextPassword = view?.findViewById(R.id.editTextPassword)!!
        buttonLogin = view?.findViewById(R.id.buttonLogin)!!
        buttonRegister = view?.findViewById(R.id.buttonRegister)!!
        buttonForgotPassword = view?.findViewById(R.id.buttonForgotPassword)!!
        buttonAboutApp = view?.findViewById(R.id.buttonAbout)!!


    }

    private fun registerListeners() {
        buttonRegister.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(LoginFragmentDirections.actionLoginFragmentToRegisterFragment())
        }


        buttonForgotPassword.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(LoginFragmentDirections.actionLoginFragmentToPasswordResetFragment())
        }

        buttonAboutApp.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(LoginFragmentDirections.actionLoginFragmentToAboutAppFragment())
        }



        buttonLogin.setOnClickListener {


            val email = editTextEmail.text.toString()
            val password = editTextPassword.text.toString()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(activity, "Type your E-mail and Password first!", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener

            }

            FirebaseAuth.getInstance()
                .signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Navigation.findNavController(requireView()).navigate(LoginFragmentDirections.actionLoginFragmentToProfileFragment())
                    } else {
                        Toast.makeText(
                            activity,
                            "E-mail or Password is incorrect!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }


        }

    }
}