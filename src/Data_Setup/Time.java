package Data_Setup;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Time build time from java.util.Date.
 */

public class Time {
	
	Date time;
	
	DateFormat TimeFormater = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public Time(Date time) {
		this.time = time;
	}
	public Time(Time time) {
		this.time = time.time;
	}
	public Time() {
		this.time = new Date();
	}

	/**
	 * @return the time
	 */
	public Date getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(Time time) {
		this.time = time.time;
	}
	
	/**
	 *  compare check if 2 times are equals.
	 */
	public boolean compare(Time t) {
		if(this.time.compareTo(t.time)==0) return true;
			return false;
	}
	
	@Override
	public String toString() {
		return TimeFormater.format(time);
	}

	
}

