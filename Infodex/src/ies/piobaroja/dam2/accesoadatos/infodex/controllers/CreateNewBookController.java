package ies.piobaroja.dam2.accesoadatos.infodex.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ies.piobaroja.dam2.accesoadatos.infodex.Main;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Book;
import ies.piobaroja.dam2.accesoadatos.infodex.views.CreateNewBookView;
import ies.piobaroja.dam2.accesoadatos.infodex.views.InfodexPanel;

public class CreateNewBookController {
	private InfodexPanel infodexPanel;
	private CreateNewBookView createNewBookView;

	
	public CreateNewBookController(InfodexPanel infodexPanel, CreateNewBookView createNewBookView) {
		this.createNewBookView = createNewBookView;
		this.infodexPanel = infodexPanel;
		
		createNewBookView.getSubmitBtn().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(createNewBookView.getBookNameTF().getText().isBlank()) {
					JOptionPane.showMessageDialog(infodexPanel, "Por favor introduce un nombre");
					return;
				}
				//Llamada al modelo
					Main.bookDAO.createBook(new Book(createNewBookView.getBookNameTF().getText()));
				//Actualiza la vista
				infodexPanel.showReadBooksView();
				createNewBookView.getBookNameTF().setText("");
			}
		});
	}
}
