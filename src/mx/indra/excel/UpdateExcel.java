package mx.indra.excel;

import java.io.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.*;
import java.util.Iterator;

public class UpdateExcel {
	
    public static void main(String[] args) throws Exception{
        
        FileInputStream fsIP= new FileInputStream(new File("holamundo.xls")); //Read the spreadsheet that needs to be updated
          
        HSSFWorkbook wb = new HSSFWorkbook(fsIP); //Access the workbook
          
        HSSFSheet worksheet = wb.getSheetAt(0); //Access the worksheet, so that we can update / modify it.
          
        Cell cell = null; // declare a Cell object
        
        cell = worksheet.getRow(2).getCell(2);   // Access the second cell in second row to update the value
          
        cell.setCellValue("OverRide Last Name");  // Get current cell value value and overwrite the value
          
        fsIP.close(); //Close the InputStream
         
        FileOutputStream output_file =new FileOutputStream(new File("FormatoExportExample2.xls"));  //Open FileOutputStream to write updates
          
        wb.write(output_file); //write changes
          
        output_file.close();  //close the stream    
	}


}
