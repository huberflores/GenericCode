package ee.ut.cs.quick.utilities;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by huber on 12/12/15.
 */
public class TimeScheduler {

    private final String TAG = TimeScheduler.class.getSimpleName();

    public static final String inputFormat = "HH:mm";
    
    private String compareStringOne = null;
    private String compareStringTwo = null;
    
    public TimeScheduler(String compareStringOne, String compareStringtwo){
    	this.compareStringOne = compareStringOne;
    	this.compareStringTwo = compareStringtwo;
    }
    

    private Date date;
    private Date dateCompareOne;
    private Date dateCompareTwo;


    SimpleDateFormat inputParser = new SimpleDateFormat(inputFormat, Locale.US);


    public boolean checkAvailability(long timestamp){
    	
    	Date timeMeasurement = conversion(timestamp); 
    	int hour = timeMeasurement.getHours();
    	int minutes = timeMeasurement.getMinutes();
    	int seconds = timeMeasurement.getSeconds();
    	
    	
    	    	
    	date = parseDate(hour +  ":" +  minutes);
    	date.setSeconds(seconds);
        dateCompareOne = parseDate(compareStringOne);
        dateCompareTwo = parseDate(compareStringTwo);
        
      
        if (dateCompareOne.before(date) && dateCompareTwo.after(date)) {
        	//System.out.println(hour + "," + minutes);
            return true;
        }/*else{
        	System.out.println(hour + "," + minutes + "No idenfitied");
        }*/
        

        return false;
    }

    private Date parseDate(String date) {

        try {
            return inputParser.parse(date);
        } catch (java.text.ParseException e) {
            return new Date(0);
        }
    }
    
    public Date conversion(long milliSecondsTime){    
		Date resultdate = new Date(milliSecondsTime);
		
		return resultdate;
		
	}

}
