package com.sureshgupta.shoppingcart.fragment

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

import com.sureshgupta.shoppingcart.MainActivity
import com.sureshgupta.shoppingcart.R
import com.sureshgupta.shoppingcart.adapter.SaladMenuAdapter
import kotlinx.android.synthetic.main.shopping_cart_summery_frag.*

/**
 * Created by sureshgupta on 23/01/18.
 */

class SaladMenuFragment : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.salad_menu_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).currFrag = this@SaladMenuFragment



        val linearLayoutManager = LinearLayoutManager(activity)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        salad_rec!!.layoutManager = linearLayoutManager

        val saladMenuAdapter = SaladMenuAdapter(activity)
        salad_rec!!.adapter = saladMenuAdapter
        saladMenuAdapter.notifyDataSetChanged()


    }


    override fun onDestroy() {
        super.onDestroy()

        //        Animation animfadeout;
        //        animfadeout = AnimationUtils.loadAnimation(getActivity(), R.anim.slide_in2);
        //        animfadeout.setDuration(500);
        //        ((MainActivity)getActivity()).animLayout2.setVisibility(View.VISIBLE);
        //        ((MainActivity)getActivity()).animLayout1.setVisibility(View.GONE);
        //        ((MainActivity)getActivity()).animLayout3.setVisibility(View.GONE);
        //
        //        ((MainActivity)getActivity()).animLayout2.startAnimation(animfadeout);
        //        animfadeout.setAnimationListener(new Animation.AnimationListener() {
        //            @Override
        //            public void onAnimationStart(Animation animation) {
        //
        //
        //            }
        //
        //            @Override
        //            public void onAnimationEnd(Animation animation) {
        //
        //                ((MainActivity)getActivity()).animLayout2.setVisibility(View.GONE);
        //                ((MainActivity)getActivity()).animLayout1.setVisibility(View.VISIBLE);
        //                ((MainActivity)getActivity()).animLayout3.setVisibility(View.GONE);
        //            }
        //
        //            @Override
        //            public void onAnimationRepeat(Animation animation) {
        //
        //            }
        //        });
    }
}
