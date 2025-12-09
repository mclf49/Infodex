package ies.piobaroja.dam2.accesoadatos.infodex.views;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import ies.piobaroja.dam2.accesoadatos.infodex.views.owncomponents.TwoButtonsJPanel;

public class ReadEntriesView extends JPanel{

	private static final long serialVersionUID = 9130832811771153650L;

	private JButton newEntryButton = new JButton ("New Entry");
	private JButton returnButton = new JButton ("Go back");
	private FlowLayout flowLayout;

	public ReadEntriesView() {
		flowLayout = new FlowLayout(FlowLayout.LEFT, 25, 20);
		setLayout(flowLayout); 
	}
	
	public void drawItemBtn(TwoButtonsJPanel twoButtonsJPanel) {
		this.add(twoButtonsJPanel);
}
	
	public JButton getNewEntryButton() {
		return newEntryButton;
	}
	
	public JButton getReturnButton() {
		return returnButton;
	}
	
	public void addNewEntryBtn() {
		add(newEntryButton);
	}
	
	public void addReturnButton() {
		add(returnButton);
	}
}
