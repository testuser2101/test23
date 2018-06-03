import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.*;


public class Model {
	private String dir;
	private boolean sortup=true;
	private File csvfile= new File("newcsvfile.csv");
//	private File addcsvfile = new File("newcsvfile2.csv");
	ArrayList<String[]> data = new ArrayList<String[]>();

	private FileReader reader;

	
	private BufferedReader buffreader;
	private String[][] Data;
	
		Model() {
			getfilepath();
			try {
		if (!csvfile.exists())
			
				csvfile.createNewFile();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				
			}	
		csvfile = new File(dir+"/newcsvfile.csv");
		returncsvstringastable();
		
		
		
		}
		
	
	public void getfilepath() {
		dir = System.getProperty("user.dir");
		
		try {
			System.out.println(csvfile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public ArrayList<String[]> returncsvstringastable() {
		data.clear();
		int line=0;
		int lines = 0;
		String textline;
		String[] textparts;	
		
			System.out.println(csvfile);
			try {
				reader = new FileReader(csvfile);
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			buffreader = new BufferedReader (reader);
	
			
			try {
				while (buffreader.ready()) {
					line++;
					textline = buffreader.readLine();
					textparts = textline.split(";");
					
						if (textparts.length==5) {
							data.add(textparts);
							System.out.println("wszystko OK na lini "+ line);
						}
						else {
							textline= "";
							System.out.println("Cos poszlo nie tak w lini "+line);
						}
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			System.out.println(data.size());

		updateFile(data);
		return data;
	}
	
	
	
	
	private void updateFile(ArrayList<String[]> data) {
		// TODO Auto-generated method stub
		try {
			FileUtils.writeStringToFile(csvfile, "");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i=0; i<data.size();i++) {
			for (int j=0;j<5;j++) {
				try {
					FileUtils.writeStringToFile(csvfile, FileUtils.readFileToString(csvfile)+data.get(i)[j]+";");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
	}


	public void loadfromfile(File loadfile) {
		System.out.println(csvfile+"   jego dlugosc to   "+csvfile.length());
		csvfile = loadfile;
		System.out.println(csvfile+"   jego dlugosc to   "+csvfile.length());
	}


	
	public void sort() {
		
	}
	
	public void saveFile(File saveFile) {
		try {
			
			FileUtils.writeStringToFile(saveFile, FileUtils.readFileToString(csvfile));
			saveFile.createNewFile();
			System.out.println(saveFile+"   jego dlugosc to   "+saveFile.length());
		}catch (Exception e) {
			System.out.println(e);
		}
		
		
	}
	int index=0;
	
	public void addNewMovie(String name, String genre, String director, String length, String date) {
		System.out.println("testaddnewmovie");
		try {
			FileUtils.writeStringToFile(csvfile, FileUtils.readFileToString(csvfile)+name+";"+genre+";"+director+";"+length+";"+date+"\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(csvfile.length());
		
		
//		System.out.println(data.get(index++));
		
	
	}
	
	public void delete() {
		System.out.println("DELETtest");
		
		
	}
	
	public void fileAddMovies(File addcsvfile) {
		System.out.println(csvfile+"   jego dlugosc to   "+csvfile.length());
		try {
			FileUtils.writeStringToFile(csvfile, FileUtils.readFileToString(csvfile)+FileUtils.readFileToString(addcsvfile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(csvfile+"   jego dlugosc to   "+csvfile.length());
	}
	
	
	public void sortup() {
		if (sortup){
			sortup=false;
			System.out.println("Sortujê w do³");
			
		}
		else {
			sortup=true;
			System.out.println("Sortuje w gore");
		}
	}	
	
	
		public void searchby(String sortby) {
		System.out.println("sortuje po: " +sortby);
	}
	
	
		
		
		
		
		
		
	
	
	
	public File getcsvfile() {
		return csvfile;
	}
//	public File getaddcsvfile() {
//		return addcsvfile;
//	}
	public void changefile(File csvfilev) {
		this.csvfile = csvfilev;
	}
//	public void addfile(File csvfilev) {
//		this.addcsvfile = csvfilev;
	//}





}
