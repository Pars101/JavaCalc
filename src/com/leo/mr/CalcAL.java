package com.leo.mr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcAL implements ActionListener {
	GUI gui;
	
	public CalcAL(GUI gui)
	{
		this.gui = gui;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		gui.isScientificCalc = !gui.isScientificCalc;
		if(gui.isScientificCalc)
		{
			gui.calcSwitch.setText("Scientific");
		}
		else
		{
			gui.calcSwitch.setText("Standard");
		}
	}

}
