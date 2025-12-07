package ies.piobaroja.dam2.accesoadatos.infodex.controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

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
			final int bookIndex = i;
			Book book = infodex.getBook(bookIndex);
			
			JButton jButton = (new JButton(book.getTitle()));
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
					
					
					ActionListener[] eals = twoButtonsJPanel.getEditOption().getActionListeners();
					for(ActionListener al:eals) {
						twoButtonsJPanel.getEditOption().removeActionListener(al);						
					}
					twoButtonsJPanel.getEditOption().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							infodexPanel.showEditBookView(bookIndex);
							
						}
					});
					ActionListener[] dals = twoButtonsJPanel.getDeleteOption().getActionListeners();
					for(ActionListener al:dals) {
						twoButtonsJPanel.getDeleteOption().removeActionListener(al);						
					}
					twoButtonsJPanel.getDeleteOption().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							
							int option = JOptionPane.showConfirmDialog(infodexPanel, String.format("¿Seguro que quieres eliminar el libro %s?", book.getTitle()), "Confirm delete", JOptionPane.YES_NO_OPTION);
							if(option==JOptionPane.YES_OPTION) {
								System.out.println("El índice apunta a " + bookIndex);
								System.out.println("Se va a borrar el libro con el índice: " + books.get(bookIndex));
								
								infodex.removeBook(bookIndex);
								
								readBooksView.revalidate();
								readBooksView.repaint();
								readyButtons();
								
							}
							
						}
					});
				}
			});
			
			readBooksView.drawButton(twoButtonsJPanel);
			
		}
	}
}
