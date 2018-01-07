package Filtering;

import Data_Setup.Record;

public class Or_Filter{

	private Filter _f1, _f2;
	
	public Or_Filter(Filter f1, Filter f2) {
		_f1 = f1;
		_f2 = f2;
	}
	
	public boolean test(Record rec) {
		return _f1.test(rec) || _f2.test(rec);
	}
	
	public String toString() {
		return "("+_f1+" or "+_f2+")";
	}
}
