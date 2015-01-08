package ee.ut.cs.json.parsers6;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class GSONParser_6 {


	@SerializedName("dimension")
	public String dimension;

	@SerializedName("nameMethods")
	public String nameMethods;

	@SerializedName("device")
	public String device;

	@SerializedName("description")
	public String description;
	
	@SerializedName("network")
	public List<String> network;
	
	
	public String getMethods(){
		return this.nameMethods;
	}
	
	public String getDevice(){
		return this.device;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public List<String> getNetworkParameters(){
		return this.network;
	}
	

}
