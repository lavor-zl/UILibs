package com.lavor.circleindicatordemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.lavor.circleindicatordemo.loop.LoopViewPager2;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewpager;
    private me.relex.circleindicator.CircleIndicator indicator;
    private MyFragment myFragment1;
    private MyFragment myFragment2;
    private MyFragment myFragment3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_circle_indicator);
        //最佳循环轮播方案
        perfectLoop();
    }

    /**
     * 当xml中是android.support.v4.view.ViewPager与me.relex.circleindicator.CircleIndicator时，
     * 调用此方法进行轮播（不能循环）
     */
    public void baseUsage() {
        this.indicator = (CircleIndicator) findViewById(R.id.indicator);
        this.viewpager = (ViewPager) findViewById(R.id.view_pager);
        List<Fragment> list = new ArrayList<>();
        myFragment1 = new MyFragment(R.drawable.image1);
        myFragment2 = new MyFragment(R.drawable.image2);
        myFragment3 = new MyFragment(R.drawable.image3);
        list.add(myFragment1);
        list.add(myFragment2);
        list.add(myFragment3);
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(getSupportFragmentManager(), list);
        viewpager.setAdapter(myPagerAdapter);
        indicator.setViewPager(viewpager);
    }

    /**
     * 当xml中是com.lavor.circleindicatordemo.LoopViewPager与me.relex.circleindicator.CircleIndicator时，
     * CircleIndicator这个库中，实现普通的循环轮播（不完美，从最后一个滑到到第一个，或者从第一个滑动到最后一个有点问题）
     */
    public void normalLoop(){
        this.indicator = (CircleIndicator) findViewById(R.id.indicator);
        this.viewpager = (ViewPager) findViewById(R.id.view_pager);
        SamplePagerAdapter samplePagerAdapter = new SamplePagerAdapter();
        viewpager.setAdapter(samplePagerAdapter);
        indicator.setViewPager(viewpager);
    }

    /**
     * 当xml中是com.lavor.circleindicatordemo.loop.LoopViewPager2与com.lavor.circleindicatordemo.loop.CircleIndicator时，
     * 最佳循环轮播，修改CircleIndicator这个库中的与ViewPager相关的东西为与LoopViewPager2相关的东西
     * 并将其中 mViewpager.removeOnPageChangeListener(mInternalPageChangeListener), mViewpager.addOnPageChangeListener(mInternalPageChangeListener);
     * 改为mViewpager.setOnPageChangeListener(mInternalPageChangeListener);
     * 因为LoopViewPager2是早期实现的版本，里面没有removeOnPageChangeListener，addOnPageChangeListener这两个方法
     * LoopViewPager2复制自LoopViewPager库中的LoopViewPager
     * CircleIndicator库地址：https://github.com/ongakuer/CircleIndicator
     * LoopViewPager库地址：https://github.com/yanzm/LoopViewPager
     */
    public void perfectLoop() {
        com.lavor.circleindicatordemo.loop.CircleIndicator indicator = (com.lavor.circleindicatordemo.loop.CircleIndicator) findViewById(R.id.indicator);
        LoopViewPager2 viewpager = (LoopViewPager2) findViewById(R.id.view_pager);
        List<View> list = new ArrayList<>();
        LayoutInflater.from(this).inflate(R.layout.view1, null);
        list.add(LayoutInflater.from(this).inflate(R.layout.view1, null));
        list.add(LayoutInflater.from(this).inflate(R.layout.view2, null));
        list.add(LayoutInflater.from(this).inflate(R.layout.view3, null));
        MyPagerAdapter2 myPagerAdapter2 = new MyPagerAdapter2(list);
        viewpager.setAdapter(myPagerAdapter2);
        indicator.setViewPager(viewpager);
    }

}
