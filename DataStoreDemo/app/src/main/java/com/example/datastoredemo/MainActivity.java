package com.example.datastoredemo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<String> adapter;
    private MyDatabaseHelper dbHelper;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button1);
        //创建MyDatabaseHelper对象
        dbHelper = new MyDatabaseHelper(this, "test.db", 1);
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1);
        ListView listView = (ListView)findViewById(R.id.list1);
        listView.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //通过SQLiteDatabase返回的对象对数据库进行操作
                //getWritableDatabase()方法创建或打开一个可读数据库
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                //查询student表中所有数据
                //查询到的数据都将从Cursor对象取出
                Cursor cursor = db.query(false, "student", null, null, null ,null, null, null, null);
                if (cursor.moveToFirst()){//遍历对象
                    do {
                        //向适配器中添加数据
                        adapter.add(cursor.getString(cursor.getColumnIndex("name")));
                        adapter.add(cursor.getString(cursor.getColumnIndex("no")));
                    }while (cursor.moveToNext());
                }
                cursor.close();
            }
        });
    }

}
