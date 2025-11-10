package ies.piobaroja.dam2.accesoadatos.infodex;


import java.util.ArrayList;

import javax.swing.ScrollPaneConstants;

import ies.piobaroja.dam2.accesoadatos.infodex.controllers.ReadBooksController;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Book;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Entry;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Infodex;
import ies.piobaroja.dam2.accesoadatos.infodex.views.InfodexPanel;
import ies.piobaroja.dam2.accesoadatos.infodex.views.ReadBooksView;

public class Main {
	public static void main(String[] args) {
		
		Infodex infodex1 = new Infodex();
		Book book1 = new Book("Pokemon");
		Book book2 = new Book("Objetos informáticos");
		Book book3 = new Book("Alumnos del Pio Baorja");
		Entry e1 = new Entry("Charmander");
		Entry e2 = new Entry("Bulbasaur");
		Entry e3 = new Entry("Squirtle");

		infodex1.createBook(book1);
		infodex1.createBook(book2);
		infodex1.createBook(book3);
		
		infodex1.addEntryToBook(book1, e1);
		infodex1.addEntryToBook(book1, e2);
		infodex1.addEntryToBook(book1, e3);
		
		System.out.println(infodex1.readEntriesOfBook(book2));

		InfodexFrame infodexFrame = new InfodexFrame();
		
		
		InfodexPanel infodexPanel = new InfodexPanel(infodex1);
		infodexFrame.add(infodexPanel);
		infodexFrame.setVisible(true);
		
		infodexPanel.showReadBooksView();
	}
}
