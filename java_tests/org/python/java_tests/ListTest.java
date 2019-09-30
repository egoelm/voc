package org.python.java_tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertArrayEquals;
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
    	org.python.types.Object index;
    	org.python.types.Object expected;
    	
    	//Setup: list = [1,2,3,4,5];
    	list.append(org.python.types.Int.getInt(1));
    	list.append(org.python.types.Int.getInt(2));
    	list.append(org.python.types.Int.getInt(3));
    	list.append(org.python.types.Int.getInt(4));
    	list.append(org.python.types.Int.getInt(5));
    	
    	
    	//Simple positive index: list[2]
    	index = org.python.types.Int.getInt(2);
    	expected = org.python.types.Int.getInt(3); 
    	assertEquals(expected,list.__getitem__(index));
    	
    	//Simple negative index: list[-2]
    	index = org.python.types.Int.getInt(-2);
    	expected = org.python.types.Int.getInt(4); 
    	assertEquals(expected,list.__getitem__(index));
    	  
    	//Positive index out of range: x[10]
    	assertThrows(IndexError.class, () -> {
    		org.python.types.Object innerIndex = org.python.types.Int.getInt(10);
            list.__getitem__(innerIndex);
        });
    	
    	//Negative index out of range: x[10]
    	assertThrows(IndexError.class, () -> {
    		org.python.types.Object innerIndex = org.python.types.Int.getInt(-10);
            list.__getitem__(innerIndex);
        });
    }
    
    @Test
    public void test__setItem__() {
    	
    	//Setup: list = [1]
    	org.python.types.List list =  new org.python.types.List();
    	list.append(org.python.types.Int.getInt(1));
    	
    	org.python.types.Object index;
    	org.python.types.Object value;
    	
    	
    	//list[0] = 5; 
    	index = org.python.types.Int.getInt(0);
    	value = org.python.types.Int.getInt(5);
    	list.__setitem__(index, value);
    	assertEquals(value,list.__getitem__(index));
    	
    	
    	
    	
    	//Setup: list = [1, 2, 3];
    	list = new org.python.types.List();
    	list.append(org.python.types.Int.getInt(1));
    	list.append(org.python.types.Int.getInt(2));
    	list.append(org.python.types.Int.getInt(3));
    	
    	// list[1] = "hello"; list[2] = "there";
    	index = org.python.types.Int.getInt(1);
    	value = new org.python.types.Str("hello");
    	list.__setitem__(index, value);
    	index = org.python.types.Int.getInt(2);
    	value = new org.python.types.Str("there");
    	list.__setitem__(index, value);
    	
    	// Setup expected = [1, "hello", "there"]
    	org.python.types.List expectedList =  new org.python.types.List();
    	expectedList.append(org.python.types.Int.getInt(1));
    	expectedList.append(new org.python.types.Str("hello"));
    	expectedList.append(new org.python.types.Str("there"));
    	
    	assertEquals(
    			expectedList.__repr__(),
    			list.__repr__()
    			);
    	
    	
    	
    	
    	//Out of bounds:list = []; list[0] = 5
    	assertThrows(IndexError.class, () -> {
    		//Setup: list = [];
    		org.python.types.List innerlist =  new org.python.types.List();
    		
    		////list[0] = 5
    		org.python.types.Object innerIndex = org.python.types.Int.getInt(0);;
    		org.python.types.Object innerValue = org.python.types.Int.getInt(5);
    		innerlist.__setitem__(innerIndex, innerValue);	
        });
    	
    	
    	//Out of bounds:list = [1]; list[-2] = 5
    	assertThrows(IndexError.class, () -> {
    		//Setup: list = [1];
    		org.python.types.List innerlist =  new org.python.types.List();
    		innerlist.append(org.python.types.Int.getInt(1));
    		
    		////list[-2] = 5
    		org.python.types.Object innerIndex = org.python.types.Int.getInt(-2);;
    		org.python.types.Object innerValue = org.python.types.Int.getInt(5);
    		innerlist.__setitem__(innerIndex, innerValue);	
        });

    			
    	
    }
    
    
}
