package view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MathInterface extends JFrame{
	/**
	 * This view uses for calculating the quadratic equation 2
	 */
	private static final long serialVersionUID = 1L;
	private JTextField contanst1Txt;
	private JTextField contanst2Txt;
	private JTextField contanst3Txt;
	private JButton resultBtn;
	private JTextArea resultTxtArea;
	
	public MathInterface() {
		setTitle("Giai phuong trinh bac 2");
		// Create label for program
		JLabel constantLbl = new JLabel("Hang so:");
		JLabel constant1Lbl = new JLabel("a:");
		JLabel constant2Lbl = new JLabel("b:");
		JLabel constant3Lbl = new JLabel("c:");
		constantLbl.setBounds(50, 20, 50, 20);
		constant1Lbl.setBounds(50, 50, 10, 20);
		constant2Lbl.setBounds(130, 50, 10, 20);
		constant3Lbl.setBounds(210, 50, 10, 20);
		
		contanst1Txt = new JTextField();
		contanst2Txt = new JTextField();
		contanst3Txt = new JTextField();
		contanst1Txt.setBounds(60, 50, 50, 20);
		contanst2Txt.setBounds(140, 50, 50, 20);
		contanst3Txt.setBounds(220, 50, 50, 20);
		
		resultTxtArea = new JTextArea("Ket qua: ");
		resultTxtArea.setBounds(50, 80, 250, 40);
		resultTxtArea.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		resultBtn = new JButton("Tinh toan");
		resultBtn.setBounds(50, 130, 100, 30);
		
		add(constantLbl);
		add(constant1Lbl);
		add(constant2Lbl);
		add(constant3Lbl);
		add(contanst1Txt);
		add(contanst2Txt);
		add(contanst3Txt);
		add(resultTxtArea);
		add(resultBtn);
//		Design layout
		setLayout(null);
		setSize(350, 220);
		setVisible(true);
	}

	public JTextField getContanst1Txt() {
		return contanst1Txt;
	}

	public void setContanst1Txt(JTextField contanst1Txt) {
		this.contanst1Txt = contanst1Txt;
	}

	public JTextField getContanst2Txt() {
		return contanst2Txt;
	}

	public void setContanst2Txt(JTextField contanst2Txt) {
		this.contanst2Txt = contanst2Txt;
	}

	public JTextField getContanst3Txt() {
		return contanst3Txt;
	}

	public void setContanst3Txt(JTextField contanst3Txt) {
		this.contanst3Txt = contanst3Txt;
	}

	public JButton getResultBtn() {
		return resultBtn;
	}

	public void setResultBtn(JButton resultBtn) {
		this.resultBtn = resultBtn;
	}

	public JTextArea getResultLbl() {
		return resultTxtArea;
	}

	public void setResultLbl(JTextArea resultArea) {
		this.resultTxtArea = resultArea;
	}
	
	public Integer isBlankValue() {
		if (contanst1Txt.getText().trim().equals("")) {
			return 1;
		} else if (contanst2Txt.getText().trim().equals("")) {
			return 2;
		} else if (contanst3Txt.getText().trim().equals("")) {
			return 3;
		}
		return 0;
	}
}
