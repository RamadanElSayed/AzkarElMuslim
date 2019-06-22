package com.azkar.azkarelmuslim.addingazkarpackage.presenter;

import com.azkar.azkarelmuslim.base.BasePresenter;

public interface AzkarAddingPresenter extends BasePresenter{
    void onSavingAzkarClicked(String azkarTextAdding);
    void onStop();
    void onDestroy();
}
