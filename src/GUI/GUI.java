package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Data_base.ConnectionMySQL;
import GUI.Panels.Panel_Algorithm_1;
import GUI.Panels.Panel_Algorithm_2;
import GUI.Panels.Panel_Filters;
import GUI.Panels.Panel_Login;
import Memory.Data_Structures;

import java.awt.event.MouseEvent;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.ParseException;
import java.awt.event.MouseAdapter;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import javax.swing.JRadioButton;

public class GUI {
	
	
	private JFrame frmOop;
	public static JTextField textField;
	public static Path directoryPath;

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
					GUI window = new GUI();
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
	public GUI() {
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
					directoryPath = FileSystems.getDefault().getPath(GUI_Wrapper.folder.getPath());
					Thread thread = new Thread(new Thread_Watcher());
					thread.start();
				} catch (IOException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// Browse button to select directory
				if(Data_Structures.Sql_flag == true) {
					
					textField.setText("size of data: " + Data_Structures.Sql_Data.size());
				}
				else {
					textField.setText("size of data: " + Data_Structures.All_Data.size());
				}
				
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

				if(Data_Structures.Sql_flag == true) {
					textField.setText("size of data: " + Data_Structures.Sql_Data.size());
				}
				else {
					textField.setText("size of data: " + Data_Structures.All_Data.size());
				}
				
			}
		});
		btnBrowse_1.setBounds(22, 109, 183, 27);
		frmOop.getContentPane().add(btnBrowse_1);

		JButton btnClearData = new JButton("Clear Data");
		btnClearData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				GUI_Wrapper.clearData();
				textField.setText("size of data: " + Data_Structures.All_Data.size());


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
		lblAlgorithms.setForeground(Color.DARK_GRAY);
		lblAlgorithms.setBounds(412, 7, 114, 48);
		frmOop.getContentPane().add(lblAlgorithms);

		JLabel lblFilters = new JLabel("Filters");
		lblFilters.setForeground(Color.DARK_GRAY);
		lblFilters.setFont(new Font("Elephant", Font.BOLD, 18));
		lblFilters.setBounds(261, 7, 114, 48);
		frmOop.getContentPane().add(lblFilters);

		JLabel lblDataStructure = new JLabel("Data Structure");
		lblDataStructure.setForeground(Color.DARK_GRAY);
		lblDataStructure.setFont(new Font("Elephant", Font.BOLD, 18));
		lblDataStructure.setBounds(22, 14, 162, 34);
		frmOop.getContentPane().add(lblDataStructure);

		JButton btnTime = new JButton("Filter");
		btnTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				Panel_Filters filter = new Panel_Filters();
				filter.setVisible(true);

			}
		});
		btnTime.setBounds(251, 70, 98, 27);
		frmOop.getContentPane().add(btnTime);

		JButton btnAlgorithm = new JButton("Algorithm 1");
		btnAlgorithm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Panel_Algorithm_1 algorithm1 = new Panel_Algorithm_1();
				algorithm1.setVisible(true);
			}
		});
		btnAlgorithm.setBounds(412, 70, 139, 27);
		frmOop.getContentPane().add(btnAlgorithm);

		JButton btnAlgorithm_1 = new JButton("Algorithm 2");
		btnAlgorithm_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Panel_Algorithm_2 algorithm2 = new Panel_Algorithm_2();
				algorithm2.setVisible(true);

			}
		});
		btnAlgorithm_1.setBounds(412, 109, 139, 27);
		frmOop.getContentPane().add(btnAlgorithm_1);

		textField = new JTextField();
		textField.setFont(new Font("Georgia Pro Semibold", Font.BOLD, 20));
		textField.setBounds(22, 278, 225, 34);
		frmOop.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		textField.setText("Size of data: " + Data_Structures.All_Data.size());

		JButton btnSaveToKml = new JButton("Save To KML");
		btnSaveToKml.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				try {
					GUI_Wrapper.saveTOKML("allData");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		btnSaveToKml.setBounds(22, 226, 183, 27);
		frmOop.getContentPane().add(btnSaveToKml);

		JButton btnInfo = new JButton("Info");
		btnInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {


			}
		});
		btnInfo.setBounds(610, 283, 162, 27);
		frmOop.getContentPane().add(btnInfo);

		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setBackground(Color.DARK_GRAY);
		editorPane.setBounds(22, 44, 162, 2);
		frmOop.getContentPane().add(editorPane);

		JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setEditable(false);
		editorPane_1.setBackground(Color.DARK_GRAY);
		editorPane_1.setBounds(251, 44, 97, 2);
		frmOop.getContentPane().add(editorPane_1);

		JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setEditable(false);
		editorPane_2.setBackground(Color.DARK_GRAY);
		editorPane_2.setBounds(403, 44, 136, 2);
		frmOop.getContentPane().add(editorPane_2);
		
		JButton btnMysql = new JButton("Login to Sql");
		btnMysql.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				Panel_Login pl = new Panel_Login();
				pl.setVisible(true);
			
			}
		});
		btnMysql.setBounds(593, 71, 179, 25);
		frmOop.getContentPane().add(btnMysql);
		
		JButton btnLoadDataFrom = new JButton("Load Data From Sql");
		btnLoadDataFrom.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Data_Structures.Sql_Data.clear();
					ConnectionMySQL.start();
					textField.setText("Size of data: " + Data_Structures.Sql_Data.size());
				} catch (IOException | ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLoadDataFrom.setBounds(593, 110, 179, 25);
		frmOop.getContentPane().add(btnLoadDataFrom);
		
		JLabel lblSql = new JLabel("Sql");
		lblSql.setForeground(Color.DARK_GRAY);
		lblSql.setFont(new Font("Elephant", Font.BOLD, 18));
		lblSql.setBounds(646, 7, 114, 48);
		frmOop.getContentPane().add(lblSql);
		
		JEditorPane editorPane_3 = new JEditorPane();
		editorPane_3.setEditable(false);
		editorPane_3.setBackground(Color.DARK_GRAY);
		editorPane_3.setBounds(625, 44, 97, 2);
		frmOop.getContentPane().add(editorPane_3);
		frmOop.setBackground(Color.WHITE);
		frmOop.setBounds(100, 100, 804, 367);
		frmOop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
