package ee.ut.cs.pattern.state;

public class SoldState implements State {
	GumballMachine gumballMachine;

	public SoldState(GumballMachine gumballMachine){
		this.gumballMachine = gumballMachine;
	}
	
	
	@Override
	public void insertQuarter() {
		// TODO Auto-generated method stub
		System.out.println("Please wait, we are already giving you a gumball");
	}

	@Override
	public void ejectQuarter() {
		// TODO Auto-generated method stub
		System.out.println("Sorry, you already turned the crank");
	}

	@Override
	public void turnCrank() {
		// TODO Auto-generated method stub
		System.out.println("Turning twice does not get you another gumball");
		
	}

	@Override
	public void dispense() {
		// TODO Auto-generated method stub
		gumballMachine.releaseBall();
		if (gumballMachine.getCount()>0){
			gumballMachine.setState(gumballMachine.getNoQuarterState());
		}else{
			System.out.println("Oops, out of gumballs");
			gumballMachine.setState(gumballMachine.getSoldOutState());
		}
	}

}
