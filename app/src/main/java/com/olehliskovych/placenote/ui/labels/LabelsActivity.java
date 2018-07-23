package com.olehliskovych.placenote.ui.labels;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.olehliskovych.placenote.databinding.ActivityLabelsBinding;
import com.olehliskovych.placenote.ui.base.BaseActivity;

public class LabelsActivity extends BaseActivity {

    private ActivityLabelsBinding binding;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void setupUI() {
        setSupportActionBar(binding.toolbar);
    }

    private void navigateToLabelList() {

    }
}
