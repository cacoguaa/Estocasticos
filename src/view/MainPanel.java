package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;

public class MainPanel {

	private JFrame frame;

	private String text;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPanel window = new MainPanel();
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
	public MainPanel() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450,380);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		text  = "";
		JFileChooser chooser = new JFileChooser();
		frame.getContentPane().add(chooser, BorderLayout.SOUTH);
		int returnVal = chooser.showOpenDialog(frame);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			text = chooser.getSelectedFile().getPath();
		       System.out.println("You chose to open this file: " +
		            chooser.getSelectedFile().getPath());
		       		
		       }
	}

	public String getText() {
		// TODO Auto-generated method stub
		return text;
	}

}
