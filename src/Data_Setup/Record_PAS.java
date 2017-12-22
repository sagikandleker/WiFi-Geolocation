package Data_Setup;

import java.util.ArrayList;

public class Record_PAS {
	public Position position;
	public Signal signal;

	

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