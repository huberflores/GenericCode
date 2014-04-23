package mc.cs.ut.ee;

public class DecoratorDesignPatternMain {  

	 public static void main(String args[]) {  
		 Room room = new CurtainDecorator(new ColorDecorator(new ConcreteRoom()));  
		 System.out.println(room.showRoom());  
	 }  

}  