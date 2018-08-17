package com.olehliskovych.placenote.ui.note

import android.databinding.DataBindingUtil
import android.os.Bundle

import com.olehliskovych.placenote.databinding.ActivityNoteBinding
import com.olehliskovych.placenote.ui.base.BaseActivity
import com.olehliskovych.placenote.R
import com.olehliskovych.placenote.ui.base.BaseFragment
import com.olehliskovych.placenote.ui.note.details.NoteDetailsFragment

class NoteActivity : BaseActivity() {

    private lateinit var binding: ActivityNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_note)

        setupUI()

    }

    override fun setupUI() {
        setSupportActionBar(binding.toolbar)

    }

    override fun onResume() {
        super.onResume()
        if (currentFragmentName == null) {
            navigateToNoteDetails()
        } else {
            navigateToFragment(currentFragment!!, true, true)
        }
    }

    private fun navigateToNoteDetails() {
        val fragment = BaseFragment.newInstance(NoteDetailsFragment::class.java) as NoteDetailsFragment?
        navigateToFragment(fragment!!, true, true)
    }
}
