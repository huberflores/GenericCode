package ee.ut.cs.pattern.observer;

public interface Subject {
	
	/**
	 * The subject in which the observers are subscribed
	 * 
	 */
	
	public void registerObserver(Observer o);
	public void removeObserver(Observer o);
	public void notifyObservers(); 

}
