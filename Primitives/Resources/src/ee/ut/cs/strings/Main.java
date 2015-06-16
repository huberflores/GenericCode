package ee.ut.cs.strings;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		String s1 = "WELCOME to Estonia";
		System.out.println(s1);
		
		String s2 = new String("Welcome to Estonia");
		System.out.println(s2);
		
		/*if (s1 == s2){
			System.out.println("They match");
		}else{
			System.out.println("They don't match");
		}*/
		
		/*if (s1.equals(s2)){
			System.out.println("They match");
		}else{
			System.out.println("They don't match");
		}*/
		
		if (s1.equalsIgnoreCase(s2)){
			System.out.println("They match");
		}else{
			System.out.println("They don't match");
		}
		
		
		char [] chars = s1.toCharArray();
		
		for (char c : chars) {
			System.out.println(c);
		}
		
	}

}
