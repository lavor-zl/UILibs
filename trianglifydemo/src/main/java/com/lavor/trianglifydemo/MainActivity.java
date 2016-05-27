package com.lavor.trianglifydemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.manolovn.trianglify.TrianglifyView;

public class MainActivity extends AppCompatActivity {

    private com.manolovn.trianglify.TrianglifyView trianglifyview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_trianglify);
        this.trianglifyview = (TrianglifyView) findViewById(R.id.trianglify_view);
    }
}
