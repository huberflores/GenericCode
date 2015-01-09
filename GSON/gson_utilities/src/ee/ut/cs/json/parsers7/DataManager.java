package ee.ut.cs.json.parsers7;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
 * author Huber Flores
 */

public class DataManager{

	private List<String> dimensions;
	private Map<String, DimensionalDescriptor> values = null;
	
	public DataManager(){
		dimensions = new ArrayList<String>();
	}
	
	public void appendDimension(String d){
		dimensions.add(d);
	}	
	
	public List<String> getDimensions(){
		return dimensions;
	}
	
	public void setDimensionValues(Map<String, DimensionalDescriptor> v){
		values = v;
	}
	
	public Map<String, DimensionalDescriptor> getDimensionValues(){
		return values;
	}
	
}
