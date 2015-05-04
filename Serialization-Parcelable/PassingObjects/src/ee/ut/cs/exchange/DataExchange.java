package ee.ut.cs.exchange;

import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import android.view.View.OnClickListener;  

public class DataExchange extends ActionBarActivity implements OnClickListener {

	private Button sButton,pButton;  
        

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_exchange);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        
        setupViews();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.data_exchange, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_data_exchange, container, false);
            return rootView;
        }
    }
    

    public void setupViews(){  
        sButton = (Button)findViewById(R.id.button1);  
        pButton = (Button)findViewById(R.id.button2);  
        sButton.setOnClickListener(this);  
        pButton.setOnClickListener(this);  
    }  
    
    
    public void serializableMethod(){  
        Person mPerson = new Person();  
        mPerson.setName("Raul");  
        mPerson.setSurname("Macario");  
        Intent mIntent = new Intent(this,SerializableDemo.class);  
        Bundle mBundle = new Bundle();  
        mBundle.putSerializable("ee.ut.cs.exchange",mPerson);  
        mIntent.putExtras(mBundle);  
           
        startActivity(mIntent);  
    }  
 
    public void parcelableMethod(){  
        Book mBook = new Book();  
        mBook.setBookTitle("El portero");  
        mBook.setAuthor("Reinaldo Arenas");  
        mBook.setEdition(3);  
        Intent mIntent = new Intent(this,ParcelableDemo.class);  
        Bundle mBundle = new Bundle();  
        mBundle.putParcelable("ee.ut.cs.exchange", mBook);  
        mIntent.putExtras(mBundle);  
           
        startActivity(mIntent);  
    }  
 
    
    public void onClick(View v) {  
        if(v == sButton){
        	Toast.makeText(getApplicationContext(), "Serializable method",Toast.LENGTH_SHORT).show();
        	
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	serializableMethod();  
 			 
        }else{
        	Toast.makeText(getApplicationContext(), "Parcelable method",Toast.LENGTH_SHORT).show();
        	
        	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	parcelableMethod();  
 			 
        }  
    }

}
