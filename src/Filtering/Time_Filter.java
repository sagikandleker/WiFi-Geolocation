package Filtering;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import Data_Setup.Position;
import Data_Setup.SSID;
import Data_Setup.Time;
import Main_App.Write_2_CSV;

/**
 * Filtering by Begin time to End time.
 *
 */
public class Time_Filter {

	public static void timeFilter(String time_begin, String time_end) throws ParseException, IOException {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date_start =  format.parse(time_begin);
		Date date_end =  format.parse(time_end);

		for (int i = 0; i < Write_2_CSV.All_Data_List.size(); i++) {

			Date temp= new Date(Write_2_CSV.All_Data_List.get(i).getDate().getTime());
			if(temp.after(date_start) && temp.before(date_end)) {
				{

					Date d = new Date(Write_2_CSV.All_Data_List.get(i).getDate().getTime());
					Position position = Write_2_CSV.All_Data_List.get(i).getPosition();
					Time time = new Time(d);
					
					/**
					 * Loop to run inside the line.
					 */
					for (int k = 0; k < Write_2_CSV.All_Data_List.get(i).getWifiList().size(); k++) {

						SSID id =new SSID(Write_2_CSV.All_Data_List.get(i).getWifiList().get(k).getSsid());
						Record_Filter record = new Record_Filter(time, position, id);
						Filter.data.add(record);

					}
				}
			}	
		}
	}
}
