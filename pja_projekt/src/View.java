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
import java.awt.event.ActionEvent;

import javax.swing.*;
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
	
	private DefaultTableModel tabmodel= new DefaultTableModel(list, 0);
	private JButton addfromfile = new JButton("Add from CSV file");
	private JButton savebutton= new JButton("Save to");
	private JPanel mainPanel = new JPanel();
	private JPanel navPan = new JPanel();
	
	private JButton LoadFile = new JButton("Load CSV File");
	private JButton add = new JButton("Add");
	private JButton delete = new JButton("Delete");
	private JComboBox sortList = new JComboBox(list);
	private JButton sortup = new JButton ("⇅");
	
	private JLabel search = new JLabel("Search");
	private JTextField searchfield = new JTextField();
	private JLabel searchby = new JLabel ("Search by");
	private JPanel bottompan = new JPanel();
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
		// TODO Auto-generated catch block
		e1.printStackTrace();
		}		
		

		
		table.setDefaultEditor(Object.class, null);
		font = font.deriveFont(1, 15);
		text.setText("gowno");
		text.setFont(font);
	//	System.out.println(text.getFont());
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
	//	bottompan.setLayout(new BorderLayout());
	//	table.setFillsViewportHeight(true);
	//	scroll.setSize(new Dimension(this.getHeight()-navPan.getHeight(),this.getWidth()-navPan.getWidth()));					
		System.out.println(sortList.getSelectedIndex());
		

		chooseFile.setAcceptAllFileFilterUsed(false);
		chooseFile.setFileFilter(csvfilter);
		//chooseFile.setCurrentDirectory(new File(System.getProperty("user.home")));

		
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
	public DefaultTableModel gettabmod() {
		return tabmodel;
		
	}

	
	
//	_______________________________________________________
// file chooser	
	public JFileChooser getFileChooser() {
	//	try {
		
//		int result = chooseFile.showOpenDialog(this);
//		File tempfile ;
//			if (chooseFile.getSelectedFile()==null || result == JFileChooser.CANCEL_OPTION ) {
//				
//				System.out.println("abort");
//				return chooseFile;
///			}
//			else if (result == JFileChooser.APPROVE_OPTION){
//				System.out.println("u have chose "+chooseFile.getSelectedFile());
//				tempfile=chooseFile.getSelectedFile();
//				System.out.println(tempfile.length());
///				return chooseFile;
//			}
//		}
//		catch (Exception e) {
//			return null;
//		}
		return chooseFile;
	}
//		_______________________________________________________
		// saving file			
}



	
