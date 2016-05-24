package com.lavor.labelviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.lid.lib.LabelButtonView;
import com.lid.lib.LabelImageView;
import com.lid.lib.LabelTextView;

public class MainActivity extends AppCompatActivity {

    private com.lid.lib.LabelButtonView labelButton;
    private com.lid.lib.LabelImageView labelImage;
    private com.lid.lib.LabelTextView labelText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_label_view);
        this.labelText = (LabelTextView) findViewById(R.id.labelText);
        this.labelImage = (LabelImageView) findViewById(R.id.labelImage);
        this.labelButton = (LabelButtonView) findViewById(R.id.labelButton);
    }
}
