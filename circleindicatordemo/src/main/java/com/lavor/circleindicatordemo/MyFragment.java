package com.lavor.circleindicatordemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by shitian on 2016-05-25.
 */
public class MyFragment extends Fragment {
    private View view;
    private int res;
    public MyFragment(int res) {
        this.res = res;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.my_fragment,container,false);
        setImage(res);
        return view;
    }
    //设置Fragment中ImageView的图片
    public void setImage(int res){
        ImageView imageView= (ImageView) view.findViewById(R.id.loop_image);
        imageView.setImageResource(res);
    }

}
