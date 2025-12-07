package ies.piobaroja.dam2.accesoadatos.infodex.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Infodex {
	
	private ArrayList<Book> books;
	
	public Infodex() {
		books = new ArrayList<Book>();
	}
	
	public void createBook(Book book) {
		books.add(book);
	}
	
	public Book getBook(int bookIndex) {
		return books.get(bookIndex);
	}
	
	public int indexOfBook(Book book) {
		return books.indexOf(book);
	}
	
	public ArrayList<Book> readBooks(){
		return books;
	}
	
	public void updateBook(Book oldBook, Book newBook) {
		books.set(books.indexOf(oldBook), newBook);
	}
	
	public void removeBook(int bookIndex) {
		System.out.println("Eliminado libro "+bookIndex);
		books.remove(bookIndex);
	}
	
	public void updateEntry(Book book, Entry oldEntry, Entry newEntry) {
		book.set(book.indexOf(oldEntry), newEntry);
	}
	
	
	public void addEntryToBook(Book book, Entry entry) {
		book.add(entry);
	}
	
	public String readEntriesOfBook(Book book){
		return book.toString();
	}
}
