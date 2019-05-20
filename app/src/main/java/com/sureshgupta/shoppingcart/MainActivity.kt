package com.sureshgupta.shoppingcart

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.RelativeLayout

import com.sureshgupta.shoppingcart.fragment.HomeFragment
import com.sureshgupta.shoppingcart.fragment.SaladMenuFragment
import com.sureshgupta.shoppingcart.fragment.ShoppingCartSummery
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    var currFrag: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        switchFirstFragment(HomeFragment())

    }


    fun switchFirstFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit).replace(R.id.container, fragment).commitAllowingStateLoss()
    }

    override fun onBackPressed() {
        if (currFrag is HomeFragment) {
            super.onBackPressed()
        } else if (currFrag is SaladMenuFragment) {
            val animfadeout: Animation
            animfadeout = AnimationUtils.loadAnimation(this, R.anim.slide_in2)
            animfadeout.duration = 500
            animLayout2.visibility = View.VISIBLE
            animLayout1.visibility = View.GONE
            animLayout3.visibility = View.GONE

            animLayout2.startAnimation(animfadeout)
            animfadeout.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {

                    super@MainActivity.onBackPressed()

                }

                override fun onAnimationEnd(animation: Animation) {

                    animLayout2.visibility = View.GONE
                    animLayout1.visibility = View.VISIBLE
                    animLayout3.visibility = View.GONE
                }

                override fun onAnimationRepeat(animation: Animation) {

                }
            })
        } else if (currFrag is ShoppingCartSummery) {
            val animfadeout: Animation
            animfadeout = AnimationUtils.loadAnimation(this, R.anim.slide_in2)
            animfadeout.duration = 500
            animLayout2.visibility = View.GONE
            animLayout1.visibility = View.GONE
            animLayout3.visibility = View.VISIBLE

            animLayout3.startAnimation(animfadeout)
            animfadeout.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {

                    super@MainActivity.onBackPressed()

                }

                override fun onAnimationEnd(animation: Animation) {

                    animLayout2.visibility = View.VISIBLE
                    animLayout1.visibility = View.GONE
                    animLayout3.visibility = View.GONE
                }

                override fun onAnimationRepeat(animation: Animation) {

                }
            })
        }
    }

    fun switchFragment(fragment: Fragment) {

        if (fragment is HomeFragment) {

        } else if (fragment is SaladMenuFragment) {

            val animfadeout: Animation
            animfadeout = AnimationUtils.loadAnimation(this, R.anim.slide_out2)
            animfadeout.duration = 500
            animLayout2.visibility = View.VISIBLE
            animLayout1.visibility = View.GONE
            animLayout3.visibility = View.GONE

            animLayout2.startAnimation(animfadeout)
            animfadeout.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {


                }

                override fun onAnimationEnd(animation: Animation) {


                }

                override fun onAnimationRepeat(animation: Animation) {

                }
            })

        } else if (fragment is ShoppingCartSummery) {

            val animfadeout: Animation
            animfadeout = AnimationUtils.loadAnimation(this, R.anim.slide_out2)
            animfadeout.duration = 500
            animLayout2.visibility = View.GONE
            animLayout1.visibility = View.GONE
            animLayout3.visibility = View.VISIBLE

            animLayout3.startAnimation(animfadeout)
            animfadeout.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {


                }

                override fun onAnimationEnd(animation: Animation) {


                }

                override fun onAnimationRepeat(animation: Animation) {

                }
            })
        }

        supportFragmentManager.beginTransaction().setCustomAnimations(R.anim.enter, R.anim.exit, R.anim.pop_enter, R.anim.pop_exit).replace(R.id.container, fragment).addToBackStack(null).commitAllowingStateLoss()
    }


}
