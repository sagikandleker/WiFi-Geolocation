package Main_App;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Data_Setup.Frequency;
import Data_Setup.ID;
import Data_Setup.Mac;
import Data_Setup.Position;
import Data_Setup.Record;
import Data_Setup.Record_Mac_Signal;
import Data_Setup.SSID;
import Data_Setup.Signal;
import Data_Setup.Time;
import Data_Setup.Wifi;

public class Read_From {

	private static Mac mac;
	private static Signal signal;
	private static SSID ssid;
	private static Frequency frequency;
	private static Position position;
	private static ID id;
	private static Wifi wifi;
	//TODO private static Time time;

	/**
	 * wigle_File read from CSV file all the data and copy it to ArrayList.
	 */
	public static void wigle_File(File file)throws IOException, ParseException {

		ArrayList<Record> wigle_data = new ArrayList<Record>();
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		String [] getmodel = line.split(",");
		id = new ID(getmodel[2].substring(6));
		
		line = br.readLine();
		line = br.readLine();

		while(line!=null) {
			String[] arr = (line.split(","));

			if(arr[10].equals("WIFI")) {
				mac = new Mac(arr[0]);
				ssid = new SSID(arr[1]);
				Date date  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(arr[3]);
				Time time = new Time(date);
				frequency = new Frequency(arr[4]);
				signal = new Signal(arr[5]);
				position = new Position(arr[6],arr[7],arr[8]);

				Wifi wifi = new Wifi(ssid, mac, frequency, signal);
				Record record = new Record(time, position);
				record.addWifi(wifi);
				record.setid(id);
				wigle_data.add(record);

				line = br.readLine();

			}
			else {
				line = br.readLine();
			}

		}

		br.close();
		Write_2_CSV.Build_ArrayList(wigle_data);
	}

	public static ArrayList<Record> comb_File(File file) throws IOException, ParseException {

		ArrayList<Record> comb_data = new ArrayList<Record>();
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();


		while(!line.isEmpty()) {
			String[] arr = (line.split(","));

			Date date  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(arr[0]);
			Time time = new Time(date);
			position = new Position(arr[2],arr[3],arr[4]);
			Record record = new Record(time, position);
			//TODO id to record.
			
			for (int i = 6; i < arr.length; i += 4) {
				if(!(arr[i+1].equals(" "))) {
					ssid = new SSID(arr[i]);
					mac = new Mac(arr[i+1]);
					frequency = new Frequency(arr[i+2]);
					signal = new Signal(arr[i+3]);
					wifi = new Wifi(ssid, mac, frequency, signal);
					record.addWifi(wifi);

				}
			}
			
			comb_data.add(record);
			line = br.readLine();
		}

		br.close();
		return comb_data;
	}

	public static ArrayList<ArrayList<Record_Mac_Signal>> nogps_File(File file) throws IOException {

		Record_Mac_Signal rms;
		ArrayList<ArrayList<Record_Mac_Signal>> nogps_data = new ArrayList<ArrayList<Record_Mac_Signal>>();

		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();

		while(line!=null) {

			String[] arr = (line.split(","));
			ArrayList<Record_Mac_Signal> row_data = new ArrayList<Record_Mac_Signal>();
			
			for (int m = 7; m < arr.length; m+=4) {

				mac = new Mac(arr[m]);
				signal = new Signal(arr[m+2]);
				rms = new Record_Mac_Signal(mac, signal);
				row_data.add(rms);

			}

			nogps_data.add(row_data);
			line = br.readLine();

		}
		
		br.close();
		return nogps_data;
	}
}