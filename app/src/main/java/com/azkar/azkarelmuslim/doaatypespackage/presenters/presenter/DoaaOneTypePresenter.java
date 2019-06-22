package com.azkar.azkarelmuslim.doaatypespackage.presenters.presenter;

import com.azkar.azkarelmuslim.base.BasePresenter;

public interface DoaaOneTypePresenter extends BasePresenter {
    void getDoaaDataOneType(int doaaType);
    void onStop();
    void onDestroy();
}
