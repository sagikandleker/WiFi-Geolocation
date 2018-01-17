package Tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * AllTests Testing all the Testing Classes.
 */

	@RunWith(Suite.class)
	@SuiteClasses({ Test_Wifi.class, Test_Time.class, Test_Position.class, Test_Mac.class
		, Test_Record.class, Test_And_Filter.class, Test_Or_Filter.class, Test_Not_Filter.class
		, Test_Algorithm_1.class})
	
	
	public class Test_All {
		
		
	}
	
