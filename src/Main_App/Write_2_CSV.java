package Main_App;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import Data_Setup.Record;


/**
 * Write_2_CSV Build sorted CSV file.
 */

public class Write_2_CSV {

	public static final ArrayList<Record> All_Data_List = new ArrayList<Record>();

	/**
	 *  Write_Headers Create CSV file with Headers.
	 */
	public static void Write_Headers() throws IOException{
		String[] titles_List = {"Time","ID","Lat","Lon","Alt","#WiFi networks","SSID","MAC","Frequency","Signal"};
		FileWriter file = new FileWriter(Main.WigleWifi_file_Out);

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

		All_Data_List.addAll(sorted_data_list);
		sorted_data_list.clear();
		data_list.clear();

	}

	public static void Write() throws IOException {

		StringBuilder stringBuilder = new StringBuilder();
		FileWriter fw = new FileWriter(Main.WigleWifi_file_Out, true);
		for (int i = 0; i < All_Data_List.size(); i++) {
			stringBuilder.append("\n");
			stringBuilder.append((All_Data_List.get(i).toString().replace("[", "").replace("]", "")));	
		}

		fw.write(stringBuilder.toString());
		fw.close();

	}
}
