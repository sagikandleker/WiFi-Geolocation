package Memory;

import java.util.ArrayList;

import Data_Setup.Position;
import Data_Setup.Record;
import Data_Setup.Record_Pos_Wifi_Time;

public class Data_Structures {

	/**
	 * All_Data_List this the ArrayList with all data.
	 */
	public static final ArrayList<Record> All_Data = new ArrayList<Record>();
	public static final ArrayList<Record> Sql_Data = new ArrayList<Record>();
	public static ArrayList<Record_Pos_Wifi_Time> final_algo1_data = new ArrayList<Record_Pos_Wifi_Time>();
	public static ArrayList<Position> final_algo2_data  = new ArrayList<Position>();
	
	public static boolean Sql_flag = false;

	public static void merged_Data(){

		
		for (int i = 0; i < All_Data.size(); i++) {
			Sql_Data.add(All_Data.get(i));
		}
	}
}