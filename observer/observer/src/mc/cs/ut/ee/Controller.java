package mc.cs.ut.ee;

import mc.cs.ut.ee.MyObjModel.MyObj; 

public class Controller {

	public static void main(String[] args) {
	    MyObjModel model = new MyObjModel();
	    
	    MyObserver observer = new MyObserver(model);
	    
	    for (MyObj obj : model.getObjects()) {
	        obj.setAttribute1(obj.getAttribute1() + " modified");
	    }
	    
	  }
}
