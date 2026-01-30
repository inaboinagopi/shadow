package com.shadowapp.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

import com.shadowapp.constants.Constants.FormatDates;

public class DU {
	
	
	public static Date parse(String dateString, String format) {
		if (format != null && format.equals("dd-MM-yyyy") && dateString != null && !dateString.contains("-")) {
			format = FormatDates.DATEFORMAT;
		}
		SimpleDateFormat sdf = null;
		sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(dateString);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public static String CurrentDate() {
		return DU.format(new Date(), "YYYY-MM-dd HH:MM:SS.sss").replace(" ", "T");
	}

	public static Date addDays(Date date, int days, boolean tillLastMinOfDay) {
		Calendar tomorrow = new GregorianCalendar(DEFAULT_TIME_ZONE);
		tomorrow.setTime(date);
		tomorrow.add(Calendar.DATE, days);
		if (tillLastMinOfDay) {
			tomorrow.set(Calendar.AM_PM, 0);
			tomorrow.set(Calendar.HOUR_OF_DAY, 23);
			tomorrow.set(Calendar.MINUTE, 59);
			tomorrow.set(Calendar.SECOND, 59);
		}
		return tomorrow.getTime();
	}

	public static Date parsed(String dateString, String format) {
		if (format == null) {
			throw new IllegalArgumentException("format cannot be null");
		}

		// Determine format based on the date string
		if (dateString == null || dateString == "") {
			return null; // Return null if the date string is null
		}
		if (dateString.matches("\\d{2}-\\d{2}-\\d{4}")) {
			format = "dd-MM-yyyy";
		} else if (dateString.matches("\\d{2} \\w{3} \\d{4}")) {
			format = "dd MMM yyyy";
		} else if (dateString.matches("\\d{2}-\\w{3}-\\d{4}")) {
			format = "dd-MMM-yyyy";
		} else if (dateString.matches("\\d{4}-\\d{2}-\\d{2}")) {
			format = "yyyy-MM-dd";
		} else if (dateString.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}")) {
			format = "yyyy-MM-dd HH:mm";
		} else if (dateString.matches("\\d{4}-\\d{2}-\\d{2} \\d{1}:\\d{2}")) {
			format = "yyyy-MM-dd H:mm";
		} else if (dateString.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}")) {
			format = "yyyy-MM-dd HH:mm";
		} else if (dateString.matches("\\d{4}-\\d{2}-\\d{2} \\d{1,2}:\\d{2} [AP]M")) {
			format = "yyyy-MM-dd h:mm a";
		} else if (dateString.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}")) {
			format = "yyyy-MM-dd HH:mm:ss";
		} else {
			throw new IllegalArgumentException("Unrecognized date format: " + dateString);
		}

		SimpleDateFormat sdf = new SimpleDateFormat(format);
		try {
			return sdf.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	public static String calculateWorkingTime(String loginString, String logoutString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
		LocalTime loginTime = LocalTime.parse(loginString, formatter);
		LocalTime logoutTime = LocalTime.parse(logoutString, formatter);
		long hours = loginTime.until(logoutTime, java.time.temporal.ChronoUnit.HOURS);
		long minutes = loginTime.until(logoutTime, java.time.temporal.ChronoUnit.MINUTES) % 60;
		return String.format("%02d:%02d", hours, minutes);

	}

	public static String formatStr(Date date) {
		return format(date, "dd-MM-yyyy");
	}

	public static String formatStrTO(Date date) {
		return format(date, "yyyy-MM-dd");
	}

	public static String formatDateAndtime(Date date) {
		return format(date, "yyyy-MM-dd HH:mm:sss");
	}
	
	public static String formatDateAndtimes(Date date) {
		return format(date, "dd-MM-yyyy HH:mm:ss");
	}


	public static String format(Date date, String format) {
		if (date == null) {
			return null;
		}
		SimpleDateFormat sdf = null;
		sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	public static boolean isToday(Date otherDate) {
		Calendar otherCal = Calendar.getInstance();
		otherCal.setTime(otherDate);
		Calendar nowCal = Calendar.getInstance();

		if (otherCal.get(Calendar.DATE) == nowCal.get(Calendar.DATE)
				&& otherCal.get(Calendar.MONTH) == nowCal.get(Calendar.MONTH)
				&& otherCal.get(Calendar.YEAR) == nowCal.get(Calendar.YEAR)) {
			return true;
		} else {
			return false;
		}
	}

	public static int getDifferenceDays(Timestamp day1, Timestamp day2) {
		if (day1 == null || day2 == null) {
			return 0;
		}
		int diff = 0;
		diff = (int) ((day1.getTime() - day2.getTime()) / (1000 * 60 * 60 * 24));
		return diff;
	}

	public static int getDifferenceDays(Date startDate, Date endDate) {
		if (startDate == null || endDate == null) {
			return 0;
		}
		int diff = 0;
		diff = (int) ((startDate.getTime() - endDate.getTime()) / (1000 * 60 * 60 * 24));
		return diff;
	}

	private static final TimeZone DEFAULT_TIME_ZONE = TimeZone.getDefault();

	public static Timestamp now() {
		Calendar zoneCalendar = Calendar.getInstance(DEFAULT_TIME_ZONE);
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DATE, zoneCalendar.get(Calendar.DATE));
		calendar.set(Calendar.MONTH, zoneCalendar.get(Calendar.MONTH));
		calendar.set(Calendar.YEAR, zoneCalendar.get(Calendar.YEAR));
		calendar.set(Calendar.HOUR, zoneCalendar.get(Calendar.HOUR));
		calendar.set(Calendar.HOUR_OF_DAY, zoneCalendar.get(Calendar.HOUR_OF_DAY));
		calendar.set(Calendar.AM_PM, zoneCalendar.get(Calendar.AM_PM));
		calendar.set(Calendar.MINUTE, zoneCalendar.get(Calendar.MINUTE));
		calendar.set(Calendar.SECOND, zoneCalendar.get(Calendar.SECOND));
		calendar.set(Calendar.MILLISECOND, zoneCalendar.get(Calendar.MILLISECOND));
		return new Timestamp(calendar.getTime().getTime());
	}

	public static Date addMinutes(Date date1, int minBefore) {
		Calendar now = Calendar.getInstance();
		now.setTime(date1);
		now.add(Calendar.MINUTE, minBefore);
		return now.getTime();
	}

	public static Date addDaysAndHours(Date date, int days, int hours) {
		return addDaysAndHours(date, days, hours, DEFAULT_TIME_ZONE);
	}

	public static Date addDaysAndHours(Date date, int days, int hours, TimeZone zone) {
		Calendar newDate = new GregorianCalendar(zone);
		newDate.setTime(date);
		newDate.add(Calendar.DATE, days);
		newDate.add(Calendar.HOUR, hours);
		return new Timestamp(newDate.getTime().getTime());
	}

	public static Date today() {
		Timestamp now = now();
		return now;
	}

	public static long timeDuration(String startTime, String endTime) {
		LocalTime start = LocalTime.parse(startTime, DateTimeFormatter.ofPattern("HH:mm"));
		LocalTime end = LocalTime.parse(endTime, DateTimeFormatter.ofPattern("HH:mm"));

		Duration duration;

		duration = Duration.between(start, end);

		return duration.toMinutes();

	}

	public static Date trimTimeS(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.AM_PM, Calendar.AM);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	public static Date trimTime(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.AM_PM, Calendar.AM);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		// cal.set(Calendar.ZONE_OFFSET,0);
		return cal.getTime();
	}
	
	
	

}
