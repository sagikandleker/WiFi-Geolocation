package Main_App;

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

public class Mac_HM {

	public static HashMap<String,ArrayList<Record_Pos_Wifi_Time>> hash = new HashMap<String,ArrayList<Record_Pos_Wifi_Time>>();
	static ArrayList<Record> All_Data_List = Write_2_CSV.All_Data_List;

	public static void Build_Hash() {

		Record_Pos_Wifi_Time pos_wifi_time;

		Mac mac;
		Signal signal;
		SSID ssid;
		Time time;
		Frequency frequency;
		Position position;
		Wifi wifi;

		for (int i = 0; i < All_Data_List.size(); i++) {
			position = All_Data_List.get(i).getPosition();
			for (int k = 0; k < All_Data_List.get(i).getWifiList().size(); k++) {
				mac = new Mac(All_Data_List.get(i).getWifiList().get(k).getMac());
				signal = new Signal((All_Data_List.get(i).getWifiList().get(k).getSignal()));
				ssid = new SSID(All_Data_List.get(i).getWifiList().get(k).getSsid());
				time = new Time(All_Data_List.get(i).getDate());
				frequency =  new Frequency(All_Data_List.get(i).getWifiList().get(k).getFrequency());
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
