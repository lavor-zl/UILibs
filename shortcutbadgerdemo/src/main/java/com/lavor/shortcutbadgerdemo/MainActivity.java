package com.lavor.shortcutbadgerdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import me.leolin.shortcutbadger.ShortcutBadger;

public class MainActivity extends AppCompatActivity {

    private android.widget.Button add;
    private android.widget.Button delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_shortcutbadger);
        this.delete = (Button) findViewById(R.id.delete);
        this.add = (Button) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int badgeCount = 1;
                ShortcutBadger.applyCount(MainActivity.this, badgeCount); //for 1.1.4
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShortcutBadger.removeCount(MainActivity.this); //for 1.1.4
            }
        });

    }
}
