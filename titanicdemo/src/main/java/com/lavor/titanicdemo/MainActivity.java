package com.lavor.titanicdemo;

import android.content.res.ObbInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.romainpiel.titanic.library.Titanic;
import com.romainpiel.titanic.library.TitanicTextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TitanicTextView tv = (TitanicTextView) findViewById(R.id.my_text_view);
        // 设置我们想要的字体
        tv.setTypeface(Typefaces.get(this, "Satisfy-Regular.ttf"));
        // 开启下沉动画
        new Titanic().start(tv);





    }
}
