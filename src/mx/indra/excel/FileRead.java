package mx.indra.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileRead {

	public static void main(String[] args) throws FileNotFoundException {

		FileRead f1 = new FileRead();
		f1.readExcel();


	}
	
	public void readExcel() throws FileNotFoundException{

    	ClassLoader classLoader = getClass().getClassLoader();
    	File file = new File("FormatoExport1.xlsx"); 
    	System.out.println("File :: " + file.getAbsolutePath());
    	
	}

}
