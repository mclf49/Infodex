package ies.piobaroja.dam2.accesoadatos.infodex.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ies.piobaroja.dam2.accesoadatos.infodex.model.Book;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Infodex;
import ies.piobaroja.dam2.accesoadatos.infodex.views.EditBookView;
import ies.piobaroja.dam2.accesoadatos.infodex.views.InfodexPanel;

public class EditBookController {
	private EditBookView editBookView;
	private Infodex infodex;
	private InfodexPanel infodexPanel;
	private Book oldBook;
	
	public EditBookController(InfodexPanel infodexPanel, EditBookView editBookView, Infodex infodex) {
		this.editBookView= editBookView;
		this.infodex= infodex;
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
				oldBook.setTitle(editBookView.getNewNameTf().getText());
				infodexPanel.showReadBooksView();
				editBookView.getNewNameTf().setText("");
			}
		});
	}
	public void setBook(int bookIndex) {
		this.oldBook = infodex.getBook(bookIndex);
		editBookView.getNewNameTf().setText(oldBook.getTitle());
		editBookView.getNewNameTf().grabFocus();
	}
}
