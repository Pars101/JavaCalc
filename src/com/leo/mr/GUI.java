package com.leo.mr;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class GUI implements Runnable{
	protected JTextField display;
	protected boolean isScientificCalc = true;
	protected JButton calcSwitch;
	
	public static void main(String[] args)
	{
		GUI gui = new GUI();
		SwingUtilities.invokeLater(gui);
	}
	
	@Override
	public void run()
	{
		JFrame frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);
		BorderLayout bl = new BorderLayout();
		frame.setLayout(bl);
		display = new JTextField("");
		frame.add(display, BorderLayout.NORTH);
		frame.add(createButtonPanel(), BorderLayout.CENTER);
		frame.setVisible(true);
	}
	
	public void updateText(String str)
	{
		display.setText(display.getText() + str);
	}
	
	public void showResult(String str)
	{
		display.setText(str);
	}
	
	private JButton createButton(ActionListener AL, String strNum)
	{
		JButton button = new JButton(strNum);
		button.addActionListener(AL);
		return button;
	}
	
	private JPanel createButtonPanel()
	{
		JPanel buttonPanel = new JPanel();
		GridLayout gridLayout = new GridLayout(5, 4);
		buttonPanel.setLayout(gridLayout);
		NumberAL numAL = new NumberAL(this);
		
		JButton JButton7 = createButton(numAL, "7");
		JButton JButton8 = createButton(numAL, "8");
		JButton JButton9 = createButton(numAL, "9");
		JButton JButton4 = createButton(numAL, "4");
		JButton JButton5 = createButton(numAL, "5");
		JButton JButton6 = createButton(numAL, "6");
		JButton JButton1 = createButton(numAL, "1");
		JButton JButton2 = createButton(numAL, "2");
		JButton JButton3 = createButton(numAL, "3");
		JButton JButton0 = createButton(numAL, "0");
		JButton plus = createButton(numAL, "+");
		JButton minus = createButton(numAL, "-");
		JButton multiply = createButton(numAL, "*");
		JButton divide = createButton(numAL, "/");
		JButton decimal = createButton(numAL, ".");
		JButton clear = createButton(new ClearAL(this), "C");
		JButton equals = createButton(new EqualsAL(this), "=");
		JButton backSpace = createButton(new BackAL(this), "<--");
		calcSwitch = createButton(new CalcAL(this), "Scientific");
		
		buttonPanel.add(new JLabel());
		buttonPanel.add(clear);
		buttonPanel.add(backSpace);
		buttonPanel.add(divide);
		buttonPanel.add(JButton7);
		buttonPanel.add(JButton8);
		buttonPanel.add(JButton9);
		buttonPanel.add(multiply);
		buttonPanel.add(JButton4);
		buttonPanel.add(JButton5);
		buttonPanel.add(JButton6);
		buttonPanel.add(minus);
		buttonPanel.add(JButton1);
		buttonPanel.add(JButton2);
		buttonPanel.add(JButton3);
		buttonPanel.add(plus);
		buttonPanel.add(calcSwitch);
		buttonPanel.add(JButton0);
		buttonPanel.add(decimal);
		buttonPanel.add(equals);
		return buttonPanel;
	}

}
