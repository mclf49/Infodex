package ies.piobaroja.dam2.accesoadatos.infodex.model;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String title;
	@OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Entry>entries = new ArrayList<Entry>();
	public Book() {
		
	}
	public Book(String title) {
		this.title=title;
	}
	
	public int getID() {
		return this.id; 
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	public List<Entry> getEntries() {
		return entries;
	}
	
	public void addEntry(Entry entry) {
		entry.setBook(this);
		entries.add(entry);
	}
	
	public void removeEntry(int entryID) {
		entries.remove(entryID);
	}
	
	@Override
	public String toString() {
		String s="";
		for(Entry entry:entries) {
			s+="[";
			s+=entry.getEntryName();
			s+="]";
		}
		if(s.isEmpty()) {return title+" [Empty]";}
		else {return title+s;}
	}
}
