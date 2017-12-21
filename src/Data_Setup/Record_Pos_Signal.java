package Data_Setup;

public class Record_Pos_Signal {

	Position position;
	Signal signal;
	
	public Record_Pos_Signal() {
		this.position = new Position();
		this.signal = new Signal();
	}
	
	public Record_Pos_Signal(Position position, Signal signal) {
		this.position = position;
		this.signal = signal;
	}
	
	public Record_Pos_Signal(Position position, int signal) {
		this.position = position;
		this.signal.signal = signal;
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
