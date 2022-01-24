package com.example.repeat.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.repeat.R

class AboutAppFragment : Fragment(R.layout.fragment_aboutapp) {

    private lateinit var buttonBack: Button
    private lateinit var textViewAbout: TextView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_aboutapp, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        backlisteners()
    }

    private fun init() {
        buttonBack = view?.findViewById(R.id.buttonBack)!!
    }

    private fun backlisteners() {
        buttonBack.setOnClickListener {
            Navigation.findNavController(requireView())
                .navigate(AboutAppFragmentDirections.actionAboutAppFragmentToLoginFragment())
        }

    }
}