package Algorithms;

import java.util.ArrayList;
import java.util.HashMap;

import Data_Setup.Frequency;
import Data_Setup.Mac;
import Data_Setup.Position;
import Data_Setup.Record;
import Data_Setup.Record_Mac_Signal;
import Data_Setup.Record_Pos_Wifi_Time;
import Data_Setup.SSID;
import Data_Setup.Signal;
import Data_Setup.Time;
import Data_Setup.Wifi;


// ArrayList<ArrayList> = nogps file.
// ArrayList<Record> = comb file.

public class Algorithm2 {
	
	public static HashMap<String,ArrayList<ArrayList<Record_Pos_Wifi_Time>>> hash2 = new HashMap<String,ArrayList<ArrayList<Record_Pos_Wifi_Time>>>();
	
/*
	static final double power=2, norm=10000, sigdiff=0.4, mindiff=3, nosignal=-120, diffnosignal=100;

	public static void no_gps_lines(ArrayList<Record> data, ArrayList<ArrayList<Record_Mac_Signal>> rms) {

		Mac mac;
		Signal signal;
		Record_Mac_Signal ms;


		ArrayList<Record_Mac_Signal> three = null;

		for (int i = 0; i < rms.size(); i++) {

			three = new ArrayList<Record_Mac_Signal>();

			for (int j = 0; j < rms.get(i).size(); j++) {

				if(j<3)
				{
					mac = rms.get(i).get(j).getMac();
					signal = rms.get(i).get(j).getSignal();
					ms = new Record_Mac_Signal(mac, signal);
					three.add(ms);
				}
			}
			Algo2(data, three);
		}
	}

	public static void Algo2(ArrayList<Record> data, ArrayList<Record_Mac_Signal> three) {
		//Algo2 START!
		//System.out.println(three);

		double diff;
		double w;
		int counter = 0;
		Record_Pos_Pi pp;
		ArrayList<Record_Pos_Pi> array_pp = new ArrayList<Record_Pos_Pi>();
		
		for (int i = 0; i < data.size(); i++) {
			double pi = 1;

			for (int z = 0; z < three.size(); z++) {

				for (int j = 0; j < data.get(i).getWifiList().size(); j++) {

					double sig = three.get(z).getSignal().signal;

					if((three.get(z).getMac().compare((data.get(i).getWifiList().get(j).getMac()))))
					{
						
						counter++;
						diff = Math.max(Math.abs(sig-data.get(i).getWifiList().get(j).getSignal()),mindiff);

					}
					else {

						diff = diffnosignal;
					}

					w = norm/(Math.pow(diff, power)*Math.pow(sig, power));
					pi *= w;

				}

			}

			
			pp = new Record_Pos_Pi(pi,data.get(i).getPosition());
			array_pp.add(pp);
			sort(array_pp);
			System.out.println(array_pp);
			
			
			//all function algo 
			//take 3 pos
			//send to hishov
			
			
			
			
			//sort 3 pi strong take pos 3 strong pi and send to algo1 hishov
			
		}	
		array_pp.clear();
	}
	
	public static void sort(ArrayList<Record_Pos_Pi> pp) {
		
		for (int i = 0; i < pp.size(); i++)
		{
			for (int j = 0; j <pp.size(); j++)
			{
				if(pp.get(i).getPi() > pp.get(j).getPi())
				{
				
					Record_Pos_Pi temp;
					temp=pp.get(i);
					pp.set(i, pp.get(j));
					pp.set(j, temp);
				}
			}
		}

	}

*/
	
	
	
	public static HashMap<String, ArrayList<ArrayList<Record_Pos_Wifi_Time>>> Build_Hash2(ArrayList<Record> data) {

		Record_Pos_Wifi_Time pos_wifi_time;
		Mac mac;
		Signal signal;
		Time time;
		Position position;

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

				if(hash2.containsKey(mac.getMac()) && !hash2.get(mac.getMac()).contains(pos_wifi_time)) {
					hash2.get(mac.getMac()).add(pos_wifi_time);
				}

				else
				{
					rps.add(pos_wifi_time);
					hash2.put(mac.getMac(), rps);
				}

			}

		}
		
		return hash;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}









