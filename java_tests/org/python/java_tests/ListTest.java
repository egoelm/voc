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
    public void test__append__() {
    	org.python.types.List list =  new org.python.types.List();
    	list.append(org.python.types.Int.getInt(1));
    	list.append(org.python.types.Int.getInt(11));
    	
    	
    	org.python.types.Object index;
    	org.python.types.Object expected;
    	org.python.types.Object value;
    	
    	
    	//list with 2 elements, getting the second one
    	index = org.python.types.Int.getInt(1);
    expected = org.python.types.Int.getInt(11); 
    assertEquals( expected,list.__getitem__(index));
    
    //appending a string
    org.python.types.Str expected_str;
    expected_str = new org.python.types.Str("hello");
    index = org.python.types.Int.getInt(2);
    
    list.append(expected_str);
    assertEquals( expected_str,list.__getitem__(index));
    
    	}	
    
    @Test
    public void test__extend__() {
    	org.python.types.List list =  new org.python.types.List();
    	list.append(org.python.types.Int.getInt(0));
    	list.append(org.python.types.Int.getInt(1));
    	list.append(org.python.types.Int.getInt(2));
    	
    org.python.types.List list2 =  new org.python.types.List();
    	list2.append(org.python.types.Int.getInt(3));
    	list2.append(org.python.types.Int.getInt(4));
    	list2.append(org.python.types.Int.getInt(5));
    	
    	list.extend(list2);
    	
    	org.python.types.Object index;
    	org.python.types.Object expected;
    	
    	//testing extend for 2 lists of integers
    	index = org.python.types.Int.getInt(4);
    expected = org.python.types.Int.getInt(4); 
    assertEquals( expected, list.__getitem__(index));
    
   //testing extend for 2 lists: integers then strings
    org.python.types.Str str1,str2,str3, expected_str;
    org.python.types.List list3 =  new org.python.types.List();
	
    str1 = new org.python.types.Str("str1"); 
    str2 = new org.python.types.Str("str2");
    str3 = new org.python.types.Str("str3");
    list3.append(str1);
    list3.append(str2);
    list3.append(str3);
    list.extend(list3);
    
    index = org.python.types.Int.getInt(6);
    expected_str=str1;
    
    assertEquals(expected_str, list.__getitem__(index));
    
    //extending with a list containing int and string
    org.python.types.List list4 =  new org.python.types.List();
    list4.append(org.python.types.Int.getInt(0));
    list4.append(str1);
    list.extend(list4);
    
    index = org.python.types.Int.getInt(9);
    expected=org.python.types.Int.getInt(0);
    assertEquals(expected, list.__getitem__(index));
    
    // dictionary
    //org.python.types.Dict smt = new org.python.types.Dict();
    	}
    @Test
    public void test__remove__() {
    	org.python.types.List list =  new org.python.types.List();
    	list.append(org.python.types.Int.getInt(0));
    	list.append(org.python.types.Int.getInt(1));
    	list.append(org.python.types.Int.getInt(2));
    	
    	
    	org.python.types.Object index;
    	org.python.types.Object expected;
  
    	
    	//list with 3 elements, removing the second one
    	index = org.python.types.Int.getInt(1);
    	list.remove(index);
    	
    expected = org.python.types.Int.getInt(2); 
    assertEquals( expected,list.__getitem__(index));
    
    //appending 2 Bools to the int list, and removing the first one
    org.python.types.Bool tr= org.python.types.Bool.getBool(true);
    org.python.types.Bool fl= org.python.types.Bool.getBool(false);
    list.append(tr);
    list.append(fl);
   
	index = org.python.types.Int.getInt(2);
	 list.remove(index);
	assertEquals( fl,list.__getitem__(index));
    
    	}	

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
    
    @Test
    public void test__lt__() {
    	org.python.types.List list =  new org.python.types.List();
    	org.python.types.List other =  new org.python.types.List();
    	
    	//list = [1, 2, 3, 4, 5]
    	list.append(org.python.types.Int.getInt(1));
    	list.append(org.python.types.Int.getInt(2));
    	list.append(org.python.types.Int.getInt(3));
    	list.append(org.python.types.Int.getInt(4));
    	list.append(org.python.types.Int.getInt(5));
    	
    	//other = [1, 2, 3, 4, 5]
    	other.append(org.python.types.Int.getInt(1));
    	other.append(org.python.types.Int.getInt(2));
    	other.append(org.python.types.Int.getInt(3));
    	other.append(org.python.types.Int.getInt(4));
    	other.append(org.python.types.Int.getInt(5));
    	
    	//check with identical 
    	org.python.Object result = (list.__lt__(other));
    	
    	//Assert.assertEquals("False", result);
    	
    	//ensure rich comparison logic is used
    	
    	//when elements are non-identical, return that comparison, even if size is not
    	
    	//ensure tie breaker by size is still used when identical elements
    	
    	//If other isn't instance of list
    	/*assertThrows(IndexError.class, () -> {
    		});*/
    	 
       
    }
    
    

}
