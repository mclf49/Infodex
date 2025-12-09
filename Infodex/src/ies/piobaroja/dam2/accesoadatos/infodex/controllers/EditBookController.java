package ies.piobaroja.dam2.accesoadatos.infodex.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ies.piobaroja.dam2.accesoadatos.infodex.Main;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Book;
import ies.piobaroja.dam2.accesoadatos.infodex.views.EditBookView;
import ies.piobaroja.dam2.accesoadatos.infodex.views.InfodexPanel;

public class EditBookController {
	private EditBookView editBookView;
	private InfodexPanel infodexPanel;
	private Book oldBook;
	
	public EditBookController(InfodexPanel infodexPanel, EditBookView editBookView) {
		this.editBookView= editBookView;
		this.infodexPanel= infodexPanel;
		
		
		editBookView.getCancelBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				infodexPanel.showReadBooksView();
			}
		});
		
		editBookView.getAcceptBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			
				if(editBookView.getNewNameTf().getText().isBlank()) {
					JOptionPane.showMessageDialog(infodexPanel, String.format("Por favor introduce el nuevo nombre del libro %s", oldBook.getTitle()));
				}
				//DAO
				oldBook.setTitle(editBookView.getNewNameTf().getText());
				Book book = oldBook;
				Main.bookDAO.updateBook(book);
				//Vista
				infodexPanel.showReadBooksView();
				editBookView.getNewNameTf().setText("");
			}
		});
	}
	public void setBook(int bookID) {
		this.oldBook = Main.bookDAO.readBook(bookID);
		editBookView.getNewNameTf().setText(oldBook.getTitle());
		editBookView.getNewNameTf().grabFocus();
	}
}
