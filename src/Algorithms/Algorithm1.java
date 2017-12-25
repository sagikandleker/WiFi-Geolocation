package Algorithms;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import Data_Setup.Record_Pos_Wifi_Time;
import Main_App.Mac_HM;
import Main_App.Main;

public class Algorithm1 {
	
	public static ArrayList<Record_Pos_Wifi_Time> rpwt = new ArrayList<Record_Pos_Wifi_Time>();

	public static void Better() throws IOException {

		ArrayList<String> mac_names = new ArrayList<String>(Mac_HM.hash.keySet());

		for (int i = 0; i < mac_names.size(); i++) {
			String mac1 = mac_names.get(i);
			Algo1(Record_Pos_Wifi_Time.sort_Signal_Power(Mac_HM.hash.get(mac1)));
			
		}
		
		Write(rpwt);

	}
	//spwt=sorted pos wifi time.
	public static void Algo1(ArrayList<Record_Pos_Wifi_Time> spwt) {
		Algo_Data all_parameters = new Algo_Data();
		Record_Pos_Wifi_Time pos = new Record_Pos_Wifi_Time();
		
		int size=0;
		while(size<spwt.size())
		{
			all_parameters.setWeight(((1/Math.pow((spwt.get(0).getWifi().getSignal()),2.0))));
			all_parameters.setWeightsum(all_parameters.getWeight());
			all_parameters.setWlatsum(spwt.get(size).getPosition().getLat()*(all_parameters.getWeight()));
			all_parameters.setWlonsum(spwt.get(size).getPosition().getLon()*all_parameters.getWeight());
			all_parameters.setWaltsum(spwt.get(size).getPosition().getAlt()*all_parameters.getWeight());
			
			pos.getPosition().setLat((all_parameters.getWlatsum())/(all_parameters.getWeightsum()));
			pos.getPosition().setLon((all_parameters.getWlonsum())/(all_parameters.getWeightsum()));
			pos.getPosition().setAlt((all_parameters.getWaltsum())/(all_parameters.getWeightsum()));
			pos.getWifi().setSignal((spwt.get(size).getWifi().getSignal()));
			pos.getWifi().setMac(spwt.get(size).getWifi().getMac());
			pos.getWifi().setFrequency(spwt.get(size).getWifi().getFrequency());
			pos.getWifi().setSsid(spwt.get(size).getWifi().getSsid());
			pos.getTime().setTime(spwt.get(size).getTime());
			
			size++;
		}
		
		
		/*
		
		if(three_pos.size() == 1) {
		
			pos.getPosition().setLat(three_pos.get(0).getPosition().getLat());
			pos.getPosition().setLon(three_pos.get(0).getPosition().getLon());
			pos.getPosition().setAlt(three_pos.get(0).getPosition().getAlt());
			pos.getWifi().setSignal((three_pos.get(0).getWifi().getSignal()));
			pos.getWifi().setMac(three_pos.get(0).getWifi().getMac());
			pos.getWifi().setFrequency(three_pos.get(0).getWifi().getFrequency());
			pos.getWifi().setSsid(three_pos.get(0).getWifi().getSsid());
			pos.getTime().setTime(three_pos.get(0).getTime());
			
		}
			
		else if(three_pos.size() == 2) {

			all_parameters.setWeight1(((1/Math.pow((three_pos.get(0).getWifi().getSignal()),2.0))));
			all_parameters.setWlat1(three_pos.get(0).getPosition().getLat()*(all_parameters.getWeight1()));
			all_parameters.setWlon1(three_pos.get(0).getPosition().getLon()*all_parameters.getWeight1());
			all_parameters.setWalt1(three_pos.get(0).getPosition().getAlt()*all_parameters.getWeight1());

			all_parameters.setWeight2(1/Math.pow((three_pos.get(1).getWifi().getSignal()),2.0));
			all_parameters.setWlat2(three_pos.get(1).getPosition().getLat()*all_parameters.getWeight2());
			all_parameters.setWlon2(three_pos.get(1).getPosition().getLon()*all_parameters.getWeight2());
			all_parameters.setWalt2(three_pos.get(1).getPosition().getAlt()*all_parameters.getWeight2());

			all_parameters.setWeightsum();
			all_parameters.setWlatsum();
			all_parameters.setWlonsum();
			all_parameters.setWaltsum();

			pos.getPosition().setLat((all_parameters.getWlatsum())/(all_parameters.getWeightsum()));
			pos.getPosition().setLon((all_parameters.getWlonsum())/(all_parameters.getWeightsum()));
			pos.getPosition().setAlt((all_parameters.getWaltsum())/(all_parameters.getWeightsum()));
			pos.getWifi().setSignal((three_pos.get(0).getWifi().getSignal()));
			pos.getWifi().setMac(three_pos.get(0).getWifi().getMac());
			pos.getWifi().setFrequency(three_pos.get(0).getWifi().getFrequency());
			pos.getWifi().setSsid(three_pos.get(0).getWifi().getSsid());
			pos.getTime().setTime(three_pos.get(0).getTime());
		}
		else if(three_pos.size() == 3) {

			all_parameters.setWeight1(((1/Math.pow((three_pos.get(0).getWifi().getSignal()),2.0))));
			all_parameters.setWlat1((three_pos.get(0).getPosition().getLat())*(all_parameters.getWeight1()));
			all_parameters.setWlon1((three_pos.get(0).getPosition().getLon())*(all_parameters.getWeight1()));
			all_parameters.setWalt1((three_pos.get(0).getPosition().getAlt())*(all_parameters.getWeight1()));

			all_parameters.setWeight2(1/Math.pow((three_pos.get(1).getWifi().getSignal()),2.0));
			all_parameters.setWlat2((three_pos.get(1).getPosition().getLat())*(all_parameters.getWeight2()));
			all_parameters.setWlon2((three_pos.get(1).getPosition().getLon())*(all_parameters.getWeight2()));
			all_parameters.setWalt2((three_pos.get(1).getPosition().getAlt())*(all_parameters.getWeight2()));

			all_parameters.setWeight3(1/Math.pow((three_pos.get(2).getWifi().getSignal()),2.0));
			all_parameters.setWlat3((three_pos.get(2).getPosition().getLat())*(all_parameters.getWeight3()));
			all_parameters.setWlon3((three_pos.get(2).getPosition().getLon())*(all_parameters.getWeight3()));
			all_parameters.setWalt3((three_pos.get(2).getPosition().getAlt())*(all_parameters.getWeight3()));

			all_parameters.setWeightsum();
			all_parameters.setWlatsum();
			all_parameters.setWlonsum();
			all_parameters.setWaltsum();

			pos.getPosition().setLat((all_parameters.getWlatsum())/(all_parameters.getWeightsum()));
			pos.getPosition().setLon((all_parameters.getWlonsum())/(all_parameters.getWeightsum()));
			pos.getPosition().setAlt((all_parameters.getWaltsum())/(all_parameters.getWeightsum()));
			pos.getWifi().setSignal((three_pos.get(0).getWifi().getSignal()));
			pos.getWifi().setMac(three_pos.get(0).getWifi().getMac());
			pos.getWifi().setFrequency(three_pos.get(0).getWifi().getFrequency());
			pos.getWifi().setSsid(three_pos.get(0).getWifi().getSsid());
			pos.getTime().setTime(three_pos.get(0).getTime());
				
		}
		
		else if(three_pos.size() == 4) {

			all_parameters.setWeight1(((1/Math.pow((three_pos.get(0).getWifi().getSignal()),2.0))));
			all_parameters.setWlat1((three_pos.get(0).getPosition().getLat())*(all_parameters.getWeight1()));
			all_parameters.setWlon1((three_pos.get(0).getPosition().getLon())*(all_parameters.getWeight1()));
			all_parameters.setWalt1((three_pos.get(0).getPosition().getAlt())*(all_parameters.getWeight1()));

			all_parameters.setWeight2(1/Math.pow((three_pos.get(1).getWifi().getSignal()),2.0));
			all_parameters.setWlat2((three_pos.get(1).getPosition().getLat())*(all_parameters.getWeight2()));
			all_parameters.setWlon2((three_pos.get(1).getPosition().getLon())*(all_parameters.getWeight2()));
			all_parameters.setWalt2((three_pos.get(1).getPosition().getAlt())*(all_parameters.getWeight2()));

			all_parameters.setWeight3(1/Math.pow((three_pos.get(2).getWifi().getSignal()),2.0));
			all_parameters.setWlat3((three_pos.get(2).getPosition().getLat())*(all_parameters.getWeight3()));
			all_parameters.setWlon3((three_pos.get(2).getPosition().getLon())*(all_parameters.getWeight3()));
			all_parameters.setWalt3((three_pos.get(2).getPosition().getAlt())*(all_parameters.getWeight3()));

			
			all_parameters.setWeight4(1/Math.pow((three_pos.get(2).getWifi().getSignal()),2.0));
			all_parameters.setWlat4((three_pos.get(2).getPosition().getLat())*(all_parameters.getWeight3()));
			all_parameters.setWlon4((three_pos.get(2).getPosition().getLon())*(all_parameters.getWeight3()));
			all_parameters.setWalt4((three_pos.get(2).getPosition().getAlt())*(all_parameters.getWeight3()));
			
			all_parameters.setWeightsum();
			all_parameters.setWlatsum();
			all_parameters.setWlonsum();
			all_parameters.setWaltsum();

			pos.getPosition().setLat((all_parameters.getWlatsum())/(all_parameters.getWeightsum()));
			pos.getPosition().setLon((all_parameters.getWlonsum())/(all_parameters.getWeightsum()));
			pos.getPosition().setAlt((all_parameters.getWaltsum())/(all_parameters.getWeightsum()));
			pos.getWifi().setSignal((three_pos.get(0).getWifi().getSignal()));
			pos.getWifi().setMac(three_pos.get(0).getWifi().getMac());
			pos.getWifi().setFrequency(three_pos.get(0).getWifi().getFrequency());
			pos.getWifi().setSsid(three_pos.get(0).getWifi().getSsid());
			pos.getTime().setTime(three_pos.get(0).getTime());
				
		}
		*/
		rpwt.add(pos);
	}

	public static void Write(ArrayList<Record_Pos_Wifi_Time> rpwt) throws IOException {

		StringBuilder stringBuilder = new StringBuilder();
		FileWriter fw = new FileWriter(Main.Algo1_Out);
		for (int i = 0; i < rpwt.size(); i++) {
			stringBuilder.append("\n");
			stringBuilder.append((rpwt.get(i).toString().replace("[", "").replace("]", "")));	
		}

		fw.write(stringBuilder.toString());
		System.out.println("Algo1 Write file to ["+Main.Algo1_Out+"]");
		fw.close();

	}

}