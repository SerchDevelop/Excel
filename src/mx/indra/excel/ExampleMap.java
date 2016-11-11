package mx.indra.excel;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class ExampleMap {

	public static void main(String[] args) {
		
		Map<String, Double> hora = new HashMap<String, Double>();
		hora.put("hora1", 12.0);
		hora.put("hora2", 23.0);
		hora.put("hora3", 34.0);
		hora.put("hora4", 45.0);
		hora.put("hora5", 56.0);
		hora.put("hora6", 68.0);
		hora.put("hora7", 73.0);
		hora.put("hora8", 18.0);
		hora.put("hora9", 59.0);
		hora.put("hora10", 140.0);
		hora.put("hora11", 181.0);
		hora.put("hora12", 192.0);
		hora.put("hora13", 103.0);
		hora.put("hora14", 134.0);
		hora.put("hora15", 15.0);
		hora.put("hora16", 156.0);
		hora.put("hora17", 187.0);
		hora.put("hora18", 138.0);
		hora.put("hora19", 119.0);
		hora.put("hora20", 620.0);
		hora.put("hora21", 821.0);
		hora.put("hora22", 322.0);
		hora.put("hora23", 823.0);
		hora.put("hora24", 924.0);
		hora.put("hora25", 245.0);
		
    	for(Integer time = 1; time <= 25; time++){
    		String timeString = "hora" + time.toString(); 
    		System.out.println("Hora " + time + " :: " + hora.get("hora" + time));	
    	}

	}

}
