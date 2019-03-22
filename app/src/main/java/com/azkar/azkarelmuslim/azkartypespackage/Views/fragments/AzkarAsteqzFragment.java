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

import com.azkar.azkarelmuslim.R;
import com.azkar.azkarelmuslim.azkartypespackage.Views.adapters.AzkarSpecificTypeAdapter;
import com.azkar.azkarelmuslim.azkartypespackage.Views.interfaces.AzkarTypeView;
import com.azkar.azkarelmuslim.azkartypespackage.models.AzkarTypeModel;
import com.azkar.azkarelmuslim.azkartypespackage.presenters.presenterimpl.AzkarAsteqzPresenterImpl;
import com.azkar.azkarelmuslim.azkartypespackage.presenters.presenterimpl.AzkarMsaPresenterImpl;
import com.azkar.azkarelmuslim.base.BaseFragment;
import com.azkar.azkarelmuslim.base.OnItemClickListener;
import com.azkar.azkarelmuslim.utils.Messenger;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AzkarAsteqzFragment extends BaseFragment implements AzkarTypeView, OnItemClickListener<AzkarTypeModel> {

    @BindView(R.id.list_azkarasteqz_rv)
    RecyclerView AzkarAsteqzRv;
    private AzkarSpecificTypeAdapter azkarSpecificTypeAdapter;
    private ArrayList<AzkarTypeModel> azkarTypeModels;

    public static AzkarAsteqzFragment getInstance() {
        return new AzkarAsteqzFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_azkar_asteqz, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onReceivedAzkarOfSpecificTypeList(ArrayList<AzkarTypeModel> azkarTypeModels) {
        this.azkarTypeModels = azkarTypeModels;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        AzkarAsteqzRv.setLayoutManager(layoutManager);
        azkarSpecificTypeAdapter = new AzkarSpecificTypeAdapter(getContext(), azkarTypeModels);
        azkarSpecificTypeAdapter.setOnItemClickListener(this);
        AzkarAsteqzRv.setItemAnimator(new DefaultItemAnimator());
        AzkarAsteqzRv.setAdapter(azkarSpecificTypeAdapter);
        AzkarAsteqzRv.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        azkarSpecificTypeAdapter.notifyDataSetChanged();
    }

    @Override
    protected void initPresenter() {
        AzkarAsteqzPresenterImpl azkarAsteqzPresenter = new AzkarAsteqzPresenterImpl(this);
        azkarTypeModels = new ArrayList<>();
        azkarAsteqzPresenter.getAllAzkarOfSpecificType();
    }

    @Override
    protected void initComponents() {

    }

    @Override
    public void onItemClick(AzkarTypeModel azkarTypeModel) {
        if (azkarTypeModel.getIncreaseOrDecrease().equals("IN")) {
            if (azkarTypeModel.getAzkarSbahFont() < 40) {
                float fontNow = azkarTypeModel.getAzkarSbahFont();
                fontNow++;
                azkarTypeModel.setAzkarSbahFont(fontNow);
            } else {
                Messenger.showErrorMsg(getString(R.string.increase_message), getActivity());
            }
            azkarTypeModels.set(azkarTypeModel.getIndexOfAzkarNow(), azkarTypeModel);
            azkarSpecificTypeAdapter.notifyDataSetChanged();
        } else if (azkarTypeModel.getIncreaseOrDecrease().equals("DE")) {
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
}
