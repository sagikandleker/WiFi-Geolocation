
import java.io.IOException;
import java.text.ParseException;

/**
 * @author Itay, Sagi & Guy.
 */

/**
 *  Choose folder from PC to read files.
 * Call functions to continue.
 */

public class Main {
	static final String path = "C:\\Users\\itay1\\Desktop\\Project_OOP";
	static final String path_In = path+"/In";
	static final String path_Out= path+"/Out";
	static final String file_Out = path_Out+"/WigleWifi_Sorted.csv";
	
	public static void main(String[] args) throws IOException, ParseException {
		
		Files_2_CSV.getFiles();
		System.out.println("Finish");
	}
}