package ee.ut.cs.quick.utilities;

public class CSVData {

	long timestamp;
	String myAddress;
	String surrogateName;
	String surrogateAddress;
	int networkInterface; //wifidirect 1, bluetooth 2, wifi 0
	int wifiRTT;
	int batteryLevel;

	
	public CSVData(String timestamp, String myAddress, 
					String surrogateName, String surrogateAddress,
					String wifidirect, String bluetooth, String wifi, String wifiRTT, String batteryLevel){
		
		this.timestamp = Long.parseLong(timestamp);
		this.myAddress = myAddress;
		this.surrogateName = surrogateName;
		this.surrogateAddress = surrogateAddress;
		
		this.wifiRTT = Integer.parseInt(wifiRTT);
		this.batteryLevel = Integer.parseInt(batteryLevel);
		
		if (Integer.parseInt(wifidirect)==1){
			this.networkInterface = 1;
		}else{
			if (Integer.parseInt(bluetooth)==1){
				this.networkInterface = 2;
			}else{
				if (Integer.parseInt(wifi)==1){
					this.networkInterface = 0;
				}
			}
		}
		
		
	}
	
	public long getTimestamp(){
		return this.timestamp;
	}
	
	public String getMyAddress(){
		return this.myAddress;
	}
	
	public String getSurrogateName(){
		return this.surrogateName;
	}
	
	public String getSurrogateAddress(){
		return this.surrogateAddress;
	}
	
	public int getNetworkInterface(){
		return this.networkInterface;
	}
	
	public int getWifiRTT(){
		return this.wifiRTT;
	}
	
	public int getBatteryLevel(){
		return this.batteryLevel;
	}
	

}
