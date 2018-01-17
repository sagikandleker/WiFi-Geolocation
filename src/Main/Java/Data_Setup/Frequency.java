package Data_Setup;

/**
 * Frequency Object.
 *
 */
public class Frequency {

	public int frequency;

	/**
	 * Object constructor.
	 * @param frequency
	 */
	public Frequency(int frequency) {
		this.frequency = frequency;
	}
	
	/**
	 * Object constructor.
	 * @param frequency
	 */
	public Frequency(Frequency frequency) {
		this.frequency = frequency.frequency;
	}
	
	/**
	 * String constructor.
	 * @param frequency
	 */
	public Frequency(String frequency) {
		this.frequency = Integer.parseInt(frequency);
	}

	/**
	 * Empty constructor.
	 */
	public Frequency() {
		this.frequency = 0;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getFrequency() {
		return frequency;
	}

	/**
	 * 
	 * @param frequency
	 */
	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	/**
	 * toString
	 */
	@Override
	public String toString() {
		return ""+frequency;
	}
	
}
