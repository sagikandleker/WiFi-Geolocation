package Data_Setup;

/**
 * Wifi Build object that called Wifi with 2 Strings (SSID, MAC) and 2 Integers (Signal, Frequency).
 */

public class Wifi {
	
	private String ssid;
	private String mac;
	private int signal;
	private int frequency;
	
	/**
	 * Constructor build Wifi with - SSID, MAC, Frequency, Signal.
	 */
	public Wifi(String ssid, String mac, int frequency, int signal) {
		this.signal = signal;
		this.mac = mac;
		this.ssid = ssid;
		this.frequency = frequency;
	}

	/**
	 * @return the ssid
	 */
	public String getSsid() {
		return ssid;
	}


	/**
	 * @param ssid the ssid to set
	 */
	public void setSsid(String ssid) {
		this.ssid = ssid;
	}


	/**
	 * @return the mac
	 */
	public String getMac() {
		return mac;
	}


	/**
	 * @param mac the mac to set
	 */
	public void setMac(String mac) {
		this.mac = mac;
	}


	/**
	 * @return the signal
	 */
	public int getSignal() {
		return signal;
	}


	/**
	 * @param signal the signal to set
	 */
	public void setSignal(int signal) {
		this.signal = signal;
	}
	
	/**
	 * @return the frequency
	 */
	public int getFrequency() {
		return frequency;
	}

	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return ssid + "," + mac + "," + frequency + "," + signal;
	}
}

