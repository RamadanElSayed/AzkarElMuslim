package com.azkar.azkarelmuslim.addingazkarpackage.presenter;

import com.azkar.azkarelmuslim.base.BasePresenter;

public interface DisplayingAzkarPresneter extends BasePresenter {
    void getAllAddingAzkarData();
    void onStop();
    void onDestroy();
    void deleteAzkarOnClicked(Long azkarId);
}
