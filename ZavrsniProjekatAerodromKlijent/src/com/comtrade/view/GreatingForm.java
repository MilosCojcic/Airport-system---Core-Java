package com.comtrade.view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.xml.bind.annotation.XmlElementDecl.GLOBAL;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GreatingForm extends JFrame{

	private JFrame frame;
	private JButton btnWeatherForcast;
	private JButton btnStaff;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GreatingForm window = new GreatingForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public GreatingForm() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.setBounds(100, 100, 786, 531);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 770, 492);
		frame.getContentPane().add(panel);

		ImageIcon iconA = new ImageIcon("avioncic1.png");
		JButton prakash;
		prakash = new JButton("Reserve a Flight", iconA);
		prakash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransitionForm tf = null;
				try {
					tf = new TransitionForm();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tf.setVisible(true);
				dispose();
				
				
			}
		});
		prakash.setRolloverIcon(iconA);
		prakash.setBounds(55, 62, 233, 45);

		panel.add(prakash);
		
		ImageIcon iconZnakici = new ImageIcon("znakici1.jpg");
		
		ImageIcon iconAero = new ImageIcon("aerodromcic1.png");
		
		ImageIcon iconOblacic = new ImageIcon("oblacic1.png");
		btnWeatherForcast = new JButton("Weather Forcast", iconOblacic);
		
		btnWeatherForcast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				openWebPage("https://www.weather2umbrella.com");
			}
		});
		
		btnWeatherForcast.setBounds(55, 211, 200, 45);
		panel.add(btnWeatherForcast);
		
		JButton btnStaff_1 = new JButton("", new ImageIcon("stjuardescica.png"));
		btnStaff_1.setBounds(665, 175, 54, 34);
		panel.add(btnStaff_1);
		
		JButton btnaero = new JButton("About Us", iconAero);
		btnaero.setBounds(536, 62, 200, 45);
		panel.add(btnaero);
		
		JLabel picLabel = new JLabel(new ImageIcon("naslovna1.jpg"));
		picLabel.setBounds(0, 0, 768, 490);
		panel.add(picLabel);
		btnaero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutUsForm auf=new AboutUsForm();
				auf.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnStaff_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				StaffForm sf=new StaffForm();
				sf.setVisible(true);
				
			}
		});
		
		ImageIO.read(new File("avioncic2veci.jpg"));
		
		ImageIcon iconStuart = new ImageIcon("stjuardescica.png");
		
		
		
		

	}
	public void openWebPage(String url){
		   try {         
		     java.awt.Desktop.getDesktop().browse(java.net.URI.create("https://www.weather2umbrella.com"));
		   }
		   catch (java.io.IOException e) {
		       System.out.println(e.getMessage());
		   }
		}
}
