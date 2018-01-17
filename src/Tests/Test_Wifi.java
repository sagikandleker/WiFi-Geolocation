package Tests;

import static org.junit.Assert.*;

import org.junit.Test;
import Data_Setup.Wifi;

public class Test_Wifi {
		
	public final static String ssid = "Bezeq";
	public final static String mac = "6a:12:f5:f9:5e:71";
	public final static int signal = -60;
	public final static int frequency = 10;
	
	@SuppressWarnings("unused")
	@Test
	public void testWificonstructor(){
	Wifi new_Wifi = new Wifi(ssid, mac, signal, frequency);
	if (new_Wifi == null) {
			fail("JUnit fail: Somthing is wrong with the Wifi construction");
		}	
	}		
}
