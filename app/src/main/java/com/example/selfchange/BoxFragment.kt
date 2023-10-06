package com.example.selfchange

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.selfchange.databinding.FragmentBoxBinding


class BoxFragment : Fragment() {

    private lateinit var binding: FragmentBoxBinding
    lateinit var boxlist: ArrayList<modelbox>
    lateinit var numtext: Array<String>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBoxBinding.inflate(layoutInflater)
        //Boxrecycler
        numtext = arrayOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20","21")
        val numberOfColumns = 5
        binding.boxrecycler.layoutManager = GridLayoutManager(context, numberOfColumns, RecyclerView.VERTICAL, false)


        boxlist = arrayListOf<modelbox>()
        getUserData()

        return binding.root
    }

    private fun getUserData() {
        for (i in numtext.indices) {

            val model = modelbox(numtext[i])
            boxlist.add(model)
        }
        var Badaptor=AdaptorBox(boxlist)
        binding.boxrecycler.adapter=Badaptor


        Badaptor.onItemCkick(object :AdaptorBox.onItemClickListener{
            override fun onItemClick(position: Int) {
                val controller=findNavController()
                controller.navigate(R.id.action_boxFragment_to_scratchFragment)
            }


        })
    }
}