package com.azkar.azkarelmuslim.azkartypespackage.Views.fragments;


import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.azkar.azkarelmuslim.R;
import com.azkar.azkarelmuslim.base.BaseFragment;
import com.azkar.azkarelmuslim.startpackageview.views.activities.StartAzkarActivity;

import java.util.Objects;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AzkarMuslimTypeFragment extends BaseFragment {

    public static AzkarMuslimTypeFragment getInstance() {
        return new AzkarMuslimTypeFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_azkar_muslim_type, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @OnClick(R.id.azkar_sbah_btn)
    void onAzkarSbahBtnClicked() {
        AzkarSbahFragment azkarSbahFragment = AzkarSbahFragment.getInstance();
        ((StartAzkarActivity) Objects.requireNonNull(getActivity())).replaceCurrentFragment(azkarSbahFragment, true);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @OnClick(R.id.azkar_msa_btn)
    void onAzkarMsaBtnClicked() {
        AzkarMsaFragment azkarMsaFragment = AzkarMsaFragment.getInstance();
        ((StartAzkarActivity) Objects.requireNonNull(getActivity())).replaceCurrentFragment(azkarMsaFragment, true);
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @OnClick(R.id.azkar_nwm_btn)
    void onAzkarNwmBtnClicked() {
        AzkarNwmFragment azkarNwmFragment = AzkarNwmFragment.getInstance();
        ((StartAzkarActivity) Objects.requireNonNull(getActivity())).replaceCurrentFragment(azkarNwmFragment, true);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @OnClick(R.id.azkar_esteqz_btn)
    void onesteqzBtnClicked() {
        AzkarAsteqzFragment azkarAsteqzFragment = AzkarAsteqzFragment.getInstance();
        ((StartAzkarActivity) Objects.requireNonNull(getActivity())).replaceCurrentFragment(azkarAsteqzFragment, true);
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initComponents() {

    }
}
