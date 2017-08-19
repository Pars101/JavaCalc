package com.leo.mr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NumberAL implements ActionListener 
{
	private GUI gui;
	
	public NumberAL(GUI gui)
	{
		this.gui = gui;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		gui.updateText(((JButton)e.getSource()).getText());
	}
}
