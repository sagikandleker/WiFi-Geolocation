package Data_Setup;

/**
 * Wifi Build object that called Wifi with 2 Strings (SSID, MAC) and 2 Integers (Signal, Frequency).
 */

public class Wifi {
	
	private SSID ssid;
	private Mac mac;
	private Signal signal;
	private Frequency frequency;
	
	/**
	 * Constructor build Wifi with - SSID, MAC, Frequency, Signal.
	 */
	
	public Wifi(SSID ssid, Mac mac, Frequency frequency, Signal signal) {
		this.signal = new Signal(signal);
		this.mac = new Mac(mac);
		this.ssid = new SSID(ssid);
		this.frequency = new Frequency(frequency);
	}
	
	public Wifi(String ssid, String mac, int frequency, int signal) {
		this.signal = new Signal(signal);
		this.mac = new Mac(mac);
		this.ssid = new SSID(ssid);
		this.frequency = new Frequency(frequency);
	}
	
	public Wifi() {
		this.signal = new Signal();
		this.mac = new Mac();
		this.ssid = new SSID();
		this.frequency = new Frequency();
	}


	public SSID getSsid() {
		return ssid;
	}

	public void setSsid(SSID ssid) {
		this.ssid = ssid;
	}

	public Mac getMac() {
		return mac;
	}

	public void setMac(Mac mac) {
		this.mac = mac;
	}

	public double getSignal() {
		return signal.getSignal();
	}
	
	
	public void setSignal(int signal) {
		this.signal.signal = signal;
	}

	public Frequency getFrequency() {
		return frequency;
	}

	public void setFrequency(Frequency frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return mac + "," + ssid + "," + frequency + "," + signal;
	}
}