package com.example.leiyang.myapplication4;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by LeiYang on 2016/8/11 0011.
 */
public class AlarmReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("info","收到定时广播，重新计时");
        Intent intent1 = new Intent(context,LongRunningService.class);
        context.startService(intent1);
    }
}
