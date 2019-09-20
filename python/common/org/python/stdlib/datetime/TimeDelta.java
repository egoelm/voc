package org.python.stdlib.datetime;

import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;

public class TimeDelta extends org.python.types.Object {
    private org.python.Object days;
    private org.python.Object seconds;
    private org.python.Object microseconds;


    @org.python.Method(
        __doc__ = ""
    )
    public TimeDelta(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs)  { //gets kwargs to get by keyword yr,minth
        super();

        this.days = kwargs.get("days");
        if (this.days != null && args.length > 0) {
            throw new org.python.exceptions.SyntaxError("positional argument follows keyword argument");
        }

        this.seconds = kwargs.get("seconds");
        if (this.seconds != null && args.length > 0) {
            throw new org.python.exceptions.SyntaxError("positional argument follows keyword argument");
        }

        this.microseconds = kwargs.get("microseconds");
        if (this.microseconds != null && args.length > 0) {
            throw new org.python.exceptions.SyntaxError("positional argument follows keyword argument");
        }

        if(!kwargs.isEmpty()){
          // A week is converted to 7 days.
          if(kwargs.get("weeks") != null){
            long weeks = ((org.python.types.Int)kwargs.get("weeks")).value;
            this.days = org.python.types.Int.getInt(weeks*7);
          }

          // An hour is converted to 3600 seconds.
          if(kwargs.get("hours") != null){
          long hours = ((org.python.types.Int)kwargs.get("hours")).value;
          this.seconds = org.python.types.Int.getInt(hours*3600);
          }

          // A minute is converted to 60 seconds.
          if(kwargs.get("minutes") != null){
          long minutes = ((org.python.types.Int)kwargs.get("minutes")).value;
          this.seconds = org.python.types.Int.getInt(minutes*60);
          }

          // A millisecond is converted to 1000 microseconds.
          if(kwargs.get("milliseconds") != null){
          long millisecond = ((org.python.types.Int)kwargs.get("millisecond")).value;
          this.microseconds = org.python.types.Int.getInt(millisecond*1000);
          }
        }
    }

    @org.python.Method(
        __doc__ = ""
    )
    //we use this function for testing
    public static org.python.Object constant_4() {
        return org.python.types.Int.getInt(4);
    }
}
