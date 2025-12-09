package ies.piobaroja.dam2.accesoadatos.infodex;

import ies.piobaroja.dam2.accesoadatos.infodex.dao.BookDAO;
import ies.piobaroja.dam2.accesoadatos.infodex.dao.EntryDAO;
import ies.piobaroja.dam2.accesoadatos.infodex.views.InfodexPanel;

public class Main {
	
		public static BookDAO bookDAO = new BookDAO();
		public static EntryDAO entryDAO = new EntryDAO();
		public static void main(String[] args) {
		InfodexFrame infodexFrame = new InfodexFrame();
		InfodexPanel infodexPanel = new InfodexPanel();
		infodexFrame.add(infodexPanel);
		infodexFrame.setVisible(true);
		
		infodexPanel.showReadBooksView();
		infodexPanel.revalidate();
		infodexPanel.repaint();
	}
}
