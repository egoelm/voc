package org.python.java_tests.workloads;


public class Contains {
	public static void main(String[] args) {

		org.python.types.List list =  new org.python.types.List();
		int len = 14000;
		int i;
		for(i= 0; i<len; i++) {
		list.append(org.python.types.Int.getInt(i));
			
		}
		int runs = 10;
		
		long startTime = System.currentTimeMillis();
		
		for(int x = 0; x<runs;x++) {
		for(int j= 0; j<len; j++) {
		list.__contains__(org.python.types.Int.getInt(i));
		}
		}
	

		long endTime = System.currentTimeMillis();

		long timeElapsed = (endTime - startTime)/runs;

		System.out.println("Execution time in milliseconds: " + timeElapsed);
    	
    
		
	}
	
}
