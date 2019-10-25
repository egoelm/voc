package org.python.java_tests.workloads;

public class Len {
	public static void main(String[] args) {
		int len = 14000;
		int totalTime = 0;
		int runs = 8;
		org.python.types.List list = new org.python.types.List();
		
		for(int i= 0; i<len; i++) {
			list.append(org.python.types.Int.getInt(i));	
		}
		
		for(int i = 0; i<runs; i++) {
			long startTime = System.currentTimeMillis();
			list.__len__();
			totalTime += System.currentTimeMillis() - startTime;
		}

    	System.out.println("Time in miliseconds " + (totalTime/runs));
	}
}