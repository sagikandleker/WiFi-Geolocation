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

import Data_sets.Position;
import Data_sets.Record;
import Data_sets.Time;
import Data_sets.Wifi;

/**
 * Files_2_CSV Build sorted CSV@ file.
 */

public class Files_2_CSV {

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
			if(files_Names[i].endsWith(".csv")) {
				Analayze(Main.path_In+"/"+files_Names[i]);
				counter++;
			}	
		}	
		
		System.out.println(counter + " CSV Files Founded");
		if(counter != 0) {
			System.out.println("CSV has been Created");
			Filter.Main_Filter.Choosefilter();
		}
		
	}

	/**
	 * Analyze read from CSV file all the data and copy it to ArrayList.
	 */
	public static void Analayze(String file)throws IOException, ParseException {

		
		String mac,ssid;
		int signal, frequency;
		double lat,lon,alt;
		
		ArrayList<Record> data_list = new ArrayList<Record>();
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String Line = br.readLine();
		String [] getmodel=Line.split(",");
		String id=getmodel[2].substring(6);
		Line = br.readLine();
		Line = br.readLine();

		while(Line!=null) {
			String[] arr = (Line.split(","));

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
			
			Line = br.readLine();		
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
	public static void Write_2_CSV(ArrayList<Record> data_list) throws IOException{
		
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
		sorted_data_list.clear();
		data_list.clear();
	}
}