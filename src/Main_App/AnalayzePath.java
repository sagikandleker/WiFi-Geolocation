package Main_App;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

/**
 * Analyze Folder.
 *
 */
public class AnalayzePath {

	/**
	 *  getFiles Call to Write_Headers function and check all the CSV files in the folder,
	 * and sending them to Analyze function.
	 */
	public static void getFiles(File folder) throws IOException, ParseException {

		String[] files_names = folder.list();

		for(int i = 0; i < files_names.length; i++) {
			if(files_names[i].startsWith("WigleWifi") && files_names[i].endsWith(".csv")) {
				File file = new File(folder+"/"+files_names[i]);
				Reading.WigleFile.read(file);

			}
		}

	}
}
