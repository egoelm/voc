package org.python.java_tests;
import org.junit.Assert;
import org.junit.Test;
import org.python.Object;

public class ListTest{
    @Test
    public void testSomething() {
       
   
    	org.python.types.Int day = org.python.types.Int.getInt(31);
    org.python.types.Int month = org.python.types.Int.getInt(12);
    org.python.types.Int year = org.python.types.Int.getInt(9999);

    org.python.Object[] args = {year, month, day};
    System.out.println(args.length);
    org.python.types.List ll;
    Assert.assertTrue(false!=true);
    }
}
