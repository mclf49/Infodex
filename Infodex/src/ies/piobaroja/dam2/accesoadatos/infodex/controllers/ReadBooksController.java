package ies.piobaroja.dam2.accesoadatos.infodex.controllers;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JButton;

import ies.piobaroja.dam2.accesoadatos.infodex.views.owncomponents.BookButtonJPanel;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Book;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Infodex;
import ies.piobaroja.dam2.accesoadatos.infodex.views.ReadBooksView;

public class ReadBooksController {
	private ReadBooksView readBooksView;
	private Infodex infodex;
	
	public ReadBooksController(ReadBooksView readBooksView,Infodex infodex) {
		this.readBooksView=readBooksView;
		this.infodex = infodex;
		readyButtons();
	}

	
	private void readyButtons() {
		
		for(int i = 0; i<infodex.readBooks().size(); i++) {
			JButton jButton = (new JButton(infodex.readBooks().get(i).getTitle()));
			jButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(jButton.getText());
					System.out.println(infodex.readBooks().size());
					
				}
			});
			
			BookButtonJPanel bookButtonJPanel = new BookButtonJPanel(jButton);
			readBooksView.drawButton(bookButtonJPanel);
			
			
		}
		
		
		readBooksView.getNewBookButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				infodex.createBook(new Book("Nuevo libro"));
			}
		});
	}
}
