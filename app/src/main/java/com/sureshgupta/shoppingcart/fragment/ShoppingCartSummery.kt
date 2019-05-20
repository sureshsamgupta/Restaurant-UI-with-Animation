package com.sureshgupta.shoppingcart.fragment

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView

import com.sureshgupta.shoppingcart.MainActivity
import com.sureshgupta.shoppingcart.R
import com.sureshgupta.shoppingcart.adapter.ShoppingCartSummeryAdapter
import kotlinx.android.synthetic.main.shopping_cart_summery_frag.*

/**
 * Created by sureshgupta on 24/01/18.
 */

class ShoppingCartSummery : Fragment(), View.OnClickListener {



    private var btnBottom: RelativeLayout? = null
    private var bottomLayout: LinearLayout? = null
    private var bottomLinearForAnim: LinearLayout? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.shopping_cart_summery_frag, container, false)

    }


    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).currFrag = this@ShoppingCartSummery


        bottomLayout?.visibility = View.GONE

        btnCheckOut?.setOnClickListener(this)


        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        salad_rec?.layoutManager = linearLayoutManager

        val shoppingCartSummeryAdapter = ShoppingCartSummeryAdapter(activity)
        salad_rec?.adapter = shoppingCartSummeryAdapter
        shoppingCartSummeryAdapter.notifyDataSetChanged()

        btnBottom?.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.btnBottom ->

                if (bottomLayout?.visibility == View.VISIBLE) {
                    val animfadeout: Animation
                    animfadeout = AnimationUtils.loadAnimation(activity, R.anim.slide_down)
                    animfadeout.duration = 500


                    bottomLinearForAnim!!.startAnimation(animfadeout)
                    animfadeout.setAnimationListener(object : Animation.AnimationListener {
                        override fun onAnimationStart(animation: Animation) {
                            btnDownArrow!!.rotation = 90f

                        }

                        override fun onAnimationEnd(animation: Animation) {
                            bottomLayout!!.visibility = View.GONE
                        }

                        override fun onAnimationRepeat(animation: Animation) {

                        }
                    })
                } else if (bottomLayout!!.visibility == View.GONE) {
                    val animfadeout: Animation
                    animfadeout = AnimationUtils.loadAnimation(activity, R.anim.slide_up)
                    animfadeout.duration = 500
                    bottomLayout!!.visibility = View.VISIBLE


                    bottomLinearForAnim!!.startAnimation(animfadeout)
                    animfadeout.setAnimationListener(object : Animation.AnimationListener {
                        override fun onAnimationStart(animation: Animation) {

                            btnDownArrow!!.rotation = 270f
                        }

                        override fun onAnimationEnd(animation: Animation) {}

                        override fun onAnimationRepeat(animation: Animation) {

                        }
                    })
                }
            R.id.btnCheckOut -> {
                startActivity(Intent(activity, MainActivity::class.java))
                activity.finish()
            }
        }
    }
}
