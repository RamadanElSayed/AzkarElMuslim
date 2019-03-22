package com.azkar.azkarelmuslim.azkartypespackage.Views.interfaces;

import com.azkar.azkarelmuslim.azkartypespackage.models.AzkarTypeModel;
import com.azkar.azkarelmuslim.base.BaseView;

import java.util.ArrayList;

public interface AzkarTypeView extends BaseView {

    void onReceivedAzkarOfSpecificTypeList(ArrayList<AzkarTypeModel> azkarTypeModels);
}
