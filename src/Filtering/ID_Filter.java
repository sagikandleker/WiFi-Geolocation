package Filtering;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import Data_Setup.Position;
import Data_Setup.SSID;
import Data_Setup.Time;
import Main_App.Write_2_CSV;;

/**
 * Filtering by ID Device.
 *
 */
public class ID_Filter {

	public static void idFilter(String iddevice) throws IOException, ParseException {

		for (int i = 0; i < Write_2_CSV.All_Data_List.size(); i++) {

			if(Write_2_CSV.All_Data_List.get(i).getid().equalsIgnoreCase(iddevice)) {

				Date d = new Date(Write_2_CSV.All_Data_List.get(i).getDate().getTime());
				Position position = Write_2_CSV.All_Data_List.get(i).getPosition();
				Time time = new Time(d);
				
				/**
				 * Loop to run inside the line.
				 */
				for (int k = 0; k < Write_2_CSV.All_Data_List.get(i).getWifiList().size(); k++) {

					SSID ssid = new SSID(Write_2_CSV.All_Data_List.get(i).getWifiList().get(k).getSsid());
					Record_Filter record = new Record_Filter(time, position, ssid);
					Filter.data.add(record);
				}
			}
		}
	}

}
