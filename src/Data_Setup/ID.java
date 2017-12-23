package Data_Setup;

public class ID {

	public String id;

	public ID(String id) {
		this.id = id;
	}

	public ID() {
		this.id = "";
	}
	
	public ID(ID id) {
		this.id = id.id;
	}
	
	
	public String getID() {
		return id;
	}

	public void setID(String ID) {
		ID = id;
	}

	@Override
	public String toString() {
		return ""+id;
	}
}
