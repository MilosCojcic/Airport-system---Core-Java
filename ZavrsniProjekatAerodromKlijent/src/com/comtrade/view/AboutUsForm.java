package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.UIManager;

public class AboutUsForm extends JFrame {

	private JPanel contentPane;
	private JButton btnTransport;

	public AboutUsForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 531);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 5, 760, 487);
		contentPane.add(panel);
		panel.setLayout(null);
		ImageIcon iconContactic = new ImageIcon("contactic.jpg");
		JButton btnContactUs = new JButton(iconContactic);
		btnContactUs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ContactUsForm cuf = new ContactUsForm();
				cuf.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnContactUs.setBounds(32, 201, 151, 44);
		panel.add(btnContactUs);

		JButton btnOffer = new JButton("Top Knoch Offer");
		btnOffer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TopKnochForm tkf=new TopKnochForm();
				tkf.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnOffer.setIcon(new ImageIcon(AboutUsForm.class.getResource("/javax/swing/plaf/metal/icons/Inform.gif")));
		btnOffer.setForeground(Color.DARK_GRAY);
		btnOffer.setFont(new Font("Tahoma", Font.ITALIC, 18));
		btnOffer.setBounds(32, 269, 223, 37);
		panel.add(btnOffer);

		JButton btnFrequentlyAskedQuestions = new JButton("Frequently asked Questions");
		btnFrequentlyAskedQuestions.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrequentlyForm ff = new FrequentlyForm();
				ff.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnFrequentlyAskedQuestions.setIcon(new ImageIcon(
				AboutUsForm.class.getResource("/com/sun/javafx/scene/control/skin/caspian/dialog-confirm.png")));
		btnFrequentlyAskedQuestions.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnFrequentlyAskedQuestions.setBounds(32, 330, 305, 37);
		panel.add(btnFrequentlyAskedQuestions);
		ImageIcon iconAutic = new ImageIcon("autic1.png");
		JButton btnTransport;
		btnTransport = new JButton("Need Transport to the city?", iconAutic);
		btnTransport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TransportForm tf=new TransportForm();
				tf.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		btnTransport.setFont(new Font("Tahoma", Font.ITALIC, 16));
		btnTransport.setBounds(32, 391, 305, 44);
		panel.add(btnTransport);

		JButton button = new JButton("Homepage");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GreatingForm gf = null;
				try {
					gf = new GreatingForm();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				gf.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		button.setForeground(Color.BLACK);
		button.setFont(new Font("Times New Roman", Font.ITALIC, 16));
		button.setBackground(Color.LIGHT_GRAY);
		button.setBounds(615, 420, 113, 38);
		panel.add(button);
		JLabel picLabel = new JLabel(new ImageIcon("aerodromic2.jpg"));
		picLabel.setLocation(10, 0);
		picLabel.setSize(760, 487);
		panel.add(picLabel);

	}
}
