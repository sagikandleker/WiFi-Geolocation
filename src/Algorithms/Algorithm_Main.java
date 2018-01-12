
package Algorithms;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import Data_Setup.Position;
import Data_Setup.Record_Mac_Signal;
import GUI.GUI_Wrapper;
import Writing.CSV_File;
import db.Database;

public class Algorithm_Main {

	public static void ChooseAlgo1() throws IOException, ParseException {

		Algorithm_1.AnalyzeMAC();
		CSV_File.write_Algo1(Database.final_algo1_data);
	}

	public static Position algo1_Mac(String mac) throws IOException {
		Mac_Hashmap.Build_Hash(Database.All_Data, "Algo1");
		Algorithm_1.AnalyzeMAC();
		for (int i = 0; i < Database.final_algo1_data.size(); i++) {

			if(Database.final_algo1_data.get(i).getWifi().getMac().getMac().equalsIgnoreCase(mac)) {
				return Database.final_algo1_data.get(i).getPosition();
			}
		}
		return new Position();
	}

	public static void ChooseAlgo2() throws IOException, ParseException {

		Algorithm_2.no_gps_lines(Mac_Hashmap.Build_Hash((Reading.Comb_File.read(GUI_Wrapper.combfile,"noHeaders")), "Algo2"),Reading.Nogps_File.read(GUI_Wrapper.nogpsfile));

	}

	public static void algo2_all(ArrayList<Record_Mac_Signal> mac_signal) throws IOException, ParseException {

		Algorithm_2.Algo2((Mac_Hashmap.Build_Hash(Database.All_Data, "Algo2")),mac_signal);

	}

}
