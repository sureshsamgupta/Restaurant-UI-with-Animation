package com.sureshgupta.shoppingcart.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView

import com.sureshgupta.shoppingcart.MainActivity
import com.sureshgupta.shoppingcart.R
import com.sureshgupta.shoppingcart.fragment.SaladMenuFragment
import kotlinx.android.synthetic.main.home_row.view.*

/**
 * Created by sureshgupta on 23/01/18.
 */

class HomeRowAdapter(private var context: Context, private var stringList: List<String>) : RecyclerView.Adapter<HomeRowAdapter.HomeRowHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeRowHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.home_row, parent, false)

        return HomeRowHolder(itemView)
    }

    override fun onBindViewHolder(holder: HomeRowHolder, position: Int) {

        holder.itemView.txtName.text = stringList[position]

    }

    override fun getItemCount(): Int {
        return stringList.size
    }


    inner class HomeRowHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {


        init {




            itemView.containerLayout.setOnClickListener(this)


        }

        override fun onClick(v: View) {
            when (v.id) {
                R.id.containerLayout -> (context as MainActivity).switchFragment(SaladMenuFragment())
            }
        }
    }


}
