package ies.piobaroja.dam2.accesoadatos.infodex.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ies.piobaroja.dam2.accesoadatos.infodex.model.Book;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Entry;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Infodex;
import ies.piobaroja.dam2.accesoadatos.infodex.views.EditEntryView;
import ies.piobaroja.dam2.accesoadatos.infodex.views.InfodexPanel;

public class EditEntryController {
	private EditEntryView editEntryView;
	private Infodex infodex;
	private InfodexPanel infodexPanel;
	private Book book;
	private Entry entry;
	
	public EditEntryController(InfodexPanel infodexPanel, Infodex infodex, EditEntryView editEntryView) {
		this.infodex=infodex;
		this.infodexPanel=infodexPanel;
		this.editEntryView=editEntryView;
		
		editEntryView.getCancelBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				infodexPanel.showReadEntriesView(infodex.indexOfBook(book));
			}
		});
		
		editEntryView.getNewNameTf().grabFocus();
		editEntryView.getAcceptBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(editEntryView.getNewNameTf().getText().isBlank()) {
					JOptionPane.showMessageDialog(infodexPanel, String.format("Por favor, introduce un nombre para el elemento de la lista %s", book.getTitle()));
					return;
				}
				if(editEntryView.getNewDescriptionTf().getText().isBlank()) {
					JOptionPane.showMessageDialog(infodexPanel, String.format("Por favor, introduce una descripción para el ítem %s", entry.getEntryName()));
					return;
				}
				
				book.set(book.indexOf(entry), new Entry(editEntryView.getNewNameTf().getText(), editEntryView.getNewDescriptionTf().getText()));
				
				infodexPanel.showReadEntriesView(infodex.indexOfBook(book));
				editEntryView.getNewNameTf().setText("");
				editEntryView.getNewDescriptionTf().setText("");
				
			}
		});
	}
	
	public void setEntry(int bookIndex, int entryIndex) {
		this.book=infodex.getBook(bookIndex);
		this.entry=book.get(entryIndex);
		editEntryView.getNewNameTf().setText(entry.getEntryName());
		editEntryView.getNewDescriptionTf().setText(entry.getEntryDescription());
	}
}
