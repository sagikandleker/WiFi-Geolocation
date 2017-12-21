package Algo_Search;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Data_Setup.Record_Mac_Signal;

public class Algo_Main {

	public static void ChooseAlgo() throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String choice;
		System.out.println("Select an Algorithm you'd like to use: algo1 / algo2 ?");
		choice=sc.nextLine();
		if(choice.equalsIgnoreCase("algo1"))
		{
			String mac;
			System.out.println("Enter MAC: ");
			mac=sc.nextLine();
			Algorithm1.Better(mac);

		}
		else if(choice.equalsIgnoreCase("algo2"))
		{
			ArrayList<Record_Mac_Signal> input=new ArrayList<Record_Mac_Signal>();
			String mac;
			int signal;
			for(int i=0;i<3;i++)
			{
				System.out.println("enter mac");
			}
		}
		sc.close();
	}

}