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

class PasswordResetFragment : Fragment(R.layout.fragment_password_reset) {

    private lateinit var editTextEmail: EditText
    private lateinit var buttonResetPassword: Button
    private lateinit var buttonBack3: Button


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_password_reset, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        registerListeners()
    }
    private fun init(){
        editTextEmail = view?.findViewById(R.id.editTextEmail)!!
        buttonResetPassword = view?.findViewById(R.id.buttonResetPassword)!!
        buttonBack3 = view?.findViewById(R.id.buttonBack3)!!


    }
    private fun registerListeners(){
        buttonResetPassword.setOnClickListener {
            val email = editTextEmail.text.toString()

            if (email.isEmpty()) {
                Toast.makeText(activity, "Line is empty!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            FirebaseAuth.getInstance().sendPasswordResetEmail(email)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful) {
                        Toast.makeText(activity, "Time To Check E-mail", Toast.LENGTH_SHORT).show()
                        Navigation.findNavController(requireView()).navigate(PasswordResetFragmentDirections.actionPasswordResetFragmentToLoginFragment())
                    } else {
                        Toast.makeText(activity, "ERROR!", Toast.LENGTH_SHORT).show()
                    }
                }
        }

        buttonBack3.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(PasswordResetFragmentDirections.actionPasswordResetFragmentToLoginFragment())
        }
    }
}