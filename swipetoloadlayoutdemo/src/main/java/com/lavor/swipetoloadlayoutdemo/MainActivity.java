package com.lavor.swipetoloadlayoutdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.aspsine.swipetoloadlayout.OnLoadMoreListener;
import com.aspsine.swipetoloadlayout.OnRefreshListener;
import com.aspsine.swipetoloadlayout.SwipeToLoadLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private android.support.v7.widget.RecyclerView recyclerView;
    private List<String> list;
    private com.aspsine.swipetoloadlayout.SwipeToLoadLayout swipeToLoadLayout;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_swipe_to_load_layout);
        this.swipeToLoadLayout = (SwipeToLoadLayout) findViewById(R.id.swipeToLoadLayout);
        this.recyclerView = (RecyclerView) findViewById(R.id.swipe_target);
        //为recyclerView设置布局管理器
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("原始数据");
        }
        myAdapter = new MyAdapter(list);
        //为recyclerView设置适配器
        recyclerView.setAdapter(myAdapter);
        //为swipeToLoadLayout设置下拉刷新监听者
        swipeToLoadLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                for (int i = 0; i < 20; i++) {
                    list.add(0,"刷新获得的数据");
                }
                myAdapter.notifyDataSetChanged();
                //设置下拉刷新结束
                swipeToLoadLayout.setRefreshing(false);
            }
        });
        //为swipeToLoadLayout设置上拉加载更多监听者
        swipeToLoadLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                for (int i = 0; i < 20; i++) {
                    list.add("加载更多获得的数据");
                }
                myAdapter.notifyDataSetChanged();
                //设置上拉加载更多结束
                swipeToLoadLayout.setLoadingMore(false);
            }
        });
    }
}
