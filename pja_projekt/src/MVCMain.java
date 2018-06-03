

import java.awt.Font;
import java.io.File;
import java.io.IOException;

public class MVCMain {
	public static void main(String[] args) {	
		View viewmain= new View();
		Model modelmain = new Model();
		Control controlmain = new Control(viewmain,modelmain);
	}
}