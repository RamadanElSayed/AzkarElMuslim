package com.azkar.azkarelmuslim.azkartypespackage.Views.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.azkar.azkarelmuslim.R;
import com.azkar.azkarelmuslim.azkartypespackage.Views.adapters.AzkarSpecificTypeAdapter;
import com.azkar.azkarelmuslim.azkartypespackage.Views.interfaces.AzkarTypeView;
import com.azkar.azkarelmuslim.azkartypespackage.models.AzkarTypeModel;
import com.azkar.azkarelmuslim.azkartypespackage.presenters.presenterimpl.AzkarMsaPresenterImpl;
import com.azkar.azkarelmuslim.azkartypespackage.presenters.presenterimpl.AzkarSbahPresenterImpl;
import com.azkar.azkarelmuslim.base.BaseFragment;
import com.azkar.azkarelmuslim.base.OnItemClickListener;
import com.azkar.azkarelmuslim.utils.Messenger;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AzkarMsaFragment extends BaseFragment implements AzkarTypeView, OnItemClickListener<AzkarTypeModel> {

    @BindView(R.id.list_azkarmsa_rv)
    RecyclerView AzkarMsaRv;
    private AzkarSpecificTypeAdapter azkarSpecificTypeAdapter;
    private AzkarMsaPresenterImpl azkarMsaPresenter;
    private ArrayList<AzkarTypeModel> azkarTypeModels;
    Random rand = new Random();
    int randomNum = rand.nextInt((3 - 1) + 1) + 1;
    int[] animationList = {R.anim.layout_animation_up_to_down, R.anim.layout_animation_right_to_left, R.anim.layout_animation_down_to_up, R.anim.layout_animation_left_to_right};

    public static AzkarMsaFragment getInstance() {
        return new AzkarMsaFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_azkar_msa, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onReceivedAzkarOfSpecificTypeList(ArrayList<AzkarTypeModel> azkarTypeModels) {
        this.azkarTypeModels = azkarTypeModels;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        AzkarMsaRv.setLayoutManager(layoutManager);
        azkarSpecificTypeAdapter = new AzkarSpecificTypeAdapter(getContext(), azkarTypeModels);
        azkarSpecificTypeAdapter.setOnItemClickListener(this);
        AzkarMsaRv.setItemAnimator(new DefaultItemAnimator());
        LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(getContext(), animationList[randomNum]);
        AzkarMsaRv.setLayoutAnimation(controller);
        AzkarMsaRv.scheduleLayoutAnimation();
        AzkarMsaRv.setAdapter(azkarSpecificTypeAdapter);
        AzkarMsaRv.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        azkarSpecificTypeAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initPresenter() {
        azkarMsaPresenter = new AzkarMsaPresenterImpl(this);
        azkarTypeModels = new ArrayList<>();
        azkarMsaPresenter.getAllAzkarOfSpecificType();
    }

    @Override
    protected void initComponents() {

    }

    @Override
    public void onItemClick(AzkarTypeModel azkarTypeModel) {
        if (azkarTypeModel.getIncreaseOrDecrease().equals(Objects.requireNonNull(getActivity()).getString(R.string.increase_font))) {
            if (azkarTypeModel.getAzkarSbahFont() < 40) {
                float fontNow = azkarTypeModel.getAzkarSbahFont();
                fontNow++;
                azkarTypeModel.setAzkarSbahFont(fontNow);
            } else {
                Messenger.showErrorMsg(getString(R.string.increase_message), getActivity());
            }
            azkarTypeModels.set(azkarTypeModel.getIndexOfAzkarNow(), azkarTypeModel);
            azkarSpecificTypeAdapter.notifyDataSetChanged();
        } else if (azkarTypeModel.getIncreaseOrDecrease().equals(Objects.requireNonNull(getActivity()).getString(R.string.decrease_font))) {
            if (azkarTypeModel.getAzkarSbahFont() > 15) {
                float fontNow = azkarTypeModel.getAzkarSbahFont();
                fontNow--;
                azkarTypeModel.setAzkarSbahFont(fontNow);

            } else {
                Messenger.showErrorMsg(getString(R.string.decrease_message), getActivity());
            }
            azkarTypeModels.set(azkarTypeModel.getIndexOfAzkarNow(), azkarTypeModel);
            azkarSpecificTypeAdapter.notifyDataSetChanged();
        }


    }

    @Override
    public void onStop() {
        super.onStop();
        azkarMsaPresenter.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        azkarMsaPresenter.onDestroy();
    }
}
