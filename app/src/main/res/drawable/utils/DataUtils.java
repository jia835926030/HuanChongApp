package com.huanchong.pet.utils;

import com.huanchong.pet.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataUtils {
	/**
	 * 非寄养家庭数�??
	 */
	public static List<Map<String, Object>> NO_FOSTERHOME;
	/**
	 * 寄养家庭数据
	 */
	public static List<Map<String, Object>> FOSTERHOME;

	static {
		// 初始化非寄养家庭数据
		initNoFosterHome();
		// 初始化寄养家庭数�??
		initFosterHome();
	}

	/**
	 * 
	 * @描述 : 非寄养家庭数�??
	 * @方法名称 : initNoFosterHome---->DataUtils.java
	 * @作�?? : Android - yhq
	 * @创建日期 : 2016�??3�??29�?? 下午9:20:41
	 */
	private static void initNoFosterHome() {
		NO_FOSTERHOME = new ArrayList<Map<String, Object>>();
		int[] no_foster_images = { R.drawable.messages, R.drawable.pet,
				R.drawable.order_details, R.drawable.collection_account,
				R.drawable.know, R.drawable.perfect_information };
		int[] no_foster_names = { R.string.messages, R.string.pet,
				R.string.order_details, R.string.collection_account,
				R.string.know, R.string.perfect_information };
		for (int i = 0; i < no_foster_images.length; i++) {
			Map<String, Object> datas = new HashMap<String, Object>();
			datas.put("photo", no_foster_images[i]);
			datas.put("name", no_foster_names[i]);
			NO_FOSTERHOME.add(datas);
		}
	}

	/**
	 * 
	 * @描述 : 寄养家庭数据
	 * @方法名称 : initFosterHome---->DataUtils.java
	 * @作�?? : Android - yhq
	 * @创建日期 : 2016�??3�??29�?? 下午9:20:34
	 */
	private static void initFosterHome() {
		FOSTERHOME = new ArrayList<Map<String, Object>>();
		int[] foster_images = { R.drawable.messages, R.drawable.order_details,
				R.drawable.time_setting, R.drawable.collection_account,
				R.drawable.perfect_information };
		int[] foster_names = { R.string.messages, R.string.order_details_home,
				R.string.time_setting_home, R.string.collection_account_home,
				R.string.perfect_information_home };
		for (int i = 0; i < foster_images.length; i++) {
			Map<String, Object> datas = new HashMap<String, Object>();
			datas.put("photo", foster_images[i]);
			datas.put("name", foster_names[i]);
			FOSTERHOME.add(datas);
		}
	}

}
