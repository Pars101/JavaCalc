package com.leo.mr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackAL implements ActionListener 
{
	
	GUI gui;
	
	public BackAL(GUI gui)
	{
		this.gui = gui;
	}
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		int i = gui.display.getText().length() - 1;
		gui.display.setText(gui.display.getText().substring(0, i));
		i--;
	}

}
