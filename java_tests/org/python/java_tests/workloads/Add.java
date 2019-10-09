package org.python.java_tests.workloads;

public class Add {
	public static void main(String[] args){
		long totalTime = 0;
		int runs = 5;
		long startTime; 
		org.python.types.List list = null;
		
		for(int i = 0; i<runs; i++) {
			startTime = System.currentTimeMillis();
			list =  new org.python.types.List();
			for(int k = 0; k < 10000; k++ ) {
				org.python.types.List temp = new org.python.types.List();
				temp.append(org.python.types.Int.getInt(k));
				list = (org.python.types.List) list.__add__(temp);
			}
			totalTime += System.currentTimeMillis() - startTime;
			
		}
		
    	
    	System.out.println("Time in seconds " + (totalTime/runs)/1000);
		
	}
}
