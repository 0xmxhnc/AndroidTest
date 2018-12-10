package com.example.timedemo;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    Button button;
    TextView textView;
    Integer integer = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        //获取主活动传递来的数据
        String data = intent.getStringExtra("extra_data");
        //将String类型data转为Int类型，再强转为long型
        long num = (long) integer.parseInt(data);
        textView = (TextView)findViewById(R.id.text2);
        button = (Button)findViewById(R.id.button2);

        //使用倒计时类，传入倒计时数值
        CountDownTimer timer = new CountDownTimer(num * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                // TODO Auto-generated method stub
                button.setText("还剩" + millisUntilFinished / 1000 + "秒");
            }

            @Override
            public void onFinish() {
                button.setText("倒计时完毕");
            }
        };
        //倒计时功能生效
        timer.start();
    }

}

