package com.azkar.azkarelmuslim.addingazkarpackage.views.interfaces;

import com.azkar.azkarelmuslim.base.BaseView;
import com.azkar.azkarelmuslim.database.AzkarModelDB;

import java.util.List;

public interface DisplayingAzkarView extends BaseView{
    void onReceiveAzkarData(List<AzkarModelDB> azkarModelDBS);
    void showRemovingAzkarDialog();
    void dismissRemovingAzkarDialog();
    void initialDialogData();
}
