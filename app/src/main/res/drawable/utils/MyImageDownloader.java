package com.huanchong.pet.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.nostra13.universalimageloader.core.download.BaseImageDownloader;

import java.io.IOException;
import java.io.InputStream;

public class MyImageDownloader extends BaseImageDownloader {
	private Context context;

	public MyImageDownloader(Context context) {
		super(context);
		this.context = context;
	}

	public MyImageDownloader(Context context, int connectTimeout,
			int readTimeout) {
		super(context, connectTimeout, readTimeout);
		this.context = context;
	}

	@SuppressWarnings("deprecation")
	@Override
	public InputStream getStream(String imageUri, Object extra)
			throws IOException {
		SharedPreferences spf = context.getSharedPreferences("Image_load",
				Context.MODE_PRIVATE);
		boolean isWifiLoad = spf.getBoolean("lv", false);
		if (isWifiLoad) {
			if (ConnectionUtils.isWiFi(context)
					|| !ConnectionUtils.isConnNetWork(context)) {
				return super.getStream(imageUri, extra);
			} else {
				if (imageUri.indexOf("file://") != -1) {
					return super.getStream(imageUri, extra);
				} else {
					return null;
				}
			}
		}
		return super.getStream(imageUri, extra);
	}

}