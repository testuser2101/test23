import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.event.RowSorterEvent;
import javax.swing.event.RowSorterListener;
import javax.swing.table.DefaultTableModel;
public class Control{

	private View projectView=new View();
	private Model projectModel=new Model();
	String listSelected;
	addpanel newmovie;
	public static void main(String[] args) {
		Control TEST = new Control();
	}
	public Control() {
		projectView.addfileToC(new addfromfile());
		projectView.loadToC(new loadbutton());
		projectView.addToC(new addbutton());
		projectView.deleteToC(new deletbut());
		projectView.searchToC(new Searchlis());
		projectView.sortByToC(new sortbyList());
		projectView.saveToC(new savebutton());
		projectView.gettabmod().setRowCount(0);
		Drawtable();
	}
	class loadbutton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int result = projectView.getFileChooser().showOpenDialog(projectView);
			if (projectView.getFileChooser().getSelectedFile()==null || result == projectView.getFileChooser().CANCEL_OPTION )
				System.out.println("plik nie zosta³ zmieniony, jest to wci¹¿ "+projectModel.getcsvfile());
			else if (result == projectView.getFileChooser().APPROVE_OPTION) {
				projectModel.loadfromfile(projectView.getFileChooser().getSelectedFile());
				projectView.gettabmod().setRowCount(0);
				projectModel.updateDataFromCSV();
				Drawtable();
			}
		}
	}
	class savebutton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int result = projectView.getFileChooser().showSaveDialog(projectView);
			if (projectView.getFileChooser().getSelectedFile()==null || result == JFileChooser.CANCEL_OPTION ) {
				System.out.println("abort");
			}
			else 
				if (result == JFileChooser.APPROVE_OPTION){
				System.out.println("u have saved "+projectView.getFileChooser().getSelectedFile());
				projectModel.saveFile(projectView.getFileChooser().getSelectedFile());
			}
		}
	}
	class addfromfile implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int result = projectView.getFileChooser().showOpenDialog(projectView);
			if (projectView.getFileChooser().getSelectedFile()==null || result == projectView.getFileChooser().CANCEL_OPTION )
				System.out.println("plik nie zosta³ zmieniony, jest to wci¹¿ "+projectModel.getcsvfile());
			else if (result == projectView.getFileChooser().APPROVE_OPTION){
				projectModel.fileAddMovies(projectView.getFileChooser().getSelectedFile());
				projectView.gettabmod().setRowCount(0);
				Drawtable();
			}
		}
	}
	
	class addbutton implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			addpanel newmovie = new addpanel();
			newmovie.addpToC(new addpanelbut(newmovie));
		}
	}
	class deletbut implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			int x[]=projectView.getTable().getSelectedRows();
			for (int i=0;i<x.length;i++){
				projectView.gettabmod().removeRow(x[i]-i);
				projectModel.deleteDataRow(x[projectModel.getSelectedRow().get(i)]-i);
			}
			projectModel.updateFile();
			Drawtable();
		}	
	}
	class sortUpBut implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {

		}
	}
	class sortbyList implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			  JComboBox cb = (JComboBox)e.getSource();
			  System.out.println(cb.getSelectedIndex());
		        String petName = (String)cb.getSelectedItem();
			listSelected = petName;
		}
	}
	class addpanelbut implements ActionListener{
	addpanel newmovie;
		addpanelbut(addpanel newmovie){
			this.newmovie=newmovie;
		}
			public void actionPerformed(ActionEvent e) {
			projectModel.addNewMovie(newmovie.gettitletext().getText(),newmovie.getgenretext().getText(),
			newmovie.getdirectortext().getText(), newmovie.getlengthtext().getText(),
			newmovie.getdatetext().getText());
			newmovie.dispose();
			Drawtable();
		}
	}
	
	class Searchlis implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Drawtable();
		}
	}
	public void Drawtable() {
		projectModel.getSelectedRow().clear();
		projectView.gettabmod().setRowCount(0);
		if (!projectModel.getdata().isEmpty())
			for (int i=0;i<	projectModel.getdata().size();i++) {
				if(projectModel.getdata().get(i)[projectView.getCB().getSelectedIndex()].contains(projectView.getTextField().getText())||projectView.getTextField().getText()=="") {		
					
					projectModel.getSelectedRow().add(i);
					projectView.gettabmod().addRow(projectModel.getdata().get(i));
					System.out.println(projectView.getTable().convertRowIndexToModel(i)+"dupa");
				}
			}
		else {
				/////////////////////////////////////////////////////////////////////////////////////////
				/////////////////////////////////////////////////////////////////////////////////////////
				/////////////////////////////////////////////////////////////////////////////////////////
				//KOMUNIKAT O DODANYM PUSTYM PLIKU
				/////////////////////////////////////////////////////////////////////////////////////////
				/////////////////////////////////////////////////////////////////////////////////////////
				/////////////////////////////////////////////////////////////////////////////////////////
		}
	}
}

	
	
	
	
	






