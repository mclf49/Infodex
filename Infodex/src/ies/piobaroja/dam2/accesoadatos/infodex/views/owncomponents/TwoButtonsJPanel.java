package ies.piobaroja.dam2.accesoadatos.infodex.views.owncomponents;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JMenuItem;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TwoButtonsJPanel extends JPanel{
	private static final long serialVersionUID = -2215544257617420634L;
	
	
	
	private JButton mainButton;
	private JButton dots;
	private JPopupMenu popupMenu;
	private JMenuItem editOption;
	private JMenuItem deleteOption;
	
	
	public TwoButtonsJPanel(JButton mainButton) {
		this.mainButton = mainButton;
		this.dots= new JButton("...");
	
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		add(mainButton);
		add(dots);
		
		popupMenu = new JPopupMenu();
		
		editOption = new JMenuItem("Edit");
		popupMenu.add(editOption);
		
		deleteOption = new JMenuItem("Delete");
		popupMenu.add(deleteOption);
		
	}
	
	
	public JButton getMainButton() {
		return mainButton;
	}
	
	public void setMainButtonText(String text) {
		mainButton.setText(text);
	}
	
	public JButton getDotsButton() {
		return this.dots;
	}
	
	public JPopupMenu getPopupMenu() {
		return popupMenu;
	}
	public JMenuItem getEditOption() {
		return editOption;
	}
	public JMenuItem getDeleteOption() {
		return deleteOption;
	}
}
