package com.crm.techsan.generics;

import java.util.Date;
import java.util.Random;
/**
 * 
 * @author Rajiv
 *
 */
public class JavaUtil {
	/**
	 * to get random number
	 * @return randon number in the range of 1to 5000
	 */
	public int randomvalue() {
		Random ran=new Random();
		int num=ran.nextInt(5000);
		return num;
	}
	/**
	 * to get the current month
	 * @return
	 */
	public String getmonth() {
		Date date=new Date();
		String strDate = date.toString();
		String[] dateArr = strDate.split(" ");
		String month = dateArr[1];
		return month;
	}
	/**
	 * ro get the Todays date
	 * @return
	 */
	public String getdate() {
		Date date=new Date();
		String strDate = date.toString();
		String[] dateArr = strDate.split(" ");
		String Todaysdate = dateArr[2];
		return Todaysdate;
	}
	/**
	 * to get the current Year
	 * @return
	 */
	public String getyear() {
		Date date=new Date();
		String strDate = date.toString();
		String[] dateArr = strDate.split(" ");
		String year = dateArr[5];
		return year;
	}
	
	public String currentdate() {
		Date date=new Date();
		String strDate = date.toString();
		return strDate;
	}

}
