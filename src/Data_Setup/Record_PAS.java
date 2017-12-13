package Data_Setup;

public class Record_PAS {
	private Position position;
	private Signal signal;
	
	public Record_PAS(Position position, Signal signal) {
		this.position = position;
		this.signal = signal;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Signal getSignal() {
		return signal;
	}

	public void setSignal(Signal signal) {
		this.signal = signal;
	}

	@Override
	public String toString() {
		return position + "," + signal;
	}
	
}
