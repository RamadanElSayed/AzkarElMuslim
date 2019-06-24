package com.azkar.azkarelmuslim.addingazkarpackage.views.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.azkar.azkarelmuslim.R;
import com.azkar.azkarelmuslim.addingazkarpackage.views.fragments.AzkarDisplayingFragment;
import com.azkar.azkarelmuslim.base.BaseActivity;

public class AzkarDisplayingActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_azkar_displaying);
        AzkarDisplayingFragment azkarDisplayingFragment = new AzkarDisplayingFragment();
        addFragment(azkarDisplayingFragment);
    }
    public static Intent getLaunchIntent(Context context) {
        return new Intent(context, AzkarDisplayingActivity.class);
    }
}
