package com.example.addressbook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by asus on 2018/11/16.
 */

public class MyAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private Context mcontext;
    private List<Person> personlist;

    public MyAdapter (Context context, List<Person> list) {
        layoutInflater = LayoutInflater.from(context);
        this.mcontext = context;
        this.personlist = list;
    }

    @Override
    public int getCount() {
        return personlist.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            view = layoutInflater.inflate(R.layout.person_information, null);
        }
        else{
            view = convertView;
        }

        //绑定布局
        TextView textView = (TextView)view.findViewById(R.id.text_name);
        TextView textView1 = (TextView)view.findViewById(R.id.text_phonenumber);
        ImageView imageView = (ImageView)view.findViewById(R.id.image);

        //设置内容
        textView.setText(personlist.get(position).getName());
        textView1.setText(personlist.get(position).getPhonenum());
        imageView.setImageResource(personlist.get(position).getImageId());

        return view;
    }


}
