package com.iblood.dbprefents;

import android.app.Application;
import android.content.SharedPreferences;
/**
 * 通用数据库（存用用户名密码等）
 *
 */
public class ApplicationDB extends Application{
	/**
	 * 小型数据库读取
	 */
	public static SharedPreferences preferences;
	/**
	 * 小型数据库写入
	 */
	public static SharedPreferences.Editor editor;

	public void onCreate() {
		super.onCreate();
		// 初始化小型数据库的读写
		preferences = getSharedPreferences("doge", MODE_PRIVATE);
		editor = preferences.edit();
	}

}
