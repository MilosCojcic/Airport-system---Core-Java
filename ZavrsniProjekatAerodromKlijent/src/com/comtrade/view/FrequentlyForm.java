package com.comtrade.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrequentlyForm extends JFrame {

	private JPanel contentPane;

	
	public FrequentlyForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 786, 531);
		contentPane = new JPanel();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 770, 492);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblWhere = new JLabel("Where is the Airport located? ");
		lblWhere.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblWhere.setForeground(Color.BLACK);
		lblWhere.setBounds(10, 30, 217, 14);
		panel.add(lblWhere);
		
		JButton button = new JButton();
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutUsForm auf = new AboutUsForm();
				auf.setVisible(true);
				setVisible(false);
				dispose();
			}
		});
		button.setIcon(new ImageIcon("back.png"));
		button.setFont(new Font("Tahoma", Font.ITALIC, 15));
		button.setBounds(394, 451, 93, 30);
		panel.add(button);
		JLabel piclabel = new JLabel(new ImageIcon("faq1.jpg"));
		piclabel.setBounds(406, -11, 364, 492);
		panel.add(piclabel);
		
		JLabel lblResponce1 = new JLabel("The Address of the Airport is Aerodrom Belgrade 59, Belgrade 11180 .");
		lblResponce1.setForeground(Color.BLACK);
		lblResponce1.setBounds(10, 55, 416, 14);
		panel.add(lblResponce1);
		
		JLabel lblWhen = new JLabel("When should I come to the Airport before my flight?");
		lblWhen.setForeground(Color.BLACK);
		lblWhen.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblWhen.setBounds(10, 80, 342, 18);
		panel.add(lblWhen);
		
		JLabel lblIfYouHave = new JLabel("If you have checked in online then the recommended time is 2 hours,\r\n\r\n");
		lblIfYouHave.setForeground(Color.BLACK);
		lblIfYouHave.setBounds(10, 109, 389, 18);
		panel.add(lblIfYouHave);
		
		JLabel lblIfNotWe = new JLabel("if not we recommend 4 hours to avoid crouds.");
		lblIfNotWe.setBounds(10, 133, 309, 14);
		panel.add(lblIfNotWe);
		
		JLabel lblCanIWeigh = new JLabel("Can I weigh my baggage at the Airport?");
		lblCanIWeigh.setForeground(Color.BLACK);
		lblCanIWeigh.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblCanIWeigh.setBounds(10, 158, 342, 18);
		panel.add(lblCanIWeigh);
		
		JLabel lblCan = new JLabel("There is a scale at the entrance with which you can weigh baggage.");
		lblCan.setBounds(10, 187, 459, 14);
		panel.add(lblCan);
		
		JLabel lblWhyIsntMy = new JLabel("Why isn't my flight showing on the live information \r\nboard?");
		lblWhyIsntMy.setForeground(Color.BLACK);
		lblWhyIsntMy.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblWhyIsntMy.setBounds(10, 212, 389, 18);
		panel.add(lblWhyIsntMy);
		
		JLabel lblItMayBe = new JLabel("It may be because it's too early or too late; or it may be that the flight\r\n");
		lblItMayBe.setBounds(10, 241, 441, 14);
		panel.add(lblItMayBe);
		
		JLabel lblOperatorHasntSupplied = new JLabel("operator hasn't supplied any information yet.");
		lblOperatorHasntSupplied.setBounds(10, 262, 297, 14);
		panel.add(lblOperatorHasntSupplied);
		
		JLabel lblWhatIsMaximum = new JLabel("What is maximum amount of baggage I can bring with me?");
		lblWhatIsMaximum.setForeground(Color.BLACK);
		lblWhatIsMaximum.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblWhatIsMaximum.setBounds(10, 287, 389, 18);
		panel.add(lblWhatIsMaximum);
		
		JLabel lblNewLabel = new JLabel("That depends on the Airline but usually no more then 46kg is allowed.");
		lblNewLabel.setBounds(10, 316, 441, 14);
		panel.add(lblNewLabel);
		
		JLabel lblIveHeardThat = new JLabel("I`ve heard that the Airport has an Air museum close by.\r\n");
		lblIveHeardThat.setForeground(Color.BLACK);
		lblIveHeardThat.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblIveHeardThat.setBounds(10, 341, 389, 18);
		panel.add(lblIveHeardThat);
		
		JLabel lblIsItTrue = new JLabel("Is it true?");
		lblIsItTrue.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblIsItTrue.setBounds(10, 363, 117, 14);
		panel.add(lblIsItTrue);
		
		JLabel lblThereIsIndeed = new JLabel("There is indeed an Air museum just next to the Airport. ");
		lblThereIsIndeed.setBounds(10, 388, 389, 14);
		panel.add(lblThereIsIndeed);
		
		JLabel lblItIsOpen = new JLabel("It is open everyday 8:00-17:00.");
		lblItIsOpen.setBounds(10, 405, 266, 14);
		panel.add(lblItIsOpen);
		
		JLabel lblForAnyAdditional = new JLabel("For any additional questions or queries you can contact us via our email nteslaairport@airport.com or over phone on +38166447788.");
		lblForAnyAdditional.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblForAnyAdditional.setBounds(10, 429, 733, 14);
		panel.add(lblForAnyAdditional);
	}

}
