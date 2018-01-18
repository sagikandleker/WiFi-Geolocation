package GUI.Panels;


import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Data_base.ConnectionMySQL;
import Memory.Data_Structures;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Panel_Login extends JFrame {
	private static Panel_Login frame;
	private JPanel contentPane;
	public static String user;
	public static String password;
	public static String ip;
	public static String port;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new Panel_Login();
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
	public Panel_Login() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 378, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMysql = new JLabel("Sql Login Panel");
		lblMysql.setVerticalAlignment(SwingConstants.BOTTOM);
		lblMysql.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
		lblMysql.setBounds(111, 16, 175, 25);
		contentPane.add(lblMysql);
		
		textField = new JTextField();
		textField.setBounds(111, 71, 175, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(111, 106, 175, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(111, 141, 175, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(111, 176, 175, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(textField.getText()!=null && textField_1.getText()!=null &&
						textField_2.getText()!=null && textField_3.getText()!=null) {
					
					user = textField.getText();
					password = textField_1.getText();
					ip = textField_2.getText();
					port = textField_3.getText();
					
					Data_Structures.Sql_flag = ConnectionMySQL.login(user, password, ip, port);
					if(Data_Structures.Sql_flag==true) {
						GUI.GUI.btnNewButton.setForeground(Color.GREEN);
						GUI.GUI.btnNewButton.setBackground(Color.GREEN);
						JOptionPane.showMessageDialog(null, "Login Succesfull");
						setVisible(false);
					    dispose();
					}
				}
				else {
					GUI.GUI.btnNewButton.setForeground(Color.RED);
					GUI.GUI.btnNewButton.setBackground(Color.RED);
					JOptionPane.showMessageDialog(null, "Invalid Input");
					
				}
				
			}
		});
		btnLogin.setBounds(150, 238, 97, 25);
		contentPane.add(btnLogin);
		
		JLabel lblNewLabel = new JLabel("User");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(12, 74, 56, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(12, 109, 84, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("IP");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(12, 144, 56, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Port");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(12, 179, 56, 16);
		contentPane.add(lblNewLabel_3);
	}
}
