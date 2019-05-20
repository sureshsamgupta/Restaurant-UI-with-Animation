package com.sureshgupta.shoppingcart.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout

import com.github.aakira.expandablelayout.ExpandableLayout
import com.sureshgupta.shoppingcart.MainActivity
import com.sureshgupta.shoppingcart.R
import com.sureshgupta.shoppingcart.fragment.ShoppingCartSummery
import kotlinx.android.synthetic.main.salad_menu_row.view.*

/**
 * Created by sureshgupta on 24/01/18.
 */

class SaladMenuAdapter(private var conext: Context) : RecyclerView.Adapter<SaladMenuAdapter.SaladMenuHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SaladMenuHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.salad_menu_row, parent, false)

        return SaladMenuHolder(itemView)
    }

    override fun onBindViewHolder(holder: SaladMenuHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 20
    }



    inner class SaladMenuHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        init {


           itemView. expandableLayout.collapse()

            itemView.containerLayout.setOnClickListener(this)
            itemView.btnPlus.setOnClickListener(this)
        }

        override fun onClick(v: View) {
            when (v.id) {
                R.id.containerLayout -> (conext as MainActivity).switchFragment(ShoppingCartSummery())
                R.id.btnPlus -> if (itemView.expandableLayout.isExpanded) {
                    itemView.expandableLayout.collapse()
                } else {
                    itemView.expandableLayout.expand()
                }
            }
        }
    }

}
