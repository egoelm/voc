package org.python.java_tests.workloads;

public class Reverse {
	
	private static org.python.Object workload(org.python.types.List list) {
		for(int i = 0; i < 4000 ; i++) {
			list.reverse();
		}
		return list;
	}
	
	private static org.python.types.List setup(int length) {
		org.python.types.List list = new org.python.types.List();
		for (int i = 1; i <= length; i++) {
				 list.append(org.python.types.Int.getInt(i));
		}
		

		return list;
	}
	
	public static void main(String[] args) {
		org.python.types.List lists = Reverse.setup(100000);
		
		long startTime = System.nanoTime();
		Reverse.workload(lists);
		long endTime = System.nanoTime();
		//System.out.println(lists);
		System.out.println((endTime - startTime) / 1000000); //milliseconds 
		
	
	}
	
}
