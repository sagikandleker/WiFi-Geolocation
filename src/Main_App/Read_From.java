package Main_App;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import Data_Setup.Frequency;
import Data_Setup.Mac;
import Data_Setup.Position;
import Data_Setup.Record;
import Data_Setup.Record_Mac_Signal;
import Data_Setup.SSID;
import Data_Setup.Signal;
import Data_Setup.Time;
import Data_Setup.Wifi;

public class Read_From {
	//public static final ArrayList<Record> data = new ArrayList<Record>();

	public static ArrayList<Record> comb_File(String file) throws IOException, ParseException {

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
			System.out.println(Arrays.toString(arr));
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
		System.out.println(data);
		br.close();
		return data;
	}

	public static ArrayList<ArrayList<Record_Mac_Signal>> nogps_File(String file) throws IOException {

		Mac mac;
		Signal signal;
		Record_Mac_Signal rms;
		ArrayList<ArrayList<Record_Mac_Signal>> data = new ArrayList<ArrayList<Record_Mac_Signal>>();
		
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();

		while(line!=null) {

			String[] arr = (line.split(","));
			ArrayList<Record_Mac_Signal> line_data = new ArrayList<Record_Mac_Signal>();
			for (int m = 7; m < arr.length; m+=4) {

					mac = new Mac(arr[m]);
					signal = new Signal(arr[m+2]);
					rms = new Record_Mac_Signal(mac, signal);
					line_data.add(rms);
				
			}
			
			data.add(line_data);
			line = br.readLine();
			
		}
		br.close();
		return data;

	}
}