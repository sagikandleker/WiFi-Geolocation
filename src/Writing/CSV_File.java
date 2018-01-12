package Writing;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Data_Setup.Position;
import Data_Setup.Record;
import Data_Setup.Record_Pos_Wifi_Time;
import GUI.GUI_Wrapper;
import db.Database;


/**
 * This class building ArrayList with the All data and sorting them.
 * Additionally, Write the sorted data to CSV File.
 */

public class CSV_File {


	/*public static void clearData() {
		Database.All_Data.clear();
	}*/

	/**
	 *  Write_Headers Create CSV file with Headers.
	 */
	public static void Write_Headers(String savefile) throws IOException{
		String[] titles_List = {"Time","ID","Lat","Lon","Alt","#WiFi networks","SSID","MAC","Frequency","Signal"};
		FileWriter file = new FileWriter(savefile, true);

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
	public static void Build_ArrayList(ArrayList<Record> data_list) throws IOException{


		ArrayList<Record> sorted_data_list = new ArrayList<Record>();


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

		Database.All_Data.addAll(sorted_data_list);
		sorted_data_list.clear();
		data_list.clear();

	}

	/**
	 * Write the sorted data to file.
	 * @param savefile name of file to save.
	 * @throws IOException
	 */
	public static void write(String savefile) throws IOException {
		Writing.CSV_File.Write_Headers(savefile);
		StringBuilder stringBuilder = new StringBuilder();
		FileWriter fw = new FileWriter(savefile, true);
		for (int i = 0; i < Database.All_Data.size(); i++) {
			stringBuilder.append("\n");
			stringBuilder.append((Database.All_Data.get(i).toString().replace("[", "").replace("]", "")));	
		}

		fw.write(stringBuilder.toString());
		fw.close();

	}

	/**
 	 * Writing the exact Position to CSV File for each MAC.
 	 * @throws IOException
 	 */
	public static void write_Algo1(ArrayList<Record_Pos_Wifi_Time> final_rpwt_array) throws IOException {
		
		StringBuilder stringBuilder = new StringBuilder();
 		FileWriter fw = new FileWriter(GUI_Wrapper.algorithm1+".csv");
 		String titles_list = "#ID"+","+"MAC"+","+"SSID"+","+"Frequency"+","+"Signal"+","+"Alt"+","+"Lon"+"," +"Lat"+","+"Time";
 		stringBuilder.append(titles_list);
 		for (int i = 0; i < final_rpwt_array.size(); i++) {
 			final_rpwt_array.get(i).setLine(i+1);
 			stringBuilder.append("\n");
 			stringBuilder.append((final_rpwt_array.get(i).toString().replace("[", "").replace("]", "")));	
		}
 
 		fw.write(stringBuilder.toString());
 		fw.close();	
	}
	
	
	/**
	 * Writing the Positions for each line from the "nogps" file after the calculation to CSV file.
	 * @throws IOException
	 */
	public static void write_Algo2(ArrayList<Position> final_pos_array) throws IOException {

		StringBuilder stringBuilder = new StringBuilder();
		FileWriter fw = new FileWriter(GUI_Wrapper.algorithm2+".csv");
		String t = "Alt"+","+"Lon"+","+"Lat";
		stringBuilder.append(t);
		for (int i = 0; i < final_pos_array.size(); i++) {
			stringBuilder.append("\n");
			stringBuilder.append((final_pos_array.get(i).toString().replace("[", "").replace("]", "")));	
		}

		fw.write(stringBuilder.toString());
		fw.close();
		final_pos_array.clear();
	}
	
	
	
}
