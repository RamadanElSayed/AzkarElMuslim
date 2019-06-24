package com.azkar.azkarelmuslim.startpackageview.views.fragments;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.azkar.azkarelmuslim.R;
import com.azkar.azkarelmuslim.addingazkarpackage.views.activities.AzkarDisplayingActivity;
import com.azkar.azkarelmuslim.addingazkarpackage.views.fragments.AzkarDisplayingFragment;
import com.azkar.azkarelmuslim.azkartypespackage.Views.fragments.AzkarMuslimTypeFragment;
import com.azkar.azkarelmuslim.base.BaseFragment;
import com.azkar.azkarelmuslim.doaatypespackage.viws.fragments.DoaaTypesFragment;
import com.azkar.azkarelmuslim.startpackageview.views.activities.StartAzkarActivity;

import java.util.Objects;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class StartAzkarFragment extends BaseFragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_start_azkar, container, false);
        ButterKnife.bind(this, view);
        return view;

    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initComponents() {

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @OnClick(R.id.azkar_btn_id)
    void onAzkarMuslimBtnClicked() {
        AzkarMuslimTypeFragment azkarMuslimTypeFragment = AzkarMuslimTypeFragment.getInstance();
        ((StartAzkarActivity) Objects.requireNonNull(getActivity())).replaceCurrentFragment(azkarMuslimTypeFragment,true);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @OnClick(R.id.doaa_btn_id)
    void onDoaaMuslimBtnClicked() {
        DoaaTypesFragment doaaTypesFragment = DoaaTypesFragment.getInstance();
        ((StartAzkarActivity) Objects.requireNonNull(getActivity())).replaceCurrentFragment(doaaTypesFragment,true);    }

    @OnClick(R.id.azkary_type_Btn)
    void onAzkaryMuslimBtnClicked() {
        startActivity(AzkarDisplayingActivity.getLaunchIntent(getActivity()));
//        AzkarDisplayingFragment displayingFragment = AzkarDisplayingFragment.getInstance();
//        ((StartAzkarActivity) Objects.requireNonNull(getActivity())).
//                replaceCurrentFragment(displayingFragment,true);
    }

    @OnClick(R.id.About_app_Btn)
    void onAboutBtnClicked() {
        AboutFragment aboutFragment = AboutFragment.getInstance();
        ((StartAzkarActivity) Objects.requireNonNull(getActivity())).
                replaceCurrentFragment(aboutFragment,true);    }

    @OnClick(R.id.close_App_Btn)
    void onCloseBtnClicked() {
        Objects.requireNonNull(getActivity()).finish();
        getActivity().moveTaskToBack(true);
    }
}
