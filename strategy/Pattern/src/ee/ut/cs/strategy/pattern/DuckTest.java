package ee.ut.cs.strategy.pattern;

public class DuckTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MallardDuck mallard = new MallardDuck();
		RubberDuck rubber = new RubberDuck();
		ModelDuck model = new ModelDuck();
		
		
		mallard.performQuack();
		rubber.performQuack();
		model.performQuack();
		
		
		mallard.performFly();
		rubber.performFly();
		model.performFly();
		
		
		model.setFlyBehaviour(new FlyWithRocketPowered());
		model.performFly();
		
		
		
	}

}
