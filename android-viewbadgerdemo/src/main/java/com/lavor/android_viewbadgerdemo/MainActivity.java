package com.lavor.android_viewbadgerdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.readystatesoftware.viewbadger.BadgeView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_viewbadger);
        //获取添加“徽章”的目标View
        View target  = (TextView) findViewById(R.id.text);
        BadgeView badge = new BadgeView(this, target);
        badge.setText("1");
        //设置文本颜色
        badge.setTextColor(Color.BLACK);
        //设置背景颜色
        badge.setBadgeBackgroundColor(Color.YELLOW);
        //显示
        badge.show();
    }
}
