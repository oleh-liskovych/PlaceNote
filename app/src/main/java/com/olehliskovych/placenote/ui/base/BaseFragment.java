package com.olehliskovych.placenote.ui.base;

import android.os.Bundle;

import dagger.android.support.DaggerFragment;

public abstract class BaseFragment extends DaggerFragment {

    public static BaseFragment newInstance(Class<? extends BaseFragment> fragmentClass) {
        BaseFragment fragment = null;
        try {
            fragment = fragmentClass.newInstance();
        } catch (IllegalAccessException | java.lang.InstantiationException e) {
            e.printStackTrace();
        }

        return fragment;
    }

}
