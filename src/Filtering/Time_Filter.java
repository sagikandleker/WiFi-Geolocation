package Filtering;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Data_Setup.ID;
import Data_Setup.Position;
import Data_Setup.Time;
import Main_App.Main;

public class Time_Filter {

	public static void timefilter(String time_begin,String time_end) throws ParseException, IOException
	{
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date_start =  format.parse(time_begin);
        Date date_end =  format.parse(time_end);
        double lat,lon,alt;
 		ArrayList<Record_Filter> data_list = new ArrayList<Record_Filter>();
 		FileReader fr = new FileReader(Main.file_Out);
 		BufferedReader br = new BufferedReader(fr);
 		String Line = br.readLine();
 		Line = br.readLine();
 		int count=0;
 		while(Line != null) 
 		{
 			String[] arr = (Line.split(","));
 			Date temp= format.parse(arr[0]);
 			if(temp.after(date_start) && temp.before(date_end))
 			{
 				count++;
 				for (int i = 6; i < arr.length; i=i+4) 
 				{
 				Date date  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(arr[0]);
 				lat = Double.parseDouble(arr[2]);
 				lon = Double.parseDouble(arr[3]);
 				alt = Double.parseDouble(arr[4]);
 				Position pos = new Position(alt, lon, lat);
 				Time time = new Time(date);
 				ID id=new ID(arr[i]);
 				Record_Filter record = new Record_Filter(time, pos,id);
 				data_list.add(record);
 				}
 			}
 			
 			Line = br.readLine();
 		}
 		
 		br.close();
 		if(count==0)System.out.println("Time not found");
 		else
 		{
 			Filter_2_KML.KML(data_list,"Time");
 		}
 	}
}
