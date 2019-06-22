package com.azkar.azkarelmuslim.doaatypespackage.viws.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.azkar.azkarelmuslim.R;
import com.azkar.azkarelmuslim.base.BaseFragment;
import com.azkar.azkarelmuslim.doaatypespackage.models.DoaaOneTypeModel;
import com.azkar.azkarelmuslim.doaatypespackage.models.PointerOfDoaaType;
import com.azkar.azkarelmuslim.doaatypespackage.presenters.presenter.DoaaOneTypePresenter;
import com.azkar.azkarelmuslim.doaatypespackage.presenters.presenterimpl.DoaaOneTypePresenterImpl;
import com.azkar.azkarelmuslim.doaatypespackage.viws.interfaces.DoaaOneTypeView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DoaaWithOneTitleFragment extends BaseFragment implements DoaaOneTypeView {
    @BindView(R.id.doaa_type_tv)
    TextView doaaTypeText;
    @BindView(R.id.doaa_title_one_tv)
    TextView doaaTitleOneText;
    @BindView(R.id.doaa_body_one_tv)
    TextView doaaBodyOneText;
    private DoaaOneTypePresenterImpl doaaOneTypePresenter;
    public static DoaaWithOneTitleFragment getInstance() {
        return new DoaaWithOneTitleFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doaa_with_one_title, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initPresenter() {
        doaaTypeText.setText(null);
        doaaTitleOneText.setText(null);
        doaaBodyOneText.setText(null);
        Bundle arguments = getArguments();
        if (arguments != null && arguments.containsKey(PointerOfDoaaType.DOAA_TYPE_ID)) {

            int typeId = Integer.valueOf(getArguments().getString(PointerOfDoaaType.DOAA_TYPE_ID));
            doaaOneTypePresenter = new DoaaOneTypePresenterImpl(getActivity(), this);
            doaaOneTypePresenter.getDoaaDataOneType(typeId);

        }

    }

    @Override
    protected void initComponents() {

    }

    @Override
    public void onDoaaReceivedData(DoaaOneTypeModel doaaOneTypeModel) {
        doaaTypeText.setText(doaaOneTypeModel.getDoaaTitleType());
        doaaTitleOneText.setText(doaaOneTypeModel.getTitleDoaOne());
        doaaBodyOneText.setText(doaaOneTypeModel.getBodyDoaOne());
    }

    @Override
    public void onStop() {
        super.onStop();
        doaaOneTypePresenter.onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        doaaOneTypePresenter.onDestroy();
    }
}
