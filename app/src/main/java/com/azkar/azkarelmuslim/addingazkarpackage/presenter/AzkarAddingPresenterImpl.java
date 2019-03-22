package com.azkar.azkarelmuslim.addingazkarpackage.presenter;

import com.azkar.azkarelmuslim.addingazkarpackage.views.interfaces.SavingAzkarView;
import com.azkar.azkarelmuslim.base.BaseView;
import com.azkar.azkarelmuslim.database.AzkarDao;
import com.azkar.azkarelmuslim.database.AzkarModelDB;

import java.util.concurrent.Callable;

import io.reactivex.Flowable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class AzkarAddingPresenterImpl implements AzkarAddingPresenter {

    private SavingAzkarView savingAzkarView;
    private CompositeDisposable compositeDisposable;
    private AzkarDao azkarDao;

    public AzkarAddingPresenterImpl(BaseView baseView, AzkarDao azkarDao) {
        compositeDisposable = new CompositeDisposable();
        this.azkarDao = azkarDao;
        setView(baseView);

    }

    @Override
    public void onSavingAzkarClicked(final String azkarTextAdding) {
        Flowable<Boolean> booleanFlowable = Flowable.fromCallable(new Callable<Boolean>() {
            @Override
            public Boolean call() {
                AzkarModelDB azkarModelDB = new AzkarModelDB();
                azkarModelDB.setAzkarId(System.currentTimeMillis());
                azkarModelDB.setAzkarContent(azkarTextAdding);
                azkarDao.insertAzkarData(azkarModelDB);
                return true;
            }
        });

        Disposable disposable = booleanFlowable.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).
                subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) {
                        if (aBoolean) {
                            savingAzkarView.onAzkarSavingDataDone();
                        }
                    }
                });

        compositeDisposable.add(disposable);

    }

    @Override
    public void onStop() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
            compositeDisposable.clear();
        }
    }

    @Override
    public void setView(BaseView view) {
        savingAzkarView = (SavingAzkarView) view;
    }
}
