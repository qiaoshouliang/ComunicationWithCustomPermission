package com.example.qiaoshouliang.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by qiaoshouliang on 16/1/15.
 */
public class MyBroadCastReceiver extends BroadcastReceiver{
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e("Josen-----------------",intent.getStringExtra("my_name"));
    }
}
