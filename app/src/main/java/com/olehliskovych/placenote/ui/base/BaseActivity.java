package com.olehliskovych.placenote.ui.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;

import com.olehliskovych.placenote.R;
import com.olehliskovych.placenote.databinding.ActivityMainBinding;

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseActivity extends DaggerAppCompatActivity{

    private static final String FRAGMENT_KEY = "keyFragment";

    protected abstract void setupUI();
    public abstract ActivityMainBinding getBindng();

    protected BaseFragment currentFragment;

    @Inject
    FragmentManager fragmentManager;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        final int lastIndexInFragmentStack = fragmentManager.getFragments().size() - 1;
        currentFragment = (BaseFragment) fragmentManager.getFragments().get(lastIndexInFragmentStack);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            restoreFragment(savedInstanceState);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (currentFragment != null) {
            String fragmentName = currentFragment.getClass().getName();
            fragmentManager.putFragment(outState, fragmentName, currentFragment);
        }
    }

    protected void restoreFragment(@NonNull Bundle savedInstanceState) {
        String fragmentName = savedInstanceState.getString(FRAGMENT_KEY, null);
        if (fragmentName != null) {
            currentFragment = (BaseFragment) fragmentManager.getFragment(savedInstanceState, fragmentName);
        }
    }

    public void navigateToFragment(@NonNull BaseFragment fragment,
                                   boolean isAddToBackStack,
                                   boolean isClearBackStack) {
        currentFragment = fragment;
        if (isClearBackStack) {
            clearBackStack();
        }
        if (isAddToBackStack) {
            fragmentManager.beginTransaction()
                    .replace(R.id.main_container, fragment)
                    .addToBackStack(fragment.getClass().getName())
                    .commit();
        } else {
            fragmentManager.beginTransaction()
                    .replace(R.id.main_container, fragment)
                    .commit();
        }
    }

    private void clearBackStack() {
        final int size = fragmentManager.getFragments().size() - 1;
        for (int i = 0; i <size; i++) {
            fragmentManager.popBackStack();
        }
    }

}
































