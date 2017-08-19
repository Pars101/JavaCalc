package com.leo.mr;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClearAL implements ActionListener 
{
	GUI gui;
	
	public ClearAL(GUI gui)
	{
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		gui.display.setText("");
	}

}
