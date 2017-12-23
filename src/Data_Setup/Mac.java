package Data_Setup;

public class Mac {
	String mac;

	public Mac(String mac) {
		this.mac = mac;
	}
	
	public Mac(Mac mac) {
		this.mac = mac.mac;
	}
	
	public Mac() {
		this.mac = "";
	}

	public String getMac() {
		return mac;
	}


	public void setMac(Mac mac) {
		this.mac = mac.mac;
	}
	@Override
	public String toString() {
		return mac;
	}
	
	
}
