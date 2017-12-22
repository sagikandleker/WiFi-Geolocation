package Data_Setup;

import java.util.ArrayList;

public class Record_Pos_Signal {

	public Position position;
	public Signal signal;
	
	public Record_Pos_Signal() {
		this.position = new Position();
		this.signal = new Signal();
	}
	
	/*public Record_Pos_Signal() {
		this.position = new Position(0,0,0);
		this.signal = new Signal(0);
	}*/
	
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
	
	/**
	 *  sort_Signal_Power sorting the list from the stronger signal to the lower.
	 */
	public static ArrayList<Record_Pos_Signal> sort_Signal_Power(ArrayList<Record_Pos_Signal> pas)
	{
		
			for (int i = 0; i < pas.size(); i++)
			{
				for (int j = 0; j < pas.size(); j++)
				{
					if((pas.get(i).getSignal().bigger(pas.get(j).getSignal())))
					{
						Record_Pos_Signal temp;
						temp=pas.get(i);
						pas.set(i, pas.get(j));
						pas.set(j, temp);
					}
				}
			}
			
			if(pas.size() >= 3) {
			ArrayList<Record_Pos_Signal> three_pos = new ArrayList<Record_Pos_Signal>();
			
			for (int k = 0; k < 3; k++)
			{
				three_pos.add(pas.get(k));
			}
			return three_pos;
		}

		else {
			return pas;
		}
	}
	
}
