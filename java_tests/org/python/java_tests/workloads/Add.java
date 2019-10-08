package org.python.java_tests.workloads;

public class Add {
	public static void main(String[] args){

		org.python.types.List list =  new org.python.types.List();
    	
    	
    	list.append(org.python.types.Int.getInt(1));
    	list.append(org.python.types.Int.getInt(2));
    	list.append(org.python.types.Int.getInt(3));
    	list.append(org.python.types.Int.getInt(4));
    	list.append(org.python.types.Int.getInt(5));
    	
    	System.out.println(list);
		
	}
}
