package org.python.stdlib.datetime;

import java.time.Year;

@org.python.Module(
        __doc__ =
                "TODO"
)
public class Date extends org.python.types.Object {
    
    // @org.python.Method(
    //     __doc__ = "",
    //     args={"year", "month", "day"}

    // )
    public Date( org.python.types.Object year, org.python.types.Object  month, org.python.types.Object day) {
     super();   
    }

    @org.python.Method(
        __doc__ = "",
        args = {"n"}
    )
    public org.python.Object write(org.python.types.Object n) {
       return n;
  
    }


   

}
