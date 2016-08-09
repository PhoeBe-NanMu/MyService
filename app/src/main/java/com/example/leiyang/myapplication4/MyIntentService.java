package com.example.leiyang.myapplication4;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by LeiYang on 2016/8/9 0009.
 *  Remember to register This Activity
 */
public class MyIntentService extends IntentService{

    public MyIntentService(){
        super("MyIntentService");
    }
    public MyIntentService(String name) {
        super(name);
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        Log.i("info","onHandleIntent Thread ID is : "+ Thread.currentThread().getId());
}

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("info","onHandleIntent->Destroy() executed");
    }
}
