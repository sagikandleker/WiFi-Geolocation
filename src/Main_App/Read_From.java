package Main_App;

import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Algorithms.Mac_Hashmap;
import Data_Setup.Frequency;
import Data_Setup.Mac;
import Data_Setup.Position;
import Data_Setup.Record;
import Data_Setup.SSID;
import Data_Setup.Signal;
import Data_Setup.Time;
import Data_Setup.Wifi;

public class Read_From {
	//public static final ArrayList<Record> data = new ArrayList<Record>();

	public static ArrayList<Record> CSV_File(String file) throws IOException, ParseException {

		Mac mac;
		Signal signal;
		SSID ssid;
		Frequency frequency;
		Position position;
		Wifi wifi;

		ArrayList<Record> data = new ArrayList<Record>();
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();


		while(line!=null) {
			String[] arr = (line.split(","));
			
			if(arr[1].startsWith("model")) {
				
				Date date  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(arr[0]);
				Time time = new Time(date);
				position = new Position(Double.parseDouble(arr[2]),Double.parseDouble(arr[3]),Double.parseDouble(arr[4]));
				Record record = new Record(time, position);
				//TODO id to record.
				for (int i = 6; i < arr.length; i += 4) {
					if(!(arr[i+1].equals(" "))) {
						ssid = new SSID(arr[i]);
						mac = new Mac(arr[i+1]);
						frequency = new Frequency(Integer.parseInt(arr[i+2]));
						signal = new Signal(Double.parseDouble(arr[i+3]));
						wifi = new Wifi(ssid, mac, frequency, signal);
						record.addWifi(wifi);
					}

					data.add(record);
					line = br.readLine();

				}	
				
			}
		}
		//System.out.println(data);
		br.close();
		return data;

	}
}
