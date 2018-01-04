package GUI.Filters;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

public class Filter extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Filter frame = new Filter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Filter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 854, 526);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton radioButton_3 = new JRadioButton("OR");
		radioButton_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		radioButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		
		radioButton_3.setActionCommand("enable");
		radioButton_3.setEnabled(true);
		
		radioButton_3.setBounds(439, 324, 83, 29);
		contentPane.add(radioButton_3);
		
		
		JRadioButton radioButton_4 = new JRadioButton("AND");
		radioButton_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		radioButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		radioButton_4.setBounds(328, 324, 97, 29);
		contentPane.add(radioButton_4);
		
		JRadioButton radioButton_5 = new JRadioButton("NOT");
		radioButton_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		radioButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
			}
		});
		radioButton_5.setBounds(224, 324, 97, 29);
		contentPane.add(radioButton_5);
		
		ButtonGroup bt1=new ButtonGroup();
		bt1.add(radioButton_3);
		bt1.add(radioButton_4);
		bt1.add(radioButton_5);
		
		ButtonGroup bt2=new ButtonGroup();
		
		ButtonGroup bt3=new ButtonGroup();
		
		textField = new JTextField();
		textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField.setText("");
				
			}
		});
		textField.setBounds(36, 120, 146, 26);
		contentPane.add(textField);
		textField.setText("Name Of Device");
		textField.setColumns(10);

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(193, 410, 424, 29);
		contentPane.add(btnSubmit);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Time");
		rdbtnNewRadioButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(rdbtnNewRadioButton.isSelected()) {
					
					
					textField_1.setEnabled(true);
					textField_1.setVisible(true);
					textField_1.setEditable(true);
					textField_1.setText("End");
					textField_2.setEnabled(true);
					textField_2.setVisible(true);
					textField_2.setEditable(true);
					textField_2.setText("Being");
					radioButton_6.setEnabled(true);
					radioButton_7.setEnabled(true);
					radioButton_8.setEnabled(true);
				}
				
				else if(!rdbtnNewRadioButton.isSelected()) {
					
					textField_1.setEnabled(false);
					textField_1.setVisible(true);
					textField_1.setEditable(false);
					textField_1.setText("End");
					textField_2.setEnabled(false);
					textField_2.setVisible(true);
					textField_2.setEditable(false);
					textField_2.setText("Being");
					radioButton_6.setEnabled(false);
					radioButton_7.setEnabled(false);
					radioButton_8.setEnabled(false);
					
				}
				
			}
		});
		rdbtnNewRadioButton.setBounds(293, 79, 155, 29);
		contentPane.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		
		JRadioButton rdbtnId = new JRadioButton("ID");
		rdbtnId.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(rdbtnId.isSelected()) {
					
					textField.setEnabled(true);
					textField.setVisible(true);
					textField.setEditable(true);
					textField.setText("Name Of Device");
					radioButton_3.setEnabled(true);
					radioButton_4.setEnabled(true);
					radioButton_5.setEnabled(true);
					
					
				}
				
				else if(!rdbtnId.isSelected()) {
					
					textField.setEnabled(false);
					textField.setVisible(true);
					textField.setEditable(false);
					textField.setText("Name Of Device");
					radioButton_3.setEnabled(false);
					radioButton_4.setEnabled(false);
					radioButton_5.setEnabled(false);

				}
				
			}
		});
		rdbtnId.setBounds(36, 79, 155, 29);
		contentPane.add(rdbtnId);
		rdbtnId.setSelected(true);
		
		
		
		JRadioButton rdbtnPosition = new JRadioButton("Position");
		rdbtnPosition.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(rdbtnPosition.isSelected()) {
					
					textField_3.setEnabled(true);
					textField_3.setVisible(true);
					textField_3.setEditable(true);
					textField_3.setText("Lat");
					textField_4.setEnabled(true);
					textField_4.setVisible(true);
					textField_4.setEditable(true);
					textField_4.setText("Lon");
					textField_5.setEnabled(true);
					textField_5.setVisible(true);
					textField_5.setEditable(true);
					textField_5.setText("Radius");
					radioButton_9.setEnabled(true);
					radioButton_10.setEnabled(true);
					radioButton_11.setEnabled(true);
				}
				
				else if(!rdbtnPosition.isSelected()) {
					
					textField_3.setEnabled(false);
					textField_3.setVisible(true);
					textField_3.setEditable(false);
					textField_3.setText("Lat");
					textField_4.setEnabled(false);
					textField_4.setVisible(true);
					textField_4.setEditable(false);
					textField_4.setText("Lon");
					textField_5.setEnabled(false);
					textField_5.setVisible(true);
					textField_5.setEditable(false);
					textField_5.setText("Radius");
					radioButton_9.setEnabled(false);
					radioButton_10.setEnabled(false);
					radioButton_11.setEnabled(false);

				}
				
				
			}
		});
		rdbtnPosition.setBounds(586, 79, 155, 29);
		contentPane.add(rdbtnPosition);
		rdbtnPosition.setSelected(true);
		
		textField_2 = new JTextField();
		textField_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_2.setText("");
				
			}
		});
		textField_2.setColumns(10);
		textField_2.setBounds(293, 117, 146, 26);
		contentPane.add(textField_2);
		textField_2.setText("Begin");

		
		textField_3 = new JTextField();
		textField_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_3.setText("");
			}
		});
		textField_3.setColumns(10);
		textField_3.setBounds(586, 120, 146, 26);
		contentPane.add(textField_3);
		textField_3.setText("Lat");

		
		textField_4 = new JTextField();
		textField_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_4.setText("");
			}
		});
		textField_4.setColumns(10);
		textField_4.setBounds(586, 186, 146, 26);
		contentPane.add(textField_4);
		textField_4.setText("Lon");

		
		textField_5 = new JTextField();
		textField_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_5.setText("");
			}
		});
		textField_5.setColumns(10);
		textField_5.setBounds(586, 250, 146, 26);
		contentPane.add(textField_5);
		textField_5.setText("Radius");

		
		textField_1 = new JTextField();
		textField_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textField_1.setText("");
				
			}
		});
		textField_1.setColumns(10);
		textField_1.setBounds(293, 186, 146, 26);
		contentPane.add(textField_1);
		textField_1.setText("End");
		
		JLabel lblFilters = new JLabel("Filters");
		lblFilters.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblFilters.setBounds(341, 16, 145, 20);
		contentPane.add(lblFilters);
	}
}
