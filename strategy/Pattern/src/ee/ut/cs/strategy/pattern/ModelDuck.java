package ee.ut.cs.strategy.pattern;

public class ModelDuck extends Duck{
	
	public ModelDuck() {
		flyBehaviour = new FlyNoWay();
		quackBehaviour = new Quack();
	}

	public void display() {
		System.out.println("This is a model duck");
	}

}
