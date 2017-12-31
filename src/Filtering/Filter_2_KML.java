package Filtering;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import Main_App.Main;

public class Filter_2_KML {

	public static void KML(ArrayList<Record_Filter> data,String type) throws IOException	
	{
		final Kml kml = new Kml();
		Document doc = kml.createAndSetDocument();

		for (int i = 0; i < data.size(); i++) 
		{
			String date = data.get(i).date.toString();
			Placemark place =  doc.createAndAddPlacemark().withName(data.get(i).getId()).withOpen(Boolean.TRUE);
			place.createAndSetPoint().addToCoordinates(data.get(i).position.lon,data.get(i).position.lat,data.get(i).position.alt);
			date = date.replace(' ', 'T')+'Z';
			place.createAndSetTimeStamp().setWhen(date);
		}
		kml.marshal(new File(Main.path_Out_Filters+"\\Filter_"+type+".kml"));
		System.out.println("Finish to create KML File");
	}
}
