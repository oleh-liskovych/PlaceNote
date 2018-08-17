package com.olehliskovych.placenote.ui.base

import dagger.android.support.DaggerFragment

abstract class BaseFragment : DaggerFragment() {
    companion object {

        fun newInstance(fragmentClass: Class<out BaseFragment>): BaseFragment? {
            var fragment: BaseFragment? = null
            try {
                fragment = fragmentClass.newInstance()
            } catch (e: IllegalAccessException) {
                e.printStackTrace()
            } catch (e: java.lang.InstantiationException) {
                e.printStackTrace()
            }

            return fragment
        }
    }

}
