package Filtering;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import Data_Setup.Record;
import Memory.Data_Structures;


public class And_Filter {

	public static void direct(Time_Filter tfilter, Position_Filter pfilter, ID_Filter ifilter) throws ParseException {

		if((tfilter.getStart().equalsIgnoreCase("") && tfilter.getEnd().equalsIgnoreCase(""))) {

			Pos_And_ID(pfilter, ifilter);
		}
		else if(pfilter.getLat() == 0 && pfilter.getLon() == 0 && pfilter.getRadius() == 0) {

			Time_And_ID(tfilter, ifilter);
		}
		
		else if(ifilter.getNameOfDevice().equalsIgnoreCase("")) {
			
			Time_And_Pos(tfilter, pfilter);
		}
		
		else {
			
			Time_And_Pos_And_ID(tfilter, pfilter, ifilter);
		}

	}

	public static void Time_And_ID(Time_Filter tfilter, ID_Filter ifilter) throws ParseException {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date d1 = format.parse(tfilter.getStart());
		Date d2 = format.parse(tfilter.getEnd());

		Data_Structures.All_Data.stream()
		.forEach(p -> { if(p.getid().equalsIgnoreCase(ifilter.getNameOfDevice())
				&& (p.getDate().after(d1) && p.getDate().before(d2))) 
			Filter.filters_data.add(new Record(p.getDate(), p.getPosition(), p.getWifiList()));
		else {
			return;
		}
		});
	}


	public static void Time_And_Pos(Time_Filter tfilter, Position_Filter pfilter) throws ParseException {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date d1 = format.parse(tfilter.getStart());
		Date d2 = format.parse(tfilter.getEnd());

		double latD = pfilter.getLat();
		double lonD = pfilter.getLon();
		double tempR = pfilter.getRadius();

		Data_Structures.All_Data.stream()
		.forEach(p -> { if(p.getDate().after(d1) && p.getDate().before(d2)
				&& (Position_Filter.distance(latD, lonD, p.getPosition().getLat(), p.getPosition().getLon()) <= tempR))
			Filter.filters_data.add(new Record(p.getDate(), p.getPosition(), p.getWifiList()));
		else {
			return;
		}
		});
	}



	public static void Pos_And_ID(Position_Filter pfilter, ID_Filter ifilter) {

		double latD = pfilter.getLat();
		double lonD = pfilter.getLon();
		double tempR = pfilter.getRadius();

		Data_Structures.All_Data.stream()
		.forEach(p -> { if(p.getid().equalsIgnoreCase(ifilter.getNameOfDevice())
				&& (Position_Filter.distance(latD, lonD, p.getPosition().getLat(), p.getPosition().getLon()) <= tempR))
			Filter.filters_data.add(new Record(p.getDate(), p.getPosition(), p.getWifiList()));
		else {
			return;
		}
		});
	}


	public static void Time_And_Pos_And_ID(Time_Filter tfilter, Position_Filter pfilter, ID_Filter ifilter) throws ParseException {

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date d1 = format.parse(tfilter.getStart());
		Date d2 = format.parse(tfilter.getEnd());

		double latD = pfilter.getLat();
		double lonD = pfilter.getLon();
		double tempR = pfilter.getRadius();


		Data_Structures.All_Data.stream()
		.forEach(p -> { if(p.getid().equalsIgnoreCase(ifilter.getNameOfDevice())
				&& (p.getDate().after(d1) && p.getDate().before(d2)) 
				&& (Position_Filter.distance(latD, lonD, p.getPosition().getLat(), p.getPosition().getLon()) <= tempR))
			Filter.filters_data.add(new Record(p.getDate(), p.getPosition(), p.getWifiList()));
		else {
			return;
		}
		});
	}
}
