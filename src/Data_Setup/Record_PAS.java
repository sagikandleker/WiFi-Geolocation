package Data_Setup;

import java.util.ArrayList;

public class Record_PAS {
	public Position position;
	public Signal signal;
	
	public Record_PAS() {
		this.position = new Position(0,0,0);
		this.signal = new Signal(0);
	}
	
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
	
	
	/**
	 *  sort_Signal_Power sorting the list from the stronger signal to the lower.
	 */
	public static ArrayList<Record_PAS> sort_Signal_Power(ArrayList<Record_PAS> pas)
	{
		
		for (int i = 0; i < pas.size(); i++)
		{
			for (int j = 0; j < pas.size(); j++)
			{
				if((pas.get(i).getSignal().bigger(pas.get(j).getSignal())))
				{
					Record_PAS temp;
					temp=pas.get(i);
					pas.set(i, pas.get(j));
					pas.set(j, temp);
				}
			}
		}
		
		ArrayList<Record_PAS> four_pos = new ArrayList<Record_PAS>();
		for (int k = 0; k < 4; k++)
		{
			four_pos.add(pas.get(k));
		}
		return four_pos;
	}
}
