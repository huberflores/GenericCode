package ee.ut.cs.executorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MyExecutor {

	private static Future taskTwo = null;
	private static Future taskThree = null;
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws InterruptedException, ExecutionException {{
		// TODO Auto-generated method stub
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		Runnable taskOne = new MyThread("TaskOne", 2, 100);
	    executor.execute(taskOne);
	    
	    int i = 0;
	    boolean t1 = false;
	    boolean t2 = false;
	    while (!(t1) & !(t2)){
	    	i++;
	    //for(int i = 0; i < 2; i++) {
	    	// if this task is not created or is canceled or is completed
			if ((taskTwo == null) || (taskTwo.isDone()) /*|| (taskTwo.isCancelled())*/) {
				// submit a task and return a Future
				taskTwo = executor.submit(new MyThread("TaskTwo", 4, 200));
				t1 = true;
			}
	
			if ((taskThree == null) || (taskThree.isDone()) /*|| (taskThree.isCancelled())*/) {
				taskThree = executor.submit(new MyThread("TaskThree", 5, 100));
				t2 = true;
			}
			
			// if null the task has finished
			if(taskTwo.get() == null) {
				System.out.println(i+1 + ") TaskTwo terminated successfully");
			} /*else {
				// if it doesn't finished, cancel it
				taskTwo.cancel(true);
			}*/
			if(taskThree.get() == null) {
				System.out.println(i+1 + ") TaskThree terminated successfully");
			} /*else {
				taskThree.cancel(true);
			}*/
	    //} for end
	    } //while end
	    executor.shutdown();
	    System.out.println("-----------------------");
	    // wait until all tasks are finished
	    executor.awaitTermination(1, TimeUnit.SECONDS);
	    System.out.println("All tasks are finished!");
	

	  }

    }
	
}

