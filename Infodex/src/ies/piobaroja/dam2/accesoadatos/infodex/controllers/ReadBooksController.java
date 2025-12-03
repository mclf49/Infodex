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
		readyButtons();
	}

	
	public void readyButtons() {
		
		readBooksView.removeAll();
		readBooksView.addNewBookBtn();
		
		for(Book book: infodex.readBooks()) {
			
			JButton jButton = (new JButton(infodex.readBooks().get(infodex.readBooks().indexOf(book)).getTitle()));
			jButton.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.print("Pulsado botón"+ jButton.getText());
					System.out.println(" con tamaño "+infodex.readBooks().size());
					infodexPanel.showReadEntriesView(infodex.readBooks().indexOf(book));
				}
			});
			
			TwoButtonsJPanel twoButtonsJPanel = new TwoButtonsJPanel(jButton);
			twoButtonsJPanel.getDotsButton().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					//TODO Auto-generated method stub
					twoButtonsJPanel.popupMenu.show(twoButtonsJPanel.getDotsButton(), 0, 20);
				}
			});
			
			readBooksView.drawButton(twoButtonsJPanel);
			
		}
	}
}
