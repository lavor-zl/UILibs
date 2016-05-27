package com.lavor.brokenviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.zys.brokenview.BrokenCallback;
import com.zys.brokenview.BrokenTouchListener;
import com.zys.brokenview.BrokenView;

public class MainActivity extends AppCompatActivity {

    private android.widget.ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_broken_view);
        this.image = (ImageView) findViewById(R.id.image);
        //创建BrokenView的对象
        BrokenView brokenView = BrokenView.add2Window(this);
        //创建BrokenTouchListener的对象
        BrokenTouchListener listener = new BrokenTouchListener.Builder(brokenView).build();
        //为image设置触摸事件监听
        image.setOnTouchListener(listener);

    }
}
