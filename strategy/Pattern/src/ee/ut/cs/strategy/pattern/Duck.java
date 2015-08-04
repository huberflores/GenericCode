package ee.ut.cs.strategy.pattern;

public abstract class Duck {
	FlyBehaviour flyBehaviour;
	QuackBehaviour quackBehaviour;
	
	public Duck(){
		
	}
	
	public void setFlyBehaviour(FlyBehaviour fly){
		this.flyBehaviour = fly;
	}
	
	public void setQuackBehaviour(QuackBehaviour quack){
		this.quackBehaviour = quack; 
	}

	abstract void display();
	
	public void performFly(){
		flyBehaviour.fly();
	}
	
	public void performQuack(){
		quackBehaviour.quack();
	}
	
	public void swim(){
		System.out.println("All ducks fly...");
	}
}



