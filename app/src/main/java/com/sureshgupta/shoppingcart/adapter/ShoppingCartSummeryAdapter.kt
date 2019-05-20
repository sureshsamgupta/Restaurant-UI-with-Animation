package com.sureshgupta.shoppingcart.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sureshgupta.shoppingcart.R

/**
 * Created by sureshgupta on 24/01/18.
 */

class ShoppingCartSummeryAdapter(private var context: Context) : RecyclerView.Adapter<ShoppingCartSummeryAdapter.ShoppinCartHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppinCartHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.shopping_cart_summery_row, parent, false)

        return ShoppinCartHolder(itemView)
    }

    override fun onBindViewHolder(holder: ShoppinCartHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        return 20
    }

    inner class ShoppinCartHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


}
