package ies.piobaroja.dam2.accesoadatos.infodex.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import ies.piobaroja.dam2.accesoadatos.infodex.Main;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Book;
import ies.piobaroja.dam2.accesoadatos.infodex.model.Entry;
import ies.piobaroja.dam2.accesoadatos.infodex.views.InfodexPanel;
import ies.piobaroja.dam2.accesoadatos.infodex.views.ReadEntriesView;
import ies.piobaroja.dam2.accesoadatos.infodex.views.owncomponents.TwoButtonsJPanel;

public class ReadEntriesController {
	private InfodexPanel infodexPanel;
	private ReadEntriesView readEntriesView;

	public ReadEntriesController(InfodexPanel infodexPanel, ReadEntriesView readEntriesView) {
		this.infodexPanel = infodexPanel;
		this.readEntriesView=readEntriesView;
		
	}
	
	private void readyDefaultBtns(int bookID) {
		
		readEntriesView.addReturnButton();
		readEntriesView.addNewEntryBtn();
		
		readEntriesView.getNewEntryButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				infodexPanel.showCreateNewEntryView(bookID);
			}});
		readEntriesView.getReturnButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				infodexPanel.showReadBooksView();
			}});
	}
	
	private TwoButtonsJPanel buildItem(Entry entry) {
		JButton btn = new JButton(entry.getEntryName());
		btn.addActionListener(new ActionListener() {
			  @Override public void actionPerformed(ActionEvent e) {
			  System.out.println(entry.getEntryName());
			  System.out.println(entry.getEntryDescription());
			  JOptionPane.showMessageDialog(infodexPanel,
			  entry.getEntryDescription(),entry.getEntryName(),JOptionPane.PLAIN_MESSAGE);
			  } });
		TwoButtonsJPanel item = new TwoButtonsJPanel(btn);
		return item;
	}
	
public void readyButtons(int bookID) {
	
	readEntriesView.removeAll();
	readyDefaultBtns(bookID);
	Book book = Main.bookDAO.readBook(bookID);
	List<Entry>entries = book.getEntries();
	for (Entry entry:entries) {
		final Entry e= entry;
		readEntriesView.drawItemBtn(buildItem(e));
	}
	
	
	/*
	 * 
	 * Book book = infodex.getBook(bookIndex); for(Entry entry: book) {
	 * 
	 * final int entryIndex = book.indexOf(entry);
	 * 
	 * String buttonName = entry.getEntryName(); JButton jButton = (new
	 * JButton(buttonName)); jButton.
	 * 
	 * TwoButtonsJPanel twoButtonsJPanel = new TwoButtonsJPanel(jButton);
	 * 
	 * twoButtonsJPanel.getDotsButton().addActionListener(new ActionListener() {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) {
	 * twoButtonsJPanel.getPopupMenu().show(twoButtonsJPanel.getDotsButton(), 0,
	 * 20);
	 * 
	 * } });
	 * 
	 * twoButtonsJPanel.getEditOption().addActionListener(new ActionListener() {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) {
	 * infodexPanel.showEditEntryView(bookIndex, entryIndex);
	 * 
	 * } });
	 * 
	 * twoButtonsJPanel.getDeleteOption().addActionListener(new ActionListener() {
	 * 
	 * @Override public void actionPerformed(ActionEvent e) { int option =
	 * JOptionPane.showConfirmDialog(infodexPanel,
	 * String.format("¿Seguro que quieres eliminar el libro %s?", book.getTitle()),
	 * "Confirm delete", JOptionPane.YES_NO_OPTION);
	 * if(option==JOptionPane.YES_OPTION) {
	 * 
	 * book.remove(entryIndex); readEntriesView.revalidate();
	 * readEntriesView.repaint(); readyButtons(bookIndex);
	 * 
	 * } } });
	 * 
	 * readEntriesView.drawButton(twoButtonsJPanel);
	 * 
	 * }
	 * 
	 */
	}
}
