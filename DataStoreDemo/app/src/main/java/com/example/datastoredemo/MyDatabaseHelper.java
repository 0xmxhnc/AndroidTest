package com.example.datastoredemo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    public MyDatabaseHelper (Context context, String name, int version) {
        super(context, name,null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //创建sql语句，新建表
        String sqlCommand1 = "create table student(_id integer primary key, name varchar(255), age integer)";
        //执行sql语句
        db.execSQL(sqlCommand1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
    }
}

