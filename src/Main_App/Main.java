package Main_App;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import Algo_Search.Algorithm1;

/**
 * @author Itay, Sagi & Guy.
 */

/**
 *  Choose folder from PC to read files.
 * Call functions to continue@.
 */

public class Main {
	public static final String path = "C:\\Users\\sagik\\git\\OOP";
	public static final String path_In = path+"/Files read from";
	public static final String path_Out= path+"/Files create to";
	public static final String file_Out = path_Out+"/WigleWifi_Sorted.csv";

	public static void main(String[] args) throws IOException, ParseException {
		Files_2_CSV.getFiles();
		
		Scanner sc = new Scanner(System.in);
		String input_choice;
		System.out.println("What do you want to do next? KML / Algo ?");
		input_choice=sc.nextLine();
		if(input_choice.equalsIgnoreCase("KML")) Filter.Main_Filter.Choosefilter();
		else if(input_choice.equalsIgnoreCase("Algo")) Algo_Search.Algo_Main.ChooseAlgo();
		sc.close();	
		
		
		System.out.println("Finish All");
		
				
	}
}