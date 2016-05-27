package com.lavor.android_stackblurdemo;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.commit451.nativestackblur.NativeStackBlur;

public class MainActivity extends AppCompatActivity {

    private android.widget.ImageView image;
    private android.widget.Button blurbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_stackblur);
        this.blurbutton = (Button) findViewById(R.id.blur_button);
        this.image = (ImageView) findViewById(R.id.image);
        blurbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap source= BitmapFactory.decodeResource(getResources(),R.drawable.image);
                //对Bitmap进行模糊化处理，第一个参数代表原始Bitmap，第二个参数代表模糊半径
                //半径越大，处理后的图片就越模糊
                Bitmap bm = NativeStackBlur.process(source, 5);
                image.setImageBitmap(bm);
            }
        });

    }
}
