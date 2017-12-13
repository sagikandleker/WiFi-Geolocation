package Data_Setup;

public class Signal {

	int signal;

	public Signal(int signal) {

		this.signal = signal;
	}

	public int getSignal() {
		return signal;
	}

	public void setSignal(int signal) {
		this.signal = signal;
	}

	@Override
	public String toString() {
		return ""+signal;
	}
	
}
