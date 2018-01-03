package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import GUI.Algorithms.Algorithm1;
import GUI.Algorithms.Algorithm2;
import GUI.Filters.IDFilter;
import GUI.Filters.LocationFilter;
import GUI.Filters.TimeFilter;
import Main_App.Write_2_CSV;

import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.MouseAdapter;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.TextField;
import java.awt.Choice;
import java.awt.TextArea;
import java.awt.Label;
import java.awt.Button;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;


public class Home {
	
	private JFrame frmOop;
	
	int xx, xy;
	private JTextField textField;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frmOop.setUndecorated(true);
					window.frmOop.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmOop = new JFrame();
		frmOop.setTitle("OOP");
		frmOop.getContentPane().setLayout(null);
		
		JButton btnBrowse = new JButton("Add Folder");
		btnBrowse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBrowse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					GUI_Wrapper.choosefolder();
				} catch (IOException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Browse button to select directory
				
				textField.setText("size of data: " + Write_2_CSV.All_Data_List.size());
			}
		});
		btnBrowse.setBounds(22, 70, 183, 27);
		frmOop.getContentPane().add(btnBrowse);
		
		JButton btnBrowse_1 = new JButton("Add CSV File");
		btnBrowse_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					GUI_Wrapper.chooseCSVFile("mainfile");
				} catch (IOException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				textField.setText("size of data: " + Write_2_CSV.All_Data_List.size());
			}
		});
		btnBrowse_1.setBounds(22, 109, 183, 27);
		frmOop.getContentPane().add(btnBrowse_1);
		
		JButton btnClearData = new JButton("Clear Data");
		btnClearData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				GUI_Wrapper.clearData();
				textField.setText("size of data: " + Write_2_CSV.All_Data_List.size());
				
				
			}
		});
		btnClearData.setBounds(22, 148, 183, 27);
		frmOop.getContentPane().add(btnClearData);
		
		JButton btnSaveToCsv = new JButton("Save To CSV");
		btnSaveToCsv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					GUI_Wrapper.saveTOCSV("WigleSorted");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				
			}
		});
		btnSaveToCsv.setBounds(22, 187, 183, 27);
		frmOop.getContentPane().add(btnSaveToCsv);
		
		JLabel lblAlgorithms = new JLabel("Algorithms");
		lblAlgorithms.setFont(new Font("Elephant", Font.BOLD, 18));
		lblAlgorithms.setForeground(Color.WHITE);
		lblAlgorithms.setBounds(405, 23, 114, 48);
		frmOop.getContentPane().add(lblAlgorithms);
		
		JLabel lblFilters = new JLabel("Filters");
		lblFilters.setForeground(Color.WHITE);
		lblFilters.setFont(new Font("Elephant", Font.BOLD, 18));
		lblFilters.setBounds(268, 23, 114, 48);
		frmOop.getContentPane().add(lblFilters);
		
		JLabel lblDataStructure = new JLabel("Data Structure");
		lblDataStructure.setForeground(Color.WHITE);
		lblDataStructure.setFont(new Font("Elephant", Font.BOLD, 18));
		lblDataStructure.setBounds(28, 5, 177, 53);
		frmOop.getContentPane().add(lblDataStructure);
		
		JButton btnTime = new JButton("Time");
		btnTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				TimeFilter timefilter = new TimeFilter();
				timefilter.setVisible(true);
				
				
			}
		});
		btnTime.setBounds(253, 70, 98, 27);
		frmOop.getContentPane().add(btnTime);
		
		JButton btnLocation = new JButton("Location");
		btnLocation.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				LocationFilter locationfilter = new LocationFilter();
				locationfilter.setVisible(true);
				
			}
		});
		btnLocation.setBounds(253, 127, 98, 27);
		frmOop.getContentPane().add(btnLocation);
		
		JButton btnId = new JButton("ID");
		btnId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				IDFilter idfilter = new IDFilter();
				idfilter.setVisible(true);
				
			}
		});
		btnId.setBounds(253, 187, 98, 27);
		frmOop.getContentPane().add(btnId);
		
		JButton btnAlgorithm = new JButton("Algorithm 1");
		btnAlgorithm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Algorithm1 algorithm1 = new Algorithm1();
				algorithm1.setVisible(true);
			}
		});
		btnAlgorithm.setBounds(405, 70, 98, 27);
		frmOop.getContentPane().add(btnAlgorithm);
		
		JButton btnAlgorithm_1 = new JButton("Algorithm 2");
		btnAlgorithm_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Algorithm2 algorithm2 = new Algorithm2();
				algorithm2.setVisible(true);
				
			}
		});
		btnAlgorithm_1.setBounds(405, 109, 98, 27);
		frmOop.getContentPane().add(btnAlgorithm_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Georgia Pro Semibold", Font.BOLD, 20));
		textField.setBounds(22, 269, 183, 34);
		frmOop.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		textField.setText("Size of data: " + Write_2_CSV.All_Data_List.size());
		frmOop.setBackground(Color.WHITE);
		frmOop.setBounds(100, 100, 711, 510);
		frmOop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
