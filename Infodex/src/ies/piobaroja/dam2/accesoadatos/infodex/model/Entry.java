package ies.piobaroja.dam2.accesoadatos.infodex.model;

public class Entry {
	private static int count = 0;
	private int entryID;
	private String entryName;
	private String entryInfo;
	
	public Entry(String entryName) {
		this.entryName=entryName;
	}
	
	public String getEntryName() {
		return this.entryName;
	}
}
