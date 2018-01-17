package Tests;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import Data_Setup.Position;
import Data_Setup.Record;
import Data_Setup.Time;

public class Test_Record {
	
	public final static String time1 = "27/10/17 20:00";
	public static final double alt1 = 39.01806582;
	public static final double lon1 = 34.80988156;
	public static final double lat1 = 32.16766122;
	public static final Position p = new Position(alt1, lon1, lat1);
	
	DateFormat TimeFormater = new SimpleDateFormat("yy/MM/dd HH:mm");
	
	@Test
	public void testRecordTimePosition() throws ParseException {
		
		Date date = new Date();
		date = TimeFormater.parse(time1);
		Time t = new Time(date);
		
		Record r = new Record(t,p);
		
		if((r.getDate() == null || r.getPosition() == null)) fail("JUnit fail: Somthing is wrong with the Record-Time-Position construction");
		
	}
}
