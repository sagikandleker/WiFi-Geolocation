package Algo_Search;
import java.io.IOException;
import java.util.ArrayList;

import Data_Setup.Position;
import Data_Setup.Record_PAS;
import Main_App.Files_2_CSV;

public class Algorithm1 {

	public static void Naive(String mac) throws IOException {

		int max_Signal = 0  ;
		Position pos = new Position();
		boolean found_Flag = false;
		int count = 0;

		for (int i = 0; i < Files_2_CSV.All_Data_List.size(); i++) {
			for (int j = 0; j < Files_2_CSV.All_Data_List.get(i).getWifiList().size(); j++) {

				if(mac.equals(Files_2_CSV.All_Data_List.get(i).getWifiList().get(j).getMac())) {
					found_Flag = true;

					if(count == 0) {
						pos = new Position(Files_2_CSV.All_Data_List.get(i).getPosition());
						max_Signal = Files_2_CSV.All_Data_List.get(i).getWifiList().get(j).getSignal();
						count++;
					}

					if(Files_2_CSV.All_Data_List.get(i).getWifiList().get(j).getSignal() > max_Signal) {

						max_Signal = Files_2_CSV.All_Data_List.get(i).getWifiList().get(j).getSignal();
						pos = new Position(Files_2_CSV.All_Data_List.get(i).getPosition()); 
					}

				}
			}
		}

		if(found_Flag == true) {
			System.out.println("The best option Position for ["+mac+"] is ["+pos+"]");
		}

		else {
			System.out.println("The mac ["+mac+"] not founded");
		}

	}

	public static void Better(String mac) throws IOException {

		ArrayList<Record_PAS> ara = new ArrayList<Record_PAS>();

		for (int i = 0; i < Files_2_CSV.All_Data_List.size(); i++) {
			for (int j = 0; j < Files_2_CSV.All_Data_List.get(i).getWifiList().size(); j++) {

				if(mac.equals(Files_2_CSV.All_Data_List.get(i).getWifiList().get(j).getMac())) {
					
					//ara.add(Files_2_CSV.All_Data_List.get(i).getPosition());
				}
				
			}
		}




	}

}
