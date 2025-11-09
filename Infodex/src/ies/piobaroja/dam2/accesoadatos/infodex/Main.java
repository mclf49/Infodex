package ies.piobaroja.dam2.accesoadatos.infodex;


import java.util.ArrayList;

import javax.swing.ScrollPaneConstants;

import ies.piobaroja.dam2.accesoadatos.infodex.controllers.ReadBooksController;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Book;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Entry;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Infodex;
import ies.piobaroja.dam2.accesoadatos.infodex.views.ReadBooksView;

public class Main {
	public static void main(String[] args) {
		
		Infodex infodex = new Infodex();
		Book book1 = new Book("Pokemon");
		Book book2 = new Book("Objetos informáticos");
		Book book3 = new Book("Alumnos del Pio Baorja");
		Entry e1 = new Entry("Charmander");
		Entry e2 = new Entry("Bulbasaur");
		Entry e3 = new Entry("Squirtle");

		infodex.createBook(book1);
		infodex.createBook(book2);
		infodex.createBook(book3);
		
		infodex.addEntryToBook(book1, e1);
		infodex.addEntryToBook(book1, e2);
		infodex.addEntryToBook(book1, e3);
		
		System.out.println(infodex.readEntriesOfBook(book2));

		InfodexFrame mainFrame = new InfodexFrame();
		
		
		
		mainFrame.add(new ReadBooksView());
		mainFrame.setVisible(true);
		
		
	}
}
