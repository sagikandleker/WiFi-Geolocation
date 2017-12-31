package Filtering;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Data_Setup.ID;
import Data_Setup.Position;
import Data_Setup.Time;
import Main_App.Main;;


public class ID_Filter {

	public static void idFilter(String ssid) throws IOException, ParseException {

		ArrayList<Record_Filter> data = new ArrayList<Record_Filter>();
		FileReader fr = new FileReader(Main.WigleWifi_file_Out);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		line = br.readLine();
		
		while(line != null) {

			String[] arr = (line.split(","));
			if(arr[1].equalsIgnoreCase(ssid)) {
				for (int i = 6; i < arr.length; i=i+4) {
					
					Date date  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(arr[0]);
					Position position = new Position(arr[4], arr[3], arr[2]);
					Time time = new Time(date);
					ID id = new ID(arr[i]);
					Record_Filter record = new Record_Filter(time, position, id);
					data.add(record);
				}
			}

			line = br.readLine();
		}

		br.close();

		if(data.size() == 0) {

			System.out.println("id not found");
		}
		else {

			Filter_2_KML.KML(data,"ID");
		}
	}

}
