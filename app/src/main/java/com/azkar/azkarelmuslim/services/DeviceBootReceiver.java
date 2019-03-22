package com.azkar.azkarelmuslim.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.azkar.azkarelmuslim.base.BaseActivity;
import com.azkar.azkarelmuslim.utils.AlarmUtil;

import java.util.Objects;

public class DeviceBootReceiver extends BroadcastReceiver {

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void onReceive(Context context, Intent intent) {
        if (Objects.equals(intent.getAction(), "android.intent.action.BOOT_COMPLETED")) {
            new AlarmUtil(context).setEarningAlarm(8);
            new AlarmUtil(context).setEarningAlarm(20);
        }
    }
}