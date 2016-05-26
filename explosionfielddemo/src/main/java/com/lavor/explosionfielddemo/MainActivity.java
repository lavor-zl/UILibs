package com.lavor.explosionfielddemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import tyrantgit.explosionfield.ExplosionField;

public class MainActivity extends AppCompatActivity {

    private android.widget.ImageView icon;
    private android.widget.Button button;
    private ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_explosion_field);
        this.image = (ImageView) findViewById(R.id.image);
        this.button = (Button) findViewById(R.id.button);
        this.icon = (ImageView) findViewById(R.id.icon);
        final ExplosionField mExplosionField = ExplosionField.attach2Window(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExplosionField.explode(icon);
                mExplosionField.explode(image);
            }
        });
    }
}
