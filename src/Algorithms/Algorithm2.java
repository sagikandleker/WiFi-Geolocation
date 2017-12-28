package Algorithms;

import java.util.ArrayList;

import Data_Setup.Mac;
import Data_Setup.Record;
import Data_Setup.Record_Mac_Signal;
import Data_Setup.Signal;


// ArrayList<ArrayList> = nogps file.
// ArrayList<Record> = comb file.

public class Algorithm2 {

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
		}
		Algo2(data, three);
		System.out.println(three);
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
			System.out.println("I = "+i);

			for (int z = 0; z < three.size(); z++) {
				System.out.println("Z = "+z);
				
				for (int j = 0; j < data.get(i).getWifiList().size(); j++) {
					System.out.println("J = "+j);
					
					double sig = three.get(z).getSignal().signal;
					System.out.println("MAC: "+three.get(z).getMac());
					System.out.println("WIFI MACS: "+(data.get(i).getWifiList().get(j).getMac()));

					if(three.get(z).getMac().equals(data.get(i).getWifiList().get(j).getMac()))
					{
						counter++;
						diff = Math.max(Math.abs(sig-data.get(i).getWifiList().get(j).getSignal()),mindiff);

					}
					else {

						diff = 120;
					}

					w = norm/(Math.pow(diff, power)*Math.pow(sig, power));
					pi *= w;


				}


			}

			pp = new Record_Pos_Pi(pi,data.get(i).getPosition());
			array_pp.add(pp);
			
		}
		System.out.println(counter);
		//System.out.println(array_pp);

	}

}




// ARRAYLIST ARAYYLIST -> MAC SIGNAL MAC SIGNAL MAC SIGNAL MAC SIGNAL
// HASHMAP -> MAC1 - 1 1 1
// HASHMAP -> MAC2 - 1 1 1








