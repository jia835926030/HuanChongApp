/**
 * @描述		:	
 * @作�??	    :Android - csx
 * @创建日期  :2016�?3�?18�? 下午6:43:07  
 *
 */
package com.huanchong.pet.utils;

import android.net.ParseException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @描述 :时间工具�?
 * @作�?? :Android - csx
 * @创建日期 :2016�?3�?18�? 下午6:43:07
 * 
 */
public class TimeUtils {

	/**
	 * 字符串的日期格式的计�?
	 */
	public static int daysBetween(String smdate, String bdate)
			throws ParseException {
		long between_days = 0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar cal = Calendar.getInstance();
			cal.setTime(sdf.parse(smdate));
			long time1 = cal.getTimeInMillis();
			cal.setTime(sdf.parse(bdate));
			long time2 = cal.getTimeInMillis();
			between_days = (time2 - time1) / (1000 * 3600 * 24);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 计算年龄
	 * 
	 * @param birthDate
	 * @return
	 */
	public static String getAge(Date birthDate) {

		if (birthDate == null)
			throw new RuntimeException("出生日期不能为null");

		int age = 0;

		Date now = new Date();

		SimpleDateFormat format_y = new SimpleDateFormat("yyyy");
		SimpleDateFormat format_M = new SimpleDateFormat("MM");

		String birth_year = format_y.format(birthDate);
		String this_year = format_y.format(now);

		String birth_month = format_M.format(birthDate);
		String this_month = format_M.format(now);

		// 初步，估�?
		age = Integer.parseInt(this_year) - Integer.parseInt(birth_year);

		// 如果未到出生月份，则age - 1
		if (this_month.compareTo(birth_month) < 0)
			age -= 1;
		if (age < 0)
			age = 0;
		if (age == 0) {
			return 1 + "岁";
		}
		return age + "岁";
	}

	/**
	 * 计算两个日期之间相差的天�?
	 * 
	 * @param smdate
	 *            较小的时�?
	 * @param bdate
	 *            较大的时�?
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate)
			throws ParseException {
		long between_days = 0;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			smdate = sdf.parse(sdf.format(smdate));
			bdate = sdf.parse(sdf.format(bdate));
			Calendar cal = Calendar.getInstance();
			cal.setTime(smdate);
			long time1 = cal.getTimeInMillis();
			cal.setTime(bdate);
			long time2 = cal.getTimeInMillis();
			between_days = (time2 - time1) / (1000 * 3600 * 24);
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 
	 * @描述 :计算2日期�?
	 * @方法名称 :getYear---->TimeUtils.java
	 * @作�?? :Android - csx
	 * @创建日期 :2016�?3�?30�? 上午11:54:49
	 * @param start
	 * @param end
	 * @return
	 * 
	 */
	public static String getYear(String start) {
		String year = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cStart = Calendar.getInstance();
		cStart.getTime();
		return year;
	}

	/**
	 * 获得指定日期的前�?�?
	 * 
	 * @param specifiedDay
	 * @return
	 * @throws Exception
	 */
	public static String getSpecifiedDayBefore(String specifiedDay) {// 可以用new
																		// Date().toLocalString()传�?�参�?
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
		} catch (Exception e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day - 1);

		String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c
				.getTime());
		return dayBefore;
	}

	/**
	 * 获得指定日期的后�?�?
	 * 
	 * @param specifiedDay
	 * @return
	 */
	public static String getSpecifiedDayAfter(String specifiedDay) {
		Calendar c = Calendar.getInstance();
		Date date = null;
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(specifiedDay);
		} catch (Exception e) {
			e.printStackTrace();
		}
		c.setTime(date);
		int day = c.get(Calendar.DATE);
		c.set(Calendar.DATE, day + 1);

		String dayAfter = new SimpleDateFormat("yyyy-MM-dd")
				.format(c.getTime());
		return dayAfter;
	}

}
