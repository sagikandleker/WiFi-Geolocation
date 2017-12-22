package Main_App;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import Data_Setup.Position;
import Data_Setup.Record;
import Data_Setup.Record_Pos_Signal;
import Data_Setup.Signal;
import Data_Setup.Time;
import Data_Setup.Wifi;

/**
 * Files_2_CSV Build sorted CSV file.
 */

public class Files_2_CSV {
	public static final ArrayList<Record> All_Data_List = new ArrayList<Record>();
	public static HashMap<String,ArrayList<Record_Pos_Signal>> hash = new HashMap<String,ArrayList<Record_Pos_Signal>>();
	/**
	 *  getFiles Call to Write_Headers function and check all the CSV files in the folder,
	 * and sending them to Analyze function.
	 */
	public static void getFiles() throws IOException, ParseException {
		Write_Headers();
		File folder = new File(Main.path_In);
		String[] files_Names = folder.list();

		int counter = 0;
		for(int i = 0; i < files_Names.length; i++) {
			if(files_Names[i].startsWith("WigleWifi") && files_Names[i].endsWith(".csv")) {
				Analayze(Main.path_In+"/"+files_Names[i]);
				counter++;
			}	
		}	

		System.out.println(counter + " CSV files founded ["+Main.path_In+"]");
		if(counter != 0) {
			System.out.println("1 CSV has been created ["+Main.file_Out+"]\n");


		}

	}

	/**
	 * Analyze read from CSV file all the data and copy it to ArrayList.
	 */
	private static void Analayze(String file)throws IOException, ParseException {


		String mac,ssid;
		int signal, frequency;
		double lat,lon,alt;



		ArrayList<Record> data_list = new ArrayList<Record>();
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		String [] getmodel = line.split(",");
		String id = getmodel[2].substring(6);
		line = br.readLine();
		line = br.readLine();

		while(line!=null) {
			String[] arr = (line.split(","));
			
			if(arr[10].equals("WIFI")) {
				mac = arr[0];
				ssid = arr[1];
				Date date  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(arr[3]);
				frequency = Integer.parseInt(arr[4]);
				signal = Integer.parseInt(arr[5]);
				lat = Double.parseDouble(arr[6]);
				lon = Double.parseDouble(arr[7]);
				alt = Double.parseDouble(arr[8]);

				Position pos = new Position(alt, lon, lat);
				Wifi wifi = new Wifi(ssid, mac, frequency, signal);
				Time time = new Time(date);
				Record record = new Record(time, pos);
				record.addWifi(wifi);
				record.setid(id);
				data_list.add(record);

				line = br.readLine();

			}
			else {
				line = br.readLine();
			}

		}

		br.close();
		Write_2_CSV(data_list);
	}

	/**
	 *  Write_Headers Create CSV file with Headers.
	 */
	private static void Write_Headers() throws IOException{
		String[] titles_List = {"Time","ID","Lat","Lon","Alt","#WiFi networks","SSID","MAC","Frequency","Signal"};
		FileWriter file = new FileWriter(Main.file_Out);

		for (int i = 0; i <= 5; i++) {
			file.write(titles_List[i]+",");
		}

		for (int i = 1; i <= 10; i++) {
			for (int j = 6; j < titles_List.length; j++) {
				file.write(titles_List[j]+i+",");
			}
		}

		file.close();
	}

	/**
	 * Write_2_CSV Get the ArrayList from the Analyze function and copy the data from it in a sorted way.
	 * Write to the CSV file with Headers the new sorted ArrayList.
	 */
	private static void Write_2_CSV(ArrayList<Record> data_list) throws IOException{

		StringBuilder stringBuilder = new StringBuilder();
		ArrayList<Record> sorted_data_list = new ArrayList<Record>();
		FileWriter fw = new FileWriter(Main.file_Out, true);

		for(int i = 0; i < data_list.size()-1; i++) {

			if(data_list.get(i).compare(data_list.get(i+1)) == true) {
				data_list.get(i+1).mergeWifiList(data_list.get(i).getWifiList());
			}
			else {		
				sorted_data_list.add(data_list.get(i));
			}			
		}


		for (int i = 0; i < sorted_data_list.size(); i++) {

			sorted_data_list.get(i).setWifinetworks(sorted_data_list.get(i).getWifiList().size());

		}


		for (int i = 0; i < sorted_data_list.size(); i++) {
			stringBuilder.append("\n");
			stringBuilder.append((sorted_data_list.get(i).toString().replace("[", "").replace("]", "")));	
		}

		fw.write(stringBuilder.toString());
		fw.close();
		All_Data_List.addAll(sorted_data_list);

		sorted_data_list.clear();
		data_list.clear();

	}

	public static void Hash_Add() {
		
		
		Record_Pos_Signal pos_signal = new Record_Pos_Signal();
		
		String mac;
		int signal;
		Signal sig;
		String ssid;
		Position pos = new Position();

		for (int i = 0; i < All_Data_List.size(); i++) {
			pos=All_Data_List.get(i).getPosition();
			for (int k = 0; k < All_Data_List.get(i).getWifiList().size(); k++) {
				signal = All_Data_List.get(i).getWifiList().get(k).getSignal();
				mac = All_Data_List.get(i).getWifiList().get(k).getMac();
				sig = new Signal(signal);
				ssid = All_Data_List.get(i).getWifiList().get(k).getSsid();
				pos_signal = new Record_Pos_Signal(pos,sig);

				ArrayList<Record_Pos_Signal> rps = new ArrayList<Record_Pos_Signal>();

				if(hash.containsKey(mac) && !hash.get(mac).contains(pos_signal)) {
					hash.get(mac).add(pos_signal);
				}

				else
				{
					rps.add(pos_signal);
					hash.put(mac, rps);
				}

			}
			
		}
		String ma = "00:1a:dd:e3:06:e4";
		System.out.println(hash.get(ma).get(0).getSignal());
	}
}