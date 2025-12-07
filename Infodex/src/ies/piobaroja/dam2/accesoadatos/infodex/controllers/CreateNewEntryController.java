package ies.piobaroja.dam2.accesoadatos.infodex.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ies.piobaroja.dam2.accesoadatos.infodex.model.Book;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Entry;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Infodex;
import ies.piobaroja.dam2.accesoadatos.infodex.views.CreateNewEntryView;
import ies.piobaroja.dam2.accesoadatos.infodex.views.InfodexPanel;

public class CreateNewEntryController {
	private InfodexPanel infodexPanel;
	private Infodex infodex;
	private Book book;
	private CreateNewEntryView createNewEntryView;
	
	public CreateNewEntryController(InfodexPanel infodexPanel, Infodex infodex, CreateNewEntryView createNewEntryView) {
		this.createNewEntryView= createNewEntryView;
		this.infodexPanel= infodexPanel;
		this.infodex=infodex;
		
		createNewEntryView.getSubmitBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(createNewEntryView.getEntryNameTF().getText().isBlank()) {
					JOptionPane.showMessageDialog(infodexPanel, "Por favor, introduce un nombre para la entrada");
					return;
				}
				else if(createNewEntryView.getDescriptionTF().getText().isBlank()) {
					JOptionPane.showMessageDialog(infodexPanel, "Por favor, introduce una descripción para la entrada");
					return;
				}
				String entryName= createNewEntryView.getEntryNameTF().getText();
				String entryDescription = createNewEntryView.getDescriptionTF().getText();
				System.out.println("Entrada añadida al libro " + book.getTitle());
				book.add(new Entry(entryName, entryDescription));
				JOptionPane.showMessageDialog(infodexPanel, String.format("Creado nuevo item %s con descripción %s",entryName,entryDescription));;
				infodexPanel.showReadEntriesView(infodex.indexOfBook(book));
				createNewEntryView.getEntryNameTF().setText("");
				createNewEntryView.getDescriptionTF().setText("");
			}
		});
	}
	
	public void setBook(int bookIndex) {
		this.book=infodex.getBook(bookIndex);
	}
}
