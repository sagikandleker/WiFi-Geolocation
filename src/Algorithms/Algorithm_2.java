package Algorithms;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import Data_Setup.Mac;
import Data_Setup.Position;
import Data_Setup.Record_Mac_Signal;
import Data_Setup.Record_Pos_Mac_Signal;
import Data_Setup.Record_Pos_Wifi_Time;
import Data_Setup.Signal;
import Main_App.Main;


public class Algorithm_2 {

	static final double power=2,
			norm=10000, sigdiff=0.4, 
			mindiff=3, nosignal=0.32344759,
			diffnosignal=100;

	static final ArrayList<Position> pos_array = new ArrayList<Position>();

	public static void no_gps_lines(HashMap<String,ArrayList<Record_Pos_Wifi_Time>> hash2, ArrayList<ArrayList<Record_Mac_Signal>> rms) throws IOException {

		Mac mac;
		Signal signal;
		Record_Mac_Signal ms;

		ArrayList<Record_Mac_Signal> three;

		for (int i = 0; i < rms.size(); i++) {

			three = new ArrayList<Record_Mac_Signal>();

			for (int j = 0; j < rms.get(i).size(); j++) {

				if(j<3)
				{
					mac = new Mac(rms.get(i).get(j).getMac());
					signal = new Signal(rms.get(i).get(j).getSignal());
					ms = new Record_Mac_Signal(mac, signal);
					three.add(ms);
				}
			}

			//System.out.println(three);
			Algo2(hash2, three);
		}

		Write(pos_array);

	}


	public static void Algo2(HashMap<String,ArrayList<Record_Pos_Wifi_Time>> hash2, ArrayList<Record_Mac_Signal> three) {

		Mac mac;
		Signal nogps_signal;
		Position position;
		Signal comb_signal;
		int line = 0;

		HashMap<String, Signal> ms = new HashMap<String, Signal>();

		Record_Pos_Mac_Signal rpms;

		ArrayList<Record_Pos_Mac_Signal> arrays = new ArrayList<Record_Pos_Mac_Signal>();

		for (int i = 0; i < three.size(); i++) {
			mac = new Mac(three.get(i).getMac());
			nogps_signal = new Signal(three.get(i).getSignal());

			if(hash2.get(mac.getMac())!=null) {
				for (int j = 0; j < (hash2.get(mac.getMac()).size()); j++) {

					line = hash2.get(mac.getMac()).get(j).getLine();
					position = new Position(hash2.get(mac.getMac()).get(j).getPosition());
					comb_signal = new Signal(hash2.get(mac.getMac()).get(j).getWifi().getSignal());
					rpms = new Record_Pos_Mac_Signal(line,position, mac, comb_signal);
					arrays.add(rpms);
				}

			}
		}

		sortline(arrays);

		for (int i = 0; i < three.size(); i++) 
		{

			ms.put(three.get(i).getStringMac(), three.get(i).getSignal());
		}

		//System.out.println(arrays);
		double diff;
		double w;
		Record_Pos_Pi rpp;
		ArrayList<Record_Pos_Pi> array_rpp = new ArrayList<Record_Pos_Pi>();

		for (int j = 0; j < arrays.size(); j++) 
		{

			double pi = 1;
			position = new Position(arrays.get(j).getPosition());
			mac = new Mac(arrays.get(j).getMac().getMac());

			if(arrays.size() == 1)
			{
				pos_array.add(position);
			}

			else
			{

				nogps_signal = new Signal(ms.get(mac.getMac()).getSignal());
				comb_signal = new Signal(arrays.get(j).getSignal());

				diff = Math.max(Math.abs((nogps_signal.getSignal())-(comb_signal.getSignal())),mindiff);
				w = norm/(Math.pow(diff, power)*Math.pow(nogps_signal.getSignal(), power));
				pi *= w;

				if(j != (arrays.size()-1)) 
				{
					if((arrays.get(j).getLine() != arrays.get(j+1).getLine()))
					{
						pi = pi * Math.pow(nosignal, 2);
					}

					else if((arrays.get(j).getLine() == arrays.get(j+1).getLine()))
					{
						mac = new Mac(arrays.get(j+1).getMac());
						nogps_signal = new Signal(ms.get(mac.getMac()).getSignal());
						diff = Math.max(Math.abs((nogps_signal.getSignal())-(comb_signal.getSignal())),mindiff);
						w = norm/(Math.pow(diff, power)*Math.pow(nogps_signal.getSignal(), power));
						pi = pi *w;
						arrays.remove(j+1);
						//System.out.println(j);
						//System.out.println((arrays.size()-2));
						if(j != (arrays.size()-2))
						{
							if((arrays.get(j).getLine() == arrays.get(j+2).getLine())) 
							{
								mac = new Mac(arrays.get(j+2).getMac());
								nogps_signal = new Signal(ms.get(mac.getMac()).getSignal());
								diff = Math.max(Math.abs((nogps_signal.getSignal())-(comb_signal.getSignal())),mindiff);
								w = norm/(Math.pow(diff, power)*Math.pow(nogps_signal.getSignal(), power));
								pi = pi *w;

								arrays.remove(j+2);
							}
							else {
								break;
							}
						}
						else
						{

							break;
						}

					}

				}
				else
				{

					break;

				}
			}

			rpp = new Record_Pos_Pi(position, pi);
			array_rpp.add(rpp);

		}

		Algo2_final(sortPi(array_rpp));
	}


	private static void sortline(ArrayList<Record_Pos_Mac_Signal> arrays) {

		for (int i = 0; i < arrays.size(); i++) {
			for (int j = 0; j < arrays.size(); j++) {
				if(arrays.get(i).getLine() < arrays.get(j).getLine()) {

					Record_Pos_Mac_Signal temp;
					temp = arrays.get(i);
					arrays.set(i, arrays.get(j));
					arrays.set(j, temp);
				}
			}
		}

	}

	private static ArrayList<Record_Pos_Pi> sortPi(ArrayList<Record_Pos_Pi> arrays) {

		ArrayList<Record_Pos_Pi> strongerpi=new ArrayList<Record_Pos_Pi>();
		if(arrays.size() <= 3) return arrays;

		for (int i = 0; i < 3; i++) {
			double maxpi=arrays.get(0).pi;
			int place=0;
			for (int j = 0; j <arrays.size(); j++) {
				if(arrays.get(j).pi > maxpi) {
					maxpi=arrays.get(j).pi;
					place=j;
				}
			}
			strongerpi.add(arrays.get(place));
			arrays.remove(place);

		}
		return strongerpi;

	}

	public static void Write(ArrayList<Position> rpp) throws IOException {

		StringBuilder stringBuilder = new StringBuilder();
		FileWriter fw = new FileWriter(Main.Algo2_File_Out);
		for (int i = 0; i < rpp.size(); i++) {
			stringBuilder.append("\n");
			stringBuilder.append((rpp.get(i).toString().replace("[", "").replace("]", "")));	
		}

		fw.write(stringBuilder.toString());
		System.out.println("Algo2 Write file to ["+Main.Algo2_File_Out+"]");
		fw.close();

	}


	public static void Algo2_final(ArrayList<Record_Pos_Pi> rpp) {
		Algorithm_Data all_parameters = new Algorithm_Data();
		Position pos = new Position();


		int size = 0;
		while(size < rpp.size()) {
			
			all_parameters.setWeight((rpp.get(size).getPi()));
			all_parameters.setWeightsum(all_parameters.getWeight());
			all_parameters.setWlatsum(rpp.get(size).getP().getLat()*(all_parameters.getWeight()));
			all_parameters.setWlonsum(rpp.get(size).getP().getLon()*all_parameters.getWeight());
			all_parameters.setWaltsum(rpp.get(size).getP().getAlt()*all_parameters.getWeight());

			pos.setLat((all_parameters.getWlatsum())/(all_parameters.getWeightsum()));
			pos.setLon((all_parameters.getWlonsum())/(all_parameters.getWeightsum()));
			pos.setAlt((all_parameters.getWaltsum())/(all_parameters.getWeightsum()));

			size++;
		}

		pos_array.add(pos);
	}

}