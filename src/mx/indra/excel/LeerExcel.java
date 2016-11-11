package mx.indra.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import mx.indra.bean.MercadoBean;
import mx.indra.bean.MercadoDiaAdelantoBean;
import mx.indra.bean.MercadoTiempoRealBean;
import mx.indra.bean.UnidadGeneradoraBean;

public class LeerExcel {

    public static void main(String args[]) throws IOException, URISyntaxException{
    	
    	List<MercadoBean> mercadoBean = new ArrayList<MercadoBean>();
		List<MercadoTiempoRealBean> mercadoTiempoReal = new ArrayList<MercadoTiempoRealBean>();
		List<MercadoDiaAdelantoBean> mercadoDiaAdelanto = new ArrayList<MercadoDiaAdelantoBean>();
		
		List<UnidadGeneradoraBean> unidadGeneradoraReal = new ArrayList<UnidadGeneradoraBean>();
		List<UnidadGeneradoraBean> unidadGeneradoraAdelanto = new ArrayList<UnidadGeneradoraBean>();
		
		UnidadGeneradoraBean unidad1 = new UnidadGeneradoraBean();
		unidad1.setCentralElectrica("Necaxa");
		unidad1.setFecha("08-11-2016");
		unidad1.setUnidadGeneradora("UN-NEC-01");
		Map<String, Double> hora = new HashMap<String, Double>();
		hora.put("1", 12.0);
		hora.put("2", 23.0);
		hora.put("3", 34.0);
		hora.put("4", 45.0);
		hora.put("5", 56.0);
		hora.put("6", 68.0);
		hora.put("7", 73.0);
		hora.put("8", 18.0);
		hora.put("9", 59.0);
		hora.put("10", 140.0);
		hora.put("11", 181.0);
		hora.put("12", 192.0);
		hora.put("13", 103.0);
		hora.put("14", 134.0);
		hora.put("15", 15.0);
		hora.put("16", 156.0);
		hora.put("17", 187.0);
		hora.put("18", 138.0);
		hora.put("19", 119.0);
		hora.put("20", 620.0);
		hora.put("21", 821.0);
		hora.put("22", 322.0);
		hora.put("23", 823.0);
		hora.put("24", 924.0);
		hora.put("25", 245.0);
		
		UnidadGeneradoraBean unidad2 = new UnidadGeneradoraBean();
		unidad2.setCentralElectrica("Necaxa");
		unidad2.setFecha("08-11-2016");
		unidad2.setUnidadGeneradora("UN-NEC-02");
		
		UnidadGeneradoraBean unidad3 = new UnidadGeneradoraBean();
		unidad3.setCentralElectrica("Necaxa");
		unidad3.setFecha("08-11-2016");
		unidad3.setUnidadGeneradora("UN-NEC-03");

		unidad1.setHora(hora);
		unidad2.setHora(hora);
		unidad3.setHora(hora);
		
		unidadGeneradoraReal.add(unidad1);
		unidadGeneradoraReal.add(unidad2);
		unidadGeneradoraReal.add(unidad3);
		
		MercadoTiempoRealBean mercadoReal = new MercadoTiempoRealBean();
		mercadoReal.setCentralElectrica("Necaxa");
		mercadoReal.setUnidadGeneradora(unidadGeneradoraReal);
		
		mercadoTiempoReal.add(mercadoReal);
		MercadoBean mb = new MercadoBean();
		mb.setMercadoTiempoReal(mercadoTiempoReal);
		mb.setMercadoDiaAdelanto(mercadoDiaAdelanto);
		mercadoBean.add(mb);

		
//    	FileInputStream file = new FileInputStream(new File("FormatoExport.xlsx"));
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		URL url = classLoader.getResource("FormatoExport.xlsx");
//		FileInputStream file = new FileInputStream(new File(url.toURI().toString()));
    	// Crear el objeto que tendra el libro de Excel
    	XSSFWorkbook workbook = new XSSFWorkbook(url.openStream());
    	int item = 1;
    	
		// MercadoBean
		for(MercadoBean mbAux : mercadoBean){
System.out.println("MercadoBean :: " + mbAux);
			// Mercado Tiempo Real
			for(MercadoTiempoRealBean mtr : mbAux.getMercadoTiempoReal()){
System.out.println("MercadoTiempoRealBean :: " + mtr);
				// Unidad Generadora
				for(UnidadGeneradoraBean unidadGeneradora : mtr.getUnidadGeneradora()){
System.out.println("UnidadGeneradoraBean :: " + unidadGeneradora);
					workbook.cloneSheet(0);
					generaExcel(workbook, item,
							unidadGeneradora.getCentralElectrica(), unidadGeneradora.getUnidadGeneradora(), unidadGeneradora.getHora(), unidadGeneradora.getFecha());
					item++;
				}    								
			}
		}		
		
        // Se salva el libro.
        try {
        	String nameFile = "ExportExample.xls";
        	System.out.println("nameFile :: " + nameFile);
            FileOutputStream elFichero = new FileOutputStream(nameFile);
            workbook.write(elFichero);
            elFichero.close();
        } catch (Exception e) {
            e.printStackTrace();
        }  
        
    	// cerramos el libro excel
    	workbook.close();

    	
    }
    
    public static void generaExcel(XSSFWorkbook workbook, int item,
    								String centralElectrica, String unidadHidroElectrica, Map<String, Double> horas, String fecha)
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
        workbook.setSheetName(item,unidadHidroElectrica);
        
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


    	// Se crean las celdas para MW
//		ValueComparator bvc = new ValueComparator(horas);
//		TreeMap<String, Double> sorted_map = new TreeMap<String, Double>(bvc);
//		sorted_map.putAll(horas);
//   	Iterator it = sorted_map.entrySet().iterator();
    	int count = 13;
//    	while(it.hasNext()){
    	for(Integer time = 1; time <= 25; time++){
//    		Map.Entry e = (Map.Entry)it.next();
            celdaWrite= sheet.getRow(count).getCell(3);
            // Se crea el contenido de la celda y se mete en ella.
//            System.out.println("horas.get(item) :: " + horas.get(item));
            celdaWrite.setCellValue(horas.get("hora" + time.toString()));
//            celdaWrite.setCellValue(e.getValue().toString());
            count++;
    		
    	}
//    	}
         
    }
    
	private static UnidadGeneradoraBean addDataTiempoReal(String centralElectrica, String unidadGeneradora, String fechaData){
		
		UnidadGeneradoraBean mtr = new UnidadGeneradoraBean();
		mtr.setCentralElectrica(centralElectrica);
		mtr.setFecha(fechaData);
		Map<String, Double> hora = new HashMap<String, Double>();
		for(int a = 0; a<=25; a++){
			hora.put("hora"+a, Math.floor(Math.random()*100+1));
		}
		mtr.setHora(hora);
		mtr.setUnidadGeneradora(unidadGeneradora);
		
		return mtr;
		
	}
	
	private static UnidadGeneradoraBean addDataDiaAdelanto(String centralElectrica, String unidadGeneradora, String fechaData){
		
		UnidadGeneradoraBean mda = new UnidadGeneradoraBean();
		mda.setCentralElectrica(centralElectrica);
		mda.setFecha(fechaData);
		Map<String, Double> hora = new HashMap<String, Double>();
		for(int a = 0; a<=25; a++){
			hora.put("hora"+a, Math.floor(Math.random()*100+1));
		}
		mda.setHora(hora);
		mda.setUnidadGeneradora(unidadGeneradora);
		
		return mda;
		
	}

}