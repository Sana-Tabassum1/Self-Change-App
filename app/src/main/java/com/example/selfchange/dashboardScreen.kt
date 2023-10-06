package com.example.selfchange

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.selfchange.databinding.FragmentDashboardScreenBinding


class dashboardScreen : Fragment() {
    private lateinit var binding: FragmentDashboardScreenBinding
    //recycler
    private lateinit var recyclerView: RecyclerView
    private lateinit var list:ArrayList<ModelRecycler>
    lateinit var imgId:Array<Int>
    lateinit var text:Array<String>
    //arg
    private val args: dashboardScreenArgs by navArgs()
    private var name=""





    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding=FragmentDashboardScreenBinding.inflate(layoutInflater)
        //argu passing
        name=args.name
        binding.text1.text=name

        //recyclerview

        imgId= arrayOf(
                    R.drawable.smile,
                    R.drawable.productivity ,
                    R.drawable.growth,
                    R.drawable.feelgood,
                    R.drawable.confidence,
                    R.drawable.morning,
                    R.drawable.night,
                    R.drawable.selfdiscover,
                    R.drawable.selflove,
                    R.drawable.walking,
                    R.drawable.workout,
                    R.drawable.writebook,
                    R.drawable.family,
                    R.drawable.adventure,
                    R.drawable.badgood

        )

        text= arrayOf(
           "smile",
            "productivity",
            "growth",
            "feelgood",
            "confidence",
            "morning",
            "night",
            "seldDicover",
            "self Love",
            "walking",
            "workout",
            "write Book",
            "family",
            "adventure",
            "badgood"
        )
        val numberOfColumns = 2
    binding.recyclerview.layoutManager=GridLayoutManager(context,numberOfColumns,RecyclerView.VERTICAL,false)

        list= arrayListOf<ModelRecycler>()
        getUserData()

        

        return binding.root
    }

    private fun getUserData() {
        for (i in imgId.indices){

            val model=ModelRecycler(text[i],imgId[i])
            list.add(model)
        }
         var adaptor=AdaptorRecycler(list)
        binding.recyclerview.adapter=adaptor

        adaptor.onItemCkick(object :AdaptorRecycler.onItemClickListener{
            override fun onItemClick(position: Int) {
                val controller=findNavController()
               controller.navigate(R.id.action_dashboardScreen_to_boxFragment)
            }


        })

    }


}