package ee.ut.cs.json.parsers;

import java.util.List;

import com.google.gson.annotations.Expose;

public class GSONParser_1 {
	
	@Expose
	private String mobileApplication;
	
	@Expose
	private String deviceID;
	
	@Expose
	private String description;
	
	@Expose
	private List<String> candidateComponents;
	
	
	public List<String> getMobileComponents() {
		return candidateComponents;
	}
	
	public String getMobileApplication(){
		return mobileApplication;
	}
	
	
	public String getAppName(){
		return this.mobileApplication;
	}
	
}
