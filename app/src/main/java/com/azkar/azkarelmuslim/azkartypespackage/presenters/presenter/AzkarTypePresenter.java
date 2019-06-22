package com.azkar.azkarelmuslim.azkartypespackage.presenters.presenter;
import com.azkar.azkarelmuslim.base.BasePresenter;
public interface AzkarTypePresenter extends BasePresenter {

    void getAllAzkarOfSpecificType();
    void onStop();
    void onDestroy();
}
