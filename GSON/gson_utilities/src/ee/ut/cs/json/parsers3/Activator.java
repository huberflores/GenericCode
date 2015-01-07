package ee.ut.cs.json.parsers3;

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
			Type mapType = new TypeToken<Map<String, GSONParser_3> >() {}.getType(); 
			Map<String, GSONParser_3> result= gson.fromJson(new InputStreamReader(in), mapType);
			
			Set<String> keys = result.keySet(); 
			
			Iterator<String> iterator = keys.iterator();
			
			while(iterator.hasNext()){
				String value = iterator.next();
				System.out.println(value);
			
				GSONParser_3 attributes = result.get(value);
				   System.out.println(attributes.getMethods());
				   System.out.println(attributes.getDevice());
				   System.out.println(attributes.getDescription());
				   System.out.println("");
				   
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 
	 }
		

	 public static void main(String[] args) {
			new Activator("json_dimensions");
			
	 }

	 
}
