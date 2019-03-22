package com.azkar.azkarelmuslim.addingazkarpackage.presenter;

import android.util.Log;

import com.azkar.azkarelmuslim.addingazkarpackage.views.interfaces.DisplayingAzkarView;
import com.azkar.azkarelmuslim.base.BaseView;
import com.azkar.azkarelmuslim.database.AzkarDao;
import com.azkar.azkarelmuslim.database.AzkarModelDB;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;

public class DisplayingAzkarPresneterImpl implements DisplayingAzkarPresneter {
    private DisplayingAzkarView displayingAzkarView;
    private CompositeDisposable compositeDisposable;
    private AzkarDao azkarDao;

    public DisplayingAzkarPresneterImpl(BaseView baseView, AzkarDao azkarDao) {
        compositeDisposable = new CompositeDisposable();
        this.azkarDao = azkarDao;
        setView(baseView);
    }

    @Override
    public void getAllAddingAzkarData() {
        Flowable<List<AzkarModelDB>> listFlowable = azkarDao.getAllAzkarList();
        Disposable disposabletwo = listFlowable.onBackpressureBuffer().
                subscribeOn(io.reactivex.schedulers.Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).
                subscribe(baseContents -> {
                    displayingAzkarView.onReceiveAzkarData(baseContents);
                });

        compositeDisposable.add(disposabletwo);

    }

    @Override
    public void onStop() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
            compositeDisposable.clear();
        }
    }

    @Override
    public void deleteAzkarOnClicked(Long azkarId) {

        Completable completable=  Completable.fromAction(() -> azkarDao.deleteAzkarById(azkarId));

        Disposable disposable= completable.subscribeOn(io.reactivex.schedulers.Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).
                subscribe(() -> {
                    displayingAzkarView.dismissRemovingAzkarDialog();
                });

           compositeDisposable.add(disposable);
    }

    @Override
    public void setView(BaseView view) {
        displayingAzkarView = (DisplayingAzkarView) view;
    }
}
