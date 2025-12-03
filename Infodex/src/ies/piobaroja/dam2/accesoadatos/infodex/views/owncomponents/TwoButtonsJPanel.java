package ies.piobaroja.dam2.accesoadatos.infodex.views.owncomponents;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class TwoButtonsJPanel extends JPanel{
	private static final long serialVersionUID = -2215544257617420634L;
	
	
	
	private JButton mainButton;
	private JButton dots;
	
	public TwoButtonsJPanel(JButton mainButton) {
		this.mainButton = mainButton;
		this.dots= new JButton("...");

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		add(mainButton);
		add(dots);
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
