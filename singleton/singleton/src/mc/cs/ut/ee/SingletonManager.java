package mc.cs.ut.ee;

/*
* author Huber Flores
*/

public class SingletonManager {
	public static SingletonManager instance;
	
	private SingletonManager(){ //constructor should be private
		
	}
	
	public static synchronized SingletonManager getInstance(){
		if (instance==null){
			instance = new SingletonManager();
			return instance;
		}
		
		return instance;
	}
	

}
