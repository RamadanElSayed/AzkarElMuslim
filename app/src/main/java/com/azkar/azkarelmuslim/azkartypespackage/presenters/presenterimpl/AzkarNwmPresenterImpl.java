package com.azkar.azkarelmuslim.azkartypespackage.presenters.presenterimpl;

import com.azkar.azkarelmuslim.azkartypespackage.Views.interfaces.AzkarTypeView;
import com.azkar.azkarelmuslim.azkartypespackage.models.AzkarTypeModel;
import com.azkar.azkarelmuslim.azkartypespackage.presenters.presenter.AzkarTypePresenter;
import com.azkar.azkarelmuslim.base.BaseView;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class AzkarNwmPresenterImpl implements AzkarTypePresenter {

    private AzkarTypeView azkarTypeView;
    private CompositeDisposable compositeDisposable;

    public AzkarNwmPresenterImpl(BaseView baseView) {
        setView(baseView);
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void setView(BaseView view) {
        azkarTypeView = (AzkarTypeView) view;

    }

    @Override
    public void getAllAzkarOfSpecificType() {

        Observable<ArrayList<AzkarTypeModel>> azkatTypeObservable = Observable.just(
                getAzkarNWMList()
        );
        Disposable azkarTypeSubscription = azkatTypeObservable.
                subscribe(NwmModelArrayList -> azkarTypeView.onReceivedAzkarOfSpecificTypeList(NwmModelArrayList));
        compositeDisposable.add(azkarTypeSubscription);
    }

    @Override
    public void onStop() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
            compositeDisposable.clear();
        }

    }

    @Override
    public void onDestroy() {
        if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
            compositeDisposable.dispose();
            compositeDisposable.clear();
        }
    }


    private ArrayList<AzkarTypeModel> getAzkarNWMList() {
        ArrayList<AzkarTypeModel> nwmModelArrayList = new ArrayList<>();
        String x1 = "اللَّهُ لاَ إِلَهَ إِلاَّ هُوَ الْحَيُّ الْقَيُّومُ لاَ تَأْخُذُهُ سِنَةٌ وَلاَ نَوْمٌ لَّهُ مَا فِي السَّمَاوَاتِ وَمَا فِي الأَرْضِ مَن ذَا الَّذِي يَشْفَعُ عِندَهُ إِلاَّ بِإِذْنِهِ يَعْلَمُ مَا بَيْنَ أَيْدِيهِمْ وَمَا خَلْفَهُمْ وَلاَ يُحِيطُونَ بِشَيْءٍ مِّنْ عِلْمِهِ إِلاَّ بِمَا شَاء وَسِعَ كُرْسِيُّهُ السَّمَاوَاتِ وَالأَرْضَ وَلاَ يَؤُودُهُ حِفْظُهُمَا وَهُوَ الْعَلِيُّ الْعَظِيمُ";
        String x11 = "تكرار مرة واحدة";
        nwmModelArrayList.add(new AzkarTypeModel(x1, x11));
        String x2 = " بسم الله الرحمن الرحيم قُلْ هُوَ اللَّهُ أَحَدٌ اللَّهُ الصَّمَدُ لَمْ يَلِدْ وَلَمْ يُولَدْ وَلَمْ يَكُنْ لَهُ كُفُوًا أَحَدٌ .";
        String x22 = "تكرار ثلاث مرات";
        nwmModelArrayList.add(new AzkarTypeModel(x2, x22));
        String x3 = "بسم الله الرحمن الرحيم. قُلْ أَعُوذُ بِرَبِّ الْفَلَقِ. مِن شَرِّ مَا خَلَقَ. وَمِن شَرِّ غَاسِقٍ إِذَا وَقَبَ. وَمِن شَرِّ النَّفَّاثَاتِ فِي الْعُقَدِ. وَمِن شَرِّ حَاسِدٍ إِذَا حَسَدَ.";
        String x33 = "تكرار ثلاث مرات";
        nwmModelArrayList.add(new AzkarTypeModel(x3, x33));
        String x4 = " بسم الله الرحمن الرحيم. قُلْ أَعُوذُ بِرَبِّ النَّاسِ. مَلِكِ النَّاسِ. إِلَهِ النَّاسِ. مِن شَرِّ الْوَسْوَاسِ الْخَنَّاسِ. الَّذِي يُوَسْوِسُ فِي صُدُورِ النَّاسِ. مِنَ الْجِنَّةِ وَالنَّاسِ";
        String x44 = "تكرار ثلاث مرات";
        nwmModelArrayList.add(new AzkarTypeModel(x4, x44));
        String x5 = "اللهم إني اسألك العافية في الدنيا والآخرة. اللهم إني أسألك العفو والعافية في ديني ودنياي وأهلي ومالي, اللهم استر عوراتي وآمن روعاتي, اللهم احفظني من بين يدي ومن خلفي وعن يميني وعن شمالي ومن فوقي وأعوذ بعظمتك أن أغتال من تحتي\t";
        String x55 = "مرة واحدة\t";
        nwmModelArrayList.add(new AzkarTypeModel(x5, x55));
        String x6 = "اللهم رب السماوات, ورب الأرض ورب العرش العظيم, ربنا ورب كل شئ, فالق الحب والنوى, ومنزل التوراة والإنجيل والفرقان, أعوذ بك من شر كل ذي شر أنت آخذ بناصيته, اللهم أنت الأول فليس قبلك شئ, وأنت الآخر فليس بعدك شئ, وأنت الظاهر فليس فوقك شئ, وأنت الباطن فليس دونك شئ, إقض عنا الدين, وأغننا من الفقر\t";
        String x66 = "مرة واحدة";
        nwmModelArrayList.add(new AzkarTypeModel(x6, x66));
        String x7 = "اللهم أنت خلقت نفسي, وأنت تتوفاها, لك مماتها ومحياها, إن أحييتها فاحفظها, وإن أمتها فاغر لها, اللهم إني أسألك العافية\t";
        String x77 = "مرة واحدة";
        nwmModelArrayList.add(new AzkarTypeModel(x7, x77));
        String x8 = "اللهم أسلمت نفسي إليك ووجهت وجهي إليك, وفوضت أمري إليك, وألجأت ظهري إليك, رغبة ورهبة إليك, لا ملجأ ولا منجا منك إلا إليك, آمنت بكتابك الذي أنزلت, وبنبيك الذي أرسلت\t";
        String x88 = "مرة واحدة";
        nwmModelArrayList.add(new AzkarTypeModel(x8, x88));
        String x9 = "بإسمك اللهم وضعت جنبي وبك أرفعه, إن أمسكت روحي فارحمها, وإن أرسلتها فاحفظها بما تحفظ به عبادك الصالحين\t";
        String x99 = "مرة واحدة";
        nwmModelArrayList.add(new AzkarTypeModel(x9, x99));
        String x10 = "بإسمك اللهم أموت وأحيا\t";
        String x1010 = "مرة واحدة";
        nwmModelArrayList.add(new AzkarTypeModel(x10, x1010));
        return nwmModelArrayList;
    }
}
