package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class Home {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	
	int xx, xy;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
					window.frame.setUndecorated(true);
					window.frame.setVisible(true);
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
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		Button button = new Button("SignUp");
		button.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(241, 57, 83));
		button.setBounds(178, 227, 207, 35);
		frame.getContentPane().add(button);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 564, 306);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		Button button_1 = new Button("X");
		button_1.setBounds(515, 10, 25, 24);
		panel.add(button_1);
		button_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		button_1.setForeground(Color.WHITE);
		button_1.setBackground(new Color(241, 57, 83));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(140, 114, 123, 37);
		panel.add(lblPassword);
		lblPassword.setForeground(Color.WHITE);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(140, 53, 284, 35);
		panel.add(textField_1);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(140, 85, 284, 2);
		panel.add(separator_1);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(140, 16, 123, 37);
		panel.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(140, 154, 284, 35);
		panel.add(textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(140, 186, 284, 2);
		panel.add(separator);
		
		textField_2 = new JTextField();
		textField_2.setBounds(15, 207, 153, 37);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 564, 290);
		panel.add(label);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				xx = e.getX();
				xy = e.getY();
			}
		});
		label.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent arg0) {
				
				int x = arg0.getXOnScreen();
				int y = arg0.getYOnScreen();
				
				//Home.this.setLocation((x - xx), (y - xy));
				
			}
		});
		
		label.setIcon(new ImageIcon(Home.class.getResource("/img/Background.jpg")));
		frame.setBackground(Color.WHITE);
		frame.setBounds(100, 100, 576, 342);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
