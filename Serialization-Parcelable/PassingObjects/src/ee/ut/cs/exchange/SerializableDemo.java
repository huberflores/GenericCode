package ee.ut.cs.exchange;

import android.app.Activity;  
import android.os.Bundle;  
import android.widget.TextView;

public class SerializableDemo extends Activity {  
    @Override 
    public void onCreate(Bundle savedInstanceState) {  
    	super.onCreate(savedInstanceState);  
    
    	TextView mTextView = new TextView(this);  
    	Person mPerson = (Person)getIntent().getSerializableExtra("ee.ut.cs.exchange");  
    	mTextView.setText("You name is: " + mPerson.getName() + "/n"+  
    			"You age is: " + mPerson.getSurname());  
    
    	setContentView(mTextView);  
    }  
}  


