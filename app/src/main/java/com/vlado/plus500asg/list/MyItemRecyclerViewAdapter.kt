package com.vlado.plus500asg.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.vlado.plus500asg.R


import com.vlado.plus500asg.list.ItemFragment.OnListFragmentInteractionListener
import com.vlado.plus500asg.list.dummy.DummyContent.DummyItem

import kotlinx.android.synthetic.main.fragment_item.view.*

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyItemRecyclerViewAdapter(
    private val mValues: List<DummyItem>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as DummyItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
//            mListener?.onListFragmentInteraction(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]

        val res = holder.mView.context.resources

        holder.mPairView.text = item.pair
        holder.mFirstDigitsView.text = item.firstDigits
        holder.mSecondDigitsView.text = item.secondDigits
        holder.mPercentageView.text = "%s%s".format(item.precentage, res.getString(R.string.precent))

        if(item.precentage.toDouble() > 0){
            holder.mPercentageView.setTextColor(res.getColor(R.color.colorGreen, null))
            holder.mFirstDigitsView.setTextColor(res.getColor(R.color.colorRed, null))
            holder.mSecondDigitsView.setTextColor(res.getColor(R.color.colorRed, null))
        } else {
            holder.mPercentageView.setTextColor(res.getColor(R.color.colorRed, null))
            holder.mFirstDigitsView.setTextColor(res.getColor(R.color.colorGreen, null))
            holder.mSecondDigitsView.setTextColor(res.getColor(R.color.colorGreen, null))

        }

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mPairView: TextView = mView.pair
        val mFirstDigitsView: TextView = mView.first_digits
        val mSecondDigitsView: TextView = mView.second_digits
        val mPercentageView: TextView = mView.precentage
    }
}
