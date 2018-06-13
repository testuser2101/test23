import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.commons.io.*;
public class Model {
	private ArrayList<Integer> searchrow = new ArrayList<Integer>();
	private String dir = System.getProperty("user.dir");
	private boolean sortup=true;
	private File csvfile= new File("newcsvfile.csv");
	ArrayList<String[]> data = new ArrayList<String[]>();
	private FileReader reader;
	private BufferedReader buffreader;
	private String[][] Data;
		Model() {
			
		if (!csvfile.exists())
			try {
				csvfile.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		csvfile = new File(dir+"/newcsvfile.csv");
		updateDataFromCSV();
		
		}
	public void deleteDataRow(int x) {
		data.remove(x);
	}
	
	
	
	public void updateDataFromCSV() {
		data.clear();
		int line=0;
		int lines = 0;
		String textline;
		String[] textparts;	
			System.out.println(csvfile);
			try {
				reader = new FileReader(csvfile);
			} catch (FileNotFoundException e1) {
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
				e.printStackTrace();
			}
			System.out.println(data.size());
		updateFile();

	}
	public void updateFile() {
		
		try {
			FileUtils.writeStringToFile(csvfile, "");
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		for (int i=0; i<data.size();i++) {
			for (int j=0;j<5;j++) {
				try {
					FileUtils.writeStringToFile(csvfile,FileUtils.readFileToString(csvfile)+data.get(i)[j]+";");
					

				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
			try {
				FileUtils.writeStringToFile(csvfile,FileUtils.readFileToString(csvfile)+"\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
		}
	}
		
	public void loadfromfile(File loadfile) {
		System.out.println(csvfile+"   jego dlugosc to   "+csvfile.length());
		csvfile = loadfile;
		System.out.println(csvfile+"   jego dlugosc to   "+csvfile.length());
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
	public void addNewMovie(String name, String genre, String director, String date, String length) {
		String[] temp={name, genre, director, length, date};
		try {
			FileUtils.writeStringToFile(csvfile, FileUtils.readFileToString(csvfile)+name+";"+genre+";"+director+";"+length+";"+date);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		data.add(temp);
		updateFile();
	}
	public void fileAddMovies(File addcsvfile) {
		try {
			FileUtils.writeStringToFile(csvfile, FileUtils.readFileToString(csvfile)+FileUtils.readFileToString(addcsvfile));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		updateDataFromCSV();
		updateFile();
	}
	

	public void searchby(String sortby) {
			//todo
			//dupadupadupadupadupadupadupadupadupadupadupadupadupadupadupadupadupa
			//dupadupadupadupadupadupadupadupadupadupadupadupadupadupadupadupadupa
			//dupadupadupadupadupadupadupadupadupadupadupadupadupadupadupadupadupa
		System.out.println("sortuje po: " +sortby);
	}
	public File getcsvfile(){
		return csvfile;
	}
	public ArrayList<String[]> getdata() {
		return data;
	}
	public ArrayList<Integer> getSelectedRow(){
		return searchrow;
	}
}
