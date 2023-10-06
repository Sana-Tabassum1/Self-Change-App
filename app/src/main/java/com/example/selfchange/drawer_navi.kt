package com.example.selfchange

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.example.selfchange.databinding.FragmentDrawerNaviBinding


class drawer_navi : Fragment() {


    private lateinit var binding: FragmentDrawerNaviBinding
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout
    lateinit var toolbar: Toolbar
    lateinit  var supportActionBar:ActionBar


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentDrawerNaviBinding.inflate(layoutInflater)

            toggle = ActionBarDrawerToggle(this.activity,drawerLayout,toolbar,R.string.OpenDrawer,R.string.CloseDrawer)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)



            drawerLayout.closeDrawer(GravityCompat.START)


        return (binding.root)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (toggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
    }


}