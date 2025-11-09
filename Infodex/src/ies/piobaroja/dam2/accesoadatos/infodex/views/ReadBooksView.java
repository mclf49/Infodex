package ies.piobaroja.dam2.accesoadatos.infodex.views;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import ies.piobaroja.dam2.accesoadatos.infodex.views.owncomponents.BookButtonJPanel;

public class ReadBooksView extends JPanel{
	private JButton newBookButton = new JButton("New Book");
	private FlowLayout flowLayout;
	
	public ReadBooksView() {
		drawButtons(100);
		flowLayout = new FlowLayout(FlowLayout.LEFT, 25, 20);
		setLayout(flowLayout); 
		add(newBookButton);
	}

	public void drawButtons(int buttonsAmmount) {
		
		for (int i = 1; i<= buttonsAmmount;i++) {
			JButton button = new JButton("Button " + i);
			JButton dots = new JButton("...");
			BookButtonJPanel bookButtonJPanel = new BookButtonJPanel(button, dots, i);
			
			this.add(bookButtonJPanel);
			
		}
		
	}
}
