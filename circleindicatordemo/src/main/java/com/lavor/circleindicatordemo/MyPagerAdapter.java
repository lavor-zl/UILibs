package com.lavor.circleindicatordemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by shitian on 2016-05-25.
 */
public class MyPagerAdapter extends FragmentPagerAdapter{
    private List<Fragment> list;
    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }
    public MyPagerAdapter(FragmentManager fm, List<Fragment> list) {
        super(fm);
        this.list = list;
    }
    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }
    @Override
    public int getCount() {
        return list.size();
    }
}
