package Main_App;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import Data_Setup.Record;
import Filtering.Record_Filter;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;

/**
 * Write to KML File. 
 *
 */
public class Write_2_KML {

	/**
	 * Write to KML file from "All_Data_List" ArrayList (All the data).
	 * @param data All_Data_List ArrayList from Write_2_CSV.
	 * @param file name of file to write.
	 * @throws IOException
	 */
	public static void KML(ArrayList<Record> data,String file) throws IOException	
	{
		DateFormat TimeFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		final Kml kml = new Kml();
		Document doc = kml.createAndSetDocument();

		for (int i = 0; i < data.size(); i++) 
		{
			String date = TimeFormater.format(data.get(i).getDate().getTime());
			Placemark place =  doc.createAndAddPlacemark().withName(data.get(i).getid()).withOpen(Boolean.TRUE);
			place.createAndSetPoint().addToCoordinates(data.get(i).getPosition().getLon(),data.get(i).getPosition().getLat(),data.get(i).getPosition().getAlt());
			date = date.replace(' ', 'T')+'Z';
			place.createAndSetTimeStamp().setWhen(date);
		}
		kml.marshal(new File(file));

	}

	/**
	 * Write to KML file from Filter functions.
	 * @param data This the ArrayList data after the filtering from "Filter" class.
	 * @param file name of file to write.
	 * @throws FileNotFoundException
	 */
	public static void Filter_KML(ArrayList<Record_Filter> data, String file) throws FileNotFoundException {

		DateFormat TimeFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		final Kml kml = new Kml();
		Document doc = kml.createAndSetDocument();

		for (int i = 0; i < data.size(); i++) 
		{
			String date = TimeFormater.format(data.get(i).getDate().getTime());
			Placemark place =  doc.createAndAddPlacemark().withName(data.get(i).getSsid()).withOpen(Boolean.TRUE);
			place.createAndSetPoint().addToCoordinates(data.get(i).position.lon,data.get(i).position.lat,data.get(i).position.alt);
			date = date.replace(' ', 'T')+'Z';
			place.createAndSetTimeStamp().setWhen(date);
		}

		kml.marshal(new File(file));
	}

}
