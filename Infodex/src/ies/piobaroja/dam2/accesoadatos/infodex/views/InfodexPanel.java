package ies.piobaroja.dam2.accesoadatos.infodex.views;

import java.awt.CardLayout;

import javax.swing.JPanel;

import ies.piobaroja.dam2.accesoadatos.infodex.controllers.CreateNewBookController;
import ies.piobaroja.dam2.accesoadatos.infodex.controllers.CreateNewEntryController;
import ies.piobaroja.dam2.accesoadatos.infodex.controllers.EditBookController;
import ies.piobaroja.dam2.accesoadatos.infodex.controllers.EditEntryController;
import ies.piobaroja.dam2.accesoadatos.infodex.controllers.ReadBooksController;
import ies.piobaroja.dam2.accesoadatos.infodex.controllers.ReadEntriesController;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Infodex;

public class InfodexPanel extends JPanel{
	private static final long serialVersionUID = -9050345153066713422L;
	
	private Infodex infodex;

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
		
		editBookView = new EditBookView();
		add(editBookView, "editBookView");
		editBookController = new EditBookController(this, editBookView, infodex);
		
		readEntriesView = new ReadEntriesView();
		add(readEntriesView, "readEntriesView");
		readEntriesController = new ReadEntriesController(this, readEntriesView, infodex);
		
		createNewEntryView = new CreateNewEntryView();
		add(createNewEntryView, "createNewEntryView");
		createNewEntryController = new CreateNewEntryController(this, infodex, createNewEntryView);
		
		editEntryView= new EditEntryView();
		add(editEntryView, "editEntryView");
		editEntryController = new EditEntryController(this, infodex, editEntryView);
		
	}
	
	public void showReadBooksView() {
		readBooksController.readyButtons();
		cardLayout.show(this, "readBooksView");
	}
	
	public void showCreateNewBookView() {
		cardLayout.show(this, "createNewBookView");
	}
	
	public void showEditBookView(int bookIndex) {
		editBookController.setBook(bookIndex);
		cardLayout.show(this, "editBookView");
		
	}
	public void showReadEntriesView(int bookIndex) {
		readEntriesController.readyButtons(bookIndex);
		cardLayout.show(this, "readEntriesView");
	}
	
	public void showCreateNewEntryView(int bookIndex) {
		createNewEntryController.setBook(bookIndex);
		cardLayout.show(this,"createNewEntryView");
	}

	public void showEditEntryView(int bookIndex, int entryIndex) {
		editEntryController.setEntry(bookIndex, entryIndex);
		cardLayout.show(this, "editEntryView");
	}
}
