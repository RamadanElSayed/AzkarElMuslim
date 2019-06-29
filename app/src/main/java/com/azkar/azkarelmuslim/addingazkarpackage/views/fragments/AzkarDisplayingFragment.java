package com.azkar.azkarelmuslim.addingazkarpackage.views.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.Button;

import com.azkar.azkarelmuslim.R;
import com.azkar.azkarelmuslim.addingazkarpackage.presenter.DisplayingAzkarPresneterImpl;
import com.azkar.azkarelmuslim.addingazkarpackage.views.activities.AddingAzkarActivity;
import com.azkar.azkarelmuslim.addingazkarpackage.views.adapters.DisplayingFragmentAdapter;
import com.azkar.azkarelmuslim.addingazkarpackage.views.interfaces.DisplayingAzkarView;
import com.azkar.azkarelmuslim.azkartypespackage.Views.adapters.AzkarSpecificTypeAdapter;
import com.azkar.azkarelmuslim.base.BaseApplication;
import com.azkar.azkarelmuslim.base.BaseFragment;
import com.azkar.azkarelmuslim.base.OnItemClickListener;
import com.azkar.azkarelmuslim.database.AzkarModelDB;
import com.azkar.azkarelmuslim.startpackageview.views.activities.StartAzkarActivity;
import com.azkar.azkarelmuslim.utils.Messenger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.pedant.SweetAlert.SweetAlertDialog;

public class AzkarDisplayingFragment extends BaseFragment implements DisplayingAzkarView, OnItemClickListener<AzkarModelDB> {

    @BindView(R.id.list_azkaradding_rv)
    RecyclerView azkarAddingRV;
    private List<AzkarModelDB> dbArrayList;
    private DisplayingAzkarPresneterImpl displayingAzkarPresneter;
    private SweetAlertDialog RemovingAzkarSweetAlert;
    private AzkarModelDB azkarModelDB;
    Random rand = new Random();
    int randomNum = rand.nextInt((3 - 1) + 1) + 1;
    int[] animationList = {R.anim.layout_animation_up_to_down, R.anim.layout_animation_right_to_left, R.anim.layout_animation_down_to_up, R.anim.layout_animation_left_to_right};

    public static AzkarDisplayingFragment getInstance() {
        return new AzkarDisplayingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_azkar_displaying, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initPresenter() {
        displayingAzkarPresneter = new DisplayingAzkarPresneterImpl(this, BaseApplication.getAzkarDoa());
        dbArrayList = new ArrayList<>();
        displayingAzkarPresneter.getAllAddingAzkarData();
    }

    @Override
    protected void initComponents() {
        initialDialogData();
    }

    @Override
    public void onReceiveAzkarData(List<AzkarModelDB> azkarModelDBS) {
        this.dbArrayList = azkarModelDBS;
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        azkarAddingRV.setLayoutManager(layoutManager);
        DisplayingFragmentAdapter displayingFragmentAdapter = new DisplayingFragmentAdapter(getContext(), dbArrayList);
        displayingFragmentAdapter.setOnItemClickListener(this);
        azkarAddingRV.setItemAnimator(new DefaultItemAnimator());
        LayoutAnimationController controller =
                AnimationUtils.loadLayoutAnimation(getContext(), animationList[randomNum]);
        azkarAddingRV.setLayoutAnimation(controller);
        azkarAddingRV.scheduleLayoutAnimation();
        azkarAddingRV.setAdapter(displayingFragmentAdapter);
        azkarAddingRV.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        displayingFragmentAdapter.notifyDataSetChanged();
    }

    @Override
    public void showRemovingAzkarDialog() {
        if (RemovingAzkarSweetAlert != null) {
            RemovingAzkarSweetAlert.show();

            Button keep = RemovingAzkarSweetAlert.findViewById(R.id.confirm_button);
            Button end = RemovingAzkarSweetAlert.findViewById(R.id.cancel_button);
            keep.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getContext()), R.color.white));
            keep.setBackground(ContextCompat.getDrawable(Objects.requireNonNull(getContext()), R.drawable.round_red_bg));
            end.setTextColor(ContextCompat.getColor(Objects.requireNonNull(getContext()), R.color.white));
            end.setBackground(ContextCompat.getDrawable(Objects.requireNonNull(getContext()), R.drawable.round_red_bg));
        }
    }

    @Override
    public void dismissRemovingAzkarDialog() {
        if (RemovingAzkarSweetAlert != null) {
            RemovingAzkarSweetAlert.dismissWithAnimation();
        }
    }

    @Override
    public void initialDialogData() {
        String title = getString(R.string.remove_azka_title);

        String messageContent = getString(R.string.remove_azkar_content);
        String acceptBtnText = getString(R.string.remove);

        String endBtnText = getString(R.string.cancel);

        RemovingAzkarSweetAlert = Messenger.removeAzkarSweetDialog(getContext(), title, messageContent,
                acceptBtnText, endBtnText, true, sweetAlertDialog -> {
                displayingAzkarPresneter.deleteAzkarOnClicked(azkarModelDB.getAzkarId());

        }, sweetAlertDialog -> dismissRemovingAzkarDialog());
    }

    @OnClick(R.id.display_azkarBtn)
    void onBtnDisplayClick() {
//        AzkarAddingFragment azkarAddingFragment = AzkarAddingFragment.getInstance();
//        ((StartAzkarActivity) Objects.requireNonNull(getActivity())).replaceCurrentFragment(azkarAddingFragment, true);

        startActivity(AddingAzkarActivity.getLaunchIntent(getActivity()));
    }

    @Override
    public void onItemClick(AzkarModelDB azkarModelDB) {
        this.azkarModelDB=azkarModelDB;
        initialDialogData();
        showRemovingAzkarDialog();
    }

    @Override
    public void onStop() {
        super.onStop();
        displayingAzkarPresneter.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        displayingAzkarPresneter.onDestroy();
    }


}
