package com.huanchong.pet.utils;

public class SpfUtils {

	// 用户状态否是保留在寄养师页面
	public static final String FOSTER_STATE = AppUtils.getUser().getUserId()
			+ "foster_state";

	// 用户状态记录?
	public static final String FOSTER_STATE_VAL = "foster_state_val";
}
