package ies.piobaroja.dam2.accesoadatos.infodex;


import javax.swing.ScrollPaneConstants;

import ies.piobaroja.dam2.accesoadatos.infodex.views.ReadBooksView;

public class Main {
	public static void main(String[] args) {

		InfodexFrame mainFrame = new InfodexFrame();
		
		
		
		mainFrame.add(new ReadBooksView());
		mainFrame.setVisible(true);
	}
}
