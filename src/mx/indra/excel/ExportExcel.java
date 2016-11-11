package mx.indra.excel;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExportExcel {
	
	public ExportExcel(){
		
	}
	
    public static void generaExcel(XSSFWorkbook workbook, int item,
			String centralElectrica, String unidadHidroElectrica, Map<String, Double> horas, String fecha, String prefix)
					throws IOException, URISyntaxException{

		System.out.println("Params :: centralElectrica :: " + centralElectrica + " :: unidadHidroElectrica :: " + unidadHidroElectrica);
		XSSFCellStyle cellStyle = workbook.createCellStyle();
		/*
		* Obtenemos la primera pestaña a la que se quiera procesar indicando el indice.
		*/
		XSSFSheet sheet = workbook.getSheetAt(item);
		
		// Se coloca el nombre de la Unidad HidroElectrica
		XSSFCell celdaWrite= sheet.getRow(15).getCell(3);
		HSSFRichTextString texto = new HSSFRichTextString(unidadHidroElectrica);
		celdaWrite.setCellValue(texto.getString());
		workbook.setSheetName(item,prefix + unidadHidroElectrica);
		
		// Se colocan fechas
		celdaWrite= sheet.getRow(3).getCell(3);
		// Se crea el contenido de la celda y se mete en ella.
		texto = new HSSFRichTextString(fecha.toString());
		celdaWrite.setCellValue(texto.getString());
		
		celdaWrite= sheet.getRow(3).getCell(7);
		// Se crea el contenido de la celda y se mete en ella.
		texto = new HSSFRichTextString(fecha.toString());
		celdaWrite.setCellValue(texto.getString());
		
		// Se crea la central electrica
		celdaWrite= sheet.getRow(3).getCell(11);
		// Se crea el contenido de la celda y se mete en ella.
		texto = new HSSFRichTextString(centralElectrica.toString());
		celdaWrite.setCellValue(texto.getString());
		
		// Se crea la unidad hidroelectrica
		celdaWrite= sheet.getRow(3).getCell(15);
		// Se crea el contenido de la celda y se mete en ella.
		texto = new HSSFRichTextString(unidadHidroElectrica.toString());
		celdaWrite.setCellValue(texto.getString());
		
		
		int count = 13;
		for(Integer itemMap=1; itemMap<=25; itemMap++){
			celdaWrite= sheet.getRow(count).getCell(3);
			// Se crea el contenido de la celda y se mete en ella.
			celdaWrite.setCellValue(horas.get(("hora" + itemMap)));

			count++;		
		}
		
    }

}