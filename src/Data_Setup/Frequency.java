package Data_Setup;

public class Frequency {

	public int frequency;

	public Frequency(int frequency) {
		this.frequency = frequency;
	}
	
	public Frequency(Frequency frequency) {
		this.frequency = frequency.frequency;
	}

	public Frequency() {
		this.frequency = 0;
	}
	
	public int getFrequency() {
		return frequency;
	}

	public void setFrequency(int frequency) {
		this.frequency = frequency;
	}

	@Override
	public String toString() {
		return ""+frequency;
	}
	
}
