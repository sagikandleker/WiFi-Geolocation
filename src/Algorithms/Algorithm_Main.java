
package Algorithms;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import Data_Setup.Position;
import Data_Setup.Record_Mac_Signal;
import GUI.GUI_Wrapper;
import Memory.Data_Structures;
import Writing.CSV_File;

public class Algorithm_Main {

	public static void ChooseAlgo1() throws IOException, ParseException {

		Algorithm_1.AnalyzeMAC();
		CSV_File.write_Algo1(Data_Structures.final_algo1_data);
	}

	public static Position algo1_Mac(String mac) throws IOException {
		
		if(Data_Structures.Sql_flag == true) {
			
			Mac_Hashmap.Build_Hash(Data_Structures.Sql_Data, "Algo1");
		}
		else {
		Mac_Hashmap.Build_Hash(Data_Structures.All_Data, "Algo1");
		}
		
		Algorithm_1.AnalyzeMAC();
		for (int i = 0; i < Data_Structures.final_algo1_data.size(); i++) {

			if(Data_Structures.final_algo1_data.get(i).getWifi().getMac().getMac().equalsIgnoreCase(mac)) {
				return Data_Structures.final_algo1_data.get(i).getPosition();
			}
		}
		return new Position();
	}

	public static void ChooseAlgo2() throws IOException, ParseException {

		Algorithm_2.no_gps_lines(Mac_Hashmap.Build_Hash((Reading.Comb_File.read(GUI_Wrapper.combfile,"noHeaders")), "Algo2"),Reading.Nogps_File.read(GUI_Wrapper.nogpsfile));

	}

	public static void algo2_all(ArrayList<Record_Mac_Signal> mac_signal) throws IOException, ParseException {
		if(Data_Structures.Sql_flag == true) {
			
		Algorithm_2.Algo2((Mac_Hashmap.Build_Hash(Data_Structures.Sql_Data, "Algo2")),mac_signal);
		}
		else {
			Algorithm_2.Algo2((Mac_Hashmap.Build_Hash(Data_Structures.All_Data, "Algo2")),mac_signal);
		}
		

	}

}
