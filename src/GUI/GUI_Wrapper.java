package GUI;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import Main_App.Analayze_Files;
import Main_App.Read_From;
import Main_App.Write_2_CSV;

public class GUI_Wrapper {
	
	public static File folder=new File("");
	public static File file = new File("");
	
	public static void choosefolder() throws IOException, ParseException
	{
		JFileChooser chooser = new JFileChooser();
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("Browse the folder to process");
	    chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	    chooser.setAcceptAllFileFilterUsed(false);

	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	        System.out.println("getCurrentDirectory(): "+ chooser.getCurrentDirectory());
	        System.out.println("getSelectedFile() : "+ chooser.getSelectedFile());
	    } else {
	        System.out.println("No Selection ");
	    }
	    
	     folder = chooser.getSelectedFile();

	     if (!folder.isDirectory()) {
		        folder = folder.getParentFile();
		    }

	 System.out.println(folder);
	 
	 Analayze_Files.getFiles(folder);
	 
	}
	
	public static void chooseCSVFile() throws IOException, ParseException {
		
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV FILES", "csv","CSV");
		chooser.setFileFilter(filter);
	    chooser.setCurrentDirectory(new java.io.File("."));
	    chooser.setDialogTitle("Browse the folder to process");
	    chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
	    chooser.setAcceptAllFileFilterUsed(false);
	    
	
	    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
	        System.out.println("getCurrentDirectory(): "+ chooser.getCurrentDirectory());
	        System.out.println("getSelectedFile() : "+ chooser.getSelectedFile());
	    } else {
	        System.out.println("No Selection ");
	    }
	  
	     file = chooser.getSelectedFile();
	     
	 System.out.println(file);
	 
	 Read_From.wigle_File(file);
	 
	}
	
	public static void clearData() {
	
		System.out.println("DATA: " +Write_2_CSV.All_Data_List);
		Write_2_CSV.clearData();
		System.out.println("DATA: " +Write_2_CSV.All_Data_List);
		
	}
	
	public static void saveTOCSV() throws IOException {
		
		Write_2_CSV.Write();
		
	}
	
}
