package ies.piobaroja.dam2.accesoadatos.infodex.views;

import java.awt.CardLayout;

import javax.swing.JPanel;

import ies.piobaroja.dam2.accesoadatos.infodex.controllers.CreateNewBookController;
import ies.piobaroja.dam2.accesoadatos.infodex.controllers.CreateNewEntryController;
import ies.piobaroja.dam2.accesoadatos.infodex.controllers.EditBookController;
import ies.piobaroja.dam2.accesoadatos.infodex.controllers.EditEntryController;
import ies.piobaroja.dam2.accesoadatos.infodex.controllers.ReadBooksController;
import ies.piobaroja.dam2.accesoadatos.infodex.controllers.ReadEntriesController;

public class InfodexPanel extends JPanel{
	private static final long serialVersionUID = -9050345153066713422L;
	

	private CardLayout cardLayout = new CardLayout();
	
	/*Declaration of views and its controllers*/
	private ReadBooksView readBooksView;
	private ReadBooksController readBooksController;
	
	private CreateNewBookView createNewBookView;
	private CreateNewBookController createNewBookController;
	
	private EditBookView editBookView;
	private EditBookController editBookController;
	
	private ReadEntriesView readEntriesView;
	private ReadEntriesController readEntriesController;
	
	private CreateNewEntryView createNewEntryView;
	private CreateNewEntryController createNewEntryController;
	
	private EditEntryView editEntryView;
	private EditEntryController editEntryController;
	
	
	
	public InfodexPanel() {
		setLayout(cardLayout);
		
		/*Initiates views, adds them to Should follow same order as attributes, if I don't mess it up*/
		
		readBooksView = new ReadBooksView();
		add(readBooksView, "readBooksView");
		readBooksController = new ReadBooksController(this,readBooksView);
		
		createNewBookView = new CreateNewBookView();
		add(createNewBookView, "createNewBookView");
		createNewBookController = new CreateNewBookController(this, createNewBookView);
		
		editBookView = new EditBookView();
		add(editBookView, "editBookView");
		editBookController = new EditBookController(this, editBookView);
		
		readEntriesView = new ReadEntriesView();
		add(readEntriesView, "readEntriesView");
		readEntriesController = new ReadEntriesController(this, readEntriesView);
		
		createNewEntryView = new CreateNewEntryView();
		add(createNewEntryView, "createNewEntryView");
		createNewEntryController = new CreateNewEntryController(this, createNewEntryView);
		
		editEntryView= new EditEntryView();
		add(editEntryView, "editEntryView");
		editEntryController = new EditEntryController(this, editEntryView);
		
	}
	
	public void showReadBooksView() {
		readBooksController.readyButtons();
		cardLayout.show(this, "readBooksView");
	}
	
	public void showCreateNewBookView() {
		cardLayout.show(this, "createNewBookView");
	}
	
	public void showEditBookView(int bookID) {
		editBookController.setBook(bookID);
		cardLayout.show(this, "editBookView");
		
	}
	public void showReadEntriesView(int bookID) {
		readEntriesController.readyButtons(bookID);
		cardLayout.show(this, "readEntriesView");
	}
	
	public void showCreateNewEntryView(int bookID) {
		createNewEntryController.setBook(bookID);
		cardLayout.show(this,"createNewEntryView");
	}

	public void showEditEntryView(int bookID, int entryID) {
		editEntryController.setEntry(bookID, entryID);
		cardLayout.show(this, "editEntryView");
	}
}
