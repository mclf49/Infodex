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
	public JPopupMenu popupMenu;
	
	public TwoButtonsJPanel(JButton mainButton) {
		this.mainButton = mainButton;
		this.dots= new JButton("...");
		//this.menu= new JPopupMenu();
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		add(mainButton);
		add(dots);
		
		popupMenu = new JPopupMenu();
		
		JMenuItem mntmOption = new JMenuItem("Option 1");
		popupMenu.add(mntmOption);
		
		JMenuItem mntmOption_1 = new JMenuItem("Option 2");
		popupMenu.add(mntmOption_1);
		
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
	
}
