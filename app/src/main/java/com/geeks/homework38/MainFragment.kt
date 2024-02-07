package com.geeks.homework38

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.geeks.homework38.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding
    private val characterList = arrayListOf(
        Character("https://images.squarespace-cdn.com/content/v1/5616ac17e4b018d366f57f53/1616923173664-5USKZPHNL65VM3F5T87Z/rick+sanchez+soundboard","Rick Sanchez","Alive"),
        Character("https://imgix.ranker.com/list_img_v2/17110/2777110/original/best-morty-smith-quotes?fit=crop&fm=pjpg&q=80&dpr=2&w=1200&h=720","Morty Smith","Alive"),
        Character("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSrweX60-6-qd7ydgGQvXS7vzHmSf7gyP__fg&usqp=CAU","Albert Einstein","Dead"),
        Character("https://hips.hearstapps.com/hmg-prod/images/season-six-rick-and-morty-1662104018.jpg?crop=0.391xw:0.693xh;0.107xw,0.122xh&resize=1200:*","Jerry Smith ","Alive"),
        Character("https://cdn.rikmorti.ru/uploads/2020/02/sammer-smit-s-pistoletom-rikmorti-ru-315x210.jpg","Summer Smith ","Alive"),
        Character("https://i.redd.it/u8ow19a903m71.png"," Mr.Poopybutthole ","Alive")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =  FragmentMainBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MainAdapter(characterList, this::onClick)
        binding.recyclerView.adapter = adapter
    }
    private fun onClick(model:Character){
        findNavController().navigate(R.id.secondFragment, bundleOf("character" to model))
    }


}