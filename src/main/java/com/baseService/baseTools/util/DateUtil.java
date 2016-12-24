package com.baseService.baseTools.util;

import java.util.Calendar;

public class DateUtil {
	
	public static long getCurrentTime(){
		Calendar calendar = Calendar.getInstance();
		return calendar.getTimeInMillis();
	}
}
