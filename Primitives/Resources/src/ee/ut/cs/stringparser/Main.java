package ee.ut.cs.stringparser;

public class Main {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Welcome to Estonia!";
		System.out.println("Length of the string: " + s1.length());
		
		
		int pos = s1.indexOf("Estonia");
		System.out.println("Position starts at : " + pos);
		
		String sub = s1.substring(pos);
		System.out.println(sub);
		
	}

}
