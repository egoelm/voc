package org.python.java_tests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.python.Object;
import org.python.exceptions.AttributeError;
import org.python.exceptions.IndexError;
import org.python.exceptions.TypeError;
import org.python.exceptions.ValueError;
import org.python.types.List;

//import com.sun.tools.javac.util.List;

public class ListTest{
	

	
    private static final String True = null;


	@Test
    public void testSomething() {
       
   
    org.python.types.Int day = org.python.types.Int.getInt(31);
    org.python.types.Int month = org.python.types.Int.getInt(12);
    org.python.types.Int year = org.python.types.Int.getInt(9999);

    org.python.Object[] args = {year, month, day};
    System.out.println(args[2]);
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
    

    //Extends: test_list.py

    @Test
    public void  test__getItem__invaildType() {
    	org.python.types.List list =  new org.python.types.List();
    	
    	
    	
    	//Setup: list = [1,2,3];
    	list.append(org.python.types.Int.getInt(1));
    	list.append(org.python.types.Int.getInt(2));
    	list.append(org.python.types.Int.getInt(3));
    	
    	//list["h"]
    	assertThrows(TypeError.class, () -> {
    		org.python.types.Object index = new org.python.types.Str("h");
            list.__getitem__(index);
        });
    }
    
    @Test
    public void  test__getItem__withBool() {
    	org.python.types.List list =  new org.python.types.List();
    	org.python.types.Object index;
    	org.python.types.Object expected;
    	
    	
    	//Setup: list = [1,2,3];
    	list.append(org.python.types.Int.getInt(1));
    	list.append(org.python.types.Int.getInt(2));
    	list.append(org.python.types.Int.getInt(3));
    	
    	//list[True] == list[1]
    	index =  org.python.types.Bool.TRUE;
    	expected = org.python.types.Int.getInt(1); 

    	assertEquals(list.__getitem__(expected),list.__getitem__(index));
    	
    	//list[False] == list[0]
    	index =  org.python.types.Bool.FALSE;
    	expected = org.python.types.Int.getInt(0);

    	assertEquals(list.__getitem__(expected),list.__getitem__(index));
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
    	//list= [0,1,2]
    	list.append(org.python.types.Int.getInt(0));
    	list.append(org.python.types.Int.getInt(1));
    	list.append(org.python.types.Int.getInt(2));
    	
    org.python.types.List list2 =  new org.python.types.List();
    	list2.append(org.python.types.Int.getInt(3));
    	list2.append(org.python.types.Int.getInt(4));
    	list2.append(org.python.types.Int.getInt(5));
    	
    	//list= [0,1,2,3,4,5]
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
    //list3=["str1","str2","str3"]
    list3.append(str1);
    list3.append(str2);
    list3.append(str3);
    
    //list=[0,1,2,3,4,5,"str1","str2","str3"]
    list.extend(list3);
    
    index = org.python.types.Int.getInt(6);
    expected_str=str1;
    
    assertEquals(expected_str, list.__getitem__(index));
    
    //extending with a list containing int and string
    org.python.types.List list4 =  new org.python.types.List();
    //list4=[0]
    list4.append(org.python.types.Int.getInt(0));
    list4.append(str1);
    //list=[0,1,2,3,4,5,"str1","str2","str3",0]
    list.extend(list4);
    
    index = org.python.types.Int.getInt(9);
    expected=org.python.types.Int.getInt(0);
    assertEquals(expected, list.__getitem__(index));
    
    
    //extending a list with a dictionary
    org.python.types.Str elem = new org.python.types.Str("hello");
    org.python.Object[] content = { elem};
	org.python.types.List list7  = new org.python.types.List(content, Collections.emptyMap());
		
	
	index = org.python.types.Int.getInt(12);
    expected=org.python.types.Int.getInt(0);
    str1 = new org.python.types.Str("e"); 
	list.extend(list7);  
	assertEquals(str1, list.__getitem__(index));
	
	////extending a dictionary with a dictionary
	index = org.python.types.Int.getInt(5);
    expected=org.python.types.Int.getInt(0);
    str1 = new org.python.types.Str("h"); 
	list7.extend(list7);  
	assertEquals(str1, list7.__getitem__(index));
    
	//  extending with tuples
	org.python.types.Tuple tuple = new org.python.types.Tuple(content, Collections.emptyMap());
	 	
	org.python.Object[] cont = {tuple};
	org.python.types.List list8  = new org.python.types.List(cont, Collections.emptyMap());
	
	list.extend(list8);
	index = org.python.types.Int.getInt(15);
	str1 = new org.python.types.Str("o");
	assertEquals(str1, list.__getitem__(index));
	//list8.extend(list);
	
	
    //extending with a non-iterable
    assertThrows(TypeError.class, () -> {
		//Setup: list6 = [];
		org.python.types.List list6 =  new org.python.types.List();
		
		////list6 = [1, 2, 3]
		list6.append(org.python.types.Int.getInt(1));
		list6.append(org.python.types.Int.getInt(2));
		list6.append(org.python.types.Int.getInt(3));
		org.python.types.Object indx = org.python.types.Int.getInt(4);
		list6.extend(indx);	
    });
    
    
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
    
	
	// Remove only first duplicate
	//Setup: list4 = [];
	org.python.types.List list4 =  new org.python.types.List();
	
	////list4 = [1, 2, 2, 3, 2]
	list4.append(org.python.types.Int.getInt(1));
	list4.append(org.python.types.Int.getInt(2));
	list4.append(org.python.types.Int.getInt(2));
	list4.append(org.python.types.Int.getInt(3));
	list4.append(org.python.types.Int.getInt(2));
	org.python.types.Object inx = org.python.types.Int.getInt(1);
	org.python.types.Object expect = org.python.types.Int.getInt(2);
	
	list4.remove(inx);	
	
	assertEquals( expect,list4.__getitem__(inx));
	// Not in list
	assertThrows(ValueError.class, () -> {
		//Setup: list3 = [];
		org.python.types.List list3 =  new org.python.types.List();
		
		////x = [1, 2]
		list3.append(org.python.types.Int.getInt(1));
		list3.append(org.python.types.Int.getInt(2));
		org.python.types.Object indx = org.python.types.Int.getInt(3);
		list3.remove(indx);	
    });
	
	// Negative index
		assertThrows(ValueError.class, () -> {
			//Setup: list5 = [];
			org.python.types.List list5 =  new org.python.types.List();
			
			////x = [1, 2]
			list5.append(org.python.types.Int.getInt(1));
			list5.append(org.python.types.Int.getInt(2));
			org.python.types.Object indx = org.python.types.Int.getInt(-5);
			list5.remove(indx);	
	    });
			

    
    }	
    
    @Test
    public void test__add__() {
    
    	org.python.types.List list1 =  new org.python.types.List();
    	org.python.types.List list2 =  new org.python.types.List();
    org.python.types.List list3 =  new org.python.types.List();
    	
    	
    //list1 = [0,1]
    	list1.append(org.python.types.Int.getInt(0));
    	list1.append(org.python.types.Int.getInt(1));
    //list2 = [2,3]
    	list2.append(org.python.types.Int.getInt(2));
    	list2.append(org.python.types.Int.getInt(3));
    	
    	list3=(List) list1.__add__(list2);
    	
    	// Adding 2 lists together into a third list
    	org.python.types.Object indx = org.python.types.Int.getInt(2);
    	assertEquals( indx,list3.__getitem__(indx));
    	
    	//Adding a list and an Object
    	assertThrows(TypeError.class, () -> {
    		//Setup: elem = 0;
    		org.python.types.Object elem =  org.python.types.Int.getInt(0);;
    		list1.__add__(elem);
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
    	@Test
        public void  test__setItem__withBoolIndex() {
        	org.python.types.List list =  new org.python.types.List();
        	org.python.types.Object index;
        	org.python.types.Object value; 
        	org.python.types.Object expectedIndex;
        	
        	
        	
        	//Setup: list = [1,2,3];
        	list.append(org.python.types.Int.getInt(1));
        	list.append(org.python.types.Int.getInt(2));
        	list.append(org.python.types.Int.getInt(3));
        	
        	//list[True] = 5 
        	index =  org.python.types.Bool.TRUE;
        	value = org.python.types.Int.getInt(5); 
        	expectedIndex = org.python.types.Int.getInt(1);  
        	list.__setitem__(index, value);
        	assertEquals(list.__getitem__(expectedIndex),value);
        	
        	//Setup: list = [1,2,3];
        	list.append(org.python.types.Int.getInt(1));
        	list.append(org.python.types.Int.getInt(2));
        	list.append(org.python.types.Int.getInt(3));
        	
        	//list[False] = 5 
        	index =  org.python.types.Bool.FALSE;
        	value = org.python.types.Int.getInt(5); 
        	expectedIndex = org.python.types.Int.getInt(0);  
        	list.__setitem__(index, value);
        	assertEquals(list.__getitem__(expectedIndex),value);
   
    	
    	}

        @Test
        public void  test__setItem__invaildType() {
        	org.python.types.List list =  new org.python.types.List();
        	
        	
        	
        	//Setup: list = [1,2,3];
        	list.append(org.python.types.Int.getInt(1));
        	list.append(org.python.types.Int.getInt(2));
        	list.append(org.python.types.Int.getInt(3));
        	
        	//list["h"] = 3;
        	assertThrows(TypeError.class, () -> {
        		org.python.types.Object index = new org.python.types.Str("h");
        		org.python.types.Object vaule = org.python.types.Int.getInt(3);
                list.__setitem__(index,vaule);
            });
        }
    	
    @Test
    public void test_reverse() {
    	//Setup: list = [1,2,3,4,5];
    	org.python.types.List list =  new org.python.types.List();
    	list.append(org.python.types.Int.getInt(1));
    	list.append(org.python.types.Int.getInt(2));
    	list.append(org.python.types.Int.getInt(3));
    	list.append(org.python.types.Int.getInt(4));
    	list.append(org.python.types.Int.getInt(5));
    	
    	list.reverse();
    	
    	//Setup Expected list = [5,4,3,2,1];
    	org.python.types.List expected =  new org.python.types.List();
    	expected.append(org.python.types.Int.getInt(5));
    	expected.append(org.python.types.Int.getInt(4));
    	expected.append(org.python.types.Int.getInt(3));
    	expected.append(org.python.types.Int.getInt(2));
    	expected.append(org.python.types.Int.getInt(1));
    	
    	assertEquals(
    			expected.__repr__(),
    			list.__repr__()
    			);
    	
    }
    
    @Test
    public void test_slice() {
    	//Setup: list = [1,2,3,4,5];
    	org.python.types.List list =  new org.python.types.List();
    	list.append(org.python.types.Int.getInt(1));
    	list.append(org.python.types.Int.getInt(2));
    	list.append(org.python.types.Int.getInt(3));
    	list.append(org.python.types.Int.getInt(4));
    	list.append(org.python.types.Int.getInt(5));
    	
    	// Full slice: list[:]
    	org.python.types.Object start = null;
    	org.python.types.Object stop = null;
    	org.python.types.Object step;
    	org.python.types.Object slice = new org.python.types.Slice(start,stop);
    	
    	assertEquals(
    			list.__repr__(),
    			list.__getitem__(slice).__repr__()
    			);
    	
    	
    	//Left bound slice: list[1:]
    	start = org.python.types.Int.getInt(1);
    	stop =  null;
    	slice = new org.python.types.Slice(start,stop);
    	
    	//Setup Expected: [2,3,4,5];
    	org.python.types.List expected =  new org.python.types.List();
    	expected.append(org.python.types.Int.getInt(2));
    	expected.append(org.python.types.Int.getInt(3));
    	expected.append(org.python.types.Int.getInt(4));
    	expected.append(org.python.types.Int.getInt(5));
    	
    	assertEquals(
    			expected.__repr__(),
    			list.__getitem__(slice).__repr__()
    			);
    	
    	//Left bound slice: list[:4]
    	start = null;
    	stop =  org.python.types.Int.getInt(4);
    	slice = new org.python.types.Slice(start,stop);
    	
    	//Setup Expected: [1,2,3,4];
    	expected =  new org.python.types.List();
    	expected.append(org.python.types.Int.getInt(1));
    	expected.append(org.python.types.Int.getInt(2));
    	expected.append(org.python.types.Int.getInt(3));
    	expected.append(org.python.types.Int.getInt(4));
    	
    	assertEquals(
    			expected.__repr__(),
    			list.__getitem__(slice).__repr__()
    			);
    	
    	
    	//Slice bound in both directions list[1:4]
    	start = org.python.types.Int.getInt(1);
    	stop =  org.python.types.Int.getInt(4);
    	slice = new org.python.types.Slice(start,stop);
    	
    	//Setup Expected: [2,3,4];
    	expected =  new org.python.types.List();
    	expected.append(org.python.types.Int.getInt(2));
    	expected.append(org.python.types.Int.getInt(3));
    	expected.append(org.python.types.Int.getInt(4));
    	
    	assertEquals(
    			expected.__repr__(),
    			list.__getitem__(slice).__repr__()
    			);
    	
    	//Slice bound in both directions list[6:7]
    	start = org.python.types.Int.getInt(6);
    	stop =  org.python.types.Int.getInt(7);
    	slice = new org.python.types.Slice(start,stop);
    	
    	//Setup Expected: [];
    	expected =  new org.python.types.List();
    	assertEquals(
    			expected.__repr__(),
    			list.__getitem__(slice).__repr__()
    			);
    	
    }
    
    @Test 
    public void test_slice_with_zero_step() {
    	//list[1:3:0]
    	org.python.types.Object start =  org.python.types.Int.getInt(1);
    	org.python.types.Object stop =  org.python.types.Int.getInt(3);
    	org.python.types.Object step = org.python.types.Int.getInt(0);
    	org.python.types.Object slice = new org.python.types.Slice(start, stop, step);
    	
    	assertThrows(ValueError.class, () -> {
    		//Setup: list = [1,2,3,4,5];
    		org.python.types.List innerlist =  new org.python.types.List();
      		innerlist.append(org.python.types.Int.getInt(1));
    		innerlist.append(org.python.types.Int.getInt(2));
    		innerlist.append(org.python.types.Int.getInt(3));
    		innerlist.append(org.python.types.Int.getInt(4));
    		innerlist.append(org.python.types.Int.getInt(5));
    		
    		innerlist.__getitem__(slice);	
        });
    	
    }
    
    @Test 
    public void test_slice_with_simple_step() {
    	//Setup: list = [1,2,3,4,5];
    	org.python.types.List list = new org.python.types.List();
    	list.append(org.python.types.Int.getInt(1));
		list.append(org.python.types.Int.getInt(2));
		list.append(org.python.types.Int.getInt(3));
		list.append(org.python.types.Int.getInt(4));
		list.append(org.python.types.Int.getInt(5));
    	
    	//list[::2]
    	org.python.types.Object start =  null;
    	org.python.types.Object stop =  null;
    	org.python.types.Object step = org.python.types.Int.getInt(2);
    	org.python.types.Object slice = new org.python.types.Slice(start, stop, step);
    	
    	
    	//Setup expected: expected = [1,3,5];
    	org.python.types.List expected =  new org.python.types.List();
    	expected.append(org.python.types.Int.getInt(1));
    	expected.append(org.python.types.Int.getInt(3));
    	expected.append(org.python.types.Int.getInt(5));
    
    	assertEquals(
    			expected.__repr__(),
    			list.__getitem__(slice).__repr__()
    			);
    	
    }

    @Test
    public void test__count__() {
    	org.python.types.List list =  new org.python.types.List();
    	list.append(org.python.types.Int.getInt(1));
    	list.append(org.python.types.Int.getInt(1));
    	list.append(org.python.types.Int.getInt(1));
    	list.append(org.python.types.Int.getInt(4));
    	list.append(org.python.types.Int.getInt(5));
    	
    	
    	org.python.types.Object expected;
    	
    	// Normal Count
       
    	
    	expected=org.python.types.Int.getInt(3);
    	assertEquals(expected, list.count(org.python.types.Int.getInt(1)));
    	
    	// Bool Count
    	
    	list.append(org.python.types.Bool.getBool(true));
    	list.append(org.python.types.Bool.getBool(true));
    	list.append(org.python.types.Bool.getBool(false));
    	
    	expected=org.python.types.Int.getInt(5);
    	assertEquals(expected, list.count(org.python.types.Int.getInt(1)));
    	
    	// Element does not exits
    	
    	expected=org.python.types.Int.getInt(0);
    	assertEquals(expected, list.count(org.python.types.Int.getInt(2)));
    	
    }
    
    @Test
    public void test__ge__() {
    	org.python.types.List list1 =  new org.python.types.List();
    	org.python.types.List list2 =  new org.python.types.List();
    	org.python.Object result;
    	org.python.types.Bool bool_true = org.python.types.Bool.getBool(true);
    	org.python.types.Bool bool_false = org.python.types.Bool.getBool(false);
    	
    	// [] >= [];
    	result = list1.__ge__(list2);
    	Assert.assertEquals(bool_true, result);
    	
    	// [1,2,3] >= [1,2,3]
    	list1.append(org.python.types.Int.getInt(1));
    	list1.append(org.python.types.Int.getInt(2));
    	list1.append(org.python.types.Int.getInt(3));
    	list2.append(org.python.types.Int.getInt(1));
    	list2.append(org.python.types.Int.getInt(2));
    	list2.append(org.python.types.Int.getInt(3));
    	result = list1.__ge__(list2);
    	Assert.assertEquals(bool_true, result);
    	
    	// [1,2,3] >= [1,2,3,2]
    	list2.append(org.python.types.Int.getInt(2));
    	result = list1.__ge__(list2);
    	Assert.assertEquals(bool_false, result);
    	
    	// [1,2,3,2] >= [1,2,3]
    	result = list2.__ge__(list1);
    	Assert.assertEquals(bool_true, result);
    	
    	// [1,2,3,1] >= [1,2,3,2]
    	list1.append(org.python.types.Int.getInt(1));
    	result = list1.__ge__(list2);
    	Assert.assertEquals(bool_false, result);
    	
    	// [1,2,3,2] >= [1,2,3,1]
    	result = list2.__ge__(list1);
    	Assert.assertEquals(bool_true, result);
    }
    
    @Test
    public void test__eq__() {
    	org.python.types.List list1 =  new org.python.types.List();
    	org.python.types.List list2 =  new org.python.types.List();
    	org.python.Object result;
    	org.python.types.Bool bool_true = org.python.types.Bool.getBool(true);
    	org.python.types.Bool bool_false = org.python.types.Bool.getBool(false);
    	
    	// [] == [];
    	result = list1.__eq__(list2);
    	Assert.assertEquals(bool_true, result);
    	
    	// [1,2,3] == [1,2,3]
    	list1.append(org.python.types.Int.getInt(1));
    	list1.append(org.python.types.Int.getInt(2));
    	list1.append(org.python.types.Int.getInt(3));
    	list2.append(org.python.types.Int.getInt(1));
    	list2.append(org.python.types.Int.getInt(2));
    	list2.append(org.python.types.Int.getInt(3));
    	result = list1.__eq__(list2);
    	Assert.assertEquals(bool_true, result);
    	
    	// [1,2,3] == [1,2,3,2]
    	list2.append(org.python.types.Int.getInt(2));
    	result = list1.__eq__(list2);
    	Assert.assertEquals(bool_false, result);

    	// [1,2,3,1] == [1,2,3,2]
    	list1.append(org.python.types.Int.getInt(1));
    	result = list1.__eq__(list2);
    	Assert.assertEquals(bool_false, result);
    	
    	// [1,2,3,2] == [1,2,3,1]
    	result = list2.__eq__(list1);
    	Assert.assertEquals(bool_false, result);
    }

    @Test
    public void test__contains__() {
    	 
    	org.python.types.List list =  new org.python.types.List();
     	list.append(org.python.types.Int.getInt(1));
     	list.append(org.python.types.Int.getInt(1));
     	list.append(org.python.types.Int.getInt(1));
     	list.append(org.python.types.Int.getInt(4));
     	list.append(org.python.types.Int.getInt(5));
     	
     	org.python.types.Object expected;
     	// Normal contains
     	expected = org.python.types.Bool.getBool(true);
     	assertEquals(expected, list.__contains__(org.python.types.Int.getInt(1)));
    	// Elements does not exist
     	expected = org.python.types.Bool.getBool(false);
     	assertEquals(expected, list.__contains__(org.python.types.Int.getInt(0)));
     	
    	// Boolean contains 
     	list.append(org.python.types.Bool.getBool(false)); 
     	expected = org.python.types.Bool.getBool(true);
     	assertEquals(expected, list.__contains__(org.python.types.Int.getInt(0)));
     	
     }
    
    @Test 
    public void test_slice_in_reverse() {
    	//Setup: list = [1,2,3,4,5];
    	org.python.types.List list = new org.python.types.List();
    	list.append(org.python.types.Int.getInt(1));
		list.append(org.python.types.Int.getInt(2));
		list.append(org.python.types.Int.getInt(3));
		list.append(org.python.types.Int.getInt(4));
		list.append(org.python.types.Int.getInt(5));
    	
    	//# Full slice with a negative step: list[::-1]
    	org.python.types.Object start =  null;
    	org.python.types.Object stop = null;
    	org.python.types.Object step = org.python.types.Int.getInt(-1);
    	org.python.types.Object slice = new org.python.types.Slice(start, stop, step);
    	
    	
    	//Setup expected: expected = [5,4,3,2,1];
    	org.python.types.List expected =  new org.python.types.List();
    	expected.append(org.python.types.Int.getInt(5));
    	expected.append(org.python.types.Int.getInt(4));
    	expected.append(org.python.types.Int.getInt(3));
    	expected.append(org.python.types.Int.getInt(2));
    	expected.append(org.python.types.Int.getInt(1));
    
    	assertEquals(
    			expected.__repr__(),
    			list.__getitem__(slice).__repr__()
    			);
    	
    	
    	//left bound slice with a negative step : list[4::-2]
    	start =  org.python.types.Int.getInt(4);
    	stop = null;
    	step = org.python.types.Int.getInt(-2);
    	slice = new org.python.types.Slice(start, stop, step);
    	
    	//Setup expected: expected = [5,3,1];
    	expected =  new org.python.types.List();
    	expected.append(org.python.types.Int.getInt(5));
    	expected.append(org.python.types.Int.getInt(3));
    	expected.append(org.python.types.Int.getInt(1));
    	
    
    	assertEquals(
    			expected.__repr__(),
    			list.__getitem__(slice).__repr__()
    			);
    	
    	//Right bound slice with a negative step: list[:4:-1]
    	start =  null;
    	stop = org.python.types.Int.getInt(4);
    	step = org.python.types.Int.getInt(-1);
    	slice = new org.python.types.Slice(start, stop, step);
    	
    	//Setup expected: expected = [];
    	expected =  new org.python.types.List();
    	assertEquals(
    			expected.__repr__(),
    			list.__getitem__(slice).__repr__()
    			);
    	
    	//Right bound and left bound slice with a negative step: list[1:4:-2]
    	start =  org.python.types.Int.getInt(1);
    	stop = org.python.types.Int.getInt(4);
    	step = org.python.types.Int.getInt(-2);
    	slice = new org.python.types.Slice(start, stop, step);
    	
    	//Setup expected: expected = [];
    	expected =  new org.python.types.List();
    	assertEquals(
    			expected.__repr__(),
    			list.__getitem__(slice).__repr__()
    			);
    	
    }
    
   /* @Test
    public void test__sort__() {
   	 
   	org.python.types.List list =  new org.python.types.List();
   	org.python.types.List listInt =  new org.python.types.List();
   	org.python.types.List listStr =  new org.python.types.List();
   	 
   	listInt.append(org.python.types.Int.getInt(9));
     	listInt.append(org.python.types.Int.getInt(4));
     	listInt.append(org.python.types.Int.getInt(7));
     	
     	
     	listStr.append(new org.python.types.Str("beta"));
     	listStr.append(new org.python.types.Str("theta"));
     	listStr.append(new org.python.types.Str("alpha"));
     	
     	list.append(listInt);
     	list.append(listStr);
     	
     	org.python.types.List expected =  new org.python.types.List();
     	org.python.types.List expectedInt =  new org.python.types.List();
   	org.python.types.List expectedStr =  new org.python.types.List();
   	
   	expectedInt.append(org.python.types.Int.getInt(4));
     	expectedInt.append(org.python.types.Int.getInt(7));
     	expectedInt.append(org.python.types.Int.getInt(9));
     	
     	
     	expectedStr.append(new org.python.types.Str("alpha"));
     	expectedStr.append(new org.python.types.Str("beta"));
     	expectedStr.append(new org.python.types.Str("theta"));
     	
     	expected.append(expectedInt);
     	expected.append(expectedStr);
        
     	list.sort(null,null);
    
     	assertEquals(expected, list);
   	
   	
 
    }*/
    
    @Test
    public void test_pop() {
   	 
   	org.python.types.List list =  new org.python.types.List();
   	
   	 
   	list.append(org.python.types.Int.getInt(1));
    list.append(org.python.types.Int.getInt(2));
    list.append(org.python.types.Int.getInt(3));
     	
     	
    
     // Normal pop	
     org.python.types.List expected =  new org.python.types.List();
     	
   	 expected.append(org.python.types.Int.getInt(2));
     expected.append(org.python.types.Int.getInt(3));
     //System.out.println(list.pop(org.python.types.Int.getInt(-4)));
     
     list.pop(org.python.types.Int.getInt(0));
      	
     	
      assertEquals(expected, list);
   	 
      // Pop negative index
     	
     	assertThrows(IndexError.class, () -> {
    		org.python.types.Object innerIndex = org.python.types.Int.getInt(-4);
            list.pop(innerIndex);
        });
     	
     // Pop empty list
     	
     	org.python.types.List empty =  new org.python.types.List();
     	assertThrows(IndexError.class, () -> {
    		org.python.types.Object innerIndex = org.python.types.Int.getInt(1);
            empty.pop(innerIndex);
        });
   	    
 
    }
    
    @Test
    public void test_copy() {
   	 
   	org.python.types.List list =  new org.python.types.List();
   	
   	 
   	list.append(org.python.types.Int.getInt(1));
    list.append(org.python.types.Int.getInt(2));
    list.append(org.python.types.Int.getInt(3));
     	
     	
    
    
      // 	y = x.copy()
      //    print(y)
     	
      assertEquals(list, list.copy());
   	  
      // y = x.copy()
      // print(x is not y)
      
      assertTrue(list != list.copy());
     
      
   // y = x.copy()
    // print(x == y)
      
      assertTrue(list.equals(list.copy()));
    }
   	
    @Test
    public void test__reversed__() {
    	org.python.types.List list1 =  new org.python.types.List();
    	org.python.types.List list2 =  new org.python.types.List();
    	
    	// list1 = [1,2,3,4]; list2 = [4,3,2,1];
    	list1.append(org.python.types.Int.getInt(1));
    	list1.append(org.python.types.Int.getInt(2));
    	list1.append(org.python.types.Int.getInt(3));
    	list1.append(org.python.types.Int.getInt(4));
    	list2.append(org.python.types.Int.getInt(4));
    	list2.append(org.python.types.Int.getInt(3));
    	list2.append(org.python.types.Int.getInt(2));
    	list2.append(org.python.types.Int.getInt(1));
    	
    	org.python.Object list1_rev = list1.__reversed__();
    	org.python.Object list2_iter = list2.__iter__();
    	
    	for (int i = 0; i < 4; i++) {
    		org.python.Object item1 = list1_rev.__next__();
    		org.python.Object item2 = list2_iter.__next__();
    		assertEquals(item1, item2);
    	}
    }

    @Test //extension to original conversion from python tests
    public void test_creation_args() {
    	org.python.types.List expected = new org.python.types.List();
 		org.python.Object[] args = {null,org.python.types.Int.getInt(2)};
 		org.python.types.List list  = new org.python.types.List(args, Collections.emptyMap()); 
 		
 		assertEquals(expected.__repr__(),list.__repr__());//Test when receiving null
 		
 		org.python.types.List attr = new org.python.types.List();
 		attr.append(org.python.types.Int.getInt(5));
 		
 		org.python.Object[] args1 = {attr};
 		org.python.types.List list1  = new org.python.types.List(args1, Collections.emptyMap());
 		
 		assertEquals(attr.__repr__(),list1.__repr__());//Test when there is one argument and it is a list  
  
 		org.python.Object a = org.python.types.Int.getInt(5);
 		org.python.types.Set set = new org.python.types.Set();
 		set.add(a);
 		
 		org.python.Object[] args2 = {set};
 		org.python.types.List list2  = new org.python.types.List(args2, Collections.emptyMap());
 		
 		assertEquals(attr.__repr__(),list2.__repr__());//Test when there is one argument and it is a set 
 		
 		
 		java.util.List<org.python.Object> t = new ArrayList<org.python.Object>();
 		t.add(a);
 		
 		org.python.types.Tuple tuple = new org.python.types.Tuple(args2,Collections.emptyMap());
 
 		
 		org.python.Object[] args3 = {tuple};
 		org.python.types.List list3  = new org.python.types.List(args3, Collections.emptyMap());
 		
 		assertEquals(attr.__repr__(),list3.__repr__());//Test when there is one argument and it is a tuple
 		org.python.types.Str str = new org.python.types.Str("hej");
 		org.python.types.Str str1 = new org.python.types.Str("h");
 		org.python.types.Str str2 = new org.python.types.Str("e");
 		org.python.types.Str str3 = new org.python.types.Str("j");
 		
 		org.python.Object[] args4 = { str};
 		org.python.types.List list4  = new org.python.types.List(args4, Collections.emptyMap());
 		
 		org.python.types.List attrStr = new org.python.types.List();
 		attrStr.append(str1);
 		attrStr.append(str2);
 		attrStr.append(str3);
 		
 		assertEquals(attrStr.__repr__(),list4.__repr__());//Test when there is one argument and it is not anything of above
 		
    }
    
    @Test(expected = TypeError.class)
    public void test_creation_exception() {
    	org.python.types.Str str = new org.python.types.Str("hej");
 		org.python.types.Str str1 = new org.python.types.Str("h");
 		org.python.Object[] args = {str, str1};
 		org.python.types.List list  = new org.python.types.List(args, Collections.emptyMap());
    }
    
    @Test
    public void test__lt__() {
    	org.python.types.List list =  new org.python.types.List();
    	org.python.types.List other =  new org.python.types.List();
    	org.python.Object result;
    	org.python.types.Bool bool_true = org.python.types.Bool.getBool(true);
    	org.python.types.Bool bool_false = org.python.types.Bool.getBool(false);
    	
    	// [] < [];
    	result = list.__lt__(other);
    	Assert.assertEquals(bool_false, result);
    	
    	// [1,2,3] < [1,2,3]
    	list.append(org.python.types.Int.getInt(1));
    	list.append(org.python.types.Int.getInt(2));
    	list.append(org.python.types.Int.getInt(3));
    	
    	other.append(org.python.types.Int.getInt(1));
    	other.append(org.python.types.Int.getInt(2));
    	other.append(org.python.types.Int.getInt(3));
    	
    	result = list.__lt__(other);
    	Assert.assertEquals(bool_false, result);
    	
    	// [1,2,3] < [1,2,3,1]
    	other.append(org.python.types.Int.getInt(1));
    	result = list.__lt__(other);
    	Assert.assertEquals(bool_true, result);
    	
    	// [1,2,3,1] < [1,2,3]
    	result = other.__lt__(list);
    	Assert.assertEquals(bool_false, result);
    	
    	// [1,2,3,2] < [1,2,3,1]
    	list.append(org.python.types.Int.getInt(2));
    	result = list.__lt__(other);
    	Assert.assertEquals(bool_false, result);
    	
    	// [1,2,3,1] < [1,2,3,2]
    	result = other.__lt__(list);
    	Assert.assertEquals(bool_true, result);
    }
    
    @Test
    public void test__gt__() {
    	org.python.types.List list =  new org.python.types.List();
    	org.python.types.List other =  new org.python.types.List();
    	org.python.Object result;
    	org.python.types.Bool bool_true = org.python.types.Bool.getBool(true);
    	org.python.types.Bool bool_false = org.python.types.Bool.getBool(false);
    	
    	// [] > [];
    	result = list.__gt__(other);
    	Assert.assertEquals(bool_false, result);
    	
    	// [1,2,3] > [1,2,3]
    	list.append(org.python.types.Int.getInt(1));
    	list.append(org.python.types.Int.getInt(2));
    	list.append(org.python.types.Int.getInt(3));
    	
    	other.append(org.python.types.Int.getInt(1));
    	other.append(org.python.types.Int.getInt(2));
    	other.append(org.python.types.Int.getInt(3));
    	
    	result = list.__gt__(other);
    	Assert.assertEquals(bool_false, result);
    	
    	// [1,2,3] > [1,2,3,1]
    	other.append(org.python.types.Int.getInt(1));
    	result = list.__gt__(other);
    	Assert.assertEquals(bool_false, result);
    	
    	// [1,2,3,1] > [1,2,3]
    	result = other.__gt__(list);
    	Assert.assertEquals(bool_true, result);
    	
    	// [1,2,3,2] > [1,2,3,1]
    	list.append(org.python.types.Int.getInt(2));
    	result = list.__gt__(other);
    	Assert.assertEquals(bool_true, result);
    	
    	// [1,2,3,1] > [1,2,3,2]
    	result = other.__gt__(list);
    	Assert.assertEquals(bool_false, result);
    }
    
    @Test
    public void test__len__() {
    	//setup: [1,2,3] 
    	org.python.types.List list = new org.python.types.List();
    	list.append(org.python.types.Int.getInt(1));
    	list.append(org.python.types.Int.getInt(2));
    	list.append(org.python.types.Int.getInt(3));
    	Assert.assertEquals(3,((org.python.types.Int)list.__len__()).value);
    	
    	
    	//setup: []
    	list = new org.python.types.List();
    	Assert.assertEquals(0,((org.python.types.Int)list.__len__()).value);
    	
    }
    
    

}
