package com.vlado.plus500asg

import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.app.Fragment
import com.vlado.plus500asg.buysell.BuySellFragment
import com.vlado.plus500asg.list.ItemFragment
import com.vlado.plus500asg.list.dummy.DummyContent
import com.vlado.plus500asg.menu.MenuFragment

class MainActivity : AppCompatActivity(), ItemFragment.OnListFragmentInteractionListener, MenuFragment.OnFragmentInteractionListener {

    val fragmentMenu: MenuFragment = MenuFragment()
    val fragmentBuySell: BuySellFragment = BuySellFragment()
    val fragmentList: ItemFragment = ItemFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //show the menu on every configuration change
        showMenu()
    }

    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun clickedBuySell(v: View){
        changeFragment(fragmentBuySell)
    }

    fun clickedList(v: View){
        changeFragment(fragmentList)
    }

    private fun showMenu(){
        changeFragment(fragmentMenu)
    }

    private fun changeFragment(fragment: Fragment){
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.replace(frame.id, fragment)

        //don't add the start fragment to the back stack
        //because we want to exit the app on back press
        // while we are on the menu fragment
        if(fragment !is MenuFragment)
        transaction.addToBackStack(fragment.tag)

        transaction.commit()
    }

}
