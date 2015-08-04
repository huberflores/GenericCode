package ee.ut.cs.pattern.state;

public class GumballMachine {
	
	State soldOutState; 
	State noQuarterState;
	State hasQuarterState;
	State soldState;
	
	State state = soldOutState;
	int count = 0;
	
	public GumballMachine(int numberGumballs){
		soldOutState = new SoldOutState(this);
		noQuarterState = new NoQuarterState(this);
		hasQuarterState = new HasQuarterState(this);
		soldState = new SoldState(this);
		
		this.count = numberGumballs;
		if (numberGumballs>0){
			state = noQuarterState;
		}		
	}
	
	public void insertQuarter(){
		state.insertQuarter();
	}
	
	public void ejectQuarter(){
		state.ejectQuarter();
	}
	
	public void turnCrank(){
		state.turnCrank();
		state.dispense();
	}
	
	public void releaseBall(){
		System.out.println("Ball is released...");
		if (count!=0){
			count-- ;
		}
	}
	
	int getCount(){
		return count;
	}
	
	void refill(int count){
		this.count = count;
		state = noQuarterState;
	}
	
	public void setState(State state){
		this.state = state;
	}
	
	public State getState(){
		return state;
	}
	
	public State getSoldOutState(){
		return soldOutState;
	}
	
	public State getNoQuarterState(){
		return noQuarterState;
	}
	
	public State getHasQuarterState(){
		return hasQuarterState;
	}
	
	public State getSoldState(){
		return soldState;
	}
	
	public String toString(){
		StringBuffer result = new StringBuffer();
		result.append("\nInventory: " +  count + " gumball");
		
		if (count==0){
			result.append("\nMachine is out of gumballs");
		}
		
		
		return result.toString();
	}

}
