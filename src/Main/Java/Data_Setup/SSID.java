package Data_Setup;

/**
 * SSID Object (Example: BezeqFree).
 *
 */
public class SSID {

	public String ssid;

	/**
	 * 
	 * @param ssid
	 */
	public SSID(String ssid) {
		this.ssid = ssid;
	}
	
	/**
	 * 
	 * @param ssid
	 */
	public SSID(SSID ssid) {
		this.ssid = ssid.ssid;
	}
	
	/**
	 * Empty constructor.
	 */
	public SSID() {
		this.ssid = "";
	}

	/**
	 * 
	 * @return
	 */
	public String getSsid() {
		return ssid;
	}

	/**
	 * 
	 * @param ssid
	 */
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return ssid;
	}
	
}
