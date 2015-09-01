package com.example.yxx.xdemo;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by tony on 2015/9/1.
 */
public class Mappli extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
