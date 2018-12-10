package com.example.timedemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText)findViewById(R.id.edit1);
        button = (Button)findViewById(R.id.button1);
    }

    public void Start(View view) {
        //获取编辑框中输入的数值
        String data = editText.getText().toString();
        //new一个新活动
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        //绑定数值，供下一个活动使用
        intent.putExtra("extra_data", data);
        //启动新活动
        startActivity(intent);
    }
}
