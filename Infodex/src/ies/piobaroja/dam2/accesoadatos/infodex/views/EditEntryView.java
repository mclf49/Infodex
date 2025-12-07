package ies.piobaroja.dam2.accesoadatos.infodex.views;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JTextField;

public class EditEntryView extends JPanel{
	private JLabel newDescriptionJlbl = new JLabel("Introduce new description:  ");
	private JButton acceptBtn = new JButton("Accept");
	private JButton cancelBtn = new JButton("Cancel");
	private final JTextField newNameTf = new JTextField();
	private final JTextField newDescriptionTf = new JTextField();
	private final JLabel newNameJlbl = new JLabel("Introduce new name:  ");
	
	
	public EditEntryView () {
		newNameTf.setColumns(10);
		newDescriptionTf.setColumns(20);
		
		setLayout(new FormLayout(new ColumnSpec[] {
				ColumnSpec.decode("105px"),
				ColumnSpec.decode("99px"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("65px:grow"),
				FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("65px"),},
			new RowSpec[] {
				FormSpecs.LINE_GAP_ROWSPEC,
				RowSpec.decode("23px"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		add(newNameJlbl, "1, 4, 2, 1, right, default");
		add(newNameTf, "4, 4, left, fill");
		add(newDescriptionJlbl, "1, 6, 2, 1, right, center");
		add(newDescriptionTf,"4, 6, left, fill");
		add(acceptBtn, "2, 20, left, top");
		add(cancelBtn, "4, 20, left, top");
	}


	public JButton getAcceptBtn() {
		return acceptBtn;
	}
	public JButton getCancelBtn() {
		return cancelBtn;
	}
	public JTextField getNewNameTf() {
		return newNameTf;
	}
	public JTextField getNewDescriptionTf() {
		return newDescriptionTf;
	}
	
}
