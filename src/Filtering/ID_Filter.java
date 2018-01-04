package Filtering;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import Data_Setup.ID;
import Data_Setup.Position;
import Data_Setup.SSID;
import Data_Setup.Time;
import Main_App.Write_2_CSV;;


public class ID_Filter {

	public static void idFilter(String iddevice, String file) throws IOException, ParseException {
		DateFormat TimeFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ArrayList<Record_Filter> data = new ArrayList<Record_Filter>();
	
	for (int i = 0; i < Write_2_CSV.All_Data_List.size(); i++) {
		
			if(Write_2_CSV.All_Data_List.get(i).getid().equalsIgnoreCase(iddevice)) {
				
				    //String date = TimeFormater.format(Write_2_CSV.All_Data_List.get(i).getDate().getTime());
					Date d = new Date(Write_2_CSV.All_Data_List.get(i).getDate().getTime());
				    Position position = Write_2_CSV.All_Data_List.get(i).getPosition();
					Time time = new Time(d);
					 for (int k = 0; k < Write_2_CSV.All_Data_List.get(i).getWifiList().size(); k++) {
						
						 SSID ssid = new SSID(Write_2_CSV.All_Data_List.get(i).getWifiList().get(k).getSsid());
						 Record_Filter record = new Record_Filter(time, position, ssid);
						 data.add(record);
					 }
			}

		}

	

		
		
			Filter_2_KML.KML(data,file);
		
	}

}
