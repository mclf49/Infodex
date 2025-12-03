package ies.piobaroja.dam2.accesoadatos.infodex.views;

import java.awt.CardLayout;

import javax.swing.JPanel;

import ies.piobaroja.dam2.accesoadatos.infodex.controllers.CreateNewBookController;
import ies.piobaroja.dam2.accesoadatos.infodex.controllers.ReadBooksController;
import ies.piobaroja.dam2.accesoadatos.infodex.controllers.ReadEntriesController;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Infodex;

public class InfodexPanel extends JPanel{
	private static final long serialVersionUID = -9050345153066713422L;
	
	Infodex infodex;

	private CardLayout cardLayout = new CardLayout();
	
	/*Declaration of views and its controllers*/
	private ReadBooksView readBooksView;
	private ReadBooksController readBooksController;
	
	private CreateNewBookView createNewBookView;
	private CreateNewBookController createNewBookController;
	
	
	private ReadEntriesView readEntriesView;
	private ReadEntriesController readEntriesController;
	
	
	
	public InfodexPanel(Infodex infodex) {
		this.infodex=infodex;
		setLayout(cardLayout);
		
		/*Initiates views, adds them to Should follow same order as attributes, if I don't mess it up*/
		
		readBooksView = new ReadBooksView();
		add(readBooksView, "readBooksView");
		readBooksController = new ReadBooksController(this,readBooksView,infodex);
		
		createNewBookView = new CreateNewBookView();
		add(createNewBookView, "createNewBookView");
		createNewBookController = new CreateNewBookController(this, createNewBookView, infodex);
		
		readEntriesView = new ReadEntriesView();
		add(readEntriesView, "readEntriesView");
		readEntriesController = new ReadEntriesController(this, readEntriesView, infodex);
		
	}
	
	public void showReadBooksView() {
		readBooksController.readyButtons();
		cardLayout.show(this, "readBooksView");
	}
	
	public void showCreateNewBookView() {
		cardLayout.show(this, "createNewBookView");
	}
	
	public void showReadEntriesView(int i) {
		readEntriesController.readyButtons(i);
		cardLayout.show(this, "readEntriesView");
	}
}
