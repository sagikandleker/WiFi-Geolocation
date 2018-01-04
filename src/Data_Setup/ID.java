package Data_Setup;

/**
 * ID Object (Example: SM-G950F).
 *
 */
public class ID {

	public String id;

	/**
	 * 
	 * @param id
	 */
	public ID(String id) {
		this.id = id;
	}

	/**
	 * Empty constructor.
	 */
	public ID() {
		this.id = "";
	}
	
	/**
	 * 
	 * @param id
	 */
	public ID(ID id) {
		this.id = id.id;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getID() {
		return id;
	}

	/**
	 * 
	 * @param id
	 */
	public void setID(ID id) {
		this.id = id.id;
	}
	
	/**
	 * toString
	 */
	@Override
	public String toString() {
		return ""+id;
	}
}
