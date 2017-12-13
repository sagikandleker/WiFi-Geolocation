package Data_Setup;


/**
 *  Position Build object with Alt, Lat, Lon.
 */

public class Position {
	
	public double lat, alt, lon;
	
	public Position(Position p) {
		this.alt = p.alt;
		this.lon = p.lon;
		this.lat = p.lat;
	}
	
	public Position() {
		this.alt = 0;
		this.lon = 0;
		this.lat = 0;
	}
	
	/**
	 *  Constructor build position with coordinates (alt, lon, lat)
	 */
	public Position(double alt, double lon, double lat) {
		this.alt = alt;
		this.lon = lon;
		this.lat = lat;
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

	@Override
	public String toString() {
		return lat + "," + lon + "," + alt;
	}
}
