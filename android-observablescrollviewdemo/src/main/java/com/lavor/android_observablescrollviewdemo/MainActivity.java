package com.lavor.android_observablescrollviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;

import com.github.ksoichiro.android.observablescrollview.ObservableListView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ObservableScrollViewCallbacks{

    private ObservableListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_observable_scrollview);
        this.listview = (ObservableListView) findViewById(R.id.list_view);
        ArrayList<String> items = new ArrayList<String>();
        for (int i = 1; i <= 100; i++) {
            items.add("数据 " + i);
        }
        //为listview设置Adapter
        listview.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,items));
        //为listview设置滚动回调观察者
        listview.setScrollViewCallbacks(this);

    }
    /**
     * 滚动时
     * @param scrollY
     * @param firstScroll
     * @param dragging
     */
    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        Log.i("onScrollChanged","Y轴的坐标："+scrollY);

    }
    /**
     * 按下时
     */
    @Override
    public void onDownMotionEvent() {

    }
    /**
     * 拖曳结束或者取消时
     * @param scrollState
     */
    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
        if(scrollState==ScrollState.DOWN){
            Log.i("onUpOrCancelMotionEvent","向下滚动");
        }else if(scrollState==ScrollState.UP){
            Log.i("onUpOrCancelMotionEvent","向上滚动");
        }else {
            Log.i("onUpOrCancelMotionEvent","停止滚动");
        }
    }
}
