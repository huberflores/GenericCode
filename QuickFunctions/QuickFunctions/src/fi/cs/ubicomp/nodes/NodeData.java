package fi.cs.ubicomp.nodes;

public class NodeData {

	public String consumer;
	public String leaser;
	
	public NodeData(String consumer, String leaser){
		this.consumer = consumer;
		this.leaser = leaser;
	}
	
	public String getConsumer(){
		return this.consumer;
	}
	
	public String getLeaser(){
		return this.leaser;
	}

}
