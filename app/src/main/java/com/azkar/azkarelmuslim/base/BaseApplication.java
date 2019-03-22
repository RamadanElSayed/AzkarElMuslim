package com.azkar.azkarelmuslim.base;
import android.app.Application;
import android.arch.persistence.room.Room;

import com.azkar.azkarelmuslim.database.AzkarDao;
import com.azkar.azkarelmuslim.database.AzkarDataBase;

import java.util.Locale;
public class BaseApplication extends Application {

   private AzkarDataBase azkarDataBase;
   private static AzkarDao azkarDao;
    @Override
    public void onCreate() {
        super.onCreate();
        setLocalLanguageArbic();
        setRoamingData();
    }

    private void setLocalLanguageArbic()
    {
        String languageToLoad  = "ar"; // your language
        Locale locale = new Locale(languageToLoad);
        Locale.setDefault(locale);
        android.content.res.Configuration config = new android.content.res.Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config,
                getBaseContext().getResources().getDisplayMetrics());
    }

    private void setRoamingData()
    {
        azkarDataBase = Room.databaseBuilder(getApplicationContext(),
                AzkarDataBase.class, "azkar_db").build();

        azkarDao=azkarDataBase.azkarDao();
    }
    public static AzkarDao getAzkarDoa()
    {
           return azkarDao;
    }
}
