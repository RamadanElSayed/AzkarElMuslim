package com.azkar.azkarelmuslim.azkartypespackage.Views.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.azkar.azkarelmuslim.R;
import com.azkar.azkarelmuslim.azkartypespackage.Views.adapters.AzkarSpecificTypeAdapter;
import com.azkar.azkarelmuslim.azkartypespackage.Views.interfaces.AzkarTypeView;
import com.azkar.azkarelmuslim.azkartypespackage.models.AzkarTypeModel;
import com.azkar.azkarelmuslim.azkartypespackage.presenters.presenterimpl.AzkarSbahPresenterImpl;
import com.azkar.azkarelmuslim.base.BaseFragment;
import com.azkar.azkarelmuslim.base.OnItemClickListener;
import com.azkar.azkarelmuslim.utils.Messenger;

import java.util.ArrayList;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AzkarSbahFragment extends BaseFragment implements AzkarTypeView, OnItemClickListener<AzkarTypeModel> {

    @BindView(R.id.list_azkarsbah_rv)
    RecyclerView AzkarSbahRv;
    private AzkarSpecificTypeAdapter azkarSpecificTypeAdapter;
    private AzkarSbahPresenterImpl azkarSbahPresenter;
    private ArrayList<AzkarTypeModel> azkarTypeModels;

    public static AzkarSbahFragment getInstance() {
        return new AzkarSbahFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_azkar_sbah, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initPresenter() {
        azkarSbahPresenter = new AzkarSbahPresenterImpl(this);
        azkarTypeModels = new ArrayList<>();
        azkarSbahPresenter.getAllAzkarOfSpecificType();
    }

    @Override
    protected void initComponents() {

    }

    @Override
    public void onReceivedAzkarOfSpecificTypeList(ArrayList<AzkarTypeModel> azkarTypeModels) {
        this.azkarTypeModels = azkarTypeModels;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        AzkarSbahRv.setLayoutManager(layoutManager);
        azkarSpecificTypeAdapter = new AzkarSpecificTypeAdapter(getContext(), azkarTypeModels);
        azkarSpecificTypeAdapter.setOnItemClickListener(this);
        AzkarSbahRv.setItemAnimator(new DefaultItemAnimator());
        AzkarSbahRv.setAdapter(azkarSpecificTypeAdapter);
        AzkarSbahRv.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        azkarSpecificTypeAdapter.notifyDataSetChanged();
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
        azkarSbahPresenter.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        azkarSbahPresenter.onDestroy();

    }
}
