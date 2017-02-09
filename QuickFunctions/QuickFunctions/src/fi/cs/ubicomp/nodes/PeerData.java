package fi.cs.ubicomp.nodes;

public class PeerData {

	public String address;
	
	public String id;
	
	public PeerData(String address, String id){
		this.address = address;
		this.id = id;
	}
	
	public String getAddress(){
		return this.address;
	}
	
	public String getId(){
		return this.id;
	}
	

}
