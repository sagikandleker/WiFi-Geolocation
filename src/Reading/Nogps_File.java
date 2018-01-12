package Reading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import Data_Setup.Mac;
import Data_Setup.Record_Mac_Signal;
import Data_Setup.Signal;


public class Nogps_File {
	
	private static Mac mac;
	private static Signal signal;
	
	/**
	 * nogps_File read from CSV file (Without the Position) all the data and copy it to ArrayList.
	 * @param file name of file.
	 * @return nogps_data ArrayList inside ArrayList approx Record_Mac_Signal.
	 * @throws IOException
	 */
	public static ArrayList<ArrayList<Record_Mac_Signal>> read(File file) throws IOException {

		Record_Mac_Signal rms;
		ArrayList<ArrayList<Record_Mac_Signal>> nogps_data = new ArrayList<ArrayList<Record_Mac_Signal>>();

		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();

		while(line!=null) {

			String[] arr = (line.split(","));
			ArrayList<Record_Mac_Signal> row_data = new ArrayList<Record_Mac_Signal>();

			for (int m = 7; m < arr.length; m+=4) {

				mac = new Mac(arr[m]);
				signal = new Signal(arr[m+2]);
				rms = new Record_Mac_Signal(mac, signal);
				row_data.add(rms);

			}

			nogps_data.add(row_data);
			line = br.readLine();

		}

		br.close();
		return nogps_data;
	}
	
}
