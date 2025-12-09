package ies.piobaroja.dam2.accesoadatos.infodex.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import ies.piobaroja.dam2.accesoadatos.infodex.Main;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Book;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Entry;


public class BookDAO {

	private EntityManager em;
	
	public BookDAO() {
		EntityManagerFactory emf;
		emf=Persistence.createEntityManagerFactory("infodex");
		em=emf.createEntityManager();
		}

	public void createBook(Book book) {
		
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.persist(book);
		et.commit();
		
	}
	
	public List<Book> readBooks() {
		String query = "SELECT b FROM Book b";
		List<Book> books = em.createQuery(query, Book.class).getResultList();
		return books;
	}
	
	public Book readBook(int BookID) {
		return em.find(Book.class, BookID);
	}
	
	public void updateBook(Book book) {
		Book ubook=em.getReference(Book.class, book.getID());
		EntityTransaction et=em.getTransaction();
		et.begin();
		ubook.setTitle(book.getTitle());
		et.commit();
	}
	
	public void deleteBook(Book book) {
		EntityTransaction et=em.getTransaction();
		et.begin();
		em.remove(book);
		et.commit();
	}
}

