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

public class Mac_Hashmap {

	private static Mac mac;
	private static Signal signal;
	private static SSID ssid;
	private static Frequency frequency;
	private static Position position;
	private static Wifi wifi;

	public static HashMap<String,ArrayList<Record_Pos_Wifi_Time>> hash = new HashMap<String,ArrayList<Record_Pos_Wifi_Time>>();

	public static HashMap<String, ArrayList<Record_Pos_Wifi_Time>> Build_Hash(ArrayList<Record> data, String nameOfHash) {

		Record_Pos_Wifi_Time record;

		Time time;
		int line = 1;

		for (int i = 0; i < data.size(); i++) {
			position = data.get(i).getPosition();

			for (int k = 0; k < data.get(i).getWifiList().size(); k++) {
				mac = new Mac(data.get(i).getWifiList().get(k).getMac());
				signal = new Signal((data.get(i).getWifiList().get(k).getSignal()));
				ssid = new SSID(data.get(i).getWifiList().get(k).getSsid());
				time = new Time(data.get(i).getDate());
				frequency =  new Frequency(data.get(i).getWifiList().get(k).getFrequency());
				wifi = new Wifi(ssid, mac, frequency, signal);
				record = new Record_Pos_Wifi_Time(line, position, wifi, time);

				if(hash.containsKey(mac.getMac()) && !hash.get(mac.getMac()).contains(record)) {
					hash.get(mac.getMac()).add(record);
				}

				else {
					ArrayList<Record_Pos_Wifi_Time> rps= new ArrayList<Record_Pos_Wifi_Time>();
					rps.add(record);
					hash.put(mac.getMac(), rps);
				}

			}

			line++;
		}

		if(nameOfHash.equals("Algo1")) {
			HashMap<String,ArrayList<Record_Pos_Wifi_Time>> algo1_Hash = new HashMap<String,ArrayList<Record_Pos_Wifi_Time>>();
			algo1_Hash.putAll(hash);
			return algo1_Hash;
		}

		else if(nameOfHash.equals("Algo2")) {
			HashMap<String,ArrayList<Record_Pos_Wifi_Time>> algo2_Hash = new HashMap<String,ArrayList<Record_Pos_Wifi_Time>>();
			algo2_Hash.putAll(hash);
			return algo2_Hash;
		}

		return hash;
	}
}
