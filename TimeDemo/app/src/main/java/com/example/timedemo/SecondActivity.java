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
        String data = intent.getStringExtra("extra_data");
        integer = integer.valueOf(data);
        textView = (TextView)findViewById(R.id.sectext1);
        button = (Button)findViewById(R.id.secbutton1);

        CountDownTimer timer = new CountDownTimer(integer * 1000, 1000) {
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
        timer.start();
    }

}

