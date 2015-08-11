package ee.ut.cs.executorservice;

public class MyThread implements Runnable {
	
	private String myName;
	private int myCount;
	private final long myTimeSleep;

	MyThread(String name, int newcount, long newtimeSleep) {
		this.myName = name;
	    this.myCount = newcount;
	    this.myTimeSleep = newtimeSleep;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		int sum = 0;
	    for (int i = 1; i <= this.myCount; i++) {
	    	sum = sum + i;
	    }
	    System.out.println(myName + " thread has sum = " + sum + 
	    		" and is going to sleep for " + myTimeSleep);
	    try {
			Thread.sleep(this.myTimeSleep);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}