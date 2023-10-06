package com.example.selfchange

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.selfchange.databinding.FragmentScondScreenBinding


class scondScreen : Fragment() {
    private lateinit var binding: FragmentScondScreenBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentScondScreenBinding.inflate(layoutInflater)
        binding.apply {
            btn2.setOnClickListener {
                if (Name!!.length() == 0){
                    Toast.makeText(context,"please enter the Name",Toast.LENGTH_SHORT).show()
                }else{
                    val directions=scondScreenDirections.actionScondScreenToDashboardScreen(Name.text.toString())
                    findNavController().navigate(directions)
                }

            }

        }
        return binding.root

    }


}