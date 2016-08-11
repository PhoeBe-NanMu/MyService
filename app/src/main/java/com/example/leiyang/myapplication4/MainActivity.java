package com.example.leiyang.myapplication4;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private Button start ;
    private Button stop;
    private Button bindService;
    private Button unbindServise;
    private Button alarmService;
    private DownloadBinder downloadBinder;
    private Button intentService;



    /*建立绑定关系*/
    ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            downloadBinder = (DownloadBinder) iBinder;
            downloadBinder.startDownload();
            downloadBinder.getProgress();
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = (Button) findViewById(R.id.start_service);
        stop = (Button) findViewById(R.id.stop_service);
        bindService = (Button) findViewById(R.id.bind_service);
        unbindServise = (Button) findViewById(R.id.unbind_service);
        intentService = (Button) findViewById(R.id.intent_service);
        alarmService = (Button) findViewById(R.id.start_alarm_service);
        alarmService.setOnClickListener(this);
        intentService.setOnClickListener(this);
        bindService.setOnClickListener(this);
        unbindServise.setOnClickListener(this);
        start.setOnClickListener(this);
        stop.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.start_service:
                Intent intent = new Intent(this,MyService.class);
                startService(intent);
                break;
            case R.id.stop_service:
                Intent intent1 = new Intent(this,MyService.class);
                stopService(intent1);
                break;
            case R.id.bind_service:
                Intent intent2 = new Intent(this,MyService.class);
                /**
                 *BIND_AUTO_CREATE : 标志位，表示服务和活动进行绑定后自动创建服务
                 *bindService方法用来获取一个永久链接，回调服务中的onBind（）方法
                 */
                bindService(intent2,serviceConnection,BIND_AUTO_CREATE);
                break;
            case R.id.unbind_service:
                unbindService(serviceConnection);
                break;
            case R.id.intent_service:
                /*打印主线程ID*/
                Log.i("info","Main Thread ID is : "+ Thread.currentThread().getId());
                Intent intent3 = new Intent(this,MyIntentService.class);
                startService(intent3);
                break;
            case R.id.start_alarm_service:
                Log.i("info","test");
                Intent intent4 = new Intent(this,LongRunningService.class);
                startService(intent4);
                break;
            default:
                break;
        }

    }
}
