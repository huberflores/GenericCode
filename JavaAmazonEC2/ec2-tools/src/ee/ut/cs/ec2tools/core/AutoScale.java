package ee.ut.cs.ec2tools.core;


import ee.ut.cs.ec2tools.data.DeploymentResources;


/*
 * author Huber Flores
 */

public class AutoScale {

	DeploymentResources cloudScale = DeploymentResources.getInstance();
	
	
	public AutoScale(){
		
		System.out.println(cloudScale.getInstanceType());
		cloudScale.setInstanceType("m1.large");
		System.out.println(cloudScale.getInstanceType());
		
	}
	
	
	public static void main(String[] args){
		new AutoScale();
	}
	
	
	
}
