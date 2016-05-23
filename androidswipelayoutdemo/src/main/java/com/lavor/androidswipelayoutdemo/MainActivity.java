package com.lavor.androidswipelayoutdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private android.widget.LinearLayout bottomwrapper;
    private android.support.v7.widget.RecyclerView recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.recyclerview = (RecyclerView) findViewById(R.id.recycler_view);
        this.bottomwrapper = (LinearLayout) findViewById(R.id.bottom_wrapper);
        List<String> list=new ArrayList<>();
        for(int i=0;i<40;i++){
            list.add("欢迎关注我的github:lavor-zl:"+(i+1));
        }
        MyRecyclerViewAdapter myRecyclerViewAdapter=new MyRecyclerViewAdapter(this,list);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(myRecyclerViewAdapter);

    }
}
