package Data_Setup;

/**
 * Signal Object (Example: -81).
 *
 */
public class Signal {

	public double signal;

	/**
	 * Empty constructor.
	 */
	public Signal() {
		this.signal = 0;
	}
	
	/**
	 * 
	 * @param signal
	 */
	public Signal(double signal) {

		this.signal = signal;
	}
	
	/**
	 * 
	 * @param signal
	 */
	public Signal(Signal signal) {

		this.signal = signal.signal;
	}
	
	/**
	 * 
	 * @param signal
	 */
	public Signal(String signal) {
		
		this.signal = Double.parseDouble(signal);
	}

	/**
	 * 
	 * @return
	 */
	public double getSignal() {
		return signal;
	}
	
	/**
	 * 
	 * @param signal
	 */
	public void setSignal(Signal signal) {
		this.signal = signal.signal;
	}

	/**
	 * Convert to double.
	 * @return
	 */
	public double cast()
	{
		return (double)signal;
	}
	
	/**
	 * toString
	 */
	@Override
	public String toString() {
		return ""+signal;
	}
	
}
