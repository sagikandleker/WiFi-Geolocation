package Filtering;

import java.text.ParseException;
import Data_Setup.Record;
import Memory.Data_Structures;

/**
 * Filtering by ID Device.
 *
 */
public class ID_Filter {
	
	private String nameOfDevice;
	
	public ID_Filter(String id) {
		this.nameOfDevice = id;
	}
	
	public ID_Filter() {
		this.nameOfDevice = "";
	}
	
	public String getNameOfDevice() {
		return nameOfDevice;
	}

	public void setNameOfDevice(String nameOfDevice) {
		this.nameOfDevice = nameOfDevice;
	}


	/**
	 * 
	 * @param id
	 * @throws ParseException
	 */
	public static void idFilter(ID_Filter id) throws ParseException {
		
		Data_Structures.All_Data.stream()
		.filter(p -> p.getid().equalsIgnoreCase(id.nameOfDevice))
		.forEach(p -> Filter.id_data.add(new Record(p.getDate(), p.getPosition(), p.getWifiList())));
		
	}

	@Override
	public String toString() {
		return nameOfDevice;
	}
	
	
}
