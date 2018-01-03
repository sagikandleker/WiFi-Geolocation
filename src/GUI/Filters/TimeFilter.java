package GUI.Filters;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;


import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Properties;
import javax.swing.JTextField;
import java.awt.Font;


@SuppressWarnings("serial")
public class TimeFilter extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_3;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimeFilter frame = new TimeFilter();
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
	public TimeFilter() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 478, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Time Filter");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(173, 16, 124, 20);
		contentPane.add(lblNewLabel);

		
		textField = new JTextField();
		textField.setBounds(103, 112, 79, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(103, 167, 79, 26);
		contentPane.add(textField_3);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setBounds(113, 73, 69, 20);
		contentPane.add(lblDay);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(203, 73, 69, 20);
		contentPane.add(lblMonth);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(309, 76, 69, 20);
		contentPane.add(lblYear);
		
		JLabel lblNewLabel_1 = new JLabel("Start");
		lblNewLabel_1.setBounds(31, 115, 69, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblEnd = new JLabel("End");
		lblEnd.setBounds(31, 170, 69, 20);
		contentPane.add(lblEnd);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(197, 112, 79, 26);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(197, 167, 79, 26);
		contentPane.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(291, 112, 79, 26);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(291, 167, 79, 26);
		contentPane.add(textField_5);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(173, 231, 139, 29);
		contentPane.add(btnSubmit);
		
		
		
		
	}
}
