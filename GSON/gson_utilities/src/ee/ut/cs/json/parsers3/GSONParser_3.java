package ee.ut.cs.json.parsers3;

import com.google.gson.annotations.SerializedName;

public class GSONParser_3 {


	@SerializedName("dimension")
	public String dimension;

	@SerializedName("nameMethods")
	public String nameMethods;

	@SerializedName("device")
	public String device;

	@SerializedName("description")
	public String description;
	
	
	public String getMethods(){
		return this.nameMethods;
	}
	
	public String getDevice(){
		return this.device;
	}
	
	public String getDescription(){
		return this.description;
	}
	

}
