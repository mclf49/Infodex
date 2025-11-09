package ies.piobaroja.dam2.accesoadatos.infodex.model;

import java.util.ArrayList;

public class Book extends ArrayList<Entry>{

	private static final long serialVersionUID = 8750020979438849026L;
	private String title;
	
	public Book(String title) {
		this.title=title;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	@Override
	public String toString() {
		String s="";
		for(Entry entry:this) {
			s+="[";
			s+=entry.getEntryName();
			s+="]";
		}
		if(s.isEmpty()) {return "[Empty]";}
		else {return s;}
	}
}
