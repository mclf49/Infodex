package ies.piobaroja.dam2.accesoadatos.infodex.model;

import java.util.ArrayList;

public class Book {

	private int bookIndex;
	private String title;
	private ArrayList<Entry> entries = new ArrayList<Entry>();
	
	public Book(String title) {
		this.title=title;
	}
	
	public int getIndex(){
		return bookIndex;
	}
	
	public void setIndex(int index) {
		//TODO Handle out of index exception. Please Manu, for the life of you, please...
		this.bookIndex=index;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	public void addEntry(Entry entry) {
		entries.add(entry);
	}
	
	public ArrayList<Entry> readEntries() {
		return entries;
	}
	
	public void updateEntry(Entry oldEntry, Entry newEntry) {
		int i=entries.indexOf(oldEntry);
		entries.set(i, newEntry);
	}
	
	public void removeEntry(Entry entry) {
		entries.remove(entry);
	}
	
	
}
