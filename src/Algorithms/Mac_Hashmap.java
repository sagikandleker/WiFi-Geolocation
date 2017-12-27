package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;

import Data_Setup.Frequency;
import Data_Setup.Mac;
import Data_Setup.Position;
import Data_Setup.Record;
import Data_Setup.Record_Pos_Wifi_Time;
import Data_Setup.SSID;
import Data_Setup.Signal;
import Data_Setup.Time;
import Data_Setup.Wifi;
import Main_App.Write_2_CSV;

public class Mac_Hashmap {

	public static HashMap<String,ArrayList<Record_Pos_Wifi_Time>> hash = new HashMap<String,ArrayList<Record_Pos_Wifi_Time>>();
	static ArrayList<Record> All_Data_List = Write_2_CSV.All_Data_List;
	//static ArrayList<Record> data = Read_From.data;

	public static void Build_Hash(ArrayList<Record> data, String nameOfHash) {
		
		Record_Pos_Wifi_Time pos_wifi_time;
		Mac mac;
		Signal signal;
		SSID ssid;
		Time time;
		Frequency frequency;
		Position position;
		Wifi wifi;

		for (int i = 0; i < data.size(); i++) {
			position = data.get(i).getPosition();
			for (int k = 0; k < data.get(i).getWifiList().size(); k++) {
				mac = new Mac(data.get(i).getWifiList().get(k).getMac());
				signal = new Signal((data.get(i).getWifiList().get(k).getSignal()));
				ssid = new SSID(data.get(i).getWifiList().get(k).getSsid());
				time = new Time(data.get(i).getDate());
				frequency =  new Frequency(data.get(i).getWifiList().get(k).getFrequency());
				wifi = new Wifi(ssid, mac, frequency, signal);
				pos_wifi_time = new Record_Pos_Wifi_Time(position, wifi, time);


				ArrayList<Record_Pos_Wifi_Time> rps = new ArrayList<Record_Pos_Wifi_Time>();

				if(hash.containsKey(mac.getMac()) && !hash.get(mac.getMac()).contains(pos_wifi_time)) {
					hash.get(mac.getMac()).add(pos_wifi_time);
				}

				else
				{
					rps.add(pos_wifi_time);
					hash.put(mac.getMac(), rps);
				}

			}

		}

	}
}
