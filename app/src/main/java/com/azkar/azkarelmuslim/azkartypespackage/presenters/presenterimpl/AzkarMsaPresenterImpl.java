package com.azkar.azkarelmuslim.azkartypespackage.presenters.presenterimpl;

import com.azkar.azkarelmuslim.azkartypespackage.Views.interfaces.AzkarTypeView;
import com.azkar.azkarelmuslim.azkartypespackage.models.AzkarTypeModel;
import com.azkar.azkarelmuslim.azkartypespackage.presenters.presenter.AzkarTypePresenter;
import com.azkar.azkarelmuslim.base.BaseView;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class AzkarMsaPresenterImpl implements AzkarTypePresenter {

    private AzkarTypeView azkarTypeView;
    private CompositeDisposable compositeDisposable;

    public AzkarMsaPresenterImpl(BaseView baseView) {
        setView(baseView);
        compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void getAllAzkarOfSpecificType() {

        Observable<ArrayList<AzkarTypeModel>> azkatTypeObservable = Observable.just(
                getAzkarMsaList()
        );
        Disposable azkarTypeSubscription = azkatTypeObservable.
                subscribe(asteqzModelArrayList -> azkarTypeView.onReceivedAzkarOfSpecificTypeList(asteqzModelArrayList));
        compositeDisposable.add(azkarTypeSubscription);
    }

    @Override
    public void setView(BaseView view) {
        azkarTypeView = (AzkarTypeView) view;

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


    private ArrayList<AzkarTypeModel> getAzkarMsaList() {
        ArrayList<AzkarTypeModel> msaModelArrayList = new ArrayList<>();
        String x1 = "اللَّهُ لاَ إِلَهَ إِلاَّ هُوَ الْحَيُّ الْقَيُّومُ لاَ تَأْخُذُهُ سِنَةٌ وَلاَ نَوْمٌ لَّهُ مَا فِي السَّمَاوَاتِ وَمَا فِي الأَرْضِ مَن ذَا الَّذِي يَشْفَعُ عِندَهُ إِلاَّ بِإِذْنِهِ يَعْلَمُ مَا بَيْنَ أَيْدِيهِمْ وَمَا خَلْفَهُمْ وَلاَ يُحِيطُونَ بِشَيْءٍ مِّنْ عِلْمِهِ إِلاَّ بِمَا شَاء وَسِعَ كُرْسِيُّهُ السَّمَاوَاتِ وَالأَرْضَ وَلاَ يَؤُودُهُ حِفْظُهُمَا وَهُوَ الْعَلِيُّ الْعَظِيمُ";
        String x11 = "تكرار مرة واحدة";
        msaModelArrayList.add(new AzkarTypeModel(x1, x11));
        String x2 = " بسم الله الرحمن الرحيم قُلْ هُوَ اللَّهُ أَحَدٌ اللَّهُ الصَّمَدُ لَمْ يَلِدْ وَلَمْ يُولَدْ وَلَمْ يَكُنْ لَهُ كُفُوًا أَحَدٌ .";
        String x22 = "تكرار ثلاث مرات";
        msaModelArrayList.add(new AzkarTypeModel(x2, x22));
        String x3 = "بسم الله الرحمن الرحيم. قُلْ أَعُوذُ بِرَبِّ الْفَلَقِ. مِن شَرِّ مَا خَلَقَ. وَمِن شَرِّ غَاسِقٍ إِذَا وَقَبَ. وَمِن شَرِّ النَّفَّاثَاتِ فِي الْعُقَدِ. وَمِن شَرِّ حَاسِدٍ إِذَا حَسَدَ.";
        String x33 = "تكرار ثلاث مرات";
        msaModelArrayList.add(new AzkarTypeModel(x3, x33));
        String x4 = " بسم الله الرحمن الرحيم. قُلْ أَعُوذُ بِرَبِّ النَّاسِ. مَلِكِ النَّاسِ. إِلَهِ النَّاسِ. مِن شَرِّ الْوَسْوَاسِ الْخَنَّاسِ. الَّذِي يُوَسْوِسُ فِي صُدُورِ النَّاسِ. مِنَ الْجِنَّةِ وَالنَّاسِ";
        String x44 = "تكرار ثلاث مرات";
        msaModelArrayList.add(new AzkarTypeModel(x4, x44));
        String x5 = "اللهم أنت ربي لا إله إلا أنت خلقتني وأنا عبدك وأنا على عهدك ووعدك ما استطعت أعوذ بك من شر ما صنعت أبوء لك بنعمتك علي وأبوء بذنبي فاغفر لي فإنه لا يغفر الذنوب إلا أنت.\n" +
                "(من قالها حينما يمسي مؤمنا بها موقنا بها فمات من ليلته دخل الجنة)";
        String x55 = "تكرار مرة واحدة";
        msaModelArrayList.add(new AzkarTypeModel(x5, x55));
        String x6 = "((آمَنَ الرَّسُولُ بِمَا أُنْزِلَ إِلَيْهِ مِنْ رَبِّهِ وَالْمُؤْمِنُونَ كُلٌّ آمَنَ بِاللَّهِ وَمَلائِكَتِهِ وَكُتُبِهِ وَرُسُلِهِ لا نُفَرِّقُ بَيْنَ أَحَدٍ مِنْ رُسُلِهِ وَقَالُوا سَمِعْنَا وَأَطَعْنَا غُفْرَانَكَ رَبَّنَا وَإِلَيْكَ الْمَصِيرُ *لا يُكَلِّفُ اللَّهُ نَفْسًا إِلا وُسْعَهَا لَهَا مَا كَسَبَتْ وَعَلَيْهَا مَا اكْتَسَبَتْ رَبَّنَا لا تُؤَاخِذْنَا إِنْ نَسِينَا أَوْ أَخْطَأْنَا رَبَّنَا وَلا تَحْمِلْ عَلَيْنَا إِصْرًا كَمَا حَمَلْتَهُ عَلَى الَّذِينَ مِنْ قَبْلِنَا رَبَّنَا وَلا تُحَمِّلْنَا مَا لا طَاقَةَ لَنَا بِهِ وَاعْفُ عَنَّا وَاغْفِرْ لَنَا وَارْحَمْنَا أَنْتَ مَوْلانَا فَانْصُرْنَا عَلَى الْقَوْمِ الْكَافِرِين.َ ))";
        String x66 = "مرة واحدة";
        msaModelArrayList.add(new AzkarTypeModel(x6, x66));
        String x7 = "أمسينا وأمسى الملك لله والحمد لله ، لا اله إلا الله وحده لا شريك له ، له الملك وله الحمد ، وهو على كل شيء قدير ، ربي أسألك خير ما في هذا الليلة وخير ما بعدها ، أعوذ بك من شر ما في هذا الليلة وشر ما بعدها ، ربي أعوذ بك من الكسل وسوء الكبر ، ربي أعوذ بك من عذاب في النار وعذاب في القبر";
        String x77 = "مرة واحدة";
        msaModelArrayList.add(new AzkarTypeModel(x7, x77));
        String x8 = "أمسينا على فطرة الإسلام وعلى كلمة الإخلاص وعلى دين نبينا محمد صلى الله عليه وسلم وعلى ملة أبينا إبراهيم حنيفاً مسلماً وما كان من المشركين.\n";
        String x88 = "مرة واحدة";
        msaModelArrayList.add(new AzkarTypeModel(x8, x88));
        String x9 = "اللهم بك أمسينا وبك أصبحنا ، وبك نحيا وبك نموت وإليك المصير.\n";
        String x99 = "مرة واحدة";
        msaModelArrayList.add(new AzkarTypeModel(x9, x99));
        String x10 = "اللهم إني أسألك العافية في الدنيا والآخرة ، اللهم إني أسألك العفو والعافية في ديني ودنياي وأهلي ومالي ، اللهم أستر عوراتي ، وآمن روعاتي اللهم احفظني من بين يدي ، ومن خلفي وعن يميني ، وعن شمالي ، ومن فوقي ، وأعوذ بعظمتك أن اغتال من تحتي.";
        String x1010 = "مرة واحدة";
        msaModelArrayList.add(new AzkarTypeModel(x10, x1010));
        String x111 = "بسـم الله الـذي لا يضر مع اسمه شيء في الأرض ولا في السماء وهو السميع العليم";
        String x1111 = "تكرار ثلاث مرات ";
        msaModelArrayList.add(new AzkarTypeModel(x111, x1111));
        String x222 = "رضيت بالله ربا وبالإسلام دين وبمحمد صلى الله عليه وسلم نبياً";
        String x2222 = "تكرار ثلاث مرات ";
        msaModelArrayList.add(new AzkarTypeModel(x222, x2222));
        String x333 = "حسبي الله لا إله إلا هو عليه توكلت وهو رب العرش العظيم. (من قالها 7 مرات كفاه الله ما أهمه)";
        String x3333 = "تكرار سبع مرات";
        msaModelArrayList.add(new AzkarTypeModel(x333, x3333));
        String x444 = "لا إله إلا الله وحده لا شريك له ، له الملك ، وله الحمد ، وهو على كل شيء قدير";
        String x4444 = "عشر مرات";
        msaModelArrayList.add(new AzkarTypeModel(x444, x4444));
        String x555 = "\"سبحان الله وبحمده\" من قالها ( 100 ) مرة حطت خطاياه وإن كانت مثل زبد البحر\n";
        String x5555 = "مائة مرة";
        msaModelArrayList.add(new AzkarTypeModel(x555, x5555));
        String x666 = "يا حي يا قيوم برحمتك أستغيث أصلح لي شأني كله ولا تكلني إلى نفسي طرفة عين.\n";
        String x6666 = "ثلاث مرات";
        msaModelArrayList.add(new AzkarTypeModel(x666, x6666));
        String x777 = "اللهم إني اسألك العافية في الدنيا والآخرة. اللهم إني أسألك العفو والعافية في ديني ودنياي وأهلي ومالي, اللهم استر عوراتي وآمن روعاتي, اللهم احفظني من بين يدي ومن خلفي وعن يميني وعن شمالي ومن فوقي وأعوذ بعظمتك أن أغتال من تحتي";
        String x7777 = "مرة واحدة";
        msaModelArrayList.add(new AzkarTypeModel(x777, x7777));
        String x888 = "اللهم إني أمسيت أشهدك وأشهد حملة عرشك و ملائكتك وجميع خلقك أنك انت الله لا إله إلا أنت وحدك لا شريك لك و أن محمداً عبدك ورسولك\t";
        String x8888 = "اربع مرات";
        msaModelArrayList.add(new AzkarTypeModel(x888, x8888));
        String x999 = "أعوذ بكلمات الله التامات من شر ماخلق\t";
        String x9999 = "ثلاث مرات";
        msaModelArrayList.add(new AzkarTypeModel(x999, x9999));
        String x101010 = "اللهم ما أمسى بي من نعمة أو بأحد من خلقك فمنك وحدك لا شريك لك , فلك الحمد ولك الشكر ";
        String x10101010 = "ثلاث مرات";
        String x11111 = "اللهم صل وسلم على نبينا محمد\" ";
        String x111111 = "عشر مرات";
        msaModelArrayList.add(new AzkarTypeModel(x11111, x111111));
        msaModelArrayList.add(new AzkarTypeModel(x101010, x10101010));
        return msaModelArrayList;
    }

}
