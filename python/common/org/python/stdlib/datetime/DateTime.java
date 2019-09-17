package org.python.stdlib.datetime;

public class DateTime extends org.python.types.Object {
    
     @org.python.Method(
            __doc__ = ""
    )
    public DateTime() {
        super();
    }

    @org.python.Method(
            __doc__ = ""
    )
    //we use this function for testing
    public static org.python.Object constant_4() {
        return org.python.types.Int.getInt(4);
    }
	}