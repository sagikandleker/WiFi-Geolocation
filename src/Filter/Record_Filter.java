package Filter;

import Data_sets.ID;
import Data_sets.Position;
import Data_sets.Time;


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
