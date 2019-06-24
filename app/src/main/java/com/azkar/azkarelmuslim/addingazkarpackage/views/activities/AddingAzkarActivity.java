package com.azkar.azkarelmuslim.addingazkarpackage.views.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.azkar.azkarelmuslim.R;
import com.azkar.azkarelmuslim.addingazkarpackage.views.fragments.AzkarAddingFragment;
import com.azkar.azkarelmuslim.base.BaseActivity;
import com.azkar.azkarelmuslim.startpackageview.views.fragments.StartAzkarFragment;

public class AddingAzkarActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_azkar);
        AzkarAddingFragment azkarAddingFragment = new AzkarAddingFragment();
        addFragment(azkarAddingFragment);
    }

    public static Intent getLaunchIntent(Context context) {
        return new Intent(context, AddingAzkarActivity.class);
    }
}
