package ee.ut.cs.json.parsers7;

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

public class LoadDimensionalDescriptor {

	
	private DataManager dm = null;
	
	
	public DataManager loadJSON(String filePath){
		 InputStream in;
		try {
			in = new FileInputStream(new File(filePath));
			Gson gson = new Gson();
			Type mapType = new TypeToken<Map<String, DimensionalDescriptor> >() {}.getType(); 
			Map<String, DimensionalDescriptor> values = gson.fromJson(new InputStreamReader(in), mapType);
			
			Set<String> keys = values.keySet(); 
			
			Iterator<String> iterator = keys.iterator();
			
			dm = new DataManager();
			dm.setDimensionValues(values);
			
			
			while(iterator.hasNext()){
				String dimension = iterator.next();
				dm.appendDimension(dimension);
			}
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		 
		return dm;
	 }
	
}
