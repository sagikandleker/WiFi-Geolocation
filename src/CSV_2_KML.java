import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;


import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;

/**
 *  CSV_2_KML Take the CSV file that we built and create KML file with coordinates, time and network name with API.
 */

public class CSV_2_KML {

		public static void KML() throws IOException, ParseException {
			File csv = new File(Main.file_Out);
			final Kml kml = new Kml();
			Document doc = kml.createAndSetDocument();
		
			FileReader fr=new FileReader(csv);
			@SuppressWarnings("resource")
			BufferedReader br=new BufferedReader(fr);
			
			String str = br.readLine();	
			double lat,lon,alt;
			
			str = br.readLine();
			while(str != null)
			{
				String[] srr=str.split(",");
				lat=Double.parseDouble((srr[2].trim()));
				lon=Double.parseDouble((srr[3].trim()));
				alt=Double.parseDouble((srr[4].trim()));
				
				String date =(srr[0]);	
				 Placemark place =  doc.createAndAddPlacemark().withName(srr[6])
				            .withOpen(Boolean.TRUE);
				    place.createAndSetPoint().addToCoordinates(lon,lat,alt);
				    date = date.replace(' ', 'T')+'Z';
				    place.createAndSetTimeStamp().setWhen(date);
				str = br.readLine();
			
			}
			//marshals into file
			kml.marshal(new File(Main.path_Out+"/Wifi_Connections.kml"));
			System.out.println("KML has been Created");
		}
	}


