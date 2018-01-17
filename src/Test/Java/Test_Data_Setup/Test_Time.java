package Test_Data_Setup;


import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import Data_Setup.Time;

public class Test_Time {

	public final static String time1 = "27/10/17 20:00";
	public final static String time2 = "27/10/17 20:00";
	public final static String time3 = "27/10/17 14:00";
	
	DateFormat TimeFormater = new SimpleDateFormat("yy/MM/dd HH:mm");
	

	@SuppressWarnings("unused")
	@Test
	public void testDateconstructor() throws ParseException {
		Date date = new Date();
		date = TimeFormater.parse(time1);
		Time Time = new Time(date);
		if(Time == null) fail("JUnit fail: Somthing is wrong with the Time construction");

	}
	
	@Test
	public void testCompare() throws ParseException{
		Date date1 = new Date();
		date1 = TimeFormater.parse(time1);
		Time Time1 = new Time(date1);
		Date date2 = new Date();
		date2 = TimeFormater.parse(time2);
		Time Time2 = new Time(date2);
		Date date3 = new Date();
		date3 = TimeFormater.parse(time3);
		Time Time3 = new Time(date3);
		if(!Time1.compare(Time2)) fail("JUnit fail: Somthing is wrong with the Time compare");
		if(Time2.compare(Time3)) fail("JUnit fail: Somthing is wrong with the Time compare");
		
	}
}
