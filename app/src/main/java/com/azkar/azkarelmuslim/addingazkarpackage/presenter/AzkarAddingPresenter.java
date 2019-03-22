package com.azkar.azkarelmuslim.addingazkarpackage.presenter;

import com.azkar.azkarelmuslim.base.BasePresenter;
import com.azkar.azkarelmuslim.database.AzkarDao;

public interface AzkarAddingPresenter extends BasePresenter{
    void onSavingAzkarClicked(String azkarTextAdding);
    void onStop();
}
