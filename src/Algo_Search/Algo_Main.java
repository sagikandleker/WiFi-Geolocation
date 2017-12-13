package Algo_Search;

import java.io.IOException;
import java.util.Scanner;

public class Algo_Main {

	public static void ChooseAlgo() throws IOException {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String choice;
		System.out.println("Select an Algorithm you'd like to use: algo1 / algo2 ?");
		choice=sc.nextLine();
		if(choice.equalsIgnoreCase("algo1"))
		{
			String mac;
			System.out.println("Enter MAC: ");
			mac=sc.nextLine();
			String func;
			System.out.println("Select Naive / Better ?");
			func=sc.nextLine();
			if(func.equalsIgnoreCase("Naive"))Algorithm1.Naive(mac);
			else if(func.equalsIgnoreCase("Better"))Algorithm1.Better(mac);

		}
		//TODO else if for "algo2" user choice.
	}

}
