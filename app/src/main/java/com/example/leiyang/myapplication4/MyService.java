package com.example.leiyang.myapplication4;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by LeiYang on 2016/8/9 0009.
 */

public class MyService extends Service {

    DownloadBinder downloadBinder = new DownloadBinder();

    @Nullable
    @Override
    /**
     * 当一个活动与服务绑定后就可以调用服务里的Binder提供的方法了
     * Activity：活动
     * Service：服务
     */
    public IBinder onBind(Intent intent) {
        return downloadBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("info","Service->onCreate()");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("info","Service->onStartCommand()");
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("info","Service->onDestroy()");
    }
}
