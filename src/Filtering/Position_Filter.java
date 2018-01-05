package Filtering;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import Data_Setup.Position;
import Data_Setup.SSID;
import Data_Setup.Time;
import Main_App.Write_2_CSV;

/**
 * Filtering by Lat and Lon by radius.
 *
 */
public class Position_Filter {

	public static void positionFilter(String lat, String lon,String radius) throws IOException, ParseException {

		for (int i = 0; i < Write_2_CSV.All_Data_List.size(); i++) {

			double templat = (Write_2_CSV.All_Data_List.get(i).getPosition().getLat());
			double templon = (Write_2_CSV.All_Data_List.get(i).getPosition().getLon());
			double tempRadius = Double.parseDouble(radius);
			double lat2 = Double.parseDouble(lat);
			double lon2 = Double.parseDouble(lon);

			if(distance(lat2,lon2,templat,templon) <= tempRadius) {

				Date d = new Date(Write_2_CSV.All_Data_List.get(i).getDate().getTime());
				Position position = Write_2_CSV.All_Data_List.get(i).getPosition();
				Time time = new Time(d);

				/**
				 * Loop to run inside the line.
				 */
				for (int k = 0; k < Write_2_CSV.All_Data_List.get(i).getWifiList().size(); k++) {

					SSID ssid = new SSID(Write_2_CSV.All_Data_List.get(i).getWifiList().get(k).getSsid());
					Record_Filter record = new Record_Filter(time, position, ssid);

					Filter.data.add(record);
				}
			}
		}
	}

	/**
	 * This function to calculating distance
	 * @param lat1
	 * @param lon1
	 * @param lat2
	 * @param lon2
	 * @return
	 */
	private static double distance(double lat1, double lon1, double lat2, double lon2) {
		double theta = lon1 - lon2;
		double dist = Math.sin(deg2rad(lat1))*Math.sin(deg2rad(lat2))+Math.cos(deg2rad(lat1))*Math.cos(deg2rad(lat2))*Math.cos(deg2rad(theta));
		dist = Math.acos(dist);
		dist = rad2deg(dist);
		dist = dist * 60 * 1.1515;
		dist = dist * 1.609344;

		return (dist)/100;
	}

	/**
	 * This function converts decimal degrees to radians.
	 * @param deg
	 * @return
	 */
	private static double deg2rad(double deg) {
		return (deg * Math.PI / 180.0);
	}

	/**
	 * This function converts radians to @decimal degrees.
	 * @param rad
	 * @return
	 */
	private static double rad2deg(double rad) {
		return (rad * 180 / Math.PI);
	}
}
