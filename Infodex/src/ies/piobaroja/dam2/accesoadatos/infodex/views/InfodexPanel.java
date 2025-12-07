package ies.piobaroja.dam2.accesoadatos.infodex.views;

import java.awt.CardLayout;

import javax.swing.JPanel;

import ies.piobaroja.dam2.accesoadatos.infodex.controllers.CreateNewBookController;
import ies.piobaroja.dam2.accesoadatos.infodex.controllers.CreateNewEntryController;
import ies.piobaroja.dam2.accesoadatos.infodex.controllers.ReadBooksController;
import ies.piobaroja.dam2.accesoadatos.infodex.controllers.ReadEntriesController;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Infodex;

public class InfodexPanel extends JPanel{
	private static final long serialVersionUID = -9050345153066713422L;
	
	private final Infodex infodex;

	private final CardLayout cardLayout = new CardLayout();
	
	/*Declaration of views and its controllers*/
	private final ReadBooksView readBooksView;
	private final ReadBooksController readBooksController;
	
	private final CreateNewBookView createNewBookView;
	private final CreateNewBookController createNewBookController;
	
	private final ReadEntriesView readEntriesView;
	private final ReadEntriesController readEntriesController;
	
	private final CreateNewEntryView createNewEntryView;
	private final CreateNewEntryController createNewEntryController;
	
	
	
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
		
		createNewEntryView = new CreateNewEntryView();
		add(createNewEntryView, "createNewEntryView");
		createNewEntryController = new CreateNewEntryController(this, infodex, createNewEntryView);
		
	}
	
	public void showReadBooksView() {
		readBooksController.readyButtons();
		cardLayout.show(this, "readBooksView");
	}
	
	public void showCreateNewBookView() {
		cardLayout.show(this, "createNewBookView");
	}
	
	public void showReadEntriesView(int bookIndex) {
		System.out.println("He recibido el índice" + bookIndex);
		readEntriesController.readyButtons(bookIndex);
		cardLayout.show(this, "readEntriesView");
	}
	
	public void showCreateNewEntryView(int bookIndex) {
		createNewEntryController.setBook(bookIndex);
		cardLayout.show(this,"createNewEntryView");
	}
}
