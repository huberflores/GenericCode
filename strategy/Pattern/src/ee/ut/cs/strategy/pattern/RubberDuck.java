package ee.ut.cs.strategy.pattern;

public class RubberDuck extends Duck{
	
	public RubberDuck(){
		flyBehaviour = new FlyNoWay();
		quackBehaviour = new Squeak();
		
	}

	@Override
	void display() {
		// TODO Auto-generated method stub
		System.out.println("This is a rubber duck");
		
	}

}
