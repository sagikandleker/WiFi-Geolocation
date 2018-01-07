package Filtering;

import java.text.ParseException;
import Data_Setup.Record;
import Main_App.Write_2_CSV;;

/**
 * Filtering by ID Device.
 *
 */
public class ID_Filter {
	
	private String nameOfDevice;
	
	public ID_Filter(String id) {
		this.nameOfDevice = id;
	}
	
	/**
	 * 
	 * @param id
	 * @throws ParseException
	 */
	public static void idFilter(ID_Filter id) throws ParseException {
		
		Write_2_CSV.All_Data_List.stream()
		.filter(p -> p.getid().equalsIgnoreCase(id.nameOfDevice))
		.forEach(p -> Filter.id_data.add(new Record(p.getDate(), p.getPosition(), p.getWifiList())));
		
	}
}
