package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import GUI.Algorithms.Algorithm1;
import GUI.Algorithms.Algorithm2;
import GUI.Filters.GUI_Filter;
import Main_App.Write_2_CSV;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.text.ParseException;
import java.awt.event.MouseAdapter;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;

public class GUI {

	private JFrame frmOop;
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
		lblAlgorithms.setForeground(Color.DARK_GRAY);
		lblAlgorithms.setBounds(377, 7, 114, 48);
		frmOop.getContentPane().add(lblAlgorithms);

		JLabel lblFilters = new JLabel("Filters");
		lblFilters.setForeground(Color.DARK_GRAY);
		lblFilters.setFont(new Font("Elephant", Font.BOLD, 18));
		lblFilters.setBounds(236, 7, 114, 48);
		frmOop.getContentPane().add(lblFilters);

		JLabel lblDataStructure = new JLabel("Data Structure");
		lblDataStructure.setForeground(Color.DARK_GRAY);
		lblDataStructure.setFont(new Font("Elephant", Font.BOLD, 18));
		lblDataStructure.setBounds(22, 5, 177, 53);
		frmOop.getContentPane().add(lblDataStructure);

		JButton btnTime = new JButton("Filter");
		btnTime.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnTime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				GUI_Filter filter = new GUI_Filter();
				filter.setVisible(true);

			}
		});
		btnTime.setBounds(236, 70, 98, 27);
		frmOop.getContentPane().add(btnTime);

		JButton btnAlgorithm = new JButton("Algorithm 1");
		btnAlgorithm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Algorithm1 algorithm1 = new Algorithm1();
				algorithm1.setVisible(true);
			}
		});
		btnAlgorithm.setBounds(377, 70, 98, 27);
		frmOop.getContentPane().add(btnAlgorithm);

		JButton btnAlgorithm_1 = new JButton("Algorithm 2");
		btnAlgorithm_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				Algorithm2 algorithm2 = new Algorithm2();
				algorithm2.setVisible(true);

			}
		});
		btnAlgorithm_1.setBounds(377, 109, 98, 27);
		frmOop.getContentPane().add(btnAlgorithm_1);

		textField = new JTextField();
		textField.setFont(new Font("Georgia Pro Semibold", Font.BOLD, 20));
		textField.setBounds(22, 269, 183, 34);
		frmOop.getContentPane().add(textField);
		textField.setColumns(10);
		textField.setEditable(false);
		textField.setText("Size of data: " + Write_2_CSV.All_Data_List.size());

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
		btnInfo.setBounds(377, 275, 162, 27);
		frmOop.getContentPane().add(btnInfo);
		frmOop.setBackground(Color.WHITE);
		frmOop.setBounds(100, 100, 573, 380);
		frmOop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
