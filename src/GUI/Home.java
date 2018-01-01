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
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Main_App.Main;

import java.awt.Font;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JToggleButton;
import java.awt.Window.Type;
import java.awt.Dialog.ModalExclusionType;

public class Home {

	private JFrame frmOop;
	
	int xx, xy;

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
		
		JButton btnBrowse = new JButton("browse");
		btnBrowse.setIcon(new ImageIcon(Home.class.getResource("/img/if_Application-Map_379570.png")));
		btnBrowse.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				// Browse button to select directory
				JFileChooser chooser = new JFileChooser();
			    chooser.setCurrentDirectory(new java.io.File("."));
			    chooser.setDialogTitle("Browse the folder to process");
			    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    chooser.setAcceptAllFileFilterUsed(false);

			    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			        System.out.println("getCurrentDirectory(): "+ chooser.getCurrentDirectory());
			        System.out.println("getSelectedFile() : "+ chooser.getSelectedFile());
			    } else {
			        System.out.println("No Selection ");
			    }
			
			}
		});
		btnBrowse.setBounds(45, 39, 86, 110);
		frmOop.getContentPane().add(btnBrowse);
		frmOop.setBackground(Color.WHITE);
		frmOop.setBounds(100, 100, 1022, 800);
		frmOop.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
