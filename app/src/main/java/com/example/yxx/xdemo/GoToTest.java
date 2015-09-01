package com.example.yxx.xdemo;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class GoToTest extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_go_to_test);
        TextView viewById = (TextView) findViewById(R.id.tv_test);
        LOL.install().initview(viewById);
    }
}
