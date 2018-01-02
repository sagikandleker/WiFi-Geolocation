package Algorithms;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import Main_App.Main;
import Main_App.Read_From;
import Main_App.Write_2_CSV;

public class Algo_Main {
	/**
	 * Choose between algo1 to algo2 and call function.
	 * 
	 * 
	 * @since 2018
	 */

	public static final String path_comb = Main.path_In_Algorithms+"BM2\\Comb\\_comb_all_BM2_.csv";
	public static final String path_nogps = Main.path_In_Algorithms+"BM2\\Comb\\_comb_no_gps_ts1.csv";
	/**
	 * write string input and check which algo to call 1 or 2.
	 *
	 * @param string input choice 
	 */
	public static void ChooseAlgo() throws IOException, ParseException {
		Scanner sc = new Scanner(System.in);
		String choice;
		System.out.println("Select an Algorithm you'd like to use: Algorithm1 / Algorithm2");
		choice=sc.nextLine();

		if(choice.equalsIgnoreCase("Algorithm1"))
		{
			Mac_Hashmap.Build_Hash(Write_2_CSV.All_Data_List, "Algo1");
			Algorithm_1.Better();

		}
		sc.close();

		if(choice.equalsIgnoreCase("Algorithm2"))
		{
	
			Algorithm_2.no_gps_lines(Mac_Hashmap.Build_Hash((Read_From.comb_File(path_comb)), "Algo2"),Read_From.nogps_File(path_nogps));
		
		}
		sc.close();
	}

}