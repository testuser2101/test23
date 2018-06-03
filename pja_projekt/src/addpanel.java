import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class addpanel extends JFrame{
	
	private JPanel maincontener = new JPanel();
	private JPanel bottomcontener = new JPanel();
	private JPanel gridcontener = new JPanel();
	private JLabel title = new JLabel ("Title");
	private JLabel director = new JLabel ("Director");
	private JLabel date = new JLabel ("Publication date");
	private JLabel genre = new JLabel ("Genre");
	private JLabel length = new JLabel ("Length");
	private JTextField titletext = new JTextField ("x");
	private JTextField directortext = new JTextField ("x");
	private JTextField datetext = new JTextField ("x");
	private JTextField genretext = new JTextField ("x");
	private JTextField lengthtext = new JTextField ("x");
	private JButton add = new JButton ("Add a movie");
	addpanel(){
		super("Add a movie");
		maincontener.setLayout(new BorderLayout());
		maincontener.add(gridcontener, BorderLayout.CENTER);
		bottomcontener.add(add);
		
		maincontener.add(bottomcontener, BorderLayout.PAGE_END);
		
		gridcontener.setLayout(new GridLayout(5,2,5,0));
		
		gridcontener.add(title);
		gridcontener.add(titletext);
		gridcontener.add(genre);
		gridcontener.add(genretext);
		gridcontener.add(director);
		gridcontener.add(directortext);
		gridcontener.add(date);
		gridcontener.add(datetext);
		gridcontener.add(length);
		gridcontener.add(lengthtext);




		
		
		
		gridcontener.add(lengthtext);
		this.add(maincontener);
		
		
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(400,200);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}
	
	void addpToC(ActionListener e) {
		add.addActionListener(e);		
	}
	public JTextField gettitletext() {
		return titletext;
	}
	public JTextField getdirectortext() {
		return directortext;
	}
	public JTextField getdatetext() {
		return datetext;
	}
	public JTextField getgenretext() {
		return genretext;
	}
	public JTextField getlengthtext() {
		return lengthtext;
	}
}
