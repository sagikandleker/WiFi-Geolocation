package Test_Data_Setup;

import static org.junit.Assert.*;

import org.junit.Test;

import Data_Setup.Mac;
import Data_Setup.Wifi;

public class Test_Mac {
	
	public static Mac mac1 = new Mac("14:ae:db:32:52:12");
	public static Mac mac2 =new Mac("00:27:19:e3:2d:fe");
	public static Mac mac3 =new Mac("00:27:19:e3:2d:fe");
	public static String mac4 = "a0:4f:d4:3b:e9:01";

	@SuppressWarnings("unused")
	@Test
	public void testMacString() {
		
		Mac new_Mac = new Mac(mac4);
		if (new_Mac == null) {
				fail("JUnit fail: Somthing is wrong with the Mac construction");
			}
	}

	@Test
	public void testCompare() {
		
		if(mac1.compare(mac2)==true) fail("JUnit fail: Somthing is wrong with the Mac Compare");
		if(mac2.compare(mac3)==false) fail("JUnit fail: Somthing is wrong with the Mac Compare");

	}

}
