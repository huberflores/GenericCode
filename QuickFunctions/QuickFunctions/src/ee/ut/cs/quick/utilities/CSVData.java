package ee.ut.cs.quick.utilities;

import java.util.ArrayList;
import java.util.List;

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
	
	
	public static List<String> getDayHours(){
		List<String> intervals = new ArrayList<String>();
		
		intervals.add("00:00, 1:00");
		intervals.add("1:00, 2:00");
		intervals.add("2:00, 3:00");
		intervals.add("3:00, 4:00");
		intervals.add("4:00, 5:00");
		intervals.add("5:00, 6:00");
		intervals.add("6:00, 7:00");
		intervals.add("7:00, 8:00");
		intervals.add("8:00, 9:00");
		intervals.add("9:00, 10:00");
		intervals.add("10:00, 11:00");
		intervals.add("11:00, 12:00");
		intervals.add("12:00, 13:00");
		intervals.add("13:00, 14:00");
		intervals.add("14:00, 15:00");
		intervals.add("15:00, 16:00");
		intervals.add("16:00, 17:00");
		intervals.add("17:00, 18:00");
		intervals.add("18:00, 19:00");
		intervals.add("19:00, 20:00");
		intervals.add("20:00, 21:00");
		intervals.add("21:00, 22:00");
		intervals.add("22:00, 23:00");
		intervals.add("23:00, 24:00");
		
		return intervals;
	}
	
	
	
	/*
	 * CSV example
	 */
	
	/*1;1450119653660;38:0A:94:A3:EA:7B;Nokia N8-00;6C:A7:80:42:E5:62;0;1;0;0;0
	7;1450120556821;38:0A:94:A3:EA:7B;Nokia N8-00;6C:A7:80:42:E5:62;0;1;0;0;0
	12;1450122349446;38:0A:94:A3:EA:7B;Nokia N8-00;6C:A7:80:42:E5:62;0;1;0;0;0
	17;1450123254188;38:0A:94:A3:EA:7B;Nokia N8-00;6C:A7:80:42:E5:62;0;1;0;0;0
	21;1450124149963;38:0A:94:A3:EA:7B;Nokia N8-00;6C:A7:80:42:E5:62;0;1;0;0;0
	25;1450125049223;38:0A:94:A3:EA:7B;Nokia N8-00;6C:A7:80:42:E5:62;0;1;0;0;0
	28;1450125948652;38:0A:94:A3:EA:7B;Nokia N8-00;6C:A7:80:42:E5:62;0;1;0;0;0
	32;1450126854145;38:0A:94:A3:EA:7B;Nokia N8-00;6C:A7:80:42:E5:62;0;1;0;0;0
	36;1450127750555;38:0A:94:A3:EA:7B;Nokia N8-00;6C:A7:80:42:E5:62;0;1;0;0;0*/


}
