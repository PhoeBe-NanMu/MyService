package com.example.leiyang.myapplication4;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by LeiYang on 2016/8/11 0011.
 */
public class LongRunningService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.i("info","---->>This is two second");
            }
        }).start();

        /*设置一个定时服务*/
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        int twoSecond = 1000*5;
        long longRunningTime = SystemClock.elapsedRealtime()+twoSecond;
        Intent intent1 = new Intent(this,AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this,0,intent1,0);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            alarmManager.setExact(AlarmManager.ELAPSED_REALTIME_WAKEUP,longRunningTime,pendingIntent);
        } else {
            alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,longRunningTime,pendingIntent);

        }
        return super.onStartCommand(intent, flags, startId);
    }
}
