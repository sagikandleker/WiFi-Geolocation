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
import GUI.GUI_Wrapper;


/**
 * This main class, represents the exact Position for each line in "nogps" file. (device position).
 *
 */
public class Algorithm_2 {

	static final double power=2,
			norm=10000, sigdiff=0.4, 
			mindiff=3, nosignal=0.32344759,
			diffnosignal=100;

	public static ArrayList<Position> final_pos_array  = new ArrayList<Position>();

	/**
	 * Taking three pairs (MAC with Signal) and send them to Algorithm 2 function with the HashMap.
	 * @param hash HashMap with the MAC keys and ArrayList for each key with the data about him.
	 * @param record ArrayList inside ArrayList with the lines in "nogps" file.
	 * @throws IOException
	 */
	public static void no_gps_lines(HashMap<String,ArrayList<Record_Pos_Wifi_Time>> hash, ArrayList<ArrayList<Record_Mac_Signal>> record) throws IOException {

		Mac mac;
		Signal signal;
		Record_Mac_Signal ms;

		ArrayList<Record_Mac_Signal> three;

		for (int i = 0; i < record.size(); i++) {

			three = new ArrayList<Record_Mac_Signal>();

			for (int j = 0; j < record.get(i).size(); j++) {

				if(j<3)
				{
					mac = new Mac(record.get(i).get(j).getMac());
					signal = new Signal(record.get(i).get(j).getSignal());
					ms = new Record_Mac_Signal(mac, signal);
					three.add(ms);
				}
			}
			
			Algo2(hash, three);
		}

		Write();

	}

	
	/**
	 * Algorithm 2 function, searching all the data about each MAC (from the three) and doing calculation to found the exact position of the device.
	 * @param hash HashMap with the MAC keys and ArrayList for each key with the data about him.
	 * @param three Pairs with MAC and Signal from the "nogps" file line by line.
	 */
	public static void Algo2(HashMap<String,ArrayList<Record_Pos_Wifi_Time>> hash, ArrayList<Record_Mac_Signal> three) {

		Mac mac;
		Signal nogps_signal;
		Position position;
		Signal comb_signal;
		int line = 0;

		HashMap<String, Signal> ms = new HashMap<String, Signal>();

		Record_Pos_Mac_Signal rpms;

		ArrayList<Record_Pos_Mac_Signal> comb_data = new ArrayList<Record_Pos_Mac_Signal>();

		for (int i = 0; i < three.size(); i++) {
			mac = new Mac(three.get(i).getMac());
			nogps_signal = new Signal(three.get(i).getSignal());

			if(hash.get(mac.getMac())!=null) {
				for (int j = 0; j < (hash.get(mac.getMac()).size()); j++) {

					line = hash.get(mac.getMac()).get(j).getLine();
					position = new Position(hash.get(mac.getMac()).get(j).getPosition());
					comb_signal = new Signal(hash.get(mac.getMac()).get(j).getWifi().getSignal());
					rpms = new Record_Pos_Mac_Signal(line,position, mac, comb_signal);
					comb_data.add(rpms);
				}

			}
		}

		sortline(comb_data);

		for (int i = 0; i < three.size(); i++) 
		{

			ms.put(three.get(i).getStringMac(), three.get(i).getSignal());
		}

		double diff;
		double w;
		double pi = 1;
		Record_Pos_Pi rpp;
		ArrayList<Record_Pos_Pi> array_rpp = new ArrayList<Record_Pos_Pi>();

		int size = 0;
		
		if(comb_data.size() == 1) {
			position = new Position(comb_data.get(size).getPosition());
			final_pos_array.add(position);

		}
		else {

			while(size < comb_data.size()-1) {

				pi = 1;
				position = new Position(comb_data.get(size).getPosition());
				mac = new Mac(comb_data.get(size).getMac().getMac());


				nogps_signal = new Signal(ms.get(mac.getMac()).getSignal());
				comb_signal = new Signal(comb_data.get(size).getSignal());

				diff = Math.max(Math.abs((nogps_signal.getSignal())-(comb_signal.getSignal())),mindiff);
				w = norm/(Math.pow(diff, power)*Math.pow(nogps_signal.getSignal(), power));
				pi *= w;

				if(comb_data.get(size+1) != null) {
					if((comb_data.get(size).getLine() != comb_data.get(size+1).getLine())) {
						pi = pi * Math.pow(nosignal, 2);
						size++;
					}

					else if((comb_data.get(size).getLine() == comb_data.get(size+1).getLine())) {

						mac = new Mac(comb_data.get(size+1).getMac());
						nogps_signal = new Signal(ms.get(mac.getMac()).getSignal());
						diff = Math.max(Math.abs((nogps_signal.getSignal())-(comb_signal.getSignal())),mindiff);
						w = norm/(Math.pow(diff, power)*Math.pow(nogps_signal.getSignal(), power));
						pi = pi *w;
						comb_data.remove(size+1);


						if(comb_data.get(size+1) != null)
						{
							if((comb_data.get(size).getLine() == comb_data.get(size+1).getLine())) 
							{
								mac = new Mac(comb_data.get(size+1).getMac());
								nogps_signal = new Signal(ms.get(mac.getMac()).getSignal());
								diff = Math.max(Math.abs((nogps_signal.getSignal())-(comb_signal.getSignal())),mindiff);
								w = norm/(Math.pow(diff, power)*Math.pow(nogps_signal.getSignal(), power));
								pi = pi *w;
								size++;
							}

						}

					}

				}

				rpp = new Record_Pos_Pi(position, pi);
				array_rpp.add(rpp);
			}
			Algo2_final(sortPi(array_rpp));
		}	
	}

	/**
	 * Sorting the data from "comb" file containing all the data for them.
	 * @param comb_data All the data from "comb" file for the pairs.
	 */
	private static void sortline(ArrayList<Record_Pos_Mac_Signal> comb_data) {

		for (int i = 0; i < comb_data.size(); i++) {
			for (int j = 0; j < comb_data.size(); j++) {
				if(comb_data.get(i).getLine() < comb_data.get(j).getLine()) {

					Record_Pos_Mac_Signal temp;
					temp = comb_data.get(i);
					comb_data.set(i, comb_data.get(j));
					comb_data.set(j, temp);
				}
			}
		}

	}

	/**
	 * Searching the higher three PI.
	 * @param comb_data The Position and PI to each line calculation.
	 * @return strongerpi ArrayList with the Position and PI from the higher to the lower.
	 */
	private static ArrayList<Record_Pos_Pi> sortPi(ArrayList<Record_Pos_Pi> comb_data) {

		ArrayList<Record_Pos_Pi> strongerpi = new ArrayList<Record_Pos_Pi>();
		if(comb_data.size() <= 3) return comb_data;

		for (int i = 0; i < 3; i++) {
			double maxpi=comb_data.get(0).pi;
			int place = 0;
			for (int j = 0; j <comb_data.size(); j++) {
				if(comb_data.get(j).pi > maxpi) {
					maxpi=comb_data.get(j).pi;
					place=j;
				}
			}
			strongerpi.add(comb_data.get(place));
			comb_data.remove(place);

		}
		return strongerpi;

	}

	/**
	 * Calculates the three higher Positions,  similar to Algorithm 1.
	 * @param record ArrayList with the higher PI with Positions.
	 */
	public static void Algo2_final(ArrayList<Record_Pos_Pi> record) {
		Algorithm_Tools all_parameters = new Algorithm_Tools();
		Position position = new Position();


		int size = 0;
		while(size < record.size()) {

			all_parameters.setWeight((record.get(size).getPi()));
			all_parameters.setWeightsum(all_parameters.getWeight());
			all_parameters.setWlatsum(record.get(size).getP().getLat()*(all_parameters.getWeight()));
			all_parameters.setWlonsum(record.get(size).getP().getLon()*all_parameters.getWeight());
			all_parameters.setWaltsum(record.get(size).getP().getAlt()*all_parameters.getWeight());

			position.setLat((all_parameters.getWlatsum())/(all_parameters.getWeightsum()));
			position.setLon((all_parameters.getWlonsum())/(all_parameters.getWeightsum()));
			position.setAlt((all_parameters.getWaltsum())/(all_parameters.getWeightsum()));

			size++;
		}

		final_pos_array.add(position);
	}
	
	/**
	 * Writing the Positions for each line from the "nogps" file after the calculation to CSV file.
	 * @throws IOException
	 */
	public static void Write() throws IOException {

		StringBuilder stringBuilder = new StringBuilder();
		FileWriter fw = new FileWriter(GUI_Wrapper.algorithm2+".csv");
		String t = "Alt"+","+"Lon"+","+"Lat";
		stringBuilder.append(t);
		for (int i = 0; i < final_pos_array.size(); i++) {
			stringBuilder.append("\n");
			stringBuilder.append((final_pos_array.get(i).toString().replace("[", "").replace("]", "")));	
		}

		fw.write(stringBuilder.toString());
		fw.close();
		final_pos_array.clear();

	}
}