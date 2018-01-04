package GUI;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import Algorithms.Algo_Main;
import Data_Setup.Mac;
import Data_Setup.Position;
import Data_Setup.Record_Mac_Signal;
import Data_Setup.Signal;
import Filtering.Filter;
import Filtering.ID_Filter;
import Filtering.Position_Filter;
import Filtering.Time_Filter;
import Main_App.Analayze_Files;
import Main_App.Read_From;
import Main_App.Write_2_CSV;
import Main_App.Write_2_KML;

public class GUI_Wrapper {

	//private static final String DefaultTableModel = null;
	public static File folder=new File("");
	public static File file = new File("");
	public static File nogpsfile = new File("");
	public static File combfile = new File("");
	public static File savefile = new File("");
	public static File algorithm1 = new File("");
	public static File algorithm2 = new File("");


	public static void choosefolder() throws IOException, ParseException
	{
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Browse the folder to process");
		chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		chooser.setAcceptAllFileFilterUsed(false);

		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {

		} else {
			System.out.println("No Selection");
		}

		folder = chooser.getSelectedFile();

		if (!folder.isDirectory()) {
			folder = folder.getParentFile();
		}

		Analayze_Files.getFiles(folder);

	}

	public static void chooseCSVFile(String name) throws IOException, ParseException {

		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV (Comma delimited) (*.csv)", "csv","CSV");
		chooser.setFileFilter(filter);
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle("Browse the folder to process");
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);


		if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
		} else {
			System.out.println("No Selection ");
		}
		if(name.equalsIgnoreCase("mainfile"))
		{
			file = chooser.getSelectedFile();
			Read_From.wigle_File(file);
		}
		else if(name.equalsIgnoreCase("nogpsfile"))
		{
			nogpsfile = chooser.getSelectedFile();

		}
		else if(name.equalsIgnoreCase("combfile"))
		{
			combfile = chooser.getSelectedFile();

		}
	}

	public static void clearData() {

		Write_2_CSV.clearData();

	}

	public static void saveTOCSV(String name) throws IOException, ParseException {


		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV (Comma delimited) (*.csv)", "csv","CSV");
		fileChooser.setFileFilter(filter);
		fileChooser.setCurrentDirectory(new java.io.File("."));
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

			if(name.equalsIgnoreCase("WigleSorted")) {
				savefile = fileChooser.getSelectedFile();
				Write_2_CSV.Write(savefile+".csv");		
			}
			else if(name.equalsIgnoreCase("Algo1")) {
				algorithm1 = fileChooser.getSelectedFile();
				Algo_Main.ChooseAlgo1();
			}

			else if(name.equalsIgnoreCase("Algo2")) {
				algorithm2 = fileChooser.getSelectedFile();
				Algo_Main.ChooseAlgo2();
			}
		}
	}

	public static void saveTOKML(String name) throws IOException {

		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("KML File", "kml","KML");
		fileChooser.setFileFilter(filter);
		fileChooser.setCurrentDirectory(new java.io.File("."));
		fileChooser.setAcceptAllFileFilterUsed(false);
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {

			if(name.equalsIgnoreCase("allData")) {
				savefile = fileChooser.getSelectedFile();
				Write_2_KML.KML(Write_2_CSV.All_Data_List, savefile+".kml");	
			}
			
			if(name.equalsIgnoreCase("TimeFilter")) {
				savefile = fileChooser.getSelectedFile();
				Write_2_KML.Filter_KML(Filter.data, savefile+".kml");
				Filter.data.clear();
			}
			
			if(name.equalsIgnoreCase("IDFilter")) {
				savefile = fileChooser.getSelectedFile();
				Write_2_KML.Filter_KML(Filter.data, savefile+".kml");
				Filter.data.clear();
			}
			
			if(name.equalsIgnoreCase("PositionFilter")) {
				savefile = fileChooser.getSelectedFile();
				Write_2_KML.Filter_KML(Filter.data, savefile+".kml");
				Filter.data.clear();
			}


		}
	}


	public static void exportAlgo1() throws IOException, ParseException {
		saveTOCSV("Algo1");
	}
	public static void exportAlgo2() throws IOException, ParseException {
		saveTOCSV("Algo2");		
	}

	public static Position algo1Short(String mac) throws IOException {
		return Algo_Main.algo1_Mac(mac);

	}

	public static void algo2Short(ArrayList<String> Allm_Alls) throws IOException, ParseException {

		Mac mac;
		Signal signal;
		Record_Mac_Signal ms;
		ArrayList<Record_Mac_Signal> three_ms = new ArrayList<Record_Mac_Signal>();

		for (int i = 0; i < Allm_Alls.size()-1; i+=2) {

			mac = new Mac(Allm_Alls.get(i));
			signal = new Signal(Allm_Alls.get(i+1));
			ms = new Record_Mac_Signal(mac, signal);
			three_ms.add(ms);
		}

		Algo_Main.algo2_all(three_ms);
	}

	public static void algo2Line(String line) throws IOException, ParseException {

		String word="";
		ArrayList<String> str = new ArrayList<String>();
		Record_Mac_Signal ms;
		ArrayList<Record_Mac_Signal> ams = new ArrayList<Record_Mac_Signal>();

		for (int i = 0; i < line.length(); i++) {
			if((line.charAt(i)!='	') && (line.charAt(i)!=' '))word+=line.charAt(i);
			else {
				str.add(word);
				word="";
			}
		}

		for (int i = 8; i < str.size()-2; i++) {
			if(ams.size() < 3) {
				if(str.get(i).length()>4)
				{
					if(str.get(i).charAt(2) == ':') {
						Mac mac = new Mac(str.get(i));
						Signal signal = new Signal(str.get(i+2));
						ms = new Record_Mac_Signal(mac,signal);		
						ams.add(ms);
					}
				}

			}
			else
				break;

		}
		Algo_Main.algo2_all(ams);

	}
	
	
	public static void idfilter(String id) throws IOException, ParseException
	{
		ID_Filter.idFilter(id);
	}
	
	public static void timefilter(String begin,String end) throws ParseException, IOException
	{
		
		Time_Filter.timeFilter(begin, end);
	}
	
	public static void positionfilter(String lat,String lon,String radius) throws IOException, ParseException
	{
		
		Position_Filter.positionFilter(lat, lon, radius);
	}
}
