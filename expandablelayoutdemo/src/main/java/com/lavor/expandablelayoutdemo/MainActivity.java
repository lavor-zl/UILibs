package com.lavor.expandablelayoutdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.andexert.expandablelayout.library.ExpandableLayoutListView;

public class MainActivity extends AppCompatActivity {
    private String[] array={"微信公众号","Android技术漫谈","Android","Android开发"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.header_text, array);
        final ExpandableLayoutListView expandableLayoutListView = (ExpandableLayoutListView) findViewById(R.id.list_view);
        expandableLayoutListView.setAdapter(arrayAdapter);
    }
}
