package Filtering;


import Data_Setup.Record;
import Main_App.Write_2_CSV;

/**
 * Filtering by Lat and Lon by radius.
 *
 */
public class Position_Filter {

	private String lat, lon, radius;

	public Position_Filter(String lat, String lon, String radius) {
		this.lat = lat;
		this.lon = lon;
		this.radius = radius;
	}

	/**
	 * 
	 * @param position
	 */
	public static void positionFilter(Position_Filter position) {

		double latD = Double.parseDouble(position.lat);
		double lonD = Double.parseDouble(position.lon);
		double tempR = Double.parseDouble(position.radius);

		Write_2_CSV.All_Data_List.stream()
		.forEach(p -> {if(distance(latD, lonD, p.getPosition().getLat(), p.getPosition().getLon()) <= tempR)
			Filter.position_data.add(new Record(p.getDate(), p.getPosition(), p.getWifiList()))
			;
		else {
			return;

		}
		});
		
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
