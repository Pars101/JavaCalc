package com.leo.mr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EqualsAL implements ActionListener 
{
	private GUI gui;
	
	public EqualsAL(GUI gui)
	{
		this.gui = gui;
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(gui.isScientificCalc)
		{
			gui.showResult(Calculations.calculate(gui.display.getText()));
		}
		else
		{
			gui.showResult(Calculations.standardCalc(gui.display.getText()));
		}
	}

}
