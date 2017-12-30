package Data_Setup;

public class Record_Pos_Mac_Signal {

	Position position;
	Mac mac;
	Signal signal;
	int line;
	
	public Record_Pos_Mac_Signal(int line, Position position, Mac mac, Signal signal) {
		this.line = line;
		this.position = position;
		this.mac = mac;
		this.signal = signal;
	
	}
	
	public Record_Pos_Mac_Signal() {
		this.line = -1;
		this.position = new Position();
		this.mac = new Mac();
		this.signal = new Signal();
		
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Mac getMac() {
		return mac;
	}

	public void setMac(Mac mac) {
		this.mac = mac;
	}

	public Signal getSignal() {
		return signal;
	}

	public void setSignal(Signal signal) {
		this.signal = signal;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	@Override
	public String toString() {
		return line + "," + position + "," + mac + "," + signal;
	}
	
	
}
