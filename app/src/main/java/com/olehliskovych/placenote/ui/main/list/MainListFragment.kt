package com.olehliskovych.placenote.ui.main.list

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.olehliskovych.placenote.R
import com.olehliskovych.placenote.databinding.FragmentMainListBinding
import com.olehliskovych.placenote.ui.base.BaseFragment

class MainListFragment : BaseFragment() {

    private lateinit var binding: FragmentMainListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_list, container, false)
        setupUI()
        return binding.root
    }

    private fun setupUI() {

    }
}