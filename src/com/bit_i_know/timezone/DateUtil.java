package com.bit_i_know.timezone;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * Java Date Manipulation.
 * 
 * @author pradeep
 *
 */
public class DateUtil {
	/**
	 * Get the current date.
	 * 
	 * @return
	 */
	public static Date getCurrentDate() {
		return new Date();
	}

	/**
	 * Get the current date on TIMEZONE based.
	 * 
	 * @return
	 */
	public static Date getTimeZoneCurrentDateTime(String timeZone) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeZone(TimeZone.getTimeZone("PST"));
		calendar.setTime(getCurrentDate());
		return new Date();
	}

	/**
	 * Change the format of the date and get it in string value.
	 * 
	 * @param args
	 */
	public static String getCurrentDateCustomedFormat(String format) {
		DateFormat df = new SimpleDateFormat(format);
		return df.format(new Date());
	}

	/**
	 * Return current month.
	 * 
	 * @return
	 */
	public static int getMonth() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getCurrentDate());
		return calendar.get(Calendar.MONTH);
	}

	/**
	 * Return current day.
	 * 
	 * @return
	 */
	public static int getDay() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getCurrentDate());
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * Return current hour of the day.
	 * 
	 * @return
	 */
	public static int getCurrentHour() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getCurrentDate());
		return calendar.get(Calendar.HOUR_OF_DAY);
	}

	/**
	 * Return current minute of the day.
	 * 
	 * @return
	 */
	public static int getCurrentMinute() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(getCurrentDate());
		return calendar.get(Calendar.MINUTE);
	}

	/**
	 * Parse String to date.
	 * 
	 * @return
	 * @throws ParseException
	 */
	public static Date parseStringtoDate(String date) throws ParseException {
		String fileName = date;
		String datevalue = fileName.substring(fileName.lastIndexOf("_") + 1, fileName.lastIndexOf("."));
		DateFormat df1 = new SimpleDateFormat("yyyyMMddHHmmss");
		Date fileDate = df1.parse(datevalue);
		return fileDate;
	}

	public static void main(String[] args) {
		try {
			System.out.println("Get the System date : " + getCurrentDate());

			System.out.println("Get the current date for PST time zone : " + getTimeZoneCurrentDateTime("PST"));

			System.out.println("Get the current date in the  yyyy-MM-dd HH:mm:ss format "
					+ getCurrentDateCustomedFormat("yyyy-MM-dd HH:mm:ss"));

			// Month has index with ZERO. Jan month will be 0
			System.out.println("Current month is :  " + getMonth());
			System.out.println("Current day is :  " + getDay());

			System.out.println("Current hour is :  " + getCurrentHour());
			System.out.println("Current minute is :  " + getCurrentMinute());

			String fileName = "FileName_20160829020000.csv";
			Date date = parseStringtoDate(fileName);
			System.out.println("Converting fileName FileName_20160829020000.csv to Date : " + date);

			boolean checkIfCurrentDate = new Date().before(date);
			System.out.println("Check if Current date is before mentioned date : " + checkIfCurrentDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}
}
