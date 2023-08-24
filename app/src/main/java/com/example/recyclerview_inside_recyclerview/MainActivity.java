package com.example.recyclerview_inside_recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import adapter.listdataAdapter;
import model.category;
import model.listdata;
import model.user;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvdata;
    private listdataAdapter listdataAdapter;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvdata=(RecyclerView) findViewById(R.id.rcvdata);
        listdataAdapter=new listdataAdapter();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rcvdata.setLayoutManager(linearLayoutManager);

        listdataAdapter.setdata(this,getlistdata());
        rcvdata.setAdapter(listdataAdapter);
    }

    private List<model.listdata> getlistdata() {
        List<listdata> listdata =new ArrayList<>();

        List<category> categories=new ArrayList<>();

        categories.add(new category(R.drawable.aoxanh));
        categories.add(new category(R.drawable.hoahong));
        categories.add(new category(R.drawable.aoxanh));
        categories.add(new category(R.drawable.hoahong));
        categories.add(new category(R.drawable.aoxanh));
        categories.add(new category(R.drawable.hoahong));

        List<user> users=new ArrayList<>();

        users.add(new user("user 1"));
        users.add(new user("user 2"));
        users.add(new user("user 3"));
        users.add(new user("user 4"));
        users.add(new user("user 5"));

        listdata.add(new listdata(adapter.listdataAdapter.type_cate,categories,null));
        listdata.add(new listdata(adapter.listdataAdapter.type_user,null,users));
        listdata.add(new listdata(adapter.listdataAdapter.type_cate,categories,null));
        listdata.add(new listdata(adapter.listdataAdapter.type_user,null,users));
        listdata.add(new listdata(adapter.listdataAdapter.type_cate,categories,null));
        listdata.add(new listdata(adapter.listdataAdapter.type_user,null,users));

        return listdata;
    }
}