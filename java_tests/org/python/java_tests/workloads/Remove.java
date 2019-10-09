package org.python.java_tests.workloads;

public class Remove {
	public static void main(String[] args) {

		org.python.types.List list =  new org.python.types.List();
		int len = 20000;
		int i;
		for(i= 0; i<len+20; i++) {
			list.append(org.python.types.Int.getInt(i));	
		}
			
		long startTime = System.currentTimeMillis();

		for(int j= 0; j<len; j++) {	
			org.python.types.Object val;
			val=org.python.types.Int.getInt(len-j);	
			list.remove(val);	
		}
		
		long endTime = System.currentTimeMillis();
		long timeElapsed = (endTime - startTime);
		System.out.println("Time in seconds " + (timeElapsed/1000));
		
		
	}
}
