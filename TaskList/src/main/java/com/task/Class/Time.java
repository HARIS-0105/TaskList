package com.task.Class;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time 
{
	public static String getDateWithTime()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy-hh:mm:ss");  
		Date date=new Date();
	    String strDate= formatter.format(date);
	    return strDate;
	}
	public static String getDate()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		Date date=new Date();
	    String strDate= formatter.format(date);
	    return strDate;
	}
	public static String getDateDash()
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");  
		Date date=new Date();
	    String strDate= formatter.format(date);
	    return strDate;
	}
	public static int getDaysDifference(String dueDate,String today)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
		try {
			Date date1=formatter.parse(dueDate);
			Date date2=formatter.parse(today);
			long timeDiff=(long) (date1.getTime()-date2.getTime());
			int days=(int) ((timeDiff/(3600000*24)));
			return days;
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}
	public static String convertDate(String date)
	{
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String newDate="";
		try {
			Date dateObj=formatter.parse(date);
			SimpleDateFormat formatterOut = new SimpleDateFormat("dd-MM-yyyy");  
		    newDate= formatterOut.format(dateObj);
		    
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return newDate;
	}
	public static void main(String[] args) {
//		System.out.println(getDate());
//		System.out.println(getDateWithTime());
//		System.out.println(getDaysDifference("02-07-2003","01-05-2002"));
		System.out.println(convertDate("2023-04-06"));
	}
}
