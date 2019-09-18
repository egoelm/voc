package org.python.stdlib.datetime;

public class Date extends org.python.types.Object {
    private org.python.types.Object year;


    @org.python.Method(
        __doc__ = ""
    )
    public Date(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs)  { //gets kwargs to get by keyword yr,minth

        super();
        for (org.python.Object elem: args){
            System.out.println(elem);
        }
        System.out.println(kwargs.get("year"));
        System.out.println(kwargs.get("month"));

        //this.year = new java.util.  //new java.util.LinkedHashMap<org.python.Object, org.python.Object>();

    }

    @org.python.Method(
        __doc__ = ""
    )
    //we use this function for testing
    public static org.python.Object constant_4() {
        return org.python.types.Int.getInt(4);
    }
}
