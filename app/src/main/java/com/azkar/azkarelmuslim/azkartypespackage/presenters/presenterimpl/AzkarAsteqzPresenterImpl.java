package com.azkar.azkarelmuslim.azkartypespackage.presenters.presenterimpl;

import com.azkar.azkarelmuslim.azkartypespackage.Views.interfaces.AzkarTypeView;
import com.azkar.azkarelmuslim.azkartypespackage.models.AzkarTypeModel;
import com.azkar.azkarelmuslim.azkartypespackage.presenters.presenter.AzkarTypePresenter;
import com.azkar.azkarelmuslim.base.BaseView;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class AzkarAsteqzPresenterImpl implements AzkarTypePresenter {

    private AzkarTypeView azkarTypeView;
    private CompositeDisposable compositeDisposable;

    public AzkarAsteqzPresenterImpl(BaseView baseView) {
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
                getAzkarTypeList()
        );
        Disposable azkarTypeSubscription = azkatTypeObservable.
                subscribe(asteqzModelArrayList -> azkarTypeView.onReceivedAzkarOfSpecificTypeList(asteqzModelArrayList));
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

    private ArrayList<AzkarTypeModel> getAzkarTypeList() {
        ArrayList<AzkarTypeModel> asteqzModelArrayList = new ArrayList<>();

        String azkarAsteqzValueOne = " الحَمْدُ لله الذِي أحْيَانا بَعْدَ مَا أمَاتَنَا* وإلَيْهِ النَشُور";
        String azkarAsteqzValueOneOne = "مرة واحدة";
        asteqzModelArrayList.add(new AzkarTypeModel(azkarAsteqzValueOne, azkarAsteqzValueOneOne));
        String azkarAsteqzValueTwo = "الحَمْدُ لله الذِي عَافَانِي في جَسَدِي ورَدَّ عَلَيَّ رُوحِي، وأَذِنَ لي بِذِكْرهِ";
        String azkarAsteqzValueTwoTwo = "مرة واحدة";
        asteqzModelArrayList.add(new AzkarTypeModel(azkarAsteqzValueTwo, azkarAsteqzValueTwoTwo));
        String azkarAsteqzValueThree = "قال رسول الله صلى الله عليه وسلم \" مَنْ تَعَارَ مِنَ اللَّيْل*  فقال حين يستيقظ :\" لا إلَهَ إلاَّ الله وحْدَهُ لا شَرِيكَ لَهُ، لَهُ المُلْكُ ولَهُ الحَمْدُ وهُوَ على كلِّ شيءٍ قَدير،سُبْحانَ الله والحَمْدُ لله  ولا إله إلا الله والله أكبر ولا حَولَ ولا قُوةَ إلا بالله العلي العظيم \" ثم دعا: \" اللَّهُمَّ اغْفِرْ لي، غُفِرَ له \"، قال الوليد: أو قال: \" دعا استُجيبَ لهُ، فإن قام فتوضأَ ثم صَلّى قُبِلَتْ صَلاتُهُ \"";
        String azkarAsteqzValueThreeThree = "ثلاث مرات";
        asteqzModelArrayList.add(new AzkarTypeModel(azkarAsteqzValueThree, azkarAsteqzValueThreeThree));
        String azkarAsteqzValueFour = "{إِنَّ فِي خَلْقِ السَّمَاوَاتِ وَالأَرْضِ وَاخْتِلاَفِ اللَّيْلِ وَالنَّهَارِ لآيَاتٍ لِّأُوْلِي الألْبَابِ *الَّذِينَ يَذْكُرُونَ اللّهَ قِيَاماً وَقُعُوداً وَعَلَىَ جُنُوبِهِمْ وَيَتَفَكَّرُونَ فِي خَلْقِ السَّمَاوَاتِ وَالأَرْضِ رَبَّنَا مَا خَلَقْتَ هَذا بَاطِلاً سُبْحَانَكَ فَقِنَا عَذَابَ النَّارِ*رَبَّنَا إِنَّكَ مَن تُدْخِلِ النَّارَ فَقَدْ أَخْزَيْتَهُ وَمَا لِلظَّالِمِينَ مِنْ أَنصَارٍ *رَّبَّنَا إِنَّنَا سَمِعْنَا مُنَادِياً يُنَادِي لِلإِيمَانِ أَنْ آمِنُواْ بِرَبِّكُمْ فَآمَنَّا رَبَّنَا فَاغْفِرْ لَنَا ذُنُوبَنَا وَكَفِّرْ عَنَّا سَيِّئَاتِنَا وَتَوَفَّنَا مَعَ الأبْرَارِ * رَبَّنَا وَآتِنَا مَا وَعَدتَّنَا عَلَى رُسُلِكَ وَلاَ تُخْزِنَا يَوْمَ الْقِيَامَةِ إِنَّكَ لاَ تُخْلِفُ الْمِيعَادَ *فَاسْتَجَابَ لَهُمْ رَبُّهُمْ أَنِّي لاَ أُضِيعُ عَمَلَ عَامِلٍ مِّنكُم مِّن ذَكَرٍ أَوْ أُنثَى بَعْضُكُم مِّن بَعْضٍ فَالَّذِينَ هَاجَرُواْ وَأُخْرِجُواْ مِن دِيَارِهِمْ وَأُوذُواْ فِي سَبِيلِي وَقَاتَلُواْ وَقُتِلُواْ لأُكَفِّرَنَّ عَنْهُمْ سَيِّئَاتِهِمْ وَلأُدْخِلَنَّهُمْ جَنَّاتٍ تَجْرِي مِن تَحْتِهَا الأَنْهَارُ ثَوَاباً مِّن عِندِ اللّهِ وَاللّهُ عِندَهُ حُسْنُ الثَّوَابِ *لاَ يَغُرَّنَّكَ تَقَلُّبُ الَّذِينَ كَفَرُواْ فِي الْبِلاَدِ *مَتَاعٌ قَلِيلٌ ثُمَّ مَأْوَاهُمْ جَهَنَّمُ وَبِئْسَ الْمِهَادُ *لَكِنِ الَّذِينَ اتَّقَوْاْ رَبَّهُمْ لَهُمْ جَنَّاتٌ تَجْرِي مِن تَحْتِهَا الأَنْهَارُ خَالِدِينَ فِيهَا نُزُلاً مِّنْ عِندِ اللّهِ وَمَا عِندَ اللّهِ خَيْرٌ لِّلأَبْرَارِ * وَإِنَّ مِنْ أَهْلِ الْكِتَابِ لَمَن يُؤْمِنُ بِاللّهِ وَمَا أُنزِلَ إِلَيْكُمْ وَمَا أُنزِلَ إِلَيْهِمْ خَاشِعِينَ لِلّهِ لاَ يَشْتَرُونَ بِآيَاتِ اللّهِ ثَمَناً قَلِيلاً أُوْلَـئِكَ لَهُمْ أَجْرُهُمْ عِندَ رَبِّهِمْ إِنَّ اللّهَ سَرِيعُ الْحِسَابِ *يَا أَيُّهَا الَّذِينَ آمَنُواْ اصْبِرُواْ وَصَابِرُواْ وَرَابِطُواْ وَاتَّقُواْ اللّهَ لَعَلَّكُمْ تُفْلِحُونَ }";
        String azkarAsteqzValueFourFour = "اربع مرات ";
        asteqzModelArrayList.add(new AzkarTypeModel(azkarAsteqzValueFour, azkarAsteqzValueFourFour));
        return asteqzModelArrayList;
    }
}
