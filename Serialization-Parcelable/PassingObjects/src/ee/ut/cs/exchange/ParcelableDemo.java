package ee.ut.cs.exchange;

import android.app.Activity;  
import android.os.Bundle;  
import android.widget.TextView;  

public class ParcelableDemo extends Activity {  
    
    public void onCreate(Bundle savedInstanceState) {  
    	super.onCreate(savedInstanceState);  
    	TextView mTextView = new TextView(this);  
    	Book mBook = (Book)getIntent().getParcelableExtra("parcelable");  
    	mTextView.setText("Title of the book is: " + mBook.getBookTitle()+"/n"+  
    			"Name of the author is: " + mBook.getAuthor() + "/n" +  
    			"No. of edition: " + mBook.getEdition());  
    	setContentView(mTextView);  
    }  
}  