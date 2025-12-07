package ies.piobaroja.dam2.accesoadatos.infodex.model;

public class Entry {
	private static int count = 0;
	private int entryID;
	private String entryName;
	private String entryDescription;
	
	public Entry(String entryName, String entryDescription) {
		this.entryName=entryName;
		this.entryDescription= entryDescription;
	}
	
	public String getEntryName() {
		return this.entryName;
	}
	
	public String getEntryDescription() {
		return this.entryDescription;
	}
}
