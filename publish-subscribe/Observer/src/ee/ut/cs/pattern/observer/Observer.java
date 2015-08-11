package ee.ut.cs.pattern.observer;


public interface Observer {
	/**
	 * Update all the observers
	 * @param temp
	 * @param humidity
	 * @param pressure
	 */
	
	public void update(float temp, float humidity, float pressure);
}
