package com.wisn.rxjava;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.util.Log;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * Created by wisn on 2017/12/14.
 */

public class BootReceiver extends BroadcastReceiver {
    private static final String TAG ="BootReceiver" ;

    @Override
    public void onReceive(final Context context, Intent intent) {
        Log.e(TAG,"开机了");
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                    SystemClock.sleep(500);
                    Log.d(TAG,"imdi  time "+new Date(System.currentTimeMillis()));
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getApplicationContext().getSystemService(Context.TELEPHONY_SERVICE);
                        String deviceId1 = telephonyManager.getDeviceId();
                        String deviceId= deviceId1.trim();
                        Pattern p = Pattern.compile("IMEI", Pattern.CASE_INSENSITIVE);
                        Matcher m = p.matcher(deviceId);
                        deviceId = m.replaceAll(" ");
                        deviceId = deviceId.replace(":", " ");
                        deviceId = deviceId.trim();
                        Log.d(TAG,"imdi "+deviceId+"  time "+new Date(System.currentTimeMillis()));
                    } catch (PatternSyntaxException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
