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
import com.google.firebase.auth.FirebaseAuth


class ProfileFragment : Fragment(R.layout.fragment_profile) {

    private lateinit var buttonPasswordChange: Button
    private lateinit var buttonLogout: Button
    private lateinit var textView: TextView
    private lateinit var buttonReceipt: Button


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        registerListeners()
        textView.text = FirebaseAuth.getInstance().currentUser?.uid

    }
private fun init() {
    buttonLogout = view?.findViewById(R.id.buttonLogout)!!
    buttonPasswordChange = view?.findViewById(R.id.buttonPasswordChange)!!
    textView = view?.findViewById(R.id.textView)!!
    buttonReceipt = view?.findViewById(R.id.receipts)!!

}

private fun registerListeners() {
    buttonPasswordChange.setOnClickListener {
        FirebaseAuth.getInstance().signOut()
    }

    buttonPasswordChange.setOnClickListener {
        Navigation.findNavController(requireView()).navigate(ProfileFragmentDirections.actionProfileFragmentToPasswordChangeFragment())
    }

    buttonLogout.setOnClickListener() {
        Navigation.findNavController(requireView()).navigate(ProfileFragmentDirections.actionProfileFragmentToLoginFragment())
    }

    buttonReceipt.setOnClickListener {
        Navigation.findNavController(requireView()).navigate(ProfileFragmentDirections.actionProfileFragmentToReceiptsFragment())
    }
  }
}