package Filtering;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class Main_Filter {
//TODO Filter Object.
	public static void Choosefilter() throws ParseException, IOException
	{
		Filter f = new Filter();
		f.ChooseFilter();
		
		
		/*Scanner sc = new Scanner(System.in);
		System.out.println("Select a filter you'd like to search for: ID/Time/Position");
		String Filter_input = sc.nextLine();
		if(Filter_input.equalsIgnoreCase("ID"))
		{
			System.out.println("Enter the ID: ");
			String ID_input = sc.nextLine();
			ID_Filter.idfilter(ID_input);
		}
		else if(Filter_input.equalsIgnoreCase("Position"))
		{
			System.out.println("Enter the LAT: ");
			double Lat_input = sc.nextDouble();
			System.out.println("Enter the LON: ");
			double Lon_input = sc.nextDouble();
			System.out.println("Enter the RADIUS: ");
			double Radius_input = sc.nextDouble();
			Position_Filter.Positionfilter(Lat_input, Lon_input,Radius_input);
		}
		else if(Filter_input.equalsIgnoreCase("Time")){
			{
				System.out.println("Enter start Date and Time (For Example: yyyy-mm-dd hh:mm:ss like this way 2017-10-27 14:23:00)");
				String Time_begin = sc.nextLine();
				System.out.println("Enter end Date and Time (For Example: yyyy-mm-dd hh:mm:ss like this way 2017-10-27 14:23:00)");
				String Time_end = sc.nextLine();
		 		Time_Filter.timefilter(Time_begin,Time_end);
		
			}
			
		}
		sc.close();*/
	}

}
