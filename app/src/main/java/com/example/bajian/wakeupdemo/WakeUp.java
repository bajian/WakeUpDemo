package com.example.bajian.wakeupdemo;

import android.app.KeyguardManager;
import android.content.Context;
import android.os.PowerManager;

/**
 * 屏幕唤醒和解锁
 * Created by bajian on 2015/11/10.
 * email 313066164@qq.com
 * <uses-permission android:name="android.permission.WAKE_LOCK" />
 * <uses-permission android:name="android.permission.DISABLE_KEYGUARD" />
 */
public class WakeUp {

    /**
     * @param context
     * @param unlock
     */
    public static void wakeUpAndUnlock(Context context,Boolean unlock){
        KeyguardManager km= (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
        KeyguardManager.KeyguardLock kl = km.newKeyguardLock("unLock");
        //解锁
        if (unlock)
        kl.disableKeyguard();
        //获取电源管理器对象
        PowerManager pm=(PowerManager) context.getSystemService(Context.POWER_SERVICE);
        //获取PowerManager.WakeLock对象,后面的参数|表示同时传入两个值,最后的是LogCat里用的Tag
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.ACQUIRE_CAUSES_WAKEUP | PowerManager.SCREEN_DIM_WAKE_LOCK,"bright");
        //点亮屏幕
        wl.acquire();
        //释放
        wl.release();
    }

    public static void wakeUpAndUnlock(Context context){
        wakeUpAndUnlock(context,true);
    }
}
