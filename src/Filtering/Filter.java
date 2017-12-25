package Filtering;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Filter {
	private static final Scanner sc = new Scanner(System.in);
	String Filter;

	public Filter() {
		System.out.println("Select a filter you'd like to search for: ID/Time/Position");
		Filter = sc.nextLine();
	}

	public void ChooseFilter() throws IOException, ParseException
	{
		
		if(Filter.equalsIgnoreCase("ID")) {
			System.out.println("Enter the ID: ");
			String ID = sc.nextLine();
			ID_Filter.idFilter(ID);
		}

		else if(Filter.equalsIgnoreCase("Position"))
		{
			System.out.println("Enter the LAT: ");
			double Lat = sc.nextDouble();
			System.out.println("Enter the LON: ");
			double Lon = sc.nextDouble();
			System.out.println("Enter the RADIUS: ");
			double Radius = sc.nextDouble();
			Position_Filter.positionFilter(Lat, Lon, Radius);
		}
		else if(Filter.equalsIgnoreCase("Time")){
			{
				System.out.println("Enter start Date and Time (For Example: yyyy-mm-dd hh:mm:ss like this way 2017-10-27 14:23:00)");
				String Time_begin = sc.nextLine();
				System.out.println("Enter end Date and Time (For Example: yyyy-mm-dd hh:mm:ss like this way 2017-10-27 14:23:00)");
				String Time_end = sc.nextLine();
				Time_Filter.timeFilter(Time_begin,Time_end);

			}
		}
		sc.close();
	}

}