package ee.ut.cs.json.parsers5;

import java.util.List;

import com.google.gson.annotations.SerializedName;

public class GSONParser_4 {


	@SerializedName("nameMethods")
	public List<String> nameMethods;

	@SerializedName("device")
	public String device;

	@SerializedName("description")
	public String description;
	
	@SerializedName("distance")
	public String distance;

	@SerializedName("network")
	public String network;
	
	@SerializedName("datasize")
	public String datasize;

	@SerializedName("rtt")
	public String rtt;

	@SerializedName("server")
	public String server;
	
	@SerializedName("max")
	public String max;

	
	public List<String> getMethods(){
		return this.nameMethods;
	}
	
	public String getDevice(){
		return this.device;
	}
	
	public String getDescription(){
		return this.description;
	}
	

}
