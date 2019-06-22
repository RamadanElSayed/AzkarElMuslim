package com.azkar.azkarelmuslim.doaatypespackage.viws.fragments;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.azkar.azkarelmuslim.R;
import com.azkar.azkarelmuslim.base.BaseFragment;
import com.azkar.azkarelmuslim.doaatypespackage.models.DoaaTwoTypesModel;
import com.azkar.azkarelmuslim.doaatypespackage.models.PointerOfDoaaType;
import com.azkar.azkarelmuslim.doaatypespackage.presenters.presenterimpl.DoaTypeTwoPresenterImpl;
import com.azkar.azkarelmuslim.doaatypespackage.viws.interfaces.DoaaTypeTwoView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DoaaTwoTitleFragment extends BaseFragment implements DoaaTypeTwoView {

    @BindView(R.id.doaa_type_tv)
    TextView doaaTypeText;
    @BindView(R.id.doaa_title_one_tv)
    TextView doaaTitleOneText;
    @BindView(R.id.doaa_body_one_tv)
    TextView doaaBodyOneText;
    @BindView(R.id.doaa_title_two_tv)
    TextView doaaTitleTwoText;
    @BindView(R.id.doaa_body_two_tv)
    TextView doaaBodyTwoText;
    private DoaTypeTwoPresenterImpl doaTypeTwoPresenter;
    public static DoaaTwoTitleFragment getInstance() {
        return new DoaaTwoTitleFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doaa_two_title, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initPresenter() {
        doaaTypeText.setText(null);
        doaaTitleOneText.setText(null);
        doaaBodyOneText.setText(null);
        doaaTitleTwoText.setText(null);
        doaaBodyTwoText.setText(null);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey(PointerOfDoaaType.DOAA_TYPE_ID)) {
            int typeId = Integer.valueOf(getArguments().getString(PointerOfDoaaType.DOAA_TYPE_ID));
            doaTypeTwoPresenter = new DoaTypeTwoPresenterImpl(getActivity(), this);
            doaTypeTwoPresenter.getDoaaDataOfSpecificType(typeId);

        }

    }

    @Override
    protected void initComponents() {

    }

    @Override
    public void onDoaaReceivedData(DoaaTwoTypesModel doaaTwoTypesModel) {
        doaaTypeText.setText(doaaTwoTypesModel.getDoaaTitleType());
        doaaTitleOneText.setText(doaaTwoTypesModel.getTitleDoaOne());
        doaaBodyOneText.setText(doaaTwoTypesModel.getBodyDoaOne());
        doaaTitleTwoText.setText(doaaTwoTypesModel.getTitleDoaTwo());
        doaaBodyTwoText.setText(doaaTwoTypesModel.getBodyDoaTwo());
    }

    @Override
    public void onStop() {
        super.onStop();
        doaTypeTwoPresenter.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        doaTypeTwoPresenter.onDestroy();
    }
}
