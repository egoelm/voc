package org.python.java_tests.workloads;

public class GetItem {
	public static void main(String[] args) {

		org.python.types.List list = new org.python.types.List();
		int len = 10000;

		java.util.ArrayList<org.python.types.Int> indexes = new java.util.ArrayList();
		
		for(int i=0; i<len+20; i++) {
			org.python.types.Int j = org.python.types.Int.getInt(i);
			list.append(j);
			indexes.add(j);
		}
		
		long startTime = System.currentTimeMillis();

		for(int k=0; k<10000; k++) {
			for(int j=0; j<len; j++) {	
				org.python.types.Object i;
				i = indexes.get(j);
				list.__getitem__(i);
			}
		}
		
		long endTime = System.currentTimeMillis();
		long timeElapsed = (endTime - startTime);
		System.out.println("Time in seconds " + (timeElapsed/1000));
	}
}