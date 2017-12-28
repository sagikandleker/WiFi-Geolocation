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

	public static void Algo2(ArrayList<Record> data, ArrayList<ArrayList<Record_Mac_Signal>> rms) {

		Mac mac;
		Signal signal;
		Record_Mac_Signal ms;
		double diff;
		double w;
		Record_Pos_Pi pp;
		ArrayList<Record_Pos_Pi> rpp = new ArrayList<Record_Pos_Pi>();
		ArrayList<Record_Mac_Signal> three;

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
			//Algo2 START!
			//System.out.println(three);

			for (int j = 0; j < data.size(); j++) {
				double pi = 1;

				for (int k = 0; k < data.get(j).getWifiList().size(); k++) {

					for (int z = 0; z < three.size(); z++) {

						double sig = three.get(z).getSignal().signal;

						System.out.println(sig);
						if(three.get(z).getMac().equals(data.get(j).getWifiList().get(k).getMac()))
						{

							diff = Math.max(Math.abs(sig-data.get(j).getWifiList().get(k).getSignal()),mindiff);

						}
						else {
							
							diff = 120;
						}

						w = norm/(Math.pow(diff, power)*Math.pow(sig, power));
						pi *= w;


					}


				}

				pp = new Record_Pos_Pi(pi,data.get(i).getPosition());
				rpp.add(pp);
			}



		}
		//	System.out.println(rpp);
	}


}

// ARRAYLIST ARAYYLIST -> MAC SIGNAL MAC SIGNAL MAC SIGNAL MAC SIGNAL
// HASHMAP -> MAC1 - 1 1 1
// HASHMAP -> MAC2 - 1 1 1








