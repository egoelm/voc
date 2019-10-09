package org.python.java_tests.workloads;

public class Remove {
	public static void main(String[] args) {

		org.python.types.List list =  new org.python.types.List();
		int len = 49000;
		int i;
		for(i= 0; i<len+20; i++) {
			list.append(org.python.types.Int.getInt(i));
			
		}
		int runs = 100;
		org.python.types.Bool bool_false = org.python.types.Bool.getBool(false);
		long startTime = System.currentTimeMillis();
		org.python.types.Object lenobj;
		lenobj=org.python.types.Int.getInt(len);
		for(int x = 0; x<runs;x++) {
		for(int j= 0; j<len; j++) {
			//System.out.println("j="+ j);
			org.python.types.Object val;
			val=org.python.types.Int.getInt(len-j);
			//System.out.println(val);
			if (lenobj.__lt__(val) != bool_false){
				list.remove(val);}
			
		}
		}
	

		long endTime = System.currentTimeMillis();

		long timeElapsed = (endTime - startTime)/runs;

		
		System.out.println("Time in seconds " + (timeElapsed/runs)/1000);
		System.out.println(timeElapsed);
		
	}
}
