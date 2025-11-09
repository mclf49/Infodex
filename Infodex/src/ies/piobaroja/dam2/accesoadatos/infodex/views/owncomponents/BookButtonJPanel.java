package ies.piobaroja.dam2.accesoadatos.infodex.views.owncomponents;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BookButtonJPanel extends JPanel{
	
	private int bookButtonJPanelIndex;
	private JButton mainButton;
	private JButton dots;
	
	public BookButtonJPanel(JButton mainButton, JButton dots, int bookButtonJPanelIndex) {
		this.mainButton = mainButton;
		this.dots= dots;
		this.bookButtonJPanelIndex=bookButtonJPanelIndex;
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		add(mainButton);
		add(dots);
	}
	
	public void setBookButtonJPanelIndex(int index) {
		this.bookButtonJPanelIndex= index;
	}
	public int getBookButtonJPanelIndex() {
		return bookButtonJPanelIndex;
	}
	
	public JButton getMainButton() {
		return mainButton;
	}
	
	public void setMainButtonText(String text) {
		mainButton.setText(text);
	}
	
	public JButton getDotsButton() {
		return dots;
	}
	
	
}
