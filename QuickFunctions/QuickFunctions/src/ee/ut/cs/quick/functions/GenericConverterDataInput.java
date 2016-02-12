package ee.ut.cs.quick.functions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import fi.cs.ubicomp.file.schemas.TraceSchemaQoE;


public class GenericConverterDataInput {
	
	private String filePath;
	
	private  TraceSchemaQoE schema;
	
	private List<TraceSchemaQoE> traces;
	
	
	public GenericConverterDataInput(String filePath){
		this.filePath = filePath;
		
		traces = new ArrayList<TraceSchemaQoE>();
	}
	
	public void parseCSVFile(){
		String csvFile = filePath;
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";

		try {

			int count = 0;
			
			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {
				
			     
				String[] row = line.split(cvsSplitBy);
				if (count!=0){
					traces.add(new TraceSchemaQoE(row[0], MilliSecondsToDate.conversion(row[1]), row[2], row[3], row[4], row[5], row[6]));
				}
				
				
				count++;
				


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
	
	
	public void printSchemaData(){
		for (TraceSchemaQoE trace: traces){
			System.out.println(trace.getIndex() + "," + trace.getTimestamp() + "," +
								trace.getRtt() + "," +  trace.getUserId() + "," + 
								trace.getAcceleration() + "," + trace.getBattery() + "," +
								trace.getResponseTime());
		}
		
	}
	
	public void writeSchemaToFile(){
		String outputFile = "/home/huber/Desktop/source_code/tmp/output-converter.csv";
		Writer writer = null;

		try {
		    writer = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream(outputFile), "utf-8"));
		    
		    for (TraceSchemaQoE trace: traces){
		    	writer.write(trace.getIndex() + "," + trace.getTimestamp() + "," +
						trace.getRtt() + "," +  trace.getUserId() + "," + 
						trace.getAcceleration() + "," + trace.getBattery() + "," +
						trace.getResponseTime() + "\n");

		    }
		    
		    
		} catch (IOException ex) {
		  // report
		} finally {
		   try {writer.close();} catch (Exception ex) {/*ignore*/}
		}
		
		
		
	}
	
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String filePath = "/home/huber/Desktop/source_code/tmp/output.csv";
		GenericConverterDataInput converter = new GenericConverterDataInput(filePath);
		converter.parseCSVFile();
		
		//converter.printSchemaData();
		
		converter.writeSchemaToFile();
		
		
		
	}

}
