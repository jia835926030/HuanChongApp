package com.iblood.utils;

import android.content.Context;
import android.media.Image;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.iblood.R;

/**
 * Created by 特雷西麦克格蕾蒂 on 2017/12/18.
 */

public class LoadImgUtils {
    // 获取网络管理信息
    private static ConnectivityManager manager;
    // 获取网络信息
    private static NetworkInfo network = null;
    public LoadImgUtils() {
    }
    public static boolean isWiFi(Context context) {
        manager = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        network = manager.getActiveNetworkInfo();
        if (network != null && network.isAvailable()) {
            // 是网
            if (network.getType() == ConnectivityManager.TYPE_WIFI) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    public void loadImg(Context context, String url, ImageView imageView){
        boolean wiFi = isWiFi(context);
        if(wiFi==true){
            Glide.with(context).load(url).into(imageView);
        }else if(wiFi==false){
            Toast.makeText(context, "当前未连WIFI", Toast.LENGTH_SHORT).show();
            Glide.with(context).load(R.mipmap.about).into(imageView);
        }

    }
}
