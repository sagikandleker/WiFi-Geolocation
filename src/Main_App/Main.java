package Main_App;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;


/**
 * @author Itay, Sagi & Guy.
 */

/**
 *  Choose folder from PC to read files.
 * Call functions to continue@.
 */

public class Main {
	
	public static final String path = "C:\\Users\\sagik\\git\\OOP\\";
	public static final String path_In = path+"Input_data\\";
	public static final String path_Out = path+"Output_data\\";
	public static final String path_In_Algorithms = path_In+"Algorithms\\";
	public static final String path_Out_Algorithms = path_Out+"Algorithms\\";
	public static final String path_In_WigleWifi = path_In+"WigleWifi";
	public static final String path_Out_WigleWifi = path_Out+"WigleWifi Merged\\";
	public static final String path_Out_Filters = path_Out+"Filters";
	public static final String WigleWifi_file_Out = path_Out_WigleWifi+"WigleWifi_Sorted.csv";
	public static final String Algo1_File_Out = path_Out_Algorithms+"Algorithm_1.csv";
	public static final String Algo2_File_Out = path_Out_Algorithms+"Algorithm_2.csv";

	public static void main(String[] args) throws IOException, ParseException {
	
		////Analayze_Files.getFiles();
		
		Scanner sc = new Scanner(System.in);
		String input_choice;
		System.out.println("What do you want to do next? Filter / Algorithm ?");
		input_choice=sc.nextLine();
		
		if(input_choice.equalsIgnoreCase("Filter")) {
			Filtering.Main_Filter.Choosefilter();
		}
		
		else if(input_choice.equalsIgnoreCase("Algorithm")) {	
			Algorithms.Algo_Main.ChooseAlgo();
		}
		sc.close();	
		
		System.out.println("Finish All");
			
	}
}