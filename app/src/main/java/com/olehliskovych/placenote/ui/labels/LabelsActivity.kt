package com.olehliskovych.placenote.ui.labels

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.olehliskovych.placenote.R

import com.olehliskovych.placenote.databinding.ActivityLabelsBinding
import com.olehliskovych.placenote.databinding.ActivityMainBinding
import com.olehliskovych.placenote.ui.base.BaseActivity

class LabelsActivity : BaseActivity() {

    private lateinit var binding: ActivityLabelsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_labels)
    }

    override fun onResume() {
        super.onResume()

    }

    override fun setupUI() {
        setSupportActionBar(binding!!.toolbar)
    }

    private fun navigateToLabelList() {

    }
}
