package Filtering;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


import Data_Setup.Record;
import Main_App.Write_2_CSV;


public class ChooseBetweenFilter {

	public Position_Filter p_f;
	public ID_Filter i_f;
	public Time_Filter t_f;


	public ChooseBetweenFilter(Position_Filter p_f,ID_Filter i_f,Time_Filter t_f)
	{
		this.p_f = p_f;
		this.i_f = i_f;
		this.t_f = t_f;
	}

	public static void OrFilter(Position_Filter p_f,ID_Filter i_f,Time_Filter t_f) throws ParseException
	{
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		
		
		System.out.println("Position: "+p_f);
		System.out.println("ID: "+i_f);
		System.out.println("Time: "+t_f);

		if(!(t_f == null)){
			System.out.println("ERROR!");
			Date d1 = format.parse(t_f.getStart());
			Date d2 = format.parse(t_f.getEnd());
		}
		
		System.out.println("ERROR?");
		String ds = "2017-12-03 08:37:10";
		String de = "2017-12-03 08:40:10";
		Date d1 = format.parse(ds);
		Date d2 = format.parse(de);
		
		System.out.println("Position: "+p_f);
		System.out.println("ID: "+i_f);
		System.out.println("Time: "+t_f);



		double latD = Double.parseDouble(p_f.getLat());
		double lonD = Double.parseDouble(p_f.getLon());
		double tempR = Double.parseDouble(p_f.getRadius());

		Write_2_CSV.All_Data_List.stream()
		.forEach(p -> { if(p.getid().equalsIgnoreCase(i_f.getNameOfDevice())
				&& (p.getDate().after(d1) && p.getDate().before(d2)) 
				&& (Position_Filter.distance(latD, lonD, p.getPosition().getLat(), p.getPosition().getLon()) <= tempR))
			Filter.and_data.add(new Record(p.getDate(), p.getPosition(), p.getWifiList()));
		else {
			return;
		}
		});
		

	}
}
