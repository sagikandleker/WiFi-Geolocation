package Data_Setup;


/**
 *  Position Object with Alt, Lon, Lat. (Example: 32.102533, 35.20726399, 699.2877605).
 */

public class Position {
	
	public double lat, alt, lon;
	
	/**
	 * 
	 * @param p
	 */
	public Position(Position p) {
		this.alt = p.alt;
		this.lon = p.lon;
		this.lat = p.lat;
	}
	
	/**
	 * Empty constructor.
	 */
	public Position() {
		this.alt = 0;
		this.lon = 0;
		this.lat = 0;
	}
	
	/**
	 *  Constructor build position with coordinates (alt, lon, lat).
	 */
	public Position(double alt, double lon, double lat) {
		this.alt = alt;
		this.lon = lon;
		this.lat = lat;
	}
	
	/**
	 * 
	 * @param alt
	 * @param lon
	 * @param lat
	 */
	public Position(String alt, String lon, String lat) {
		this.alt = Double.parseDouble(alt);
		this.lon = Double.parseDouble(lon);
		this.lat = Double.parseDouble(lat);
	}

	/**
	 * @return the alt
	 */
	public double getAlt() {
		return alt;
	}

	/**
	 * @param alt the alt to set
	 */
	public void setAlt(double alt) {
		this.alt = alt;
	}

	/**
	 * @return the lon
	 */
	public double getLon() {
		return lon;
	}

	/**
	 * @param lon the lon to set
	 */
	public void setLon(double lon) {
		this.lon = lon;
	}

	/**
	 * @return the lat
	 */
	public double getLat() {
		return lat;
	}

	/**
	 * @param lat the lat to set 
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}

	/**
	 * compare return true if equal check 2 positions   
	 */
	public boolean compare(Position p) {
		if(this.lat == p.lat && this.lon == p.lon && this.alt == p.alt) return true;
			return false;	
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return lat + "," + lon + "," + alt;
	}
}
