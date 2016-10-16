package com.hahacs.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * ���ڹ�����
 */
public class MyDateUtil {

	private static Logger logger = Logger.getLogger(MyDateUtil.class);
	/**
	 * ÿ�տ�ʼʱ�� 00:00:00
	 */
	public static final String DAY_START_TIME = " 00:00:00";
	/**
	 * ÿ�ս���ʱ�� 23:59:59
	 */
	public static final String DAY_END_TIME = " 23:59:59";
	/**
	 * ���ڸ�ʽ yyyy-MM-dd
	 */
	public static final String DATE_FMT = "yyyy-MM-dd";
	/**
	 * ���ڸ�ʽyyyy/MM/dd
	 */
	public static final String DATE_FMT_AM = "yyyy/MM/dd";
	/**
	 * ���ڸ�ʽ HH:mm:ss
	 */
	public static final String TIME_FMT = "HH:mm:ss";
	/**
	 * ���ڸ�ʽ HH:mm
	 */
	public static final String TIME_FMT_WITHOUT_SECOND = "HH:mm";
	/**
	 * ���ڸ�ʽ yyyy-MM
	 */
	public static final String MONTH_FMT = "yyyy-MM";
	/**
	 * ���ڸ�ʽ yyyy-MM-dd HH:mm:ss
	 */
	public static final String DATE_TIME_FMT = "yyyy-MM-dd HH:mm:ss";
	/**
	 * ���ڸ�ʽ yyyy/MM/dd HH:mm:ss
	 */
	public static final String DATE_TIME_FMT_EN = "yyyy/MM/dd HH:mm:ss";
	/**
	 * ���ڸ�ʽ yyyy-MM-dd HH:mm
	 */
	public static final String DATE_TIME_HM = "yyyy-MM-dd HH:mm";
	/**
	 * ���ڸ�ʽ yyyyMMddHHmmss
	 */
	public static final String DATETIMEFMT = "yyyyMMddHHmmss";
	/**
	 * ���ڸ�ʽ yyyy��M��
	 */
	public static final String MONTH_FMT_CN = "yyyy��M��";
	/**
	 * ���ڸ�ʽ yyyy��M��d��
	 */
	public static final String DATE_FMT_CN = "yyyy��M��d��";
	/**
	 * ���ڸ�ʽ yyyyMMdd
	 */
	public static final String DATE_FMT_EN = "yyyyMMdd";
	
	/**
	 * ��ȡָ������־�����ڼ�
	 *
	 * @param date
	 * @return
	 */
	public static int getWeekDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

		return dayOfWeek;
	}

	/**
	 * ��ñ�����һ����
	 *
	 * @return
	 */
	public static Date getMonday() {
		Calendar c = Calendar.getInstance();
		int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (day_of_week == 0) {
			day_of_week = 7;
		}
		c.add(Calendar.DATE, -day_of_week + 1);
		c.set(Calendar.HOUR, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		return c.getTime();
	}

	/**
	 * ************************************************************************
	 * �ж�currDate�Ƿ���startdate��enddate֮��
	 *
	 * @param currDate
	 *            ��ǰ����
	 * @param startdate
	 *            ���ڷ�Χ��ʼ
	 * @param enddate
	 *            ���ڷ�Χ��ֹ
	 * @return
	 */
	public static boolean isInMiddle(Date currDate, Date startdate, Date enddate) {
		boolean result = false;
		if (null == currDate || null == startdate || null == enddate) {
			return result;
		}
		long currentTimeVal = currDate.getTime();
		result = ((currentTimeVal >= startdate.getTime()) && (currentTimeVal < enddate.getTime()));
		return result;
	}

	/**
	 * ��ȡָ������־�����ڼ�
	 *
	 * @param date
	 * @return
	 */
	public static String getWeekDayString(Date date) {
		String weekString = "";
		final String dayNames[] = { "������", "����һ", "���ڶ�", "������", "������", "������", "������" };
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		weekString = dayNames[dayOfWeek - 1];
		return weekString;
	}

	/**
	 * ���������� ���ڼ��ĸ�ʽ����ĳ�������
	 *
	 * @param date
	 * @return
	 */
	public static String getDayString(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");
		String tdate = sdf.format(date);
		tdate += " " + getWeekDayString(date);
		return tdate;
	}

	public static String amOrPm(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("HH");
		int hour = Integer.valueOf(sdf.format(date));
		if (hour <= 12) {
			return "����";
		} else {
			return "����";
		}
	}

	/*
	 * public static void main(String[] args) { Calendar c =
	 * Calendar.getInstance(); for(int i=18;i<30;i++) { c.set(2012, 10, i);
	 * System.out.println(getWeekDayString(c.getTime())); } c.set(2012, 10, 16);
	 * System.out.println(getDayString(c.getTime()));
	 * System.out.println(amOrPm(new Date())); }
	 */

	// ����������yyyy-MM-dd HH:mm:ss
	public static Date getDateTimeByStr(String date) {
		Date date1 = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			if (date != null)
				date1 = sdf.parse(date);
		} catch (Exception e) {
			logger.error("���ַ���ת����yyyy-MM-dd HH:mm:ss���ڳ���" + e.getMessage(), e);
		}
		return date1;
	}

	public static Date getDateByStr(String date) {
		Date date1 = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			if (date != null)
				date1 = sdf.parse(date);
		} catch (Exception e) {
			logger.error("���ַ���ת����yyyy-MM-dd���ڳ���" + e.getMessage(), e);
		}
		return date1;
	}
	
	public static Date getDateByStr(String date, String fmt) {
		Date date1 = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(fmt);
			if (date != null)
				date1 = sdf.parse(date);
		} catch (Exception e) {
			logger.error("���ַ���ת����"+fmt+"���ڳ���" + e.getMessage(), e);
		}
		return date1;
	}

	// �����ַ���"yyyy-MM-dd"
	public static String getDateStrByDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}

	// �����ַ���"yyyy-MM-dd"
	public static String getDateStrByDate(Date date, String pattern) {
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		return sdf.format(date);
	}

	/**
	 * desc: �����ַ���"yyyy-MM-dd HH:mm:ss"
	 *
	 * @param date
	 * @return auther: �¾� mail��chenjun@hyxt.com date: Feb 26, 2014 2:47:06 PM
	 */
	public static String getDateTimeStrByDate(Date date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}

	public static Date addYear(Date date, int yearAmount) {
		return addInteger(date, Calendar.YEAR, yearAmount);
	}

	/**
	 * ����������ĳ���͵�ĳ��ֵ������������
	 *
	 * @param date
	 *            ����
	 * @param dateType
	 *            ����
	 * @param amount
	 *            ��ֵ
	 * @return ���������
	 */
	private static Date addInteger(Date date, int dateType, int amount) {
		Date myDate = null;
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(dateType, amount);
			myDate = calendar.getTime();
		}
		return myDate;
	}

	public static String getYearMonth(Date date) {
		if (null == date) {
			date = new Date();
		}
		return dateToDateStr(MONTH_FMT, date);
	}

	/**
	 * ��ȡ����
	 */
	public static Date getCurrentDateTime() {

		return getCurrentDateTime(DATE_TIME_FMT);
	}

	public static Date getCurrentDate() {

		return getCurrentDate(DATE_FMT);
	}

	public static Date getCurrentTime() {

		return getCurrentTime(TIME_FMT);
	}

	public static Date getCurrentDateTime(String fmt) {

		return dateStrToDate(fmt, getCurrentDateTimeStr(fmt));
	}

	public static Date getCurrentDate(String fmt) {

		return dateStrToDate(fmt, getCurrentDateStr(fmt));
	}

	public static Date getCurrentTime(String fmt) {

		return dateStrToDate(fmt, getCurrentTimeStr(fmt));
	}

	public static String getCurrentDateTimeStr() {

		return getCurrentDateTimeStr(DATE_TIME_FMT);
	}

	public static String getCurrentTimeStr() {

		return getCurrentTimeStr(TIME_FMT);
	}

	public static String getCurrentDateStr() {

		return getCurrentDateStr(DATE_FMT);
	}

	public static String getCurrentDateTimeStr(String fmt) {

		String temp = new SimpleDateFormat(fmt).format(new Date());

		return temp;
	}

	public static String getCurrentTimeStr(String fmt) {

		String temp = new SimpleDateFormat(fmt).format(new Date());

		return temp;
	}

	public static String getCurrentDateStr(String fmt) {

		String temp = new SimpleDateFormat(fmt).format(new Date());

		return temp;
	}

	public static String dateToDateStr(Date date) {

		String temp = new SimpleDateFormat(DATE_TIME_FMT).format(date);

		return temp;
	}

	public static String dateToDateStr(String fmt, Date date) {

		String temp = new SimpleDateFormat(fmt).format(date);

		return temp;
	}

	/**
	 * ת��Ϊ���ڶ���
	 */
	public static Date dateStrToDate(String date) {
		if (StringUtils.isEmpty(date)) {
			return null;
		}
		Date temp = null;
		try {
			temp = new SimpleDateFormat(DATE_FMT).parse(date);
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
		}
		return temp;
	}

	/**
	 * �ַ���ת��Ϊ����ʱ���ʽ����
	 */
	public static Date dateStrToDatetime(String date) {
		if (date == null) {
			return null;
		}
		Date temp = null;
		try {
			temp = new SimpleDateFormat(DATE_TIME_FMT).parse(date);
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
		}
		return temp;
	}

	public static Date dateStrToDate(String fmt, String date) {
		Date temp = null;
		try {
			temp = new SimpleDateFormat(fmt).parse(date);
		} catch (ParseException e) {
			logger.error(e.getMessage(), e);
		}
		return temp;
	}

	/**
	 * ��ʽ������
	 */
	public static String formatDateTime(Date date) {

		return formatDateTime(DATE_TIME_FMT, date);
	}

	public static String formatDateTime(String fmt, Date date) {
		if (StringUtils.isEmpty(fmt) || null == date) {
			return null;
		}
		String temp = new SimpleDateFormat(fmt).format(date);

		return temp;
	}

	public static String formatTime(Date date) {
		return formatTime(TIME_FMT, date);
	}

	public static String formatTime(String fmt, Date date) {
		if (StringUtils.isEmpty(fmt) || null == date) {
			return null;
		}
		String temp = new SimpleDateFormat(fmt).format(date);

		return temp;
	}

	public static String formatDate(Date date) {
		return formatDate(DATE_FMT, date);
	}

	public static String formatDate(String fmt, Date date) {
		if (StringUtils.isEmpty(fmt) || null == date) {
			return null;
		}
		String temp = new SimpleDateFormat(fmt).format(date);

		return temp;
	}

	public static String formatNumber(String fmt, Object value) {
		if (StringUtils.isEmpty(fmt) || null == value) {
			return null;
		}
		String temp = new DecimalFormat(fmt).format(value);

		return temp;
	}

	/**
	 * �Ƚ�����������������
	 */
	public static int compareDay(Date date1, Date date2) {
		if (date1 == null || date2 == null)
			return 0;

		Calendar d1 = Calendar.getInstance();
		d1.setTime(date1);
		Calendar d2 = Calendar.getInstance();
		d2.setTime(date2);
		if (d1.after(d2)) {
			java.util.Calendar swap = d1;
			d1 = d2;
			d2 = swap;
		}
		/*
		 * ��������Ĵ�����֤d2��d1֮��
		 * �������days����С��0����Ϊd2��d1���ܲ���ͬһ��������Ļ���Ȼd1�����С��������һ���е�"�ڼ���"ȴ���ܱ�d2��
		 */
		int days = d2.get(java.util.Calendar.DAY_OF_YEAR) - d1.get(java.util.Calendar.DAY_OF_YEAR);
		int y2 = d2.get(java.util.Calendar.YEAR);
		if (d1.get(java.util.Calendar.YEAR) != y2) {// �������ͬһ��
			d1 = (java.util.Calendar) d1.clone();
			do {
				days += d1.getActualMaximum(java.util.Calendar.DAY_OF_YEAR);
				/*
				 * ������ Calendar ��ʱ��ֵ������ָ�������ֶο���ӵ�е����ֵ�� ���磬��ĳЩ����У�MONTH �ֶε�ʵ�����ֵ��
				 * 12������ϣ��������ϵͳ����������У����ֶε�ʵ�����ֵ�� 13�� DAY_OF_YEAR������366��
				 */
				d1.add(java.util.Calendar.YEAR, 1);
			} while (d1.get(java.util.Calendar.YEAR) != y2);
		}
		return days;

	}

	/**
	 * �Ƚ�����������������
	 */
	public static int compareWeek(Date date1, Date date2) {
		if (date1 == null || date2 == null) {
			return 0;
		}
		Calendar c1 = Calendar.getInstance();
		c1.setTime(date1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(date2);

		if (c1.equals(c2)) {
			return 0;
		}

		if (c1.after(c2)) {
			Calendar temp = c1;
			c1 = c2;
			c2 = temp;
		}
		// �����ֵ
		int result = c2.get(Calendar.WEEK_OF_MONTH) - c1.get(Calendar.WEEK_OF_MONTH);
		return result;
	}

	/**
	 * �Ƚ�����������������
	 */
	public static int compareMonth(Date date1, Date date2) {
		if (date1 == null || date2 == null)
			return 0;

		int iMonth = 0;
		int flag = 0;
		try {
			Calendar objCalendarDate1 = Calendar.getInstance();
			objCalendarDate1.setTime(date1);

			Calendar objCalendarDate2 = Calendar.getInstance();
			objCalendarDate2.setTime(date2);

			if (objCalendarDate2.equals(objCalendarDate1))
				return 0;
			if (objCalendarDate1.after(objCalendarDate2)) {
				Calendar temp = objCalendarDate1;
				objCalendarDate1 = objCalendarDate2;
				objCalendarDate2 = temp;
			}

			if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1.get(Calendar.YEAR))
				iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1.get(Calendar.YEAR)) * 12
						+ objCalendarDate2.get(Calendar.MONTH) - flag)
						- objCalendarDate1.get(Calendar.MONTH);
			else
				iMonth = objCalendarDate2.get(Calendar.MONTH) - objCalendarDate1.get(Calendar.MONTH) - flag;

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return iMonth;
	}

	/**
	 * ������������֮����������
	 *
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compareMonthNew(Date date1, Date date2) {
		int iMonth = 0;
		int flag = 0;
		try {
			Calendar objCalendarDate1 = Calendar.getInstance();
			objCalendarDate1.setTime(date1);

			Calendar objCalendarDate2 = Calendar.getInstance();
			objCalendarDate2.setTime(date2);

			if (objCalendarDate2.equals(objCalendarDate1))
				return 0;
			if (objCalendarDate1.after(objCalendarDate2)) {
				Calendar temp = objCalendarDate1;
				objCalendarDate1 = objCalendarDate2;
				objCalendarDate2 = temp;
			}
			// if (objCalendarDate2.get(Calendar.DAY_OF_MONTH) <
			// objCalendarDate1
			// .get(Calendar.DAY_OF_MONTH))
			// flag = 1;

			if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1.get(Calendar.YEAR))
				iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1.get(Calendar.YEAR)) * 12
						+ objCalendarDate2.get(Calendar.MONTH) - flag)
						- objCalendarDate1.get(Calendar.MONTH);
			else
				iMonth = objCalendarDate2.get(Calendar.MONTH) - objCalendarDate1.get(Calendar.MONTH) - flag;

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return iMonth;
	}

	/**
	 * �Ƚ�����������������
	 */
	public static int compareMonth(String strdate1, String strdate2) {
		if (StringUtils.isEmpty(strdate1) || StringUtils.isEmpty(strdate2)) {
			return 0;
		}
		Date date1 = dateStrToDate(strdate1);
		Date date2 = dateStrToDate(strdate2);
		try {
			return compareMonth(date1, date2);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return 0;
	}

	/**
	 * �Ƚ�����������������
	 */
	public static int compareDay(String strdate1, String strdate2) {
		if (StringUtils.isEmpty(strdate1) || StringUtils.isEmpty(strdate2)) {
			return 0;
		}
		Date date1 = dateStrToDate(strdate1);
		Date date2 = dateStrToDate(strdate2);
		try {
			return compareDay(date1, date2);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return 0;
	}

	/**
	 * �Ƚ�����������������
	 */
	public static long compareTime(Date date1, Date date2) {
		if (date1 == null || date2 == null)
			return 0;

		Calendar c = Calendar.getInstance();

		c.setTime(date1);
		long l1 = c.getTimeInMillis();

		c.setTime(date2);
		long l2 = c.getTimeInMillis();

		return (l2 - l1) / 1000;
	}

	// ����ʱ��
	public static Date addDateTime(Date date, int type, int num) {
		if (date == null) {
			return null;
		}
		// ��ʼ����������
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		// �����������
		switch (type) {
		case 1: // �����
			cal.set(Calendar.YEAR, cal.get(Calendar.YEAR) + num);
			break;
		case 2: // �����
			cal.set(Calendar.MONTH, cal.get(Calendar.MONTH) + num);
			break;
		case 3: // �����
			cal.set(Calendar.DATE, cal.get(Calendar.DATE) + num);
			break;
		case 4: // ���ʱ
			cal.set(Calendar.HOUR, cal.get(Calendar.HOUR) + num);
			break;
		case 5: // ��ӷ�
			cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + num);
			break;
		case 6: // �����
			cal.set(Calendar.SECOND, cal.get(Calendar.SECOND) + num);
			break;
		}

		// ���ز������
		return cal.getTime();
	}

	// ��������ʱ��
	private static Date setDateTime(Date date, int type, int num) {
		if (date == null) {
			return null;
		}
		// ��ʼ����������
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);

		// �����������
		switch (type) {
		case 1: // �����
			cal.set(Calendar.YEAR, num);
			break;
		case 2: // �����
			cal.set(Calendar.MONTH, num);
			break;
		case 3: // �����
			cal.set(Calendar.DATE, num);
			break;
		case 4: // ���ʱ
			cal.set(Calendar.HOUR_OF_DAY, num);
			break;
		case 5: // ��ӷ�
			cal.set(Calendar.MINUTE, num);
			break;
		case 6: // �����
			cal.set(Calendar.SECOND, num);
			break;
		}

		// ���ز������
		return cal.getTime();
	}

	/**
	 * �����ꡢ�¡���
	 */
	public static Date setYMD(Date date, int year, int month, int day) {

		return setYear(setMonth(setDate(date, day), month), year);
	}

	public static Date setYear(Date date, int num) {
		return addDateTime(date, 1, num);
	}

	public static Date setMonth(Date date, int num) {
		return addDateTime(date, 2, num);
	}

	public static Date setDate(Date date, int num) {
		return addDateTime(date, 3, num);
	}

	/**
	 * ����ʱ���֡���
	 */
	public static Date setHMS(Date date, int hour, int minute, int second) {

		return setHour(setMinute(setSecond(date, second), minute), hour);
	}

	public static Date setHour(Date date, int num) {
		return setDateTime(date, 4, num);
	}

	public static Date setMinute(Date date, int num) {
		return setDateTime(date, 5, num);
	}

	public static Date setSecond(Date date, int num) {
		return setDateTime(date, 6, num);
	}

	// /** ����ꡢ�¡��ա�ʱ���֡��� */
	// public static Date addYear(Date date, int num) {
	// return addDateTime(date, 1, num);
	// }

	public static Date addMonth(Date date, int num) {
		return addDateTime(date, 2, num);
	}

	public static Date addDate(Date date, int num) {
		return addDateTime(date, 3, num);
	}

	/**
	 * ����ꡢ�¡���
	 */
	public static Date addYMD(Date date, int year, int month, int day) {

		return addYear(addMonth(addDate(date, day), month), year);
	}

	public static Date addHour(Date date, int num) {
		return addDateTime(date, 4, num);
	}

	public static Date addMinute(Date date, int num) {
		return addDateTime(date, 5, num);
	}

	public static Date addSecond(Date date, int num) {
		return addDateTime(date, 6, num);
	}

	/**
	 * ���ʱ���֡���
	 */
	public static Date addHMS(Date date, int hour, int minute, int second) {

		return addHour(addMinute(addSecond(date, second), minute), hour);
	}

	public static int getYear(Date date) {
		Calendar cale = Calendar.getInstance();
		if (date != null) {
			cale.setTime(date);
		}
		return cale.get(Calendar.YEAR);
	}

	/**
	 * �õ�ĳ��ĵ�һ��
	 *
	 * @return
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 */
	public static String getYearFirstDate(Date date) {
		return getYear(date) + "-01-01";
	}

	/**
	 * �õ�ĳ��ĳ�µĵ�һ��
	 *
	 * @return
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 */
	public static String getMonthFirstDate(Date date) {
		return getYearMonth(date) + "-01";
	}

	/**
	 * �õ�ĳ��ĳ�µ����һ��
	 *
	 * @return
	 * @author dylan_xu
	 * @date Mar 11, 2012
	 */
	public static String getMonthEndDate(Date date) {
		String endDate = "";
		Calendar c = Calendar.getInstance();
		if (date == null) {
			c.setTime(date);
		}
		endDate = getYearMonth(c.getTime()) + "-" + c.getActualMaximum(Calendar.DAY_OF_MONTH);
		return endDate;
	}

	/**
	 * ת��һ��ʱ����ڵĵ�ÿһ���ʽ Ϊ 2014-05-26
	 */
	public static String getDateScope(Date date, int d) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (d == 0)
			return sdf.format(date);
		long time = date.getTime();
		Date t = new Date(time);
		Calendar c = Calendar.getInstance();
		c.setTime(t);
		c.add(Calendar.DAY_OF_YEAR, d);
		String str = sdf.format(c.getTime());
		return str;
	}

	/**
	 * ��ȡ��XX�켰ָ����ʽʱ���б�
	 *
	 * @param recentlyDay
	 * @param format
	 * @return
	 * @author weichengpei
	 * @create 2014��12��13�� ����3:58:25
	 */
	public static List<String> getRecentDate(int recentlyDay, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		List<String> recentDatelist = new ArrayList<String>();
		Calendar calendar = Calendar.getInstance();
		for (int i = recentlyDay - 1; i >= 0; i--) {
			calendar.setTime(new Date());
			calendar.add(Calendar.DAY_OF_YEAR, -i);
			String day = df.format(calendar.getTime());
			recentDatelist.add(day);
		}
		return recentDatelist;
	}

	/**
	 * ��ȡָ����ʼ���ںͽ�ֹ���ڽ�XX��ʱ���б�
	 *
	 * @param startStr
	 * @param endStr
	 * @param format
	 * @return
	 * @author weichengpei
	 * @create 2014��12��13�� ����4:16:26
	 */
	public static List<String> getRecentDateByStartEnd(String startStr, String endStr, String format) {
		List<String> list = new ArrayList<String>();
		if (startStr.trim().equals(endStr.trim())) {
			list.add(startStr);
			return list;
		}
		if (StringUtils.isNotEmpty(startStr) && StringUtils.isNotEmpty(endStr)) {
			Date startDate = MyDateUtil.getDateByStr(startStr);
			Date endDate = MyDateUtil.getDateByStr(endStr);
			if (startDate.before(endDate)) {
				int days = MyDateUtil.compareDay(startDate, endDate);
				list = getRecentDateByEndDate(days + 1, endDate, format);
			}
		}
		return list;
	}

	/**
	 * ��ȡ��ֹ���ڽ�XX�켰ָ����ʽʱ���б�
	 *
	 * @param recentlyDay
	 * @param endDate
	 * @param format
	 * @return
	 * @author weichengpei
	 * @create 2014��12��13�� ����4:16:45
	 */
	public static List<String> getRecentDateByEndDate(int recentlyDay, Date endDate, String format) {
		SimpleDateFormat df = new SimpleDateFormat(format);
		List<String> recentDatelist = new ArrayList<String>();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(endDate);
		for (int i = recentlyDay - 1; i >= 0; i--) {
			calendar.setTime(endDate);
			calendar.add(Calendar.DAY_OF_YEAR, -i);
			String day = df.format(calendar.getTime());
			recentDatelist.add(day);
		}
		return recentDatelist;
	}

	/**
	 * ��ȡָ�����������·ݵĵ�һ������һ������
	 *
	 * @param date
	 * @author weichengpei
	 * @create 2014��12��13�� ����5:25:10
	 */
	public static Date[] getMonthStartEndByDate(Date date) {
		Date[] resDates = new Date[2];
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int maxDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		int minDay = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), minDay);
		resDates[0] = calendar.getTime();
		calendar.set(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), maxDay);
		resDates[1] = calendar.getTime();
		return resDates;
	}

	/**
	 * ��ȡָ�������������ڵĵ�һ������һ������
	 *
	 * @param date
	 * @return
	 * @author weichengpei
	 * @create 2014��12��15�� ����12:11:27
	 * @description ���������ڵ�һ��, �������������һ��
	 */
	public static Date[] getWeekStartEndByDate(Date date) {
		Date[] resDates = new Date[2];
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int dayOfWeek = getWeekDay(calendar.getTime());
		calendar.add(Calendar.DAY_OF_YEAR, -dayOfWeek + 1);
		Date startDate = calendar.getTime();
		calendar.setTime(startDate);
		calendar.add(Calendar.DAY_OF_YEAR, 6);
		Date endDate = calendar.getTime();
		resDates[0] = startDate;
		resDates[1] = endDate;
		return resDates;
	}

	public static Date[] getWeekStartEndByDate(int year, int week) {
		Date[] resDates = new Date[2];
		Calendar calendar = Calendar.getInstance();
		// �������
		calendar.set(Calendar.YEAR, year);
		// ������
		calendar.set(Calendar.WEEK_OF_YEAR, week);
		// ���ø��ܵ�һ��Ϊ����һ
		calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);
		resDates[0] = calendar.getTime();
		resDates[1] = MyDateUtil.addDate(resDates[0], 6);
		return resDates;
	}

	// public static int getMonthSpace(Date date1, Date date2)
	// {
	// if (date1 == null || date2 == null)
	// return 0;
	// int result = 0;
	// Calendar c1 = Calendar.getInstance();
	// Calendar c2 = Calendar.getInstance();
	// c1.setTime(date1);
	// c2.setTime(date2);
	// result = c2.get(Calendar.) - c1.get(Calendar.MONTH);
	// return result == 0 ? 1 : Math.abs(result);
	//
	// }

	/**
	 * ��һ��ʱ�������һ��Ŀ�ʼ��00:00:00
	 *
	 * @param date
	 * @return
	 * @author qhq
	 * @create 2015��1��12�� ����4:38:15
	 */
	public static Date dateLast(Date date) {
		Date last = MyDateUtil.dateStrToDate(DATE_FMT, MyDateUtil.formatDate(DATE_FMT, date));
		last = MyDateUtil.addHour(last, 23);
		last = MyDateUtil.addMinute(last, 59);
		last = MyDateUtil.addSecond(last, 59);
		return last;

	}

	/**
	 * ��һ��ʱ�������һ������23:59:59
	 *
	 * @param date
	 * @return
	 * @author qhq
	 * @create 2015��1��12�� ����4:38:15
	 */
	public static Date dateStart(Date date) {
		Date start = MyDateUtil.dateStrToDate(DATE_FMT, MyDateUtil.formatDate(DATE_FMT, date));
		return start;

	}

	/**
	 * ��ȡָ������00:00:00��59:59:59
	 *
	 * @param date
	 * @return
	 */
	public static Date[] getDateStartAndEnd(Date date) {
		return new Date[] { dateStart(date), dateLast(date) };
	}

	/**
	 * ��ȡָ������00:00:00��59:59:59
	 * 
	 * @param date
	 * @return
	 */
	public static Date parseStrToDate(String dateStr) {
		Date date = null;
		if (!StringUtils.isEmpty(dateStr)) {
			try {
				date = MyDateUtil.dateStrToDate(MyDateUtil.DATE_TIME_FMT, dateStr);
			} catch (Exception ea) {
				date = MyDateUtil.dateStrToDate(MyDateUtil.DATE_FMT, dateStr);
			}
		}
		return date;
	}

	/**
	 * ת�������ַ���Ϊyyyy-MM-dd HH:mm:ss��ʽ �����ʽ�Ѿ���yyyy-MM-dd HH:mm:ssֱ�ӷ��أ����������
	 * 
	 * @param dateString
	 *            �����ַ���
	 * @param timeString
	 *            Ҫ���ϵ�ʱ����
	 * @return yyyy-MM-dd HH:mm:ss��ʽ�ַ���
	 */
	@Deprecated
	public static String getDateStartString(String dateString, String timeString) {
		if (StringUtils.isEmpty(dateString)) {
			return "";
		}
		if (dateString.length() == MyDateUtil.DATE_FMT.length()) {
			dateString = dateString + timeString;
		}
		return dateString;
	}

	/**
	 * �ı�������ֹ��yyyy-MM-dd HH:mm:ss��ʽ�ַ���
	 * 
	 * @param dateString
	 *            �����ַ���
	 * @param start
	 *            ���ڿ�ʼ�����
	 * @return
	 */
	public static String getDate2StringYMDHMS(String dateString, boolean start) {
		if (StringUtils.isEmpty(dateString)) {
			return "";
		}
		if (dateString.length() == MyDateUtil.DATE_FMT.length()) {
			dateString = start ? (dateString + DAY_START_TIME) : (dateString + DAY_END_TIME);
		}
		if (dateString.length() == MyDateUtil.DATE_TIME_HM.length()) {
			dateString = start ? (dateString + ":00") : (dateString + ":59");
		}
		return dateString;
	}

	/**
	 * ��ȡ����ʱ��Ĳ�ֵ
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public static long getDiscrepantDays(final Date startDate, final Date endDate) {
		if (startDate == null || endDate == null) {
			return 0;
		}

		if (startDate.before(endDate)) {
			return (endDate.getTime() - startDate.getTime()) / 1000 / 60 / 60 / 24;
		}

		return 0;
	}

	public static void main(String args[]) {

		Calendar c = Calendar.getInstance();
		int day_of_week = c.get(Calendar.DAY_OF_WEEK) - 1;
		if (day_of_week == 0) {
			day_of_week = 7;
		}
		c.add(Calendar.DATE, -day_of_week + 1);
		System.out.println(MyDateUtil.formatDate(MyDateUtil.DATETIMEFMT, new Date()));

		MyDateUtil.formatDate(MyDateUtil.DATETIMEFMT, new Date());
	}
}
