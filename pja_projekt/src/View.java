import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodListener;
import java.beans.PropertyChangeListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import javax.swing.event.RowSorterListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;



public class View extends JFrame {
	
	Dimension size = new Dimension(1050,700);
	JTextField text = new JTextField();
	Font font;
	Font font2;
	File filefont;
	String[] list = { "Title", "Genre", "Director", "Publication Date", "Length" };
	ArrayList<String> dataa = new ArrayList<String>();
	
	private JPanel mainPanel = new JPanel();
	private JPanel navPan = new JPanel();

	private JButton addfromfile = new JButton("Add from CSV file");
	private JButton savebutton= new JButton("Save to");
	private JButton LoadFile = new JButton("Load CSV File");
	private JButton add = new JButton("Add");
	private JButton delete = new JButton("Delete");
	private JComboBox sortList = new JComboBox(list);
	private JButton sortup = new JButton ("⇅");
	private JLabel search = new JLabel("Search");
	private JTextField searchfield = new JTextField();
	private JLabel searchby = new JLabel ("Search by");
	private JPanel bottompan = new JPanel();
	private DefaultTableModel tabmodel= new DefaultTableModel(list, 0);
	private JTable table = new JTable(tabmodel);
	private JScrollPane scroll = new JScrollPane(table);
	private JFileChooser chooseFile = new JFileChooser();
	private FileNameExtensionFilter csvfilter = new FileNameExtensionFilter("CSV File", "csv");
	
	View(){	
		super("Pja_Project01");
		filefont = new File("src\\ComicSans.ttf");
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, filefont);
		} catch (FontFormatException | IOException e1) {
		e1.printStackTrace();
		}		
		table.setAutoCreateRowSorter(true);
		table.setDefaultEditor(Object.class, null);
		font = font.deriveFont(1, 15);
		text.setText("gowno");
		text.setFont(font);
		searchfield.setPreferredSize(new Dimension(200,25));
		navPan.setBackground(Color.white);
		navPan.add(addfromfile);
		navPan.add(LoadFile);
		navPan.add(savebutton);
		navPan.add(add);
		navPan.add(delete);
		navPan.add(search);
		navPan.add(searchfield);
		navPan.add(searchby);
		navPan.add(sortList);
		navPan.add(sortup);	
		scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		table.setFont(font);
		table.setRowHeight(25);
		mainPanel.setFont(font);
		mainPanel.setBackground(Color.cyan);
		mainPanel.setLayout(new BorderLayout());
		mainPanel.add(navPan, BorderLayout.PAGE_START);
		mainPanel.add(scroll, BorderLayout.CENTER);				
		System.out.println(sortList.getSelectedIndex());
		chooseFile.setAcceptAllFileFilterUsed(false);
		chooseFile.setFileFilter(csvfilter);
		this.setMinimumSize(size);
		this.add(mainPanel);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(size);
		this.setVisible(true);
	}	        
	
	void loadToC(ActionListener e) {
		LoadFile.addActionListener(e);	
	}
	
	void addToC(ActionListener f) {
		add.addActionListener(f);
	}
	
	void deleteToC(ActionListener g) {
		delete.addActionListener(g);
	}
	
	void sortupToC(ActionListener h) {
		sortup.addActionListener(h);
	}
	
	void sortByToC(ActionListener i) {
		sortList.addActionListener(i);
	}
	
	void saveToC(ActionListener j) {
		savebutton.addActionListener(j);
	}
	
	void addfileToC(ActionListener j) {
		addfromfile.addActionListener(j);
	}
	
	void searchToC(ActionListener k) {
			searchfield.addActionListener(k);
	}
	
	void tableSortToC(RowSorterListener l) {
	table.getRowSorter().addRowSorterListener(l);	
	}
	
	public DefaultTableModel gettabmod() {
		return tabmodel;
	}

	public JFileChooser getFileChooser() {

		return chooseFile;
	}
	public JTable getTable() {
		return table;
	}
	
	public JTextField getTextField() {
		return searchfield;
	}
	
	public JComboBox getCB() {
		return sortList;
	}
	
}



	
