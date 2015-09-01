package com.example.yxx.xdemo;

import android.widget.TextView;

/**
 * Created by tony on 2015/9/1.
 */
public class LOL {


    private static LOL minstall;
    private TextView ss;

    public static LOL install(){
        if(minstall==null){
            minstall = new LOL();
        }
        return minstall;
    }

    public void  initview(TextView view) {
        ss=view;
    }
}
