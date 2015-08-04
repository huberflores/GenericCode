package ee.ut.cs.strategy.pattern;

public class MallardDuck extends Duck {
	
	
	public MallardDuck(){
		quackBehaviour = new Quack();
		flyBehaviour = new FlyWithWings();
	}
	
	

	@Override
	void display() {
		// TODO Auto-generated method stub
		System.out.println("This is a mallard duck");
	}
	
	
	
	

}
