package Data_Setup;

public class Record_Mac_Signal {

	private Signal signal;
	private Mac mac;
	
	public Record_Mac_Signal() {
		this.signal = new Signal();
		this.mac = new Mac("");
	}

	public Record_Mac_Signal(Mac mac, Signal signal) {
		this.signal = signal;
		this.mac = mac;
	}
	public Record_Mac_Signal(String mac, int signal) {
		this.signal.signal = signal;
		this.mac.mac = mac;
	}
	
	public Signal getSignal() {
		return signal;
	}

	public void setSignal(Signal signal) {
		this.signal = signal;
	}

	public Mac getMac() {
		return mac;
	}

	public void setMac(Mac mac) {
		this.mac = mac;
	}
	
}
