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
        dbHelper = new MyDatabaseHelper(this, "test.db", 1);
        adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1);
        ListView listView = (ListView)findViewById(R.id.list1);
        listView.setAdapter(adapter);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                //查询student表中所有数据
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
