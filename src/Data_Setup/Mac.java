package Data_Setup;

/**
 * Mac Object.
 *
 */
public class Mac {
	String mac;

	/**
	 * 
	 * @param mac
	 */
	public Mac(String mac) {
		this.mac = mac;
	}
	
	/**
	 * 
	 * @param mac
	 */
	public Mac(Mac mac) {
		this.mac = mac.mac;
	}
	
	/**
	 * Empty constructor.
	 */
	public Mac() {
		this.mac = "";
	}

	/**
	 * 
	 * @return
	 */
	public String getMac() {
		return mac;
	}

	/**
	 * 
	 * @param mac
	 */
	public void setMac(Mac mac) {
		this.mac = mac.mac;
	}
	
	/**
	 * compare Mac vs Mac.
	 * @param m
	 * @return
	 */
	public boolean compare(Mac m)
	{
		if((this.mac.equalsIgnoreCase(m.getMac())))
		{
			return true;
		}
		return false;
	}
	
	/**
	 * toString
	 */
	@Override
	public String toString() {
		return mac;
	}
	
	
}
