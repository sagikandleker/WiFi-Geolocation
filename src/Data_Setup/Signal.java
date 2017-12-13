package Data_Setup;

public class Signal {

	public int signal;

	public Signal() {
		this.signal = 0;
	}
	
	public Signal(int signal) {

		this.signal = signal;
	}

	public int getSignal() {
		return signal;
	}

	public void setSignal(int signal) {
		this.signal = signal;
	}

	public boolean bigger(Signal signal2)
	{
		if(this.signal>signal2.signal)return true;
		else
			return false;
	}
	
	
	
	@Override
	public String toString() {
		return ""+signal;
	}
	
}
