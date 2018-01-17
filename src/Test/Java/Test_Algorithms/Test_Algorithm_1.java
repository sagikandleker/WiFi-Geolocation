package Test_Algorithms;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Test;

import Algorithms.Mac_Hashmap;
import Data_Setup.Record_Pos_Wifi_Time;

public class Test_Algorithm_1 {
	
	public static HashMap<String,ArrayList<Record_Pos_Wifi_Time>> hash = new HashMap<String,ArrayList<Record_Pos_Wifi_Time>>();
	public static String mac1 = "14:ae:db:32:52:12";
	public static String mac2 = "00:27:19:e3:2d:fe";
	public static String mac3 = "a0:4f:d4:3b:e9:01";
	ArrayList<Record_Pos_Wifi_Time> rpwt = new ArrayList<Record_Pos_Wifi_Time>();
	
	@Test
	public final void testAnalyzeMAC() {
		hash.put(mac1, rpwt);
		hash.put(mac2, rpwt);
		hash.put(mac3, rpwt);
		
		ArrayList<String> namesOfKeys = new ArrayList<String>(Mac_Hashmap.hash.keySet());
		String key;
		for (int i = 0; i < namesOfKeys.size(); i++) {
 			key = namesOfKeys.get(i);
 			if(!(key.equalsIgnoreCase(mac1) || key.equalsIgnoreCase(mac2) || key.equalsIgnoreCase(mac3)))
 				fail("JUnit fail: Somthing is wrong with the testAnalyzeMAC equalsIgnoreCase");
		}
	
	}
}
