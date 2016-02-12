package ee.ut.cs.quick.functions;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MilliSecondsToDate {
	
	
	
	public MilliSecondsToDate(){
		
	}
	
	
	public static String conversion(String sampleTime){
		long milliSecondsTime = new Long (sampleTime);
		SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm");    
		Date resultdate = new Date(milliSecondsTime);
		//System.out.println(sdf.format(resultdate));
		
		return resultdate.toString();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		System.out.println(MilliSecondsToDate.conversion("1451160000000"));

	}

}
