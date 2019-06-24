package com.azkar.azkarelmuslim.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.azkar.azkarelmuslim.R;
import com.azkar.azkarelmuslim.startpackageview.views.activities.StartAzkarActivity;
import com.azkar.azkarelmuslim.utils.NotificationUtils;

public class TodayAzkarReceiver extends BroadcastReceiver {


    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationUtils notificationUtils = new NotificationUtils(context);
        Intent earningIntent = new Intent(context,StartAzkarActivity.class);
        notificationUtils.showNotificationMessage(context.getString(R.string.azkar_elmuslim)
                ,earningIntent);
    }
}