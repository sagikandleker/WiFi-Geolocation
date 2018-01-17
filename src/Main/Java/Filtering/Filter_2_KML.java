package Filtering;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;

//TODO Move the function to Write_2_KML.
public class Filter_2_KML {

	public static void KML(ArrayList<Record_Filter> data, String file) throws IOException	
	{
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
		kml.marshal(new File(file+"\\kmlfilter.kml"));
		System.out.println("Finish to create KML File");
	}
}
