package ee.ut.cs.pattern.state;

public class SoldOutState implements State {
	GumballMachine gumballMachine;
	
	public SoldOutState(GumballMachine gumballMachine){
		this.gumballMachine = gumballMachine;
	}
	

	@Override
	public void insertQuarter() {
		// TODO Auto-generated method stub
		System.out.println("You cannot insert a quarter, the machine is sold out");
	}

	@Override
	public void ejectQuarter() {
		// TODO Auto-generated method stub
		System.out.println("You cannot eject, you haven't inserted a quarter yet");
	}

	@Override
	public void turnCrank() {
		// TODO Auto-generated method stub
		System.out.println("You turned, but there are no gumballs");
	} 

	@Override
	public void dispense() {
		// TODO Auto-generated method stub
		System.out.println("No gumball dispensed");
	}

}
