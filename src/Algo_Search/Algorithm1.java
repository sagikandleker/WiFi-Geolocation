package Algo_Search;

import java.util.ArrayList;
import java.util.Optional;

import Data_Setup.Record_Pos_Signal;
import Main_App.Files_2_CSV;

public class Algorithm1 {

	public static void Better(String mac) {

		if(Files_2_CSV.hash.containsKey(mac)) {

			System.out.println(Files_2_CSV.hash.get(mac));
			System.out.println(Record_Pos_Signal.sort_Signal_Power(Files_2_CSV.hash.get(mac)));
			Algo1(Record_Pos_Signal.sort_Signal_Power(Files_2_CSV.hash.get(mac)));

		}
		//for (int i = 0; i < Files_2_CSV.hash.keySet().size(); i++) {

			//String mac1 = Files_2_CSV.hash.keySet().;
			//Record_Pos_Signal.sort_Signal_Power(Files_2_CSV.hash.get(mac1));	


		//}

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