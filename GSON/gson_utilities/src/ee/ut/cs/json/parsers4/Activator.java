package ee.ut.cs.json.parsers4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/*
 * author Huber Flores
 */

public class Activator {


	 public Activator(String fileName){
	    loadJSON(fileName);	 
	    
	 }
	 
	 public void loadJSON(String filePath){
		 InputStream in;
		try {
			in = new FileInputStream(new File(filePath));
			Gson gson = new Gson();		
			Type mapType = new TypeToken<Map<String,Map<String, String>>>() {}.getType();
			Map<String,Map<String, String>> map = gson.fromJson(new InputStreamReader(in), mapType);
			
			Set<String> keys = map.keySet(); 
			
			Iterator<String> iterator = keys.iterator();
			
			Set<String> subKeys;
			Iterator<String> subIterator;
			while(iterator.hasNext()){
				String value = iterator.next();
				System.out.println(value);
				
				subKeys = map.get(value).keySet();
				subIterator = subKeys.iterator();
				
				while(subIterator.hasNext()){
					String subValue = subIterator.next();
					System.out.println(subValue + " =" + map.get(value).get(subValue));
				}
			
				System.out.println("");  
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 
	 }
		

	 public static void main(String[] args) {
			new Activator("json_multiple_classes");
			
	 }

	 
}
