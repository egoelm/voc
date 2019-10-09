package org.python.java_tests.workloads;

public class GetItem {
	public static void main(String[] args) {

		org.python.types.List list = new org.python.types.List();
		int len = 200000;
		for(int i=0; i<len+20; i++) {
			list.append(org.python.types.Int.getInt(i));	
		}
			
		long startTime = System.currentTimeMillis();

		for(int j=0; j<len; j++) {	
			org.python.types.Object i;
			i = org.python.types.Int.getInt(j);
			list.__getitem__(i);
		}
		
		long endTime = System.currentTimeMillis();
		long timeElapsed = (endTime - startTime);
		System.out.println("Time in seconds " + (timeElapsed/1000));
	}
}