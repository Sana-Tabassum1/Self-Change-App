package com.example.selfchange

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.selfchange.databinding.FragmentFirstScreenBinding
import java.util.jar.Attributes.Name


class firstScreen : Fragment() {
    private lateinit var binding: FragmentFirstScreenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding=FragmentFirstScreenBinding.inflate(layoutInflater)
        val navController = findNavController()
       binding.apply {
           binding.btnGo.setOnClickListener {
               navController.navigate(R.id.action_firstScreen_to_scondScreen)
           }
       }
        return binding.root
    }


}