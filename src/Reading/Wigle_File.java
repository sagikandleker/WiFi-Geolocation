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
import Data_Setup.ID;
import Data_Setup.Mac;
import Data_Setup.Position;
import Data_Setup.Record;
import Data_Setup.SSID;
import Data_Setup.Signal;
import Data_Setup.Time;
import Data_Setup.Wifi;
import Writing.CSV_File;

/**
 * Reading from files in different styles.
 *
 */
public class Wigle_File {

	private static Mac mac;
	private static Signal signal;
	private static SSID ssid;
	private static Frequency frequency;
	private static Position position;
	private static ID id;

	/**
	 * wigle_File read from CSV file all the data and copy it to ArrayList.
	 * @param file name of file.
	 * @throws IOException
	 * @throws ParseException
	 */
	public static void read(File file)throws IOException, ParseException {

		ArrayList<Record> wigle_data = new ArrayList<Record>();
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		String [] getmodel = line.split(",");
		id = new ID(getmodel[2].substring(6));

		line = br.readLine();
		line = br.readLine();

		while(line!=null) {
			String[] arr = (line.split(","));

			if(arr[10].equals("WIFI")) {
				mac = new Mac(arr[0]);
				ssid = new SSID(arr[1]);
				Date date  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(arr[3]);
				Time time = new Time(date);
				frequency = new Frequency(arr[4]);
				signal = new Signal(arr[5]);
				position = new Position(arr[8],arr[7],arr[6]);

				Wifi wifi = new Wifi(ssid, mac, frequency, signal);
				Record record = new Record(time, position);
				record.addWifi(wifi);
				record.setid(id);
				wigle_data.add(record);

				line = br.readLine();

			}
			else {
				line = br.readLine();
			}

		}

		br.close();
		CSV_File.Build_ArrayList(wigle_data);
	}
}