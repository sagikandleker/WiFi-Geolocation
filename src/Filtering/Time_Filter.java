package Filtering;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Data_Setup.Frequency;
import Data_Setup.ID;
import Data_Setup.Mac;
import Data_Setup.Position;
import Data_Setup.SSID;
import Data_Setup.Signal;
import Data_Setup.Time;
import Data_Setup.Wifi;
import Main_App.Main;

public class Time_Filter {
	
	public static void timeFilter(String time_begin,String time_end) throws ParseException, IOException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date_start =  format.parse(time_begin);
        Date date_end =  format.parse(time_end);

 		ArrayList<Record_Filter> data = new ArrayList<Record_Filter>();
 		FileReader fr = new FileReader(Main.WigleWifi_file_Out);
 		BufferedReader br = new BufferedReader(fr);
 		String Line = br.readLine();
 		Line = br.readLine();
 		
 		while(Line != null) {
 			String[] arr = (Line.split(","));
 			Date temp= format.parse(arr[0]);
 			if(temp.after(date_start) && temp.before(date_end)) {
 				for (int i = 6; i < arr.length; i=i+4) {
 					
 				Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(arr[0]);
 				Position position = new Position(arr[4], arr[3], arr[2]);
 				Time time = new Time(date);
 				ID id = new ID(arr[i]);
 				Record_Filter record = new Record_Filter(time, position, id);
 				data.add(record);
 				
 				}
 			}
 			
 			Line = br.readLine();
 		}
 		
 		br.close();
 		
 		if(data.size() == 0) {
 			System.out.println("Time not found");
 		}
 		
 		else
 		{
 			Filter_2_KML.KML(data,"Time");
 		}
 	}
}
