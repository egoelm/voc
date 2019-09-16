package org.python.stdlib.datetime;

@org.python.Module(
        __doc__ =
                "TODO"
)
public class TimeDelta extends org.python.types.Module {
    public TimeDelta() {
        super();
    }
@org.python.Method(
         __doc__ = "",
         args ={"day"}
    )

public static java.time.Duration days(org.python.Object day) {
       // if (days instanceof org.python.types.Int){

        long val = ((org.python.types.Int) day).value;
        //int d = java.time.Duration.ofDays(val);
        //((org.python.types.Int) days).value = java.time.Duration.ofDays(val);
        java.time.Duration d = java.time.Duration.ofDays(val);
        return d;
          
        }
}