package Algo_Search;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

import Data_Setup.Position;
import Data_Setup.Record_PAS;
import Data_Setup.Record_Pos_Signal;
import Data_Setup.Signal;
import Main_App.Files_2_CSV;

public class Algorithm1 {

	/*public static void Better(String mac) throws IOException {

		ArrayList<Record_PAS> ara = new ArrayList<Record_PAS>();
		Position pos = new Position();
		Signal signal = new Signal();
		Record_PAS record = new Record_PAS();
		boolean found_flag=false;
		for (int i = 0; i < Files_2_CSV.All_Data_List.size(); i++) {
			for (int j = 0; j < Files_2_CSV.All_Data_List.get(i).getWifiList().size(); j++) {
				if(mac.equals(Files_2_CSV.All_Data_List.get(i).getWifiList().get(j).getMac())) {
					found_flag=true;
					signal = new Signal(Files_2_CSV.All_Data_List.get(i).getWifiList().get(j).getSignal());
					pos = new Position(Files_2_CSV.All_Data_List.get(i).getPosition());
					record = new Record_PAS(pos, signal);
					ara.add(record);
				}
			}
		}
		if(found_flag == true)
		{
			if(ara.size() == 1) {
				System.out.println(ara.get(0));
			}
			
			ArrayList<Record_PAS> sorted = new ArrayList<Record_PAS>();
			sorted = Record_PAS.sort_Signal_Power(ara);
			Algo1(sorted);
		}
		else
		{
			System.out.println("mac not found");
		}

	}*/
	public static void Better2(String mac) {
		
		if(Files_2_CSV.hash.containsKey(mac)) {
			System.out.println(Files_2_CSV.hash.get(mac));
			System.out.println(Record_Pos_Signal.sort_Signal_Power(Files_2_CSV.hash.get(mac)));
			Algo1(Record_Pos_Signal.sort_Signal_Power(Files_2_CSV.hash.get(mac)));
			
		}
		
	}

	public static void Algo1(ArrayList<Record_Pos_Signal> three_pos) {
		Algo_Data all_parameters = new Algo_Data();
		Record_Pos_Signal pos = new Record_Pos_Signal();

		if(three_pos.size() == 2) {

			all_parameters.setWeight1(((1/Math.pow((three_pos.get(0).getSignal().cast()),2.0))));
			all_parameters.setWlat1(three_pos.get(0).getPosition().getLat()*(all_parameters.getWeight1()));
			all_parameters.setWlon1(three_pos.get(0).getPosition().getLon()*all_parameters.getWeight1());
			all_parameters.setWalt1(three_pos.get(0).getPosition().getAlt()*all_parameters.getWeight1());

			all_parameters.setWeight2(1/Math.pow((three_pos.get(1).getSignal().cast()),2.0));
			all_parameters.setWlat2(three_pos.get(1).getPosition().getLat()*all_parameters.getWeight2());
			all_parameters.setWlon2(three_pos.get(1).getPosition().getLon()*all_parameters.getWeight2());
			all_parameters.setWalt2(three_pos.get(1).getPosition().getAlt()*all_parameters.getWeight2());

			all_parameters.setWeightsum();
			all_parameters.setWlatsum();
			all_parameters.setWlonsum();
			all_parameters.setWaltsum();

			pos.position.setLat(all_parameters.getWlatsum()/all_parameters.getWeightsum());
			pos.position.setLon(all_parameters.getWlonsum()/all_parameters.getWeightsum());
			pos.position.setAlt(all_parameters.getWaltsum()/all_parameters.getWeightsum());
			pos.signal.setSignal((three_pos.get(0).signal.signal));
			System.out.println(pos);
		}
		else if(three_pos.size() == 3) {

			all_parameters.setWeight1(((1/Math.pow((three_pos.get(0).getSignal().cast()),2.0))));
			all_parameters.setWlat1((three_pos.get(0).getPosition().getLat())*(all_parameters.getWeight1()));
			all_parameters.setWlon1((three_pos.get(0).getPosition().getLon())*(all_parameters.getWeight1()));
			all_parameters.setWalt1((three_pos.get(0).getPosition().getAlt())*(all_parameters.getWeight1()));

			all_parameters.setWeight2(1/Math.pow((three_pos.get(1).getSignal().cast()),2.0));
			all_parameters.setWlat2((three_pos.get(1).getPosition().getLat())*(all_parameters.getWeight2()));
			all_parameters.setWlon2((three_pos.get(1).getPosition().getLon())*(all_parameters.getWeight2()));
			all_parameters.setWalt2((three_pos.get(1).getPosition().getAlt())*(all_parameters.getWeight2()));

			all_parameters.setWeight3(1/Math.pow((three_pos.get(2).getSignal().cast()),2.0));
			all_parameters.setWlat3((three_pos.get(2).getPosition().getLat())*(all_parameters.getWeight3()));
			all_parameters.setWlon3((three_pos.get(2).getPosition().getLon())*(all_parameters.getWeight3()));
			all_parameters.setWalt3((three_pos.get(2).getPosition().getAlt())*(all_parameters.getWeight3()));

			all_parameters.setWeightsum();
			all_parameters.setWlatsum();
			all_parameters.setWlonsum();
			all_parameters.setWaltsum();

			pos.position.setLat((all_parameters.getWlatsum())/(all_parameters.getWeightsum()));
			pos.position.setLon((all_parameters.getWlonsum())/(all_parameters.getWeightsum()));
			pos.position.setAlt((all_parameters.getWaltsum())/(all_parameters.getWeightsum()));
			pos.signal.setSignal((three_pos.get(0).signal.signal));
			System.out.println(pos);
		}
	}

}

// -73	32.10260039	35.20908298	690.3743628
//		32.10272855515488,35.208795372052336,689.8946903102753,-73