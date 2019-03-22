package com.azkar.azkarelmuslim.base;


public interface BasePresenter<V extends BaseView> {
    void setView(V view);
}
