package Main_App;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;


public class Analayze_Files {

	/**
	 *  getFiles Call to Write_Headers function and check all the CSV files in the folder,
	 * and sending them to Analyze function.
	 */
	public static void getFiles() throws IOException, ParseException {
		Write_2_CSV.Write_Headers();
		File folder = new File(Main.path_In);
		String[] files_Names = folder.list();

		int counter = 0;
		for(int i = 0; i < files_Names.length; i++) {
			if(files_Names[i].startsWith("WigleWifi") && files_Names[i].endsWith(".csv")) {
				Read_From.wigle_File(Main.path_In+"/"+files_Names[i]);
				counter++;
			}	
		}	
		Write_2_CSV.Write();
		System.out.println(counter + " CSV files founded ["+Main.path_In+"]");
		if(counter != 0) {
			System.out.println("1 CSV has been created ["+Main.file_Out+"]\n");

		}
	}
}
