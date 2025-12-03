package ies.piobaroja.dam2.accesoadatos.infodex.model;

import java.util.ArrayList;
import java.util.HashMap;

public class Infodex {
	
	private ArrayList<Book> books;
	private ArrayList<Entry> entries;
	
	
	public Infodex() {
		books = new ArrayList<Book>();
	}
	
	public void createBook(Book book) {
		books.add(book);
	}
	
	public ArrayList<Book> readBooks(){
		return books;
	}
	
	public void updateBook(Book oldBook, Book newBook) {
		books.set(books.indexOf(oldBook), newBook);
	}
	
	public void removeBook(Book book) {
		books.remove(book);
	}
	
	public void createEntry(Entry entry) {
		entries.add(entry);
	}
	
	public ArrayList<Entry> readEntries() {
		return entries;
	}
	
	public void updateEntry(Entry oldEntry, Entry newEntry) {
		entries.set(entries.indexOf(oldEntry), newEntry);
	}
	
	public void removeEntry(Entry entry) {
		entries.remove(entry);
	}
	
	public void addEntryToBook(Book book, Entry entry) {
		book.add(entry);
	}
	
	public String readEntriesOfBook(Book book){
		return book.toString();
	}
}
