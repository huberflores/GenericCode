package ee.ut.cs.strategy.pattern;

public class FlyWithRocketPowered implements FlyBehaviour {
	
	public void fly() {
		System.out.println("I am flying attached to a rocket...");
	}
}