package Data_Setup;

public class SSID {

	public String ssid;

	public SSID(String ssid) {
		this.ssid = ssid;
	}
	
	public SSID(SSID ssid) {
		this.ssid = ssid.ssid;
	}
	
	public SSID() {
		this.ssid = "";
	}

	public String getSsid() {
		return ssid;
	}

	public void setSsid(String ssid) {
		this.ssid = ssid;
	}

	@Override
	public String toString() {
		return ssid;
	}
	
}
