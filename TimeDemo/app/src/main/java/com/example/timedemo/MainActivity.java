package com.example.timedemo;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.SimpleDateFormat;

public class MainActivity extends AppCompatActivity {
    Handler handler;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView)findViewById(R.id.textView2);

        handler = new Handler() {
            //接收消息的函数
            @Override
            public void handleMessage(Message message) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                long ct = System.currentTimeMillis();
                String time = simpleDateFormat.format(ct);
                textView.setText(time);

            }
        };
    }

    public void Start(View view) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true){
                    Message message = new Message();
                    message.what = 1;
                    //发送消息到UI线程
                    handler.sendMessage(message);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
