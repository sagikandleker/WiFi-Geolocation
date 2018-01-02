package GUI;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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


public class Home {
	
	private JFrame frmOop;
	
	int xx, xy;
	private JTextField txtMac;
	private JTextField textField;
	private JTextField txtMac_1;

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
		frmOop.getContentPane().setBackground(Color.DARK_GRAY);
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
			}
		});
		btnBrowse.setBounds(35, 36, 183, 27);
		frmOop.getContentPane().add(btnBrowse);
		
		JButton btnBrowse_1 = new JButton("Add CSV File");
		btnBrowse_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					GUI_Wrapper.chooseCSVFile();
				} catch (IOException | ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnBrowse_1.setBounds(35, 87, 183, 27);
		frmOop.getContentPane().add(btnBrowse_1);
		
		JButton btnClearData = new JButton("Clear Data");
		btnClearData.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				GUI_Wrapper.clearData();
				
				
			}
		});
		btnClearData.setBounds(35, 136, 183, 27);
		frmOop.getContentPane().add(btnClearData);
		
		JButton btnSaveToCsv = new JButton("Save To CSV");
		btnSaveToCsv.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					GUI_Wrapper.saveTOCSV();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
				
			}
		});
		btnSaveToCsv.setBounds(35, 192, 183, 27);
		frmOop.getContentPane().add(btnSaveToCsv);
		
		JLabel lblAlgorithms = new JLabel("Algorithms");
		lblAlgorithms.setFont(new Font("Elephant", Font.BOLD, 18));
		lblAlgorithms.setForeground(Color.WHITE);
		lblAlgorithms.setBounds(524, 23, 114, 48);
		frmOop.getContentPane().add(lblAlgorithms);
		
		txtMac = new JTextField();
		txtMac.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtMac.setText("");
				

				
			}
		});
		txtMac.setText("MAC");
		txtMac.setBounds(355, 195, 114, 21);
		frmOop.getContentPane().add(txtMac);
		txtMac.setColumns(10);
		
		Button button = new Button("Submit");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				txtMac.setText(textField.getText());			
				System.out.println(textField.getText());

			}
		});
		button.setBounds(288, 345, 76, 20);
		frmOop.getContentPane().add(button);
		
		textField = new JTextField();
		textField.setBounds(395, 90, 136, 21);
		frmOop.getContentPane().add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(395, 105, 136, 2);
		frmOop.getContentPane().add(separator);
		
		JLabel lblMac = new JLabel("MAC");
		lblMac.setForeground(Color.WHITE);
		lblMac.setBounds(395, 60, 55, 17);
		frmOop.getContentPane().add(lblMac);
		
		txtMac_1 = new JTextField();
		txtMac_1.setText("MAC");
		txtMac_1.setBounds(262, 262, 114, 21);
		frmOop.getContentPane().add(txtMac_1);
		txtMac_1.setColumns(10);
		frmOop.setBackground(Color.WHITE);
		frmOop.setBounds(100, 100, 1022, 800);
		frmOop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
