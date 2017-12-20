package Algo_Search;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import Data_Setup.Position;
import Data_Setup.Record_PAS;
import Data_Setup.Signal;
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
		if(found_flag==true)
		{
			System.out.println(Record_PAS.sort_Signal_Power(ara));
			Algo1(Record_PAS.sort_Signal_Power(ara));
		}
		else
		{
			System.out.println("mac not found");
		}

	}

	public static void Algo1(ArrayList<Record_PAS> three_pos)
	{

		Algo_Data all_parameters = new Algo_Data();
		Position pos = new Position();

		all_parameters.setWeight1(((1/Math.pow((three_pos.get(0).getSignal().cast()),2.0))));
		all_parameters.setWlat1(three_pos.get(0).getPosition().getLat()*(all_parameters.getWeight1()));
		all_parameters.setWlon1(three_pos.get(0).getPosition().getLon()*all_parameters.getWeight1());
		all_parameters.setWalt1(three_pos.get(0).getPosition().getAlt()*all_parameters.getWeight1());

		all_parameters.setWeight2(1/Math.pow((three_pos.get(1).getSignal().cast()),2.0));
		all_parameters.setWlat2(three_pos.get(1).getPosition().getLat()*all_parameters.getWeight2());
		all_parameters.setWlon2(three_pos.get(1).getPosition().getLon()*all_parameters.getWeight2());
		all_parameters.setWalt2(three_pos.get(1).getPosition().getAlt()*all_parameters.getWeight2());

		all_parameters.setWeight3(1/Math.pow((three_pos.get(2).getSignal().cast()),2.0));
		all_parameters.setWlat3(three_pos.get(2).getPosition().getLat()*all_parameters.getWeight3());
		all_parameters.setWlon3(three_pos.get(2).getPosition().getLon()*all_parameters.getWeight3());
		all_parameters.setWalt3(three_pos.get(2).getPosition().getAlt()*all_parameters.getWeight3());

		all_parameters.setWeightsum();
		all_parameters.setWlatsum();
		all_parameters.setWlonsum();
		all_parameters.setWaltsum();

		pos.setLat(all_parameters.getWlatsum()/all_parameters.getWeightsum());
		pos.setLon(all_parameters.getWlonsum()/all_parameters.getWeightsum());
		pos.setAlt(all_parameters.getWaltsum()/all_parameters.getWeightsum());
		System.out.println(pos);
	}
}
