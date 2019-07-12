package com.example.springboothadoophbase.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类
 * @author Adam
 */
public class DateUtil {

	/**
	 * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm:ss
	 * 
	 * @param dateDate
	 * @return
	 */
	public static String dateToStrLong(Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateString = formatter.format(dateDate);
		return dateString;
	}
	
	/**
	 * 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm
	 * 
	 * @param dateDate
	 * @return
	 */
	public static String dateToStrLo(Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * 将短时间格式时间转换为字符串 yyyy-MM-dd
	 * 
	 * @param dateDate
	 * @param k
	 * @return
	 */
	public static String dateToStr(Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(dateDate);
		return dateString;
	}
	
	
	
	/**
	 * 将短时间格式时间转换为字符串yyyy年MM月dd日
	 * 
	 * @param dateDate
	 * @param k
	 * @return
	 */
	public static String dateToDateStr(Date dateDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
		String dateString = formatter.format(dateDate);
		return dateString;
	}

	/**
	 * 获取时间 小时:分;秒 HH:mm:ss
	 * 
	 * @return
	 */
	public static String getTimeShort() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Date currentTime = new Date();
		String dateString = formatter.format(currentTime);
		return dateString;
	}

	/**
	 * 获取Y - M的date
	 * 
	 * @return 返回时间类型 yyyy-MM-dd HH:mm
	 */
	public static Date getYMDate(String time) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		Date date = null;
		try {
			date = formatter.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	/**
	 * 获取Y - M的date
	 * 
	 * @return 返回时间类型 yyyy-MM-dd HH:mm
	 */
	public static Date getYMSDate(String time) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date = formatter.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/**
	 * 一个date修改方法,修改参数，正负 可以实现增加减少 
	 */
	public static Date doDate(Date date,int y,int m,int d){
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		d += c.get(Calendar.DATE);
		m += c.get(Calendar.MONTH);
		y += c.get(Calendar.YEAR);
		c.set(Calendar.DATE, d);
		c.set(Calendar.MONTH, m);
		c.set(Calendar.YEAR, y);
		return c.getTime();
	}
	
	public static String getFileTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyMMddHHmm");
		Date currentTime = new Date();
		String dateString = formatter.format(currentTime);
		return dateString;
	}
	
	public static String getTimeByMinute(int minute) {

        Calendar calendar = Calendar.getInstance();

        calendar.add(Calendar.MINUTE, minute);

        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime());

    }
	
}
