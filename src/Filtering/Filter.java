package Filtering;


import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Filter {


	public void ChooseFilter(String Filter) throws IOException, ParseException
	{
		
		if(Filter.equalsIgnoreCase("ID")) {
			
			ID_Filter.idFilter(ID);
		}

		else if(Filter.equalsIgnoreCase("Position"))
		{
			System.out.println("Enter the LAT: ");

			System.out.println("Enter the LON: ");

			System.out.println("Enter the RADIUS: ");

			Position_Filter.positionFilter(Lat, Lon, Radius);
		}
		else if(Filter.equalsIgnoreCase("Time")){
			{
				System.out.println("Enter start Date and Time (For Example: yyyy-mm-dd hh:mm:ss like this way 2017-10-27 14:23:00)");
			
				System.out.println("Enter end Date and Time (For Example: yyyy-mm-dd hh:mm:ss like this way 2017-10-27 14:23:00)");
			
				Time_Filter.timeFilter(Time_begin,Time_end);

			}
		}
		
		
	}
}