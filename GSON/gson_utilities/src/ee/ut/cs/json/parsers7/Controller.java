package ee.ut.cs.json.parsers7;

import java.util.Iterator;
import java.util.List;
import java.util.Map;


public class Controller {

	private DataManager dm;
	
	public Controller(){
		dm = new LoadDimensionalDescriptor().loadJSON("json_descriptor_dimensional");
	}
	
	public void listDimensions(){
		List<String> d = dm.getDimensions();
		
		Iterator<String> l = d.iterator();
		
		while(l.hasNext()){
			System.out.println(l.next());
		}
		
	}
	
	public void listDimensionsValues(){
		Map<String, DimensionalDescriptor> values = dm.getDimensionValues();
		
		List<String> d = dm.getDimensions();
		
		Iterator<String> l = d.iterator();
		
		while(l.hasNext()){
			
			String dimension = l.next();
		    
			System.out.println(dimension);
			System.out.println(values.get(dimension).nameMethods);
			System.out.println(values.get(dimension).device);
		    System.out.println("");
			
		}
	}
	
	
	public void getDimension(String key){
		Map<String, DimensionalDescriptor> values = dm.getDimensionValues();
		
		
		
		
		System.out.println(values.get(key).getEnergyConsumed());
		
	}
	
	
	public static void main(String[] args) {
		//new Controller().listDimensions();
		//new Controller().listDimensionsValues();
		new Controller().getDimension("what-to-offload");
		
    }

}

