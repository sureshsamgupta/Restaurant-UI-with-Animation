package com.sureshgupta.shoppingcart.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout

import com.sureshgupta.shoppingcart.MainActivity
import com.sureshgupta.shoppingcart.adapter.HomeRowAdapter
import com.sureshgupta.shoppingcart.R
import kotlinx.android.synthetic.main.home_fragment.*

import java.util.ArrayList

/**
 * Created by sureshgupta on 23/01/18.
 */

class HomeFragment : Fragment() {




    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).currFrag = this@HomeFragment



        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        home_rec!!.layoutManager = linearLayoutManager

        val stringList = ArrayList<String>()

        stringList.add("Pizza")
        stringList.add("Salads")
        stringList.add("Desserts")
        stringList.add("Pasta")
        stringList.add("Beverages")
        stringList.add("Burger")
        stringList.add("Chowmin")
        stringList.add("Chilli Potato")
        stringList.add("Chilli Paneer")
        stringList.add("Veg Burger")
        stringList.add("Ras Malai")
        stringList.add("Chhena Khir")

        val homeRowAdapter = HomeRowAdapter(activity, stringList)
        home_rec!!.adapter = homeRowAdapter
        homeRowAdapter.notifyDataSetChanged()


    }
}
