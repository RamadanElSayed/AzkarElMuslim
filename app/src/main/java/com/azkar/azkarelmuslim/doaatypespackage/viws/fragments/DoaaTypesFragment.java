package com.azkar.azkarelmuslim.doaatypespackage.viws.fragments;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.azkar.azkarelmuslim.R;
import com.azkar.azkarelmuslim.base.BaseFragment;
import com.azkar.azkarelmuslim.doaatypespackage.models.PointerOfDoaaType;
import com.azkar.azkarelmuslim.doaatypespackage.viws.interfaces.DoaaTypeView;
import com.azkar.azkarelmuslim.startpackageview.views.activities.StartAzkarActivity;

import java.util.Objects;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class DoaaTypesFragment extends BaseFragment implements DoaaTypeView {

    public static DoaaTypesFragment getInstance() {
        return new DoaaTypesFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doaa_types, container, false);
        ButterKnife.bind(this, view);
        return view;
    }


    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @OnClick(R.id.doaa_khlah_btn)
    void onKhlahBtnClicked() {
        setDoaaTypeTwoFragment(PointerOfDoaaType.DOAA_KHALAH);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @OnClick(R.id.doaa_wdoo_btn)
    void onWdooBtnClicked() {
        setDoaaTypeTwoFragment(PointerOfDoaaType.DOAA_WDOWA);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @OnClick(R.id.doaa_sfar_btn)
    void onSafarBtnClicked() {
        setDoaaTypeTwoFragment(PointerOfDoaaType.DOAA_SAFAR);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @OnClick(R.id.doaa_mzakra_btn)
    void onMzakraBtnClicked() {
        setDoaaTypeTwoFragment(PointerOfDoaaType.DOAA_MZAKRA);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @OnClick(R.id.doaa_mlabs_btn)
    void onMlabsBtnClicked() {
        setDoaaTypeTwoFragment(PointerOfDoaaType.DOAA_MLABS);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @OnClick(R.id.doaa_mnzl_btn)
    void onMnzlBtnClicked() {
        setDoaaTypeTwoFragment(PointerOfDoaaType.DOAA_MNZL);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @OnClick(R.id.doaa_food_btn)
    void onFoodBtnClicked() {
        setDoaaTypeTwoFragment(PointerOfDoaaType.DOAA_FOOD);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @OnClick(R.id.doaa_msgd_btn)
    void onMsgdBtnClicked() {
        setDoaaTypeTwoFragment(PointerOfDoaaType.DOAA_MASGD);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @OnClick(R.id.doaa_strkhra_btn)
    void onAstkharaBtnClicked() {
        setDoaaTypeOneFragment(PointerOfDoaaType.DOAA_ASTKHARA);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @OnClick(R.id.doaa_tlawa_btn)
    void onTlawaBtnClicked() {
        setDoaaTypeOneFragment(PointerOfDoaaType.DOAA_SGWDTLAWA);
    }

    @Override
    protected void initPresenter() {

    }

    @Override
    protected void initComponents() {

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void setDoaaTypeTwoFragment(int typeId) {
        Bundle bundle = new Bundle();
        bundle.putString(PointerOfDoaaType.DOAA_TYPE_ID, String.valueOf(typeId));
        DoaaTwoTitleFragment doaaTwoTitleFragment = DoaaTwoTitleFragment.getInstance();
        doaaTwoTitleFragment.setArguments(bundle);
        ((StartAzkarActivity) Objects.requireNonNull(getActivity())).replaceCurrentFragment(doaaTwoTitleFragment, true);

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void setDoaaTypeOneFragment(int typeId) {
        Bundle bundle = new Bundle();
        bundle.putString(PointerOfDoaaType.DOAA_TYPE_ID, String.valueOf(typeId));
        DoaaWithOneTitleFragment doaaWithOneTitleFragment = DoaaWithOneTitleFragment.getInstance();
        doaaWithOneTitleFragment.setArguments(bundle);
        ((StartAzkarActivity) Objects.requireNonNull(getActivity())).replaceCurrentFragment(doaaWithOneTitleFragment, true);

    }
}
