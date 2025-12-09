package ies.piobaroja.dam2.accesoadatos.infodex.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "entries")
public class Entry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int entryID;
	@Column
	private String entryName;
	@Column
	private String entryDescription;
	@ManyToOne
	@JoinColumn(name="book_id", nullable = false)
	private Book book;
	
	public Entry() {
		
	}
	
	public void setEntryID(int entryID) {
		this.entryID = entryID;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Entry(String entryName, String entryDescription) {
		this.entryName=entryName;
		this.entryDescription= entryDescription;
	}
	
	public String getEntryName() {
		return this.entryName;
	}
	
	public void setEntryName(String entryName) {
		this.entryName = entryName;
	}

	public void setEntryDescription(String entryDescription) {
		this.entryDescription = entryDescription;
	}

	public String getEntryDescription() {
		return this.entryDescription;
	}
	
	public int getEntryID() {
		return this.entryID;
	}
	
	@Override
	public String toString() {
		return String.format("[Entry ID: %s] [Entry name: %s]\n [Entry description: %s]", entryID, entryName, entryDescription);
	}
}
