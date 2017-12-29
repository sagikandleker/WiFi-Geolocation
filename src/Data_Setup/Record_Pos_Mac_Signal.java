package Data_Setup;

public class Record_Pos_Mac_Signal {

	Position position;
	Mac mac;
	Signal signal;
	int line;
	
	//MAC1 - 3, 9, 15
	//MAC2 - 1, 3, 10
	//MAC3 - 3, 15, 29
	
	//[3(3) + 9(1) + 15(2)]
	
	public Record_Pos_Mac_Signal(Position position, Mac mac, Signal signal, int line) {
		this.position = position;
		this.mac = mac;
		this.signal = signal;
		this.line = line;
	}
	
	public Record_Pos_Mac_Signal() {
		this.position = new Position();
		this.mac = new Mac();
		this.signal = new Signal();
		this.line = -1;
		
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
		return "Record_Pos_Mac_Signal [position=" + position + ", mac=" + mac + ", signal=" + signal + ", line=" + line
				+ "]";
	}
	
	
}
