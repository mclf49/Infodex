package ies.piobaroja.dam2.accesoadatos.infodex.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import ies.piobaroja.dam2.accesoadatos.infodex.views.owncomponents.TwoButtonsJPanel;
import ies.piobaroja.dam2.accesoadatos.infodex.Main;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Book;
import ies.piobaroja.dam2.accesoadatos.infodex.views.InfodexPanel;
import ies.piobaroja.dam2.accesoadatos.infodex.views.ReadBooksView;

public class ReadBooksController {
	private InfodexPanel infodexPanel;
	private ReadBooksView readBooksView;
	
	public ReadBooksController(InfodexPanel infodexPanel, ReadBooksView readBooksView) {
		this.infodexPanel = infodexPanel;
		this.readBooksView=readBooksView;
	}

	
	private TwoButtonsJPanel buildItem(Book book) {
		JButton jbtn = new JButton(book.getTitle());
		jbtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				infodexPanel.showReadEntriesView(book.getID());
			}
		});
		
		TwoButtonsJPanel item = new TwoButtonsJPanel(jbtn);
		item.getDotsButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				item.getPopupMenu().show(item.getDotsButton(), 0, 20);
			}
		});
		
		item.getDeleteOption().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(infodexPanel, 
						String.format("¿Seguro que quieres eliminar el libro %s?", book.getTitle()), 
						"Confirm delete", JOptionPane.YES_NO_OPTION);
				
				if(option==JOptionPane.YES_OPTION) {
					System.out.println("iijj" +book.getEntries());
				
					Main.bookDAO.deleteBook(book);
					readBooksView.revalidate();
					readBooksView.repaint();
					readyButtons();
			}
			}
		});
		
		item.getEditOption().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				infodexPanel.showEditBookView(book.getID());
			}
		});
		
		return item;
	}
	
	private void readyDefaultBtns() {
		readBooksView.addNewBookBtn();
		
		readBooksView.getNewBookButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				infodexPanel.showCreateNewBookView();
				
			}
		});
	}
	
	public void readyButtons() {
		
		readBooksView.removeAll();
		readyDefaultBtns();
		List<Book> books = Main.bookDAO.readBooks();
		
		System.out.println(books);
		
		for(Book book:books) {
			final Book b=book;
			readBooksView.drawItemBtn(buildItem(b));
		}
			
	}
	
}

