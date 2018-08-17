package com.olehliskovych.placenote.ui.base

import android.os.Bundle
import android.support.v4.app.FragmentManager
import com.olehliskovych.placenote.R
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {

    var currentFragment: BaseFragment? = null
    var currentFragmentName: String? = null

    companion object {
        private const val FRAGMENT_KEY = "keyFragment"
    }

    @Inject
    protected lateinit var mFragmentManager: FragmentManager

    protected abstract fun setupUI()

    override fun onBackPressed() {
        super.onBackPressed()
        val lastIndexInFragmentStack = mFragmentManager.fragments.size - 1
        currentFragment = mFragmentManager.fragments[lastIndexInFragmentStack] as BaseFragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) {
            restoreFragment(savedInstanceState)
        }
    }

    protected enum class StatusBarColor {
        Master, Detail
    }

    protected fun setStatusBarColor(color: StatusBarColor) {
        if (color == StatusBarColor.Master) {

        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (currentFragment != null) {
            currentFragmentName = currentFragment!!.javaClass.name
            mFragmentManager.putFragment(outState, currentFragmentName, currentFragment)
        }
    }

    protected fun restoreFragment(savedInstanceState: Bundle) {
        currentFragmentName = savedInstanceState.getString(FRAGMENT_KEY, null)
        if (currentFragmentName != null) {
            currentFragment = mFragmentManager.getFragment(savedInstanceState, currentFragmentName) as BaseFragment
        }
    }

    fun navigateToFragment(fragment: BaseFragment,
                           isAddToBackStack: Boolean,
                           isClearBackStack: Boolean) {
        currentFragment = fragment
        if (isClearBackStack) {
            clearBackStack()
        }
        if (isAddToBackStack) {
            mFragmentManager.beginTransaction()
                    .replace(R.id.main_container, fragment)
                    .addToBackStack(fragment.javaClass.name)
                    .commit()
        } else {
            mFragmentManager.beginTransaction()
                    .replace(R.id.main_container, fragment)
                    .commit()
        }
    }

    private fun clearBackStack() {
        val size = mFragmentManager.fragments.size - 1
        for (i in 0 until size) {
            mFragmentManager.popBackStack()
        }
    }

}
































