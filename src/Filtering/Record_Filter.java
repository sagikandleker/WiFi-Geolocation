package Filtering;

import Data_Setup.Position;
import Data_Setup.SSID;
import Data_Setup.Time;


public class Record_Filter {

	public Time date;
	public Position position;
	public SSID ssid;
	
	
	public Record_Filter(Time date, Position position, SSID ssid) {
		this.date = date;
		this.position = position;
		this.ssid = ssid;
	}
	
	
	public Time getDate() {
		return date;
	}


	public void setDate(Time date) {
		this.date = date;
	}


	public Position getPosition() {
		return position;
	}


	public void setPosition(Position position) {
		this.position = position;
	}

	
	public String getSsid() {
		return ssid.getSsid();
	}


	public void Ssid(SSID ssid) {
		this.ssid = ssid;
	}


	@Override
	public String toString() {
		return date + ","+position + ","+ssid;
	}
}
