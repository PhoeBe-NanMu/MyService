package com.example.leiyang.myapplication4;

import android.os.Binder;
import android.util.Log;

/**
 * Created by LeiYang on 2016/8/9 0009.
 */
public class DownloadBinder extends Binder{

    /*模拟方法-->开始下载*/
    public void startDownload() {
        Log.i("info","startDownload executed");
    }

    /*模拟方法-->获取下载进度*/
    public int getProgress() {
        Log.i("info","getProgress executed");
        return 0;
    }


}
