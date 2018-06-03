import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
public class Control{
	private View projectView;
	private Model projectModel;
	String listSelected;
	addpanel newmovie;
	//_______________________________________________
		//Control Constructor
	
	
	public Control(View projectView, Model projectModel) {
		
		
		
		
		this.projectView=projectView;
		this.projectModel=projectModel;
		projectModel.getfilepath();
		projectView.addfileToC(new addfromfile());
		projectView.loadToC(new loadbutton());
		projectView.addToC(new addbutton());
		projectView.deleteToC(new deletbut());
		projectView.sortupToC(new sortUpBut());
		projectView.sortByToC(new sortbyList());
		projectView.saveToC(new savebutton());
		projectView.gettabmod().setRowCount(0);
		Drawtable();
	}
	
	//_______________________________________________
		//loading from file
	class loadbutton implements ActionListener{

		
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			int result = projectView.getFileChooser().showOpenDialog(projectView);
			if (projectView.getFileChooser().getSelectedFile()==null || result == projectView.getFileChooser().CANCEL_OPTION )
		
				System.out.println("plik nie zosta³ zmieniony, jest to wci¹¿ "+projectModel.getcsvfile());
			else if (result == projectView.getFileChooser().APPROVE_OPTION){
				
				projectModel.loadfromfile(projectView.getFileChooser().getSelectedFile());
				projectView.gettabmod().setRowCount(0);
				Drawtable();
			}

				
				
				//	projectModel.changefile(projectView.FileChooser(projectModel.getcsvfile()));
			
			
			//System.out.println(projectModel.getaddcsvfile()+" thats just a csvfile");
		//	System.out.println(projectModel.getaddcsvfile().length()+" thats just a csvfile length");
				
		}
		
	}
	//_______________________________________________
	//saving file to
	class savebutton implements ActionListener{
	
		@Override
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
	
	
	
	
	//_______________________________________________
	//adding from file
	class addfromfile implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {	

			int result = projectView.getFileChooser().showOpenDialog(projectView);
			if (projectView.getFileChooser().getSelectedFile()==null || result == projectView.getFileChooser().CANCEL_OPTION )
		
				System.out.println("plik nie zosta³ zmieniony, jest to wci¹¿ "+projectModel.getcsvfile());
			else if (result == projectView.getFileChooser().APPROVE_OPTION){
				
				projectModel.fileAddMovies(projectView.getFileChooser().getSelectedFile());
				projectView.gettabmod().setRowCount(0);
				Drawtable();
			}
			
	//		System.out.println(projectModel.getaddcsvfile()+" thats addcsvfile");
	//		System.out.println(projectModel.getaddcsvfile().length()+" thats addcsvfile length");
			System.out.println(projectModel.getcsvfile()+" thats just a csvfile");
			System.out.println(projectModel.getcsvfile().length()+" thats just csvfile length");
		}
	}
	
	
	
	
	
	
	
	//___________________w____________________________
		//opening adding panel button
	
	
	
	class addbutton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			addpanel newmovie = new addpanel();
			newmovie.addpToC(new addpanelbut(newmovie));
			
		}
	}
	
	
	
	
	
	//_______________________________________________
		//Deleting button
	
	class deletbut implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			projectModel.delete();
			projectView.gettabmod().removeRow(0);
			
			
			
			
		}
		//_______________________________________________
		//Sorting up-down button
	}
	
	
	
	
	
	class sortUpBut implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			projectModel.sortup();
		}
		
		//_______________________________________________
		//Sorting by combo box 
	}
	
	
	
	
	
	class sortbyList implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			  JComboBox cb = (JComboBox)e.getSource();
		        String petName = (String)cb.getSelectedItem();
			listSelected = petName;
			projectModel.searchby(petName);
		}
		
	}
	
	

	
	
	//_______________________________________________
	//adding panel listener
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
		}

	}


	
	

	public void Drawtable() {
		if (!projectModel.returncsvstringastable().isEmpty())
			for (int i=0;i<	projectModel.returncsvstringastable().size();i++)
				projectView.gettabmod().addRow(projectModel.returncsvstringastable().get(i));
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
	
	
	
	
	






