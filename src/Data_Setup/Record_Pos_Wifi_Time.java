package Data_Setup;

import java.util.ArrayList;
import java.util.Date;

public class Record_Pos_Wifi_Time {

	private Position position;
	private Wifi wifi;
	private Time time;
	
	
	public Record_Pos_Wifi_Time() {
		this.position = new Position();
		this.wifi = new Wifi();
		this.time = new Time();
	}
	
	public Record_Pos_Wifi_Time(Position position, Wifi wifi, Time time) {
		this.position = position;
		this.wifi = wifi;
		this.time = time;
	}
	
	
	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Wifi getWifi() {
		return wifi;
	}

	public void setWifi(Wifi wifi) {
		this.wifi = wifi;
	}
	
	public Time getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = new Time(time);
	}

	@Override
	public String toString() {
		return wifi + "," + position + "," + time;
	}
	
	/**
	 *  sort_Signal_Power sorting the list from the stronger signal to the lower.
	 */
	public static ArrayList<Record_Pos_Wifi_Time> sort_Signal_Power(ArrayList<Record_Pos_Wifi_Time> pas)
	{
		
			for (int i = 0; i < pas.size(); i++)
			{
				for (int j = 0; j < pas.size(); j++)
				{
					if((pas.get(i).getWifi().getSignal()>pas.get(j).getWifi().getSignal()))
					{
						Record_Pos_Wifi_Time temp;
						temp=pas.get(i);
						pas.set(i, pas.get(j));
						pas.set(j, temp);
					}
				}
			}
			
			if(pas.size() >= 4) {
			ArrayList<Record_Pos_Wifi_Time> four_pos = new ArrayList<Record_Pos_Wifi_Time>();
			
			for (int k = 0; k < 4; k++)
			{
				four_pos.add(pas.get(k));
			}
			return four_pos;
		}

		else {
			return pas;
		}
	}
	
}
