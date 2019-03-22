package com.azkar.azkarelmuslim.utils;

import android.app.Activity;
import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.azkar.azkarelmuslim.R;
import com.github.johnpersano.supertoasts.library.Style;
import cn.pedant.SweetAlert.SweetAlertDialog;

import static com.github.johnpersano.supertoasts.library.SuperActivityToast.create;

public class Messenger {

    public static void showSuccessMsg(String txt, Activity activity) {
        create(activity, new Style(), Style.TYPE_STANDARD)
                .setText(txt)
                .setDuration(Style.DURATION_LONG)
                .setFrame(Style.FRAME_LOLLIPOP)
                .setColor(ContextCompat.getColor(activity, R.color.colorPrimary))
                .setAnimations(Style.ANIMATIONS_POP).show();
    }

    public static void showErrorMsg(String msg, Activity activity) {
        create(activity, new Style(), Style.TYPE_STANDARD)
                .setText(msg)
                .setDuration(Style.DURATION_LONG)
                .setFrame(Style.FRAME_LOLLIPOP)
                .setColor(ContextCompat.getColor(activity, R.color.colorPrimary))
                .setAnimations(Style.ANIMATIONS_POP).show();


    }

    public static SweetAlertDialog removeAzkarSweetDialog(Context context, String title, String msg,
                                                         String acceptBtnText, String cancelBtnText, boolean cancelable,
                                                         SweetAlertDialog.OnSweetClickListener acceptListener,
                                                         SweetAlertDialog.OnSweetClickListener cancelListener) {
        SweetAlertDialog dialog = new SweetAlertDialog(context, SweetAlertDialog.WARNING_TYPE)
                .setTitleText(title)
                .setContentText(msg)
                .setConfirmText(acceptBtnText)
                .setConfirmClickListener(acceptListener)
                .setCancelButton(cancelBtnText, cancelListener);
        dialog.setCancelable(cancelable);
        return dialog;

    }

}
