package ee.ut.cs.pattern.state;

public class HasQuarterState implements State {
	GumballMachine gumballMachine;

	public HasQuarterState(GumballMachine gumballMachine){
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		// TODO Auto-generated method stub
		System.out.println("You can't insert another quarter");
	}

	@Override
	public void ejectQuarter() {
		// TODO Auto-generated method stub
		System.out.println("Quarter returned");
		gumballMachine.setState(gumballMachine.getNoQuarterState());
		
	}

	@Override
	public void turnCrank() {
		// TODO Auto-generated method stub
		System.out.println("You turned...");
		gumballMachine.setState(gumballMachine.getSoldState());
		
	}

	@Override
	public void dispense() {
		// TODO Auto-generated method stub
		
	}

}
