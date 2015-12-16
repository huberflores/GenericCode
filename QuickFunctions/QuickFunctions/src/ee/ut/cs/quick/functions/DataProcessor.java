package ee.ut.cs.quick.functions;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import ee.ut.cs.quick.utilities.CSVData;
import ee.ut.cs.quick.utilities.TimeScheduler;

public class DataProcessor {

	
	private final String TAG = DataProcessor.class.getSimpleName();
	
	
	private String filePath;
	private List<CSVData> hybrid;
	
	public DataProcessor(String filePath){
		this.filePath = filePath;
		this.hybrid = new ArrayList<CSVData>();
	}
	
	public void parseCSVFile(){
		String csvFile = filePath;
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

			     
				String[] row = line.split(cvsSplitBy);
				
				
				hybrid.add(new CSVData(row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8], row[9]));
				

				//System.out.println(row[0]+"," + row[1] + "," + row[2]);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done");
	}
	
	/*
	 * Surrogates per device
	 */
	public List<String> getSurrogates(String myDevice){
		
		List<String> listPeers = new ArrayList<String>();
		for (CSVData peer : hybrid){
			if (myDevice.equals(peer.getMyAddress())){
				if (!listPeers.contains(peer.getSurrogateAddress())){
					listPeers.add(peer.getSurrogateAddress());
				}
			}
			
		}
		
		return listPeers;
		
	}
	
	/*
	 * Different devices in the list
	 */	
	public List<String> getDevices(){
		List<String> listDevices = new ArrayList<String>();
		for (CSVData device: hybrid){
			if (!listDevices.contains(device.getMyAddress())){
				listDevices.add(device.getMyAddress());
			}
		}
		
		return listDevices;
	}

	
	public void displayStatistics(){
		List<String> myDevices = getDevices();
		List<String> surrogates;
		
		System.out.println("Number of devices: " + myDevices.size());
		
		System.out.println("Number of surrogates per device: ");
		
		for (String device: myDevices){
			surrogates = getSurrogates(device);
			
			if (surrogates.size()<=0){
				System.out.println("No surrogates found");
			}else{
				System.out.println("Device: " + device + " has " + surrogates.size() + " surrogates to offload");
				System.out.println("Surrogate availability:");
				for (String surrogate: surrogates){
					//System.out.println("Surrogate: " + surrogate + "," + getSurrogateName(surrogate) + " - Availability: " + getSurrogateAvailability(surrogate, device));
					//System.out.println("Surrogate: " + getSurrogateName(surrogate) + " - Availability: " + getSurrogateAvailabilityByInterface(surrogate, device, 2));
					
					
					
					//Availability per hour
					System.out.println("Surrogate: " + surrogate + ", " + getSurrogateAvailability(surrogate, device));
					getSurrogateAvailabilityByHour(surrogate, device);
				}
				
				
			}
			System.out.println("");
			
		}
	
	}
	
		
	
	
	public int getSurrogateAvailability(String surrogate, String device){
		int cont=0;
		
		for (CSVData data: hybrid){
			if (data.getSurrogateAddress().equals(surrogate) && (data.getMyAddress().equals(device))){
				cont ++;
			}
		}
		
		return cont;
	}
	
	
	public int getSurrogateAvailabilityByInterface(String surrogate, String device, int networkInterface){
		int cont=0;
		
		for (CSVData data: hybrid){
			if (data.getSurrogateAddress().equals(surrogate) && (data.getMyAddress().equals(device) && data.getNetworkInterface()==networkInterface)){
				cont ++;
			}
		}
		
		return cont;
	}
	
	
	public void getSurrogateAvailabilityByHour(String surrogate, String device){
		List<String> intervals = CSVData.getDayHours();
		TimeScheduler timeCheck;
		
		
		for (String interval: intervals){
			String[] hours = interval.split(",");
			int cont = 0;
			
			for (CSVData data: hybrid){
				if (data.getSurrogateAddress().equals(surrogate) && (data.getMyAddress().equals(device))){
					timeCheck = new TimeScheduler(hours[0], hours[1]);
					
					if (timeCheck.checkAvailability(data.getTimestamp())==true){
						cont++;
					}
					
				}
			}
			
			System.out.println(interval + ", " + cont);
			
		}
		
		
		
	}
	

	public String getSurrogateName(String surrogate){
		String name = "not found";
		
		for (CSVData data: hybrid){
			if (data.getSurrogateAddress().equals(surrogate)){
				return data.getSurrogateName();
			}
		}
		
		return name;
		
	}
	
	
	public String getNetworkInterface(String device){
		
		
		for (CSVData data: hybrid){
			if (data.getMyAddress().equals(device)){
				if (data.getNetworkInterface()==1){
					return "WifiDirect";
				}else{
					if (data.getNetworkInterface()==2){
						return "Bluetooth";
					}else{
						return "Wifi";
					}
				}
			}
		}
		
		
		return "not found";
	}
	
	
	public void showTimestamps(){
		for (CSVData data: hybrid){
			System.out.println(conversion(data.getTimestamp()));
		}
	}
	
	
	public Date conversion(long milliSecondsTime){    
		Date resultdate = new Date(milliSecondsTime);
		
		return resultdate;
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		DataProcessor csvReader = new DataProcessor("/home/huber/Desktop/source_code/db/4/1");
		csvReader.parseCSVFile();
	
		csvReader.displayStatistics();
		//csvReader.showTimestamps();
		
		
		/*for (String device: csvReader.getDevices()){
			System.out.println("Device address: " + device + " Network interface: " + csvReader.getNetworkInterface(device));
			 
		}*/
		
		
	}
	
	
}
