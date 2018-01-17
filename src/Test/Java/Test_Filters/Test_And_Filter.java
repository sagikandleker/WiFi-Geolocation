package Test_Filters;

import static org.junit.Assert.*;

import org.junit.Test;

import Data_Setup.Position;
import Filtering.ID_Filter;
import Filtering.Position_Filter;
import Filtering.Time_Filter;

public class Test_And_Filter {
	
	Time_Filter tfilter1 = new Time_Filter("2017-12-03 12:00", "2017-12-03 12:10");
	Time_Filter tfilter2 = new Time_Filter("", "");
	
	Position_Filter pfilter1 = new Position_Filter("39.01806582", "34.80988156", "0.005");
	Position_Filter pfilter2 = new Position_Filter("0", "0", "0");
	
	ID_Filter ifilter1 = new ID_Filter("Lenovo_91");
	ID_Filter ifilter2 = new ID_Filter("");
	

	@Test
	public void testDirect() {
		
		if(!(tfilter2.getStart().equalsIgnoreCase("") && tfilter2.getEnd().equalsIgnoreCase("")))
			fail("JUnit fail: Somthing is wrong with the testDirect equalsIgnoreCase");
		
		if(!(pfilter2.getLat() == 0 && pfilter2.getLon() == 0 && pfilter2.getRadius() == 0))
			fail("JUnit fail: Somthing is wrong with the testDirect equalsIgnoreCase");
		
		if(!(ifilter2.getNameOfDevice().equalsIgnoreCase("")))
			fail("JUnit fail: Somthing is wrong with the testDirect equalsIgnoreCase");
	}

}
