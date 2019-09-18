package org.python.stdlib.datetime;

public class Date extends org.python.types.Object {
    org.python.types.Object year;


    @org.python.Method(
        __doc__ = ""
    )
    public Date() {
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
