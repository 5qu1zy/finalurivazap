package com.example.repeat.fragments

import MyRecyclerviewAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.repeat.R

class ReceiptsFragment: Fragment(R.layout.fragment_receipt) {

    private lateinit var buttonBack5: Button
    private lateinit var foods:List<FoodFragment>
    private lateinit var recyclerview: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_receipt, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        registerListeners()

    }

    private fun init(){
        buttonBack5 = view?.findViewById(R.id.buttonBack5)!!
        recyclerview = view?.findViewById(R.id.RecyclerView)!!

        foods = listOf(
            FoodFragment("ხინკალი/khinkali","https://media-cdn.tripadvisor.com/media/photo-s/19/dc/6a/37/xinkali.jpg"),
            FoodFragment("ხაჭაპური/khachapuri","https://media-cdn.tripadvisor.com/media/photo-s/07/dd/77/c9/lagidze-water.jpg"),
            FoodFragment("საცივი/satsivi","https://georgianjournal.ge/media/images/georgianews/2017/December/cuisine/satsivi%20vabsheta%20baje.jpg"),
            FoodFragment("ჩაქაფული/chakapuli","https://cdn.tasteatlas.com/images/dishes/4f117bbda2ac468aa18fcfcacd8b1bd6.jpg?w=600&h=450"),
            FoodFragment("მწვადი/mtsvadi","https://gemrielia.ge/media/__sized__/images/107956-crop-c0-5__0-5-450x301-70.jpg"),
            FoodFragment("კუჭმაჭი/kuchmachi","https://live.staticflickr.com/5503/12718403394_d468b04c4b_b.jpg"),
            FoodFragment("ჭვიშტარი/chvishtari","https://georgianjournal.ge/media/_thumb/images/georgianews/2014/September/Cuisine/chvishtari.jpg"),
            FoodFragment("ლობიო/lobio", "https://www.theworldwasherefirst.com/wp-content/uploads/2020/04/DSC05945-2.jpg"),
            FoodFragment("კუბდარი/kubdari", "https://images.culinarybackstreets.com/wp-content/uploads/cb_tbilisi_svaneti_kubdari_nmr2.jpg?lossy=1&ssl=1"),
            FoodFragment("ლობიანი/lobiani", "https://georgianjournal.ge/media/images/georgianews/2017/December/cuisine/lobianilorit.jpg")

        )

        recyclerview.layoutManager = LinearLayoutManager(activity)
        recyclerview.adapter = MyRecyclerviewAdapter(foods)
    }


    private fun registerListeners(){
        buttonBack5.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(ReceiptsFragmentDirections.actionReceiptsFragmentToProfileFragment())
        }
    }
}