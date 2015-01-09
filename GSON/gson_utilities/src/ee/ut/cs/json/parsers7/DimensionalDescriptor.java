package ee.ut.cs.json.parsers7;

import java.util.List;

import com.google.gson.annotations.SerializedName;

/*
 * author Huber Flores
 */

public class DimensionalDescriptor {


	@SerializedName("dimension")
	String dimension;
	
	@SerializedName("device")
	String device;

	@SerializedName("nameMethods")
	List<String> nameMethods;

	@SerializedName("energyConsumed")
	String energyConsumed;

	@SerializedName("executionTimeApp")
	String executionTimeApp;
	
	@SerializedName("rTt")
	String rTt;
	
	@SerializedName("dataSize")
	String dataSize;
	
	@SerializedName("serverType")
	List<String> serverType;
		
	@SerializedName("executionTimeServer")
	String executionTimeServer;
	
	@SerializedName("requestChecksum")
	String requestChecksum;
	

	public String getDimension(){
		return dimension;
	}
	
	public String getDevice(){
		return device;
	}
	
	public List<String> getNameMethods(){
		return nameMethods;
	}
	
	public String getEnergyConsumed(){
		return energyConsumed;
	}
	
	public String getExecutionTimeApp(){
		return executionTimeApp;
	}
	
	public String getNetworkParameters(){
		return rTt;
	}
	
	public String getDataSize(){
		return dataSize;
	}
	
	public List<String> getServerType(){
		return serverType;
	}
	
	public String getExecutionTimeServer(){
		return executionTimeServer;
	}
	
	public String getRequestChecksum(){
		return requestChecksum;
	}
	

}

