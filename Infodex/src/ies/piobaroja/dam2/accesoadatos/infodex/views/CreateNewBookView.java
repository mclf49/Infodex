package ies.piobaroja.dam2.accesoadatos.infodex.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.TextField;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JButton;

public class CreateNewBookView extends JPanel{
	private TextField bookNameTextField = new TextField();
	private JButton submitBtn;
	public CreateNewBookView() {
	setLayout(new FormLayout(new ColumnSpec[] {
			ColumnSpec.decode("108px"),
			ColumnSpec.decode("78px"),
			FormSpecs.LABEL_COMPONENT_GAP_COLSPEC,
			ColumnSpec.decode("150px"),},
		new RowSpec[] {
			FormSpecs.LINE_GAP_ROWSPEC,
			RowSpec.decode("33px"),
			FormSpecs.RELATED_GAP_ROWSPEC,
			FormSpecs.DEFAULT_ROWSPEC,
			FormSpecs.RELATED_GAP_ROWSPEC,
			FormSpecs.DEFAULT_ROWSPEC,
			FormSpecs.RELATED_GAP_ROWSPEC,
			FormSpecs.DEFAULT_ROWSPEC,
			FormSpecs.RELATED_GAP_ROWSPEC,
			FormSpecs.DEFAULT_ROWSPEC,}));
	
		
	
	JLabel lblNewLabel = new JLabel("Book's name:");
	add(lblNewLabel, "2, 4, left, center");
	bookNameTextField.setColumns(20);
	add(bookNameTextField, "4, 4, left, top");
	
	submitBtn = new JButton("Confirm");
	add(submitBtn, "4, 10");
	}
	
	public TextField getBookNameTF() {
		return bookNameTextField;
	}
	public JButton getSubmitBtn() {
		return submitBtn;
	}
}
