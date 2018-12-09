package com.example.addressbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText1;
    EditText editText2;
    ListView listView;
    MyAdapter myAdapter;
    List<Person> personList = new ArrayList<Person>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        editText1 = (EditText)findViewById(R.id.edit_text1);
        editText2 = (EditText)findViewById(R.id.edit_text2);
        getData();
        myAdapter = new MyAdapter(MainActivity.this, personList);
        listView = (ListView)findViewById(R.id.list_view);
        listView.setAdapter(myAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = editText1.getText().toString();
                String number = editText2.getText().toString();

                Person p7 = new Person(name, number, R.drawable.pineapple_pic);
                personList.add(p7);
            }
        });
    }

    private void getData() {
        Person p1 = new Person("jjj", "223253", R.drawable.banana_pic);
        Person p2 = new Person("高老板", "12534315", R.drawable.apple_pic);
        Person p3 = new Person("蛤", "23454353", R.drawable.mango_pic);
        Person p4 = new Person("hk", "223245342", R.drawable.strawberry_pic);
        Person p5 = new Person("齐", "46543", R.drawable.pear_pic);
        Person p6 = new Person("ppn", "456546", R.drawable.banana_pic);

        personList.add(p1);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);
        personList.add(p6);
    }
}
