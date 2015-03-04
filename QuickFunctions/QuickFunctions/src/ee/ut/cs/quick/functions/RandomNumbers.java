package ee.ut.cs.quick.functions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

/**
 * 
 * @author Huber Flores
 *
 */


public class RandomNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateDoubles(18.0, 33.0, 10);

		//GenerateInts(18,30,10);
	}
	
	
	public static void GenerateDoubles(double min, double max, int times){
		Random r = new Random();
		
		
		for (int i=0; i<times; i++){
			double value = min + (max - min) * r.nextDouble();
			
			if (i==(times-1))		
			   System.out.println(round(value,2));
			else
			   System.out.println(round(value,2)+",");
		}
		
	}
	
	
	
	public static void GenerateInts(int min, int max, int times){
		Random r = new Random();
		
		for (int i= 0; i<times; i++){
			int value = r.nextInt(max-min) + min;
			
			
			if (i==(times-1))		
				System.out.println(value);
			else
			   System.out.println(value+",");
			
		}
	}
	
	public static double round(double value, int decimals) {
	    if (decimals < 0) throw new IllegalArgumentException();

	    BigDecimal tmp = new BigDecimal(value);
	    tmp = tmp.setScale(decimals, RoundingMode.HALF_UP);
	    return tmp.doubleValue();
	}

}
