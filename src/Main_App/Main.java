package Main_App;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import Algorithms.Mac_Hashmap;

/**
 * @author Itay, Sagi & Guy.
 */

/**
 *  Choose folder from PC to read files.
 * Call functions to continue@.
 */

public class Main {
	
	public static final String path = "C:\\Users\\sagik\\git\\OOP";
	public static final String path_In = path+"\\Files read from";
	public static final String path_Out = path+"\\Files create to";
	public static final String file_Out = path_Out+"\\WigleWifi_Sorted.csv";
	public static final String Algo1_Out = path_Out+"\\Algorithm1.csv";
	public static final String Algo2_Out = path_Out+"\\Algorithm2.csv";

	public static void main(String[] args) throws IOException, ParseException {
		
		Analayze_Files.getFiles();
		
		
		Scanner sc = new Scanner(System.in);
		String input_choice;
		System.out.println("What do you want to do next? Filter / Algorithm ?");
		input_choice=sc.nextLine();
		
		if(input_choice.equalsIgnoreCase("Filter")) {
			Filtering.Main_Filter.Choosefilter();
		}
		
		else if(input_choice.equalsIgnoreCase("Algorithm")) {	
			Mac_Hashmap.Build_Hash();
			Algorithms.Algo_Main.ChooseAlgo();
		}
		sc.close();	
		
		System.out.println("Finish All");
			
	}
}