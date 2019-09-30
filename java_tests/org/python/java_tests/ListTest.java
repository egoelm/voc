package org.python.java_tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Collections;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.python.Object;
import org.python.exceptions.IndexError;
import org.python.exceptions.ValueError;

public class ListTest{
	
	
	
	
    @Test
    public void testSomething() {
       
   
    org.python.types.Int day = org.python.types.Int.getInt(31);
    org.python.types.Int month = org.python.types.Int.getInt(12);
    org.python.types.Int year = org.python.types.Int.getInt(9999);

    org.python.Object[] args = {year, month, day};
    System.out.println(args[0]);
    org.python.types.List ll;
    Assert.assertTrue(false!=true);
    }
    
    @Before
    public void setUpSimpleList(){
    	
    }
    
   
    @Test
    public void test__getItem__() {
    	org.python.types.List list =  new org.python.types.List();
    	list.append(org.python.types.Int.getInt(1));
    	list.append(org.python.types.Int.getInt(2));
    	list.append(org.python.types.Int.getInt(3));
    	list.append(org.python.types.Int.getInt(4));
    	list.append(org.python.types.Int.getInt(5));
    	
    	org.python.types.Object index;
    	org.python.types.Object expected;
    	
    	//Simple positive index
    	index = org.python.types.Int.getInt(2);
    	expected = org.python.types.Int.getInt(3); 
    	assertEquals(list.__getitem__(index), expected);
    	
    	//Simple negative index
    	index = org.python.types.Int.getInt(-2);
    	expected = org.python.types.Int.getInt(4); 
    	assertEquals(list.__getitem__(index), expected);
    	  
    	//Positive index out of range
    	assertThrows(IndexError.class, () -> {
    		org.python.types.Object innerIndex = org.python.types.Int.getInt(10);
            list.__getitem__(innerIndex);
        });
    	
    	//Negative index out of range
    	assertThrows(IndexError.class, () -> {
    		org.python.types.Object innerIndex = org.python.types.Int.getInt(-10);
            list.__getitem__(innerIndex);
        });
    }
}
