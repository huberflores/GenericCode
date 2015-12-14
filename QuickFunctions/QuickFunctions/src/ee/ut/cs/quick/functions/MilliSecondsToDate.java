package ee.ut.cs.quick.functions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MilliSecondsToDate {
	
	
	
	public MilliSecondsToDate(){
		
	}
	
	
	public void conversion(String sampleTime){
		long milliSecondsTime = new Long (sampleTime);
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");    
		Date resultdate = new Date(milliSecondsTime);
		System.out.println(sdf.format(resultdate));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new MilliSecondsToDate().conversion("1450080257254");

	}

}
