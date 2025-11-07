package ies.piobaroja.dam2.accesoadatos.infodex.views;

import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ReadBooksView extends JPanel{
	private JButton newBookButton = new JButton("New Book");
	private FlowLayout flowLayout;
	
	public ReadBooksView() {
		drawButtons(50);
		flowLayout = new FlowLayout(FlowLayout.LEFT, 7, 7);
		setLayout(flowLayout); 
		add(newBookButton);
	}

	public void drawButtons(int buttonsAmmount) {
		
		for (int i = 1; i<= buttonsAmmount;i++) {
			JPanel container = new JPanel();
			container.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
			JButton button = new JButton("Button " + i);
			JButton dots = new JButton("...");
			container.add(button);
			container.add(dots);
			this.add(container);
			
		}
		
	}
}
