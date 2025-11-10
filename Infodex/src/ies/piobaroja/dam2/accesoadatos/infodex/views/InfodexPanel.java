package ies.piobaroja.dam2.accesoadatos.infodex.views;

import java.awt.CardLayout;

import javax.swing.JPanel;

import ies.piobaroja.dam2.accesoadatos.infodex.controllers.ReadBooksController;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Infodex;

public class InfodexPanel extends JPanel{
	private static final long serialVersionUID = -9050345153066713422L;
	
	Infodex infodex;

	private CardLayout cardLayout = new CardLayout();
	
	//First view where all books(lists) are shown
	private ReadBooksView readBooksView;
	private ReadBooksController readBooksController;
	
	
	public InfodexPanel(Infodex infodex) {
		this.infodex=infodex;
		setLayout(cardLayout);
		
		//instances and adds views and controllers. Should follow same order as attributes, if I don't mess it up
		
		readBooksView = new ReadBooksView();
		add(readBooksView, "readBooksView");
		readBooksController = new ReadBooksController(readBooksView,infodex);
	}
	
	public void showReadBooksView() {
		cardLayout.show(this, "readBooksView");
	}
	
	
}
