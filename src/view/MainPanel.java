package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JFileChooser;

import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;

import test.GLCP;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class MainPanel {

	private JFrame frame;

	private String text;
	private String base;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
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
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Cargar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				frame.getContentPane().add(chooser, BorderLayout.SOUTH);
				int returnVal = chooser.showOpenDialog(frame);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					text = chooser.getSelectedFile().getPath();
					textField.setText(text);
				}
			}
		});
		btnNewButton.setBounds(42, 180, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnEntrenar = new JButton("Entrenar");
		btnEntrenar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				frame.getContentPane().add(chooser, BorderLayout.SOUTH);
				int returnVal = chooser.showOpenDialog(frame);
				if(returnVal == JFileChooser.APPROVE_OPTION) {
					base = chooser.getSelectedFile().getPath();
					textField_2.setText(base);
				}
			}
		});
		btnEntrenar.setBounds(42, 107, 89, 23);
		frame.getContentPane().add(btnEntrenar);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(42, 141, 366, 20);
		frame.getContentPane().add(textField_2);
		
		JButton btnNewButton_1 = new JButton("Calcular");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				List<String> booksForTraining = new ArrayList<String>();
				booksForTraining.add(base);
				booksForTraining.add(text);
				//booksForTraining.add(base + "src\\examples\\MONTE.py");
				GLCP glcp = null;
				try {
					glcp = new GLCP (booksForTraining);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				double result = 0;
				try {
					result = glcp.getProb(base);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println();
				textField_1.setText(String.valueOf(result));
			}
		});
		btnNewButton_1.setBounds(42, 245, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(42, 214, 366, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(42, 285, 366, 20);
		frame.getContentPane().add(textField_1);
		
		
		
		JLabel lblAnalizadorDeGramaticas = new JLabel("Analizador De Gramaticas Probabilisticas Libres De Contexto");
		lblAnalizadorDeGramaticas.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnalizadorDeGramaticas.setBounds(42, 21, 366, 60);
		frame.getContentPane().add(lblAnalizadorDeGramaticas);
	}

	public String getText() {
		// TODO Auto-generated method stub
		return text;
	}
}
