package com.azkar.azkarelmuslim.doaatypespackage.presenters.presenterimpl;

import android.content.Context;

import com.azkar.azkarelmuslim.R;
import com.azkar.azkarelmuslim.azkartypespackage.models.AzkarTypeModel;
import com.azkar.azkarelmuslim.base.BaseView;
import com.azkar.azkarelmuslim.doaatypespackage.models.DoaaOneTypeModel;
import com.azkar.azkarelmuslim.doaatypespackage.models.PointerOfDoaaType;
import com.azkar.azkarelmuslim.doaatypespackage.presenters.presenter.DoaaOneTypePresenter;
import com.azkar.azkarelmuslim.doaatypespackage.viws.interfaces.DoaaOneTypeView;

import java.util.ArrayList;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class DoaaOneTypePresenterImpl implements DoaaOneTypePresenter {

    private DoaaOneTypeView doaaOneTypeView;
    private String titleDoaOne;
    private String bodyDoaOne;
    private String doaaTitleType;
    private Context context;
    private CompositeDisposable compositeDisposable;


    public DoaaOneTypePresenterImpl(Context mcontext, BaseView baseView) {
        context = mcontext;
        compositeDisposable = new CompositeDisposable();
        setView(baseView);

    }

    @Override
    public void getDoaaDataOneType(int doaaType) {

        Observable<DoaaOneTypeModel> azkatTypeObservable = Observable.just(
                getDoaaTypeObject(doaaType)
        );
        Disposable doaaDataSubscription = azkatTypeObservable.
                subscribe(doaaOneTypeModel -> doaaOneTypeView.onDoaaReceivedData(doaaOneTypeModel));
        compositeDisposable.add(doaaDataSubscription);
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

    private DoaaOneTypeModel getDoaaTypeObject(int doaaType) {
        if (doaaType == PointerOfDoaaType.DOAA_ASTKHARA) {
            titleDoaOne = "عَنْ جَابِرٍ رضي الله عنه قَالَ : كَانَ رَسُولُ اللَّهِ صلى الله عليه وسلم يُعَلِّمُنَا الاسْتِخَارَةَ فِي الأُمُورِ كُلِّهَا كَمَا يُعَلِّمُنَا السُّورَةَ مِنْ الْقُرْآنِ يَقُولُ : إذَا هَمَّ أَحَدُكُمْ بِالأَمْرِ فَلْيَرْكَعْ رَكْعَتَيْنِ مِنْ غَيْرِ الْفَرِيضَةِ ثُمَّ لِيَقُلْ : ( اللَّهُمَّ إنِّي أَسْتَخِيرُكَ بِعِلْمِكَ , وَأَسْتَقْدِرُكَ بِقُدْرَتِكَ , وَأَسْأَلُكَ مِنْ فَضْلِكَ الْعَظِيمِ فَإِنَّكَ تَقْدِرُ وَلا أَقْدِرُ , وَتَعْلَمُ وَلا أَعْلَمُ , وَأَنْتَ عَلامُ الْغُيُوبِ , اللَّهُمَّ إنْ كُنْتَ تَعْلَمُ أَنَّ هَذَا الأَمْرَ (هنا تسمي حاجتك ) خَيْرٌ لِي فِي دِينِي وَمَعَاشِي وَعَاقِبَةِ أَمْرِي أَوْ قَالَ : عَاجِلِ أَمْرِي وَآجِلِهِ , فَاقْدُرْهُ لِي وَيَسِّرْهُ لِي ثُمَّ بَارِكْ لِي فِيهِ , اللَّهُمَّ وَإِنْ كُنْتَ تَعْلَمُ أَنَّ هَذَا الأَمْرَ (هنا تسمي حاجتك ) شَرٌّ لِي فِي دِينِي وَمَعَاشِي وَعَاقِبَةِ أَمْرِي أَوْ قَالَ : عَاجِلِ أَمْرِي وَآجِلِهِ , فَاصْرِفْهُ عَنِّي وَاصْرِفْنِي عَنْهُ وَاقْدُرْ لِي الْخَيْرَ حَيْثُ كَانَ ثُمَّ ارْضِنِي بِهِ . وَيُسَمِّي حَاجَتَهُ ) وَفِي رواية ( ثُمَّ رَضِّنِي بِهِ( رَوَاهُ الْبُخَارِيُّ (1166) \n";

            bodyDoaOne = "كيفيّة صلاة الاستخارة في مايلي شرح بسيط لكيفيّة أداء صلاة الاستخارة: (4) الوضوء: فلا تجوز أيّة صلاةٍ دون وضوء، سنّةً كانت أم فرضاً. النيّة: ولا يُقصد هنا التّلفظ بالنّية حتى لا تخرج إلى حكم البدعة، إنّما موقعها القلب، فقيام المُسلم إلى الصّلاة وهو يحمل النّية بأداء صلاة الاستخارة أمرٌ كافٍ لتحديد المقصد من هذه الصّلاة، ولا حاجةً لنطقها والتّصريح بها عَلَناً. صلاة ركعتين دون الفريضة: فيصلّي المسلم ركعتين تطوّعاً على ألّا تكون من الفروض الخمسة، ويقرأ سورة الفاتحة وتليها سورةٌ صغيرةٌ، ومن السّنة قراءة سورة الكافرون بعد الفاتحة في الرّكعة الأولى، والإخلاص في الرّكعة الثّانية. التّسليم آخر الصّلاة كما يحدث في أيّة صلاةٍ عاديّةٍ. رفع اليدين للدّعاء بالأمر الذي يشغل بالَ المستخير والطّلب من الله تعالى أن يُتمّمَ الأمر إن كان فيه خيرٌ، وأن يصرفَه إن كان فيه شرٌ. التيقّن بإجابة الله تعالى وحكمه.\n" +
                    "\n";
            doaaTitleType = context.getResources().getString(R.string.doaa_astkhara_title);

        } else if (doaaType == PointerOfDoaaType.DOAA_SGWDTLAWA) {
            titleDoaOne = "الدعاء المأثور في سجود التلاوة\n";
            bodyDoaOne = "فالسنة أن يقول في سجود التلاوة: \" سجد وجهي للذي خلقه، وشق سمعه وبصره بحوله \u200Fوقوته\" رواه الترمذي والحاكم وزاد: \" فتبارك الله أحسن الخالقين\".\u200F\n" +
                    "وأجاز بعض العلماء أن يقول سبحان ربي الأعلى، أو يفعل مثلما يفعل في سائر السجود. \u200Fقال الإمام النووي: (ويستحب أن يقول في سجوده: \" سجد وجهي للذي خلقه وصوره \u200Fوشق سمعه وبصره بحوله وقوته\". وأن يقول: \" اللهم اكتب لي بها عندك أجراً، واجعلها لي \u200Fعندك ذخراً ، وضع عني بها وزراً، واقبلها مني كما قبلتها من عبدك داود عليه السلام\" ولو \u200Fقال ما يقول في سجود صلاته جاز. ثم يرفع رأسه مكبراً كما يرفع من سجود الصلاة) \u200Fروضة الطالبين (1/322).\n" +
                    "ومن العلماء من فصل بين من كان في الصلاة فاستحب له التسبيح بالإضافة إلى الدعاء المعروف ، وبين من كان خارج الصلاة فاستحب له \u200Fالاقتصار على الدعاء دون التسبيح.\u200F";
            doaaTitleType = context.getResources().getString(R.string.doaa_sgwd_title);
        }
        DoaaOneTypeModel doaaOneTypeModel = new DoaaOneTypeModel();
        doaaOneTypeModel.setTitleDoaOne(titleDoaOne);
        doaaOneTypeModel.setBodyDoaOne(bodyDoaOne);
        doaaOneTypeModel.setDoaaTitleType(doaaTitleType);
        return doaaOneTypeModel;
    }

    @Override
    public void setView(BaseView view) {
        doaaOneTypeView = (DoaaOneTypeView) view;

    }
}
