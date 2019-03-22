package com.azkar.azkarelmuslim.startpackageview.views.activities;

import android.os.Bundle;

import com.azkar.azkarelmuslim.R;
import com.azkar.azkarelmuslim.base.BaseActivity;
import com.azkar.azkarelmuslim.startpackageview.views.fragments.StartAzkarFragment;

public class StartAzkarActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base_layout);
        StartAzkarFragment addFamilyProfileFragment = new StartAzkarFragment();
        replaceCurrentFragment(addFamilyProfileFragment,true);
    }
}
