package com.lavor.numberprogressbardemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.daimajia.numberprogressbar.NumberProgressBar;

public class MainActivity extends AppCompatActivity {

    private com.daimajia.numberprogressbar.NumberProgressBar numberprogressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_number_progress_bar);
        this.numberprogressbar = (NumberProgressBar) findViewById(R.id.number_progress_bar);
        //设置进度条文本区域显示的前缀
        numberprogressbar.setPrefix("");
        //设置进度条文本区域显示的后缀
        numberprogressbar.setSuffix("%");
        //设置进度条的进度，参数的值在0-mMax之间取值，mMax默认值是100
        numberprogressbar.setProgress(70);
    }
}
