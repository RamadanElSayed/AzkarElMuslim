package com.azkar.azkarelmuslim.addingazkarpackage.views.fragments;


import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.azkar.azkarelmuslim.R;
import com.azkar.azkarelmuslim.addingazkarpackage.presenter.AzkarAddingPresenterImpl;
import com.azkar.azkarelmuslim.addingazkarpackage.views.interfaces.SavingAzkarView;
import com.azkar.azkarelmuslim.base.BaseApplication;
import com.azkar.azkarelmuslim.base.BaseFragment;
import com.azkar.azkarelmuslim.database.AzkarDao;
import com.azkar.azkarelmuslim.startpackageview.views.activities.StartAzkarActivity;
import com.azkar.azkarelmuslim.utils.KeyboardUtil;
import com.azkar.azkarelmuslim.utils.Messenger;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.disposables.CompositeDisposable;

public class AzkarAddingFragment extends BaseFragment implements SavingAzkarView {
    @BindView(R.id.azkar_text_adding)
    EditText azkarTextAdding;
    private AzkarAddingPresenterImpl addingPresenter;

    public static AzkarAddingFragment getInstance() {
        return new AzkarAddingFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_azkar_adding, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.addBtn)
    void onBtnSavingClick() {
        KeyboardUtil.dismissKeyboard(Objects.requireNonNull(getActivity()));
        String azkarTitle = azkarTextAdding.getText().toString();
        if (!azkarTitle.equals(""))
            addingPresenter.onSavingAzkarClicked(azkarTitle);
        else Messenger.showErrorMsg(getString(R.string.azkar_adding_title), getActivity());
    }

    @Override
    protected void initPresenter() {
        AzkarDao azkarDao = BaseApplication.getAzkarDoa();
        addingPresenter = new AzkarAddingPresenterImpl(this, azkarDao);

    }

    @Override
    protected void initComponents() {

    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onAzkarSavingDataDone() {
        azkarTextAdding.setText(null);
        Messenger.showErrorMsg(getString(R.string.azkar_add_done), getActivity());

    }

    @Override
    public void onStop() {
        super.onStop();
        addingPresenter.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        addingPresenter.onDestroy();
    }
}
