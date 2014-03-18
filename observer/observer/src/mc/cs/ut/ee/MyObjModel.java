package mc.cs.ut.ee;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class MyObjModel {
	public static final String ATTRIBUTE1 = "attr1";
	public static final String ATTRIBUTE2 = "attr2";

	private List<MyObj> objects = new ArrayList<MyObj>();
	private List<PropertyChangeListener> listener = new ArrayList<PropertyChangeListener>();

	
	public class MyObj{
		private String attr1;
		private String attr2; 

		public MyObj(String attr1, String attr2){
			this.attr1 = attr1;
			this.attr2 = attr2;
		}
		
		public String getAttribute1(){
			return this.attr1; 
		}
		
	
		public void setAttribute1(String attr1){
			notifyListeners(this, 
					ATTRIBUTE1, 
					this.attr1, 
					this.attr1 = attr1);
		}
	
		
		public String getAttribute2(){
			return this.attr2;
		}
		
		public void setAttribute2(String attr2){
			notifyListeners(this, 
					ATTRIBUTE2, 
					this.attr2, 
					this.attr2 = attr2);
		}
		
				
	}
	
	
	 public List<MyObj> getObjects() {
		    return this.objects;
	 }
	 
	 
	 public MyObjModel() {
		 objects.add(new MyObj("obj1_attr1","obj1_attr2"));
		 objects.add(new MyObj("obj2_attr1","obj2_attr2"));
		    
	 }

	 private void notifyListeners(Object object, String property, String oldValue, String newValue) {
	  for (PropertyChangeListener name : listener) {
		      name.propertyChange(new PropertyChangeEvent(this, "attr1", oldValue, newValue));
	   }
	}

	 public void addChangeListener(PropertyChangeListener newListener) {
	    listener.add(newListener);
	 }
	 
	 public void addObj(MyObj obj){
		 this.objects.add(obj);
	 }

	
	
}
