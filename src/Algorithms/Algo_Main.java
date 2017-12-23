package Algorithms;

import java.io.IOException;

import java.util.Scanner;


public class Algo_Main {

	public static void ChooseAlgo() throws IOException {
		Scanner sc = new Scanner(System.in);
		String choice;
		System.out.println("Select an Algorithm you'd like to use: Algorithm1 / Algorithm2");
		choice=sc.nextLine();

		if(choice.equalsIgnoreCase("Algorithm1"))
		{

			Algorithm1.Better();

		}
		sc.close();

		/*else if(choice.equalsIgnoreCase("algo2"))
		{
			ArrayList<Record_Mac_Signal> input = new ArrayList<Record_Mac_Signal>();
			String mac;
			int signal;
			for(int i=0;i<3;i++)
			{
				System.out.println("enter mac");
			}
		}
		sc.close();*/
	}

}