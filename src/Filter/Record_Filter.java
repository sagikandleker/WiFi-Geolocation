package Filter;

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

	@Override
	public String toString() {
		return date + ","+position + ","+id;
	}
}
