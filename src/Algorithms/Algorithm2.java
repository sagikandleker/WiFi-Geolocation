package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;

import Data_Setup.Record_Mac_Signal;
import Data_Setup.Record_Pos_Wifi_Time;

public class Algorithm2 {
	
	public static void Algo2(HashMap<String,ArrayList<Record_Pos_Wifi_Time>> algo2_Hash) {
		
		System.out.println("This the HashMap with gps");
		System.out.println(algo2_Hash);
		
	}
	
	public static void Algo2_nogps(ArrayList<ArrayList<Record_Mac_Signal>> data) {
		
		System.out.println("This the nogps ArrayList");
		System.out.println(data);
		
	}

}
