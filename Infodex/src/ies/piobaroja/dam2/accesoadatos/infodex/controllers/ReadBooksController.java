package ies.piobaroja.dam2.accesoadatos.infodex.controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JMenuItem;

import ies.piobaroja.dam2.accesoadatos.infodex.views.owncomponents.TwoButtonsJPanel;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Book;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Infodex;
import ies.piobaroja.dam2.accesoadatos.infodex.views.InfodexPanel;
import ies.piobaroja.dam2.accesoadatos.infodex.views.ReadBooksView;

public class ReadBooksController {
	private InfodexPanel infodexPanel;
	private ReadBooksView readBooksView;
	private Infodex infodex;
	
	public ReadBooksController(InfodexPanel infodexPanel, ReadBooksView readBooksView,Infodex infodex) {
		this.infodexPanel = infodexPanel;
		this.readBooksView=readBooksView;
		this.infodex = infodex;
	}

	
	public void readyButtons() {
		
		readBooksView.removeAll();
		readBooksView.addNewBookBtn();
		
		readBooksView.getNewBookButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				infodexPanel.showCreateNewBookView();				
			}
		});
		
		ArrayList<Book> books = infodex.readBooks();
	
		for(int i=0;i<books.size();i++) {
			
			//Estas deben ser constantes locales porque por lo visto así funcionan Java y sus clases anónimas dentro de un bucle. 
			final int bookIndex= i;
			final Book book = infodex.getBook(bookIndex);
			
			final JButton jButton = (new JButton(book.getTitle()));
			jButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.print("Pulsado botón"+ jButton.getText());
					System.out.println(" con tamaño "+book.size());

					infodexPanel.showReadEntriesView(bookIndex);
				}
			});
			
			TwoButtonsJPanel twoButtonsJPanel = new TwoButtonsJPanel(jButton);
			twoButtonsJPanel.getDotsButton().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//TODO Auto-generated method stub
					twoButtonsJPanel.getPopupMenu().show(twoButtonsJPanel.getDotsButton(), 0, 20);
					
					twoButtonsJPanel.getEditOption().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							infodexPanel.showEditBookView(bookIndex);
							
						}
					});
				}
			});
			
			readBooksView.drawButton(twoButtonsJPanel);
			
		}
	}
}
