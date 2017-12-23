package Filtering;

import Data_Setup.ID;
import Data_Setup.Position;
import Data_Setup.Time;


public class Record_Filter {

	public Time date;
	public Position position;
	public ID id;
	
	
	public Record_Filter(Time date, Position position, ID id) {
		this.date = date;
		this.position = position;
		this.id = id;
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

	
	public String getId() {
		return id.getID();
	}


	public void setId(ID id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return date + ","+position + ","+id;
	}
}
