package ee.ut.cs.json.parsers2;

import java.io.IOException;

import com.google.gson.Gson;

public class Activator {

	 private static GSONParser_2 data = null;
	 
	 Activator(){
	    loadJSON();	 
	    loadJSONIntoClass();
	 }
		
	 public void loadJSON(){
		    ReadJSONDescriptor jd = new ReadJSONDescriptor();
			Gson gson = new Gson();
			Class taskClass;
				try {
					taskClass = Class.forName("ee.ut.cs.json.parsers2.Manager");
			
					String characterizationDescriptor = jd.readFile("json_descriptor");
					data = (GSONParser_2) gson.fromJson(characterizationDescriptor, taskClass);
				 } catch (ClassNotFoundException e) {
					 	e.printStackTrace();
				 } catch (IOException e) {
					// TODO Auto-generated catch block
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
