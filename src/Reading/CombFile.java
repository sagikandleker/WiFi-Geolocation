package Reading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Data_Setup.Frequency;
import Data_Setup.Mac;
import Data_Setup.Position;
import Data_Setup.Record;
import Data_Setup.SSID;
import Data_Setup.Signal;
import Data_Setup.Time;
import Data_Setup.Wifi;

public class CombFile {
	
	private static Mac mac;
	private static Signal signal;
	private static SSID ssid;
	private static Frequency frequency;
	private static Position position;
	private static Wifi wifi;

	/**
	 * comb_File read from CSV file all the data and copy it to ArrayList.
	 * @param file name of file.
	 * @param name of the function who called to comb_File.
	 * @return comb_data ArrayList approx Record.
	 * @throws IOException
	 * @throws ParseException
	 */
	public static ArrayList<Record> read(File file, String name) throws IOException, ParseException {

		ArrayList<Record> comb_data = new ArrayList<Record>();
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();

		if(name.equalsIgnoreCase("combWithHeaders")) {
			line = br.readLine();
		}

		while(!line.isEmpty()) {

			String[] arr = (line.split(","));

			Date date  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(arr[0]);
			Time time = new Time(date);
			position = new Position(arr[2],arr[3],arr[4]);
			Record record = new Record(time, position);

			for (int i = 6; i < arr.length; i += 4) {
				if(!(arr[i+1].equals(" "))) {
					ssid = new SSID(arr[i]);
					mac = new Mac(arr[i+1]);
					frequency = new Frequency(arr[i+2]);
					signal = new Signal(arr[i+3]);
					wifi = new Wifi(ssid, mac, frequency, signal);
					record.addWifi(wifi);

				}
			}

			comb_data.add(record);
			line = br.readLine();
		}

		br.close();
		return comb_data;
	}
	
	
}
