package ee.ut.cs.stringbuilder;

public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/**
		 * No good practice in limited resources environments
		 */
		/*String s1 = "Welcome";
		s1 = s1 + " to Estonia!";
		
		System.out.println(s1);*/
		
		
		/**
		 * Better to optimize memory
		 */
		String s1 = "Welcome";
		StringBuilder sb = new StringBuilder(s1);
		sb.append(" to Estonia");
		
		System.out.println(sb);
	}

}
