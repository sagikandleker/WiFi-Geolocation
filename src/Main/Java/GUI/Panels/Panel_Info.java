package GUI.Panels;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


@SuppressWarnings("serial")
public class Panel_Info extends JFrame {
//App Information:
	//How does it work? Simple you add folder with Wigle files or just one Wigle file and you can choose what to do next.

			 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel_Info frame = new Panel_Info();
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
	public Panel_Info() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 409);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("App Information:\r\nHow does it work? Simple you add folder with Wigle files or just one Wigle file and you can choose what to do next.\r\n\r\n ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNewLabel.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel.setBounds(0, 0, 528, 353);
		getContentPane().add(lblNewLabel);
	}
}
