package ies.piobaroja.dam2.accesoadatos.infodex.views;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import ies.piobaroja.dam2.accesoadatos.infodex.views.owncomponents.TwoButtonsJPanel;

public class ReadBooksView extends JPanel{
	private static final long serialVersionUID = 7722008343160444314L;
	
	
	private JButton newBookButton = new JButton("New Book");
	private FlowLayout flowLayout;
	
	public ReadBooksView() {
		flowLayout = new FlowLayout(FlowLayout.LEFT, 25, 20);
		setLayout(flowLayout); 
		add(newBookButton);
	}

	public void drawItemBtn(TwoButtonsJPanel twoButtonsJPanel) {
			this.add(twoButtonsJPanel);
	}
	
	public JButton getNewBookButton() {
		return newBookButton;
	}
	
	public void addNewBookBtn() {
		add(newBookButton);
	}
}

