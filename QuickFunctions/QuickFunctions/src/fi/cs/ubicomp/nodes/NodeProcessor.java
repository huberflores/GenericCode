package fi.cs.ubicomp.nodes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ee.ut.cs.quick.functions.DataProcessor;


public class NodeProcessor {
	
	String filePath;
	private List<NodeData> nodes;
	
	private int counter = 0;
	private List<PeerData> peers;
	
	
	public NodeProcessor(String filePath){
		this.filePath = filePath;
		this.nodes = new ArrayList<NodeData>();
		
		this.peers = new ArrayList<PeerData>();
	}
	
	public void parseCSVFile(){
		String csvFile = filePath;
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ";";

		try {

			br = new BufferedReader(new FileReader(csvFile));
			while ((line = br.readLine()) != null) {

			     
				String[] row = line.split(cvsSplitBy);
				
				
				nodes.add(new NodeData(row[0], row[1]));


			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		System.out.println("Done");
	}
	
	
	public void listNodeData(){
		for (NodeData node: nodes){
			System.out.println("Consumer: " + node.getConsumer() + ", " + "Leaser: " +node.getLeaser() );
		}
	}
	
	public void listPeerData(){
		for (PeerData peer: peers){
			System.out.println("Peer: " + peer.getAddress() + ", " + "Id: " + peer.getId());
		}
	}
	
	
	public void nodeGeneration(){
		for (NodeData node: nodes ){
			if (searchAddress(node.getConsumer())==false){
				peers.add(new PeerData(node.getConsumer(), "p"+getCounter()));
			}
		}
		
		for (NodeData node: nodes ){
			if (searchAddress(node.getLeaser())==false){
				peers.add(new PeerData(node.getLeaser(), "p"+getCounter()));
			}
		}
		
		
	}
	
	public boolean searchAddress(String address){
		for (PeerData peer: peers){
			if (peer.getAddress().equals(address)){
				return true;
			}
		}
		
		return false;
	}
	
	public String searchId(String address){
		for (PeerData peer: peers){
			if (peer.getAddress().equals(address)){
				return peer.id;
			}
		}
		
		return null;
	}
	
	public void writeNodes(){
		List<String> nowrite = new ArrayList<String>();
		for (NodeData node: nodes ){
			if (!nowrite.contains(node.getConsumer())){
				
				System.out.println(searchId(node.getConsumer()) + " [shape=doublecircle, width=.4, height=.4, fixedsize=true, color=black, style=filled, fontcolor=white;]");
				
				nowrite.add(node.getConsumer());
			}
		}
		
		nowrite.clear();
		
		for (NodeData node: nodes ){
			if (!nowrite.contains(node.getLeaser())){
				
				//System.out.println(searchId(node.getLeaser()) + " [width=.1, height=.1, fixedsize=true, arrowhead=dot, label=\"\"]");
				System.out.println(searchId(node.getLeaser()) + " [width=.4, height=.4, fixedsize=true]");
				
				nowrite.add(node.getLeaser());
			}
		}
		
		
	}

	
	public void writeDotNodes(){
		for (NodeData node: nodes){
			System.out.println(searchId(node.getConsumer()) + "-> " + searchId(node.getLeaser()) + " [style=invis, arrowhead=none] ;");
		}
	}
	
	
	
	public int getCounter(){
		return counter++;
	}	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NodeProcessor csvReader = new NodeProcessor("/home/huber/Desktop/source_code/db/cloud/Devices/nodes/wifi.csv");
		csvReader.parseCSVFile();
		csvReader.listNodeData();
		//csvReader.nodeGeneration();
		
		//csvReader.listPeerData();
		
		//csvReader.writeDotNodes();
		
		//csvReader.writeNodes();
		
		
	}

}
