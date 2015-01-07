package ee.ut.cs.json.parsers;

import com.google.gson.Gson;

public class Activator {

	 private static GSONParser_1 data = null;
	 
	 Activator(){
	    loadJSON();	 
	    loadJSONIntoClass();
	 }
		
	 public void loadJSON(){
			Gson gson = new Gson();
			Class taskClass;
				try {
					taskClass = Class.forName(Utilities.CLASS_PATH_ROUTINES + "Manager");
			
					String characterizationDescriptor = Utilities.JSON_PATTERN_SAMPLE;
					data = (GSONParser_1) gson.fromJson(characterizationDescriptor, taskClass);
				 } catch (ClassNotFoundException e) {
					 	e.printStackTrace();
				 }
		}
		

	 
	 
	private static void loadJSONIntoClass() {
		Manager mng = (Manager) data;
		mng.appName();
	}
	
	
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			new Activator();
			
	 }

	 
}
