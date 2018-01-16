package Filtering;

import Data_Setup.Record;
import Memory.Data_Structures;

/**
 * Filtering by Lat and Lon by radius.
 *
 */
public class Position_Filter {

	private double lat, lon, radius;

	public Position_Filter(String lat, String lon, String radius) {
		this.lat = Double.parseDouble(lat);
		this.lon = Double.parseDouble(lon);
		this.radius = Double.parseDouble(radius);
	}

	public Position_Filter() {
		this.lat = 0;
		this.lon = 0;
		this.radius = 0;
	}



	public double getLat() {
		return lat;
	}



	public void setLat(double lat) {
		this.lat = lat;
	}



	public double getLon() {
		return lon;
	}



	public void setLon(double lon) {
		this.lon = lon;
	}



	public double getRadius() {
		return radius;
	}



	public void setRadius(double radius) {
		this.radius = radius;
	}


	/**
	 * 
	 * @param position
	 */
	public static void positionFilter(Position_Filter position) {

		double latD = position.lat;
		double lonD = position.lon;
		double tempR = position.radius;

		Data_Structures.All_Data.stream()
		.forEach(p -> {if(distance(latD, lonD, p.getPosition().getLat(), p.getPosition().getLon()) <= tempR)
			Filter.position_data.add(new Record(p.getDate(), p.getPosition(), p.getWifiList()));
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
	public static double distance(double lat1, double lon1, double lat2, double lon2) {
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



	@Override
	public String toString() {
		return lat + "," + lon + "," + radius;
	}	
}
