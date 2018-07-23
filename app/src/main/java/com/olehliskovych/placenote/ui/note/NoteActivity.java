package com.olehliskovych.placenote.ui.note;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.olehliskovych.placenote.databinding.ActivityNoteBinding;
import com.olehliskovych.placenote.ui.base.BaseActivity;
import com.olehliskovych.placenote.R;
import com.olehliskovych.placenote.ui.base.BaseFragment;
import com.olehliskovych.placenote.ui.note.details.NoteDetailsFragment;

public class NoteActivity extends BaseActivity {

    private ActivityNoteBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_note);

        setupUI();

    }

    @Override
    protected void setupUI() {
        setSupportActionBar(binding.toolbar);

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (currentFragmentName == null) {
            navigateToNoteDetails();
        } else {
            navigateToFragment(currentFragment, true, true);
        }
    }

    private void navigateToNoteDetails() {
        final NoteDetailsFragment fragment = (NoteDetailsFragment) BaseFragment.newInstance(NoteDetailsFragment.class);
        navigateToFragment(fragment, true, true);
    }
}
