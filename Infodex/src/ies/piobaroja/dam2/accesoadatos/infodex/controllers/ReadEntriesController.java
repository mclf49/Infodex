package ies.piobaroja.dam2.accesoadatos.infodex.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import ies.piobaroja.dam2.accesoadatos.infodex.model.Book;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Entry;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Infodex;
import ies.piobaroja.dam2.accesoadatos.infodex.views.InfodexPanel;
import ies.piobaroja.dam2.accesoadatos.infodex.views.ReadEntriesView;
import ies.piobaroja.dam2.accesoadatos.infodex.views.owncomponents.TwoButtonsJPanel;

public class ReadEntriesController {
	private InfodexPanel infodexPanel;
	private ReadEntriesView readEntriesView;
	private Infodex infodex;
	private int bookIndex;
	
	public ReadEntriesController(InfodexPanel infodexPanel, ReadEntriesView readEntriesView,Infodex infodex) {
		this.infodexPanel = infodexPanel;
		this.readEntriesView=readEntriesView;
		this.infodex = infodex;
		
		readEntriesView.getNewEntryButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Envío en readEntriesController" + bookIndex);
				infodexPanel.showCreateNewEntryView(bookIndex);
			}
		});
		
		readEntriesView.getReturnButton().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				infodexPanel.showReadBooksView();
				
			}
		});
	}
	
public void readyButtons(int bookIndex) {
		this.bookIndex=bookIndex;
		readEntriesView.removeAll();
		readEntriesView.addDefaultButtons();
		
		Book book = infodex.getBook(bookIndex);
		for(Entry entry: book) {
			
			final int entryIndex = book.indexOf(entry);
			
			String buttonName = entry.getEntryName();
			JButton jButton = (new JButton(buttonName));
			jButton.addActionListener(new ActionListener() {
				
				
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println(entry.getEntryName());
					System.out.println(entry.getEntryDescription());
					JOptionPane.showMessageDialog(infodexPanel, entry.getEntryDescription(),entry.getEntryName(),JOptionPane.PLAIN_MESSAGE);
				}
			});
			
			TwoButtonsJPanel twoButtonsJPanel = new TwoButtonsJPanel(jButton);
			
			twoButtonsJPanel.getDotsButton().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					twoButtonsJPanel.getPopupMenu().show(twoButtonsJPanel.getDotsButton(), 0, 20);
					
				}
			});
			
			twoButtonsJPanel.getEditOption().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					infodexPanel.showEditEntryView(bookIndex, entryIndex);
					
				}
			});
			
			twoButtonsJPanel.getDeleteOption().addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int option = JOptionPane.showConfirmDialog(infodexPanel, String.format("¿Seguro que quieres eliminar el libro %s?", book.getTitle()), "Confirm delete", JOptionPane.YES_NO_OPTION);
					if(option==JOptionPane.YES_OPTION) {
						
						book.remove(entryIndex);
						readEntriesView.revalidate();
						readEntriesView.repaint();
						readyButtons(bookIndex);
	
					}
				}
			});
			
			readEntriesView.drawButton(twoButtonsJPanel);
			
		}
		
		
	}
}
