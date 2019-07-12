package com.vlado.plus500asg

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
import android.support.v4.app.Fragment
import com.vlado.plus500asg.buysell.BuySellFragment
import com.vlado.plus500asg.list.ItemFragment
import com.vlado.plus500asg.list.dummy.DummyContent
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity(), ItemFragment.OnListFragmentInteractionListener {


    val fragmentBuySell: BuySellFragment = BuySellFragment()
    val fragmentList: ItemFragment = ItemFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onListFragmentInteraction(item: DummyContent.DummyItem?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun clickedBuySell(v: View){
        removeAllFragments()
        changeFragment(fragmentBuySell)
    }

    fun clickedList(v: View){
        removeAllFragments()
        changeFragment(fragmentList)
    }

    private fun changeFragment(fragment: Fragment){
        main_menu.visibility = View.GONE
        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        transaction.add(frame.id, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun removeAllFragments() {
        val manager = supportFragmentManager
        while (manager.getBackStackEntryCount() > 0) {
            manager.popBackStackImmediate()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        main_menu.visibility = View.VISIBLE
    }
}
