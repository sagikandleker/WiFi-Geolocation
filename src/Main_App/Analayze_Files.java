package Main_App;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Data_Setup.Position;
import Data_Setup.Record;
import Data_Setup.Time;
import Data_Setup.Wifi;

public class Analayze_Files {

	/**
	 *  getFiles Call to Write_Headers function and check all the CSV files in the folder,
	 * and sending them to Analyze function.
	 */
	public static void getFiles() throws IOException, ParseException {
		Write_2_CSV.Write_Headers();
		File folder = new File(Main.path_In);
		String[] files_Names = folder.list();

		int counter = 0;
		for(int i = 0; i < files_Names.length; i++) {
			if(files_Names[i].startsWith("WigleWifi") && files_Names[i].endsWith(".csv")) {
				Analayze(Main.path_In+"/"+files_Names[i]);
				counter++;
			}	
		}	
		Write_2_CSV.Write();
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
		Write_2_CSV.Build_ArrayList(data_list);
	}
}
