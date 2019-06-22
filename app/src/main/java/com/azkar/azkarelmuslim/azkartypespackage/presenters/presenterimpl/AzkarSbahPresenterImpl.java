package com.azkar.azkarelmuslim.azkartypespackage.presenters.presenterimpl;

import com.azkar.azkarelmuslim.azkartypespackage.Views.interfaces.AzkarTypeView;
import com.azkar.azkarelmuslim.azkartypespackage.models.AzkarTypeModel;
import com.azkar.azkarelmuslim.azkartypespackage.presenters.presenter.AzkarTypePresenter;
import com.azkar.azkarelmuslim.base.BaseView;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class AzkarSbahPresenterImpl implements AzkarTypePresenter {
    private AzkarTypeView azkarTypeView;
    private CompositeDisposable compositeDisposable;

    public AzkarSbahPresenterImpl(BaseView baseView) {
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
                subscribe(sbahModelArrayList -> azkarTypeView.onReceivedAzkarOfSpecificTypeList(sbahModelArrayList));
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
        ArrayList<AzkarTypeModel> sbahModelArrayList = new ArrayList<>();
        String x1 = "اللَّهُ لاَ إِلَهَ إِلاَّ هُوَ الْحَيُّ الْقَيُّومُ لاَ تَأْخُذُهُ سِنَةٌ وَلاَ نَوْمٌ لَّهُ مَا فِي السَّمَاوَاتِ وَمَا فِي الأَرْضِ مَن ذَا الَّذِي يَشْفَعُ عِندَهُ إِلاَّ بِإِذْنِهِ يَعْلَمُ مَا بَيْنَ أَيْدِيهِمْ وَمَا خَلْفَهُمْ وَلاَ يُحِيطُونَ بِشَيْءٍ مِّنْ عِلْمِهِ إِلاَّ بِمَا شَاء وَسِعَ كُرْسِيُّهُ السَّمَاوَاتِ وَالأَرْضَ وَلاَ يَؤُودُهُ حِفْظُهُمَا وَهُوَ الْعَلِيُّ الْعَظِيمُ";
        String x11 = "تكرار مرة واحدة";
        sbahModelArrayList.add(new AzkarTypeModel(x1, x11));

        String x2 = " بسم الله الرحمن الرحيم قُلْ هُوَ اللَّهُ أَحَدٌ اللَّهُ الصَّمَدُ لَمْ يَلِدْ وَلَمْ يُولَدْ وَلَمْ يَكُنْ لَهُ كُفُوًا أَحَدٌ .";

        String x22 = "تكرار ثلاث مرات";
        sbahModelArrayList.add(new AzkarTypeModel(x2, x22));
        String x3 = "بسم الله الرحمن الرحيم. قُلْ أَعُوذُ بِرَبِّ الْفَلَقِ. مِن شَرِّ مَا خَلَقَ. وَمِن شَرِّ غَاسِقٍ إِذَا وَقَبَ. وَمِن شَرِّ النَّفَّاثَاتِ فِي الْعُقَدِ. وَمِن شَرِّ حَاسِدٍ إِذَا حَسَدَ.";
        String x33 = "تكرار ثلاث مرات";
        sbahModelArrayList.add(new AzkarTypeModel(x3, x33));
        String x4 = " بسم الله الرحمن الرحيم. قُلْ أَعُوذُ بِرَبِّ النَّاسِ. مَلِكِ النَّاسِ. إِلَهِ النَّاسِ. مِن شَرِّ الْوَسْوَاسِ الْخَنَّاسِ. الَّذِي يُوَسْوِسُ فِي صُدُورِ النَّاسِ. مِنَ الْجِنَّةِ وَالنَّاسِ";
        String x44 = "تكرار ثلاث مرات";
        sbahModelArrayList.add(new AzkarTypeModel(x4, x44));
        String x5 = "اللهم أنت ربي لا إله إلا أنت خلقتني وأنا عبدك وأنا على عهدك ووعدك ما استطعت أعوذ بك من شر ما صنعت أبوء لك بنعمتك علي وأبوء بذنبي فاغفر لي فإنه لا يغفر الذنوب إلا أنت.\n" +
                "(من قالها حين يصبح مؤمناً بها فمات من يومه دخل الجنة ) ";
        String x55 = "تكرار مرة واحدة";
        sbahModelArrayList.add(new AzkarTypeModel(x5, x55));
        String x6 = " اللهم فاطر السماوات والأرض عالم الغيب والشهادة رب كل شي ومليكه أشهد أن لا إله إلا أنت أعوذ بك من شر نفسي ومن شر الشيطان وشركه وان اقترف على نفسي سوءا أو أجره لمسلم.\n" +
                " \n" +
                "أصبحنا وأصبح الملك لله والحمد لله ، لا إله إلا الله وحده لا شريك له ، له الملك وله الحمد وهو على كل شيء قدير . ربي أسألك خير ما في هذا اليوم وخير ما بعده . وأعوذ بك من شر ما في هذا اليوم وشر ما بعده ربي أعوذ بك من الكسل وسوء الكبر ، ربي أعوذ بك من عذاب في النار وعذاب في القبر.\n";
        String x66 = " تكرار مرة واحدة";

        sbahModelArrayList.add(new AzkarTypeModel(x6, x66));

        String x7 = "اللهم بك أصبحنا ، وبك أمسينا ، وبك نحيا ، وبك نموت ، وإليك النشور.";
        String x77 = " تكرار مرة واحدة";
        sbahModelArrayList.add(new AzkarTypeModel(x7, x77));

        String x8 = "أصبحنا على فطرة الإسلام وعلى كلمة الإخلاص وعلى دين نبينا محمد صلى الله عليه وسلم وعلى ملة أبينا إبراهيم حنيفاً مسلماً وما كان من المشركين.\n";
        String x88 = " تكرار مرة واحدة";
        sbahModelArrayList.add(new AzkarTypeModel(x8, x88));

        String x9 = "اللهم إني أسألك العافية في الدنيا والآخرة ، اللهم إني أسألك العفو والعافية في ديني ودنياي وأهلي ، ومالي ، اللهم أستر عوراتي ، وآمن روعاتي ، اللهم احفظني من بين يدي ، ومن خلفي وعن يميني ، وعن شمالي ، ومن فوقي ، وأعوذ بعظمتك أن اغتال من تحتي.\n";
        String x99 = " تكرار مرة واحدة";
        sbahModelArrayList.add(new AzkarTypeModel(x9, x99));

        String x10 = "لا إله إلا الله وحده لا شريك له ، له الملك ، وله الحمد ، وهو على كل شيء قدير.\n" +
                "(من قالها في يوم ( 100 ) مرة كانت له عدل عشر رقاب ، وكتبت له مائة حسنة ، ومحيت عنه مائة سيئة)";
        String x1010 = "تكرار عشر مرات او مائة مرة";
        sbahModelArrayList.add(new AzkarTypeModel(x10, x1010));

        String x111 = "بسـم الله الـذي لا يضر مع اسمه شيء في الأرض ولا في السماء وهو السميع العليم";
        String x1111 = "تكرار ثلاث مرات ";
        sbahModelArrayList.add(new AzkarTypeModel(x111, x1111));

        String x222 = "رضيت بالله ربا وبالإسلام دين وبمحمد صلى الله عليه وسلم نبياً";
        String x2222 = "تكرار ثلاث مرات ";
        sbahModelArrayList.add(new AzkarTypeModel(x222, x2222));

        String x333 = "حسبي الله لا إله إلا هو عليه توكلت وهو رب العرش العظيم. (من قالها 7 مرات كفاه الله ما أهمه)";
        String x3333 = "تكرار سبع مرات";
        sbahModelArrayList.add(new AzkarTypeModel(x333, x3333));

        String x444 = "\n" +
                "اللهم إني أصبحت أشهدك وأشهد حملة عرشك، وملائكتك وجميع خلقك، أنك أنت الله لا إله إلا أنت وحدك لا شريك لك ، وأن محمداً عبدك ورسولك\"";
        String x4444 = "تكرار اربع مرات";
        sbahModelArrayList.add(new AzkarTypeModel(x444, x4444));

        String x555 = "اللهم ما أصبح بي من نعمة أو بأحد من خلقك فمنك وحدك لا شريك لك، فلك الحمد ولك الشكر\"\n";
        String x5555 = "تكرار مرة واحدة";
        sbahModelArrayList.add(new AzkarTypeModel(x555, x5555));

        String x666 = "\n" +
                "\"اللهم عافني في بَدَني، اللهم عافني في سمعي، اللهم عافني في بصري، لا إله إلا أنت. اللهم إني أعوذ بك من الكفر، والفقر، اللهم إني أعوذ بك من عذاب القبر لا إله إلا أنت\"";
        String x6666 = "تكرار ثلاث مرات";
        sbahModelArrayList.add(new AzkarTypeModel(x666, x6666));
        String x777 = "سبحان الله وبحمده عدد خلقهِ ورِضَا نفسِهِ وزِنُة عَرشِهِ ومِداد كلماته\"";
        String x7777 = "تكرار ثلاث مرات";
        sbahModelArrayList.add(new AzkarTypeModel(x777, x7777));
        String x999 = "أعوذ بكلمات الله التامات من شر ماخلق\t";
        String x9999 = "ثلاث مرات";
        sbahModelArrayList.add(new AzkarTypeModel(x999, x9999));
        String x888 = "اللهم صل وسلم على نبينا محمد\" ";
        String x8888 = "عشر مرات";
        sbahModelArrayList.add(new AzkarTypeModel(x888, x8888));
        return sbahModelArrayList;
    }
}
