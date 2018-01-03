package Algorithms;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import Data_Setup.Record_Pos_Wifi_Time;
import GUI.GUI_Wrapper;


public class Algorithm_1 {
	
	public static ArrayList<Record_Pos_Wifi_Time> rpwt = new ArrayList<Record_Pos_Wifi_Time>();
/**
 * 
 *  @param namesOfKeys array list with all the hash map keys (mac).
 */
	public static void Better() throws IOException {
		
		ArrayList<String> namesOfKeys = new ArrayList<String>(Mac_Hashmap.hash.keySet());
		String key;
		for (int i = 0; i < namesOfKeys.size(); i++) {
			key = namesOfKeys.get(i);
			Algo1(Record_Pos_Wifi_Time.sort_Signal_Power(Mac_Hashmap.hash.get(key)));
		}
	
	}

	public static void Algo1(ArrayList<Record_Pos_Wifi_Time> spwt) {
		Algorithm_Tools all_parameters = new Algorithm_Tools();
		Record_Pos_Wifi_Time position = new Record_Pos_Wifi_Time();
		
	
		int size = 0;
		while(size < spwt.size())
		{
			all_parameters.setWeight(((1/Math.pow((spwt.get(size).getWifi().getSignal()),2.0))));
			all_parameters.setWeightsum(all_parameters.getWeight());
			all_parameters.setWlatsum(spwt.get(size).getPosition().getLat()*(all_parameters.getWeight()));
			all_parameters.setWlonsum(spwt.get(size).getPosition().getLon()*all_parameters.getWeight());
			all_parameters.setWaltsum(spwt.get(size).getPosition().getAlt()*all_parameters.getWeight());
			
			position.getPosition().setLat((all_parameters.getWlatsum())/(all_parameters.getWeightsum()));
			position.getPosition().setLon((all_parameters.getWlonsum())/(all_parameters.getWeightsum()));
			position.getPosition().setAlt((all_parameters.getWaltsum())/(all_parameters.getWeightsum()));
			position.getWifi().setSignal((spwt.get(0).getWifi().getSignal()));
			position.getWifi().setMac(spwt.get(size).getWifi().getMac());
			position.getWifi().setFrequency(spwt.get(size).getWifi().getFrequency());
			position.getWifi().setSsid(spwt.get(size).getWifi().getSsid());
			position.getTime().setTime(spwt.get(size).getTime());
			
			size++;
		}
		rpwt.add(position);
	}

	public static void Write(ArrayList<Record_Pos_Wifi_Time> rpwt) throws IOException {

		StringBuilder stringBuilder = new StringBuilder();
		FileWriter fw = new FileWriter(GUI_Wrapper.algorithm1+".csv");
		String titles_list = "#ID"+","+"MAC"+","+"SSID"+","+"Frequency"+","+"Signal"+","+"Alt"+","+"Lon"+"," +"Lat"+","+"Time";
		stringBuilder.append(titles_list);
		for (int i = 0; i < rpwt.size(); i++) {
			rpwt.get(i).setLine(i+1);
			stringBuilder.append("\n");
			stringBuilder.append((rpwt.get(i).toString().replace("[", "").replace("]", "")));	
		}

		fw.write(stringBuilder.toString());
		fw.close();

	}

}