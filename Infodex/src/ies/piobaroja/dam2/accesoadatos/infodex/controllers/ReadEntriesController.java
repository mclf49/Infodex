package ies.piobaroja.dam2.accesoadatos.infodex.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ies.piobaroja.dam2.accesoadatos.infodex.model.Book;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Infodex;
import ies.piobaroja.dam2.accesoadatos.infodex.views.InfodexPanel;
import ies.piobaroja.dam2.accesoadatos.infodex.views.ReadEntriesView;
import ies.piobaroja.dam2.accesoadatos.infodex.views.owncomponents.TwoButtonsJPanel;

public class ReadEntriesController {
	private InfodexPanel infodexPanel;
	private ReadEntriesView readEntriesView;
	private Infodex infodex;
	
	public ReadEntriesController(InfodexPanel infodexPanel, ReadEntriesView readEntriesView,Infodex infodex) {
		this.infodexPanel = infodexPanel;
		this.readEntriesView=readEntriesView;
		this.infodex = infodex;
		
		readEntriesView.getNewEntryButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//infodexPanel.showNewEntryView();
				
			}
		});
		
		readEntriesView.getReturnButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				infodexPanel.showReadBooksView();
				
			}
		});
	}
	
public void readyButtons(int i) {
		
		
		readEntriesView.removeAll();
		readEntriesView.addDefaultButtons();
		
		
		Book book = infodex.readBooks().get(i);
		for(int x = 0; x<book.size(); x++) {
			JButton jButton = (new JButton(book.get(x).getEntryName()));
			jButton.addActionListener(new ActionListener() {
				
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(jButton.getText());
					System.out.println(book.size());
					
				}
			});
			
			TwoButtonsJPanel twoButtonsJPanel = new TwoButtonsJPanel(jButton);
			twoButtonsJPanel.getDotsButton().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					twoButtonsJPanel.getPopupMenu().show(twoButtonsJPanel.getDotsButton(), 0, 20);
					
				}
			});
			readEntriesView.drawButton(twoButtonsJPanel);
			
			
		}
		
		
		readEntriesView.getNewEntryButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//infodexPanel.showCreateNewEntryView();
			}
		});
	}
}
