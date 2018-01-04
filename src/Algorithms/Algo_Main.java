package Algorithms;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import Data_Setup.Position;
import Data_Setup.Record_Mac_Signal;
import GUI.GUI_Wrapper;
import Main_App.Read_From;
import Main_App.Write_2_CSV;

public class Algo_Main {

	public static void ChooseAlgo1() throws IOException, ParseException {

		Mac_Hashmap.Build_Hash(Write_2_CSV.All_Data_List, "Algo1");
		Algorithm_1.Better();
		Algorithm_1.Write(Algorithm_1.rpwt);
	}

	public static Position algo1_Mac(String mac) throws IOException {
		Mac_Hashmap.Build_Hash(Write_2_CSV.All_Data_List, "Algo1");
		Algorithm_1.Better();
		for (int i = 0; i < Algorithm_1.rpwt.size(); i++) {

			if(Algorithm_1.rpwt.get(i).getWifi().getMac().getMac().equalsIgnoreCase(mac)) {
				return Algorithm_1.rpwt.get(i).getPosition();
			}
		}
		return new Position();
	}

	public static void ChooseAlgo2() throws IOException, ParseException {

		Algorithm_2.no_gps_lines(Mac_Hashmap.Build_Hash((Read_From.comb_File(GUI_Wrapper.combfile,"noHeaders")), "Algo2"),Read_From.nogps_File(GUI_Wrapper.nogpsfile));

	}

	public static void algo2_all(ArrayList<Record_Mac_Signal> mac_signal) throws IOException, ParseException {

		Algorithm_2.Algo2((Mac_Hashmap.Build_Hash(Write_2_CSV.All_Data_List, "Algo2")),mac_signal);

	}
}