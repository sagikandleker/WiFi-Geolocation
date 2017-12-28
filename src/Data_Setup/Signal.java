package Data_Setup;

public class Signal {

	public double signal;

	public Signal() {
		this.signal = 0;
	}
	
	public Signal(int signal) {

		this.signal = signal;
	}
	
	public Signal(Signal signal) {

		this.signal = signal.signal;
	}
	
	public Signal(String signal) {
		
		this.signal = Double.parseDouble(signal);
	}


	public Signal(double signal) {
		this.signal = (int)signal;
	}

	public double getSignal() {
		return signal;
	}

	public void setSignal(Signal signal) {
		this.signal = signal.signal;
	}

	
	public double cast()
	{
		return (double)signal;
	}
	
	@Override
	public String toString() {
		return ""+signal;
	}
	
}
