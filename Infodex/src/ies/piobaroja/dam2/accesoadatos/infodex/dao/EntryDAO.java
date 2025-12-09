package ies.piobaroja.dam2.accesoadatos.infodex.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import ies.piobaroja.dam2.accesoadatos.infodex.model.Book;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Entry;

public class EntryDAO {
	private EntityManager em;
	
	public EntryDAO() {
		EntityManagerFactory emf;
		emf=Persistence.createEntityManagerFactory("infodex");
		em=emf.createEntityManager();
		}
	
	public void createEntry(Entry entry, Book book) {
		EntityTransaction et=em.getTransaction();
		et.begin();
		book.addEntry(entry);
		et.commit();
		}
	
	public List<Entry> readEntries(){
		String query = "SELECT e from Entry e";
		List<Entry> entries = em.createQuery(query, Entry.class).getResultList();
		return entries;
	}
	
	public Entry readEntry(int entryID) {
		return em.find(Entry.class, entryID);
	}
	
	public void updateEntry(Entry entry) {
		Entry nentry=em.getReference(Entry.class, entry.getEntryID());
		EntityTransaction et = em.getTransaction();
		et.begin();
		nentry.setEntryName(entry.getEntryName());
		nentry.setEntryDescription(entry.getEntryDescription());
		et.commit();  
	}
	
	public void deleteEntry(Entry entry) {
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.remove(entry);
		et.commit();
	}
}
