package org.python.stdlib.datetime;

import javax.swing.plaf.basic.BasicSplitPaneUI.KeyboardDownRightHandler;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class TimeDelta extends org.python.types.Object {
    private org.python.Object days;
    private org.python.Object seconds;
    //private org.python.Object hours;
    private org.python.Object microseconds;

    @org.python.Attribute
    public  org.python.Object min = __min__();
    //@org.python.Attribute
    //public static org.python.Object[] max = new ArrayList<org.python.Object>; 
    /*@org.python.Attribute
    public static org.python.Object resolution;*/


    @org.python.Method(
        __doc__ = ""
    )
    public TimeDelta(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs)  { //gets kwargs to get by keyword yr,minth
        super();
        if(args.length == 0 && kwargs.isEmpty()){
            this.days = org.python.types.Int.getInt(0);
            this.seconds = org.python.types.Int.getInt(0);
            this.microseconds = org.python.types.Int.getInt(0);
        }

        //else if (args.length!=0){
            if(args.length > 7){
                throw new org.python.exceptions.TypeError("__new__() takes at most 7 arguments (" + args.length  + " given)");
            }
        //}
        String [] allowed = {"days", "seconds", "microseconds", "milliseconds", "minutes", "hours", "weeks"};
        List <String> allowedList = Arrays.asList(allowed);
         if(!kwargs.isEmpty()){
            boolean correct = true;
            for ( java.lang.String key : kwargs.keySet() ) {

                correct = allowedList.contains(key);
                if (!correct) {
                    throw new org.python.exceptions.TypeError(key + " is an invalid keyword argument for this function");

                }
            }
            if(args.length>0){
     
        //this.days = kwargs.get("days");
        if (kwargs.get("days") != null && args.length == 1) {
            throw new org.python.exceptions.TypeError("Argument given by name ('days') and position (1)");
            //throw new org.python.exceptions.SyntaxError("positional argument follows keyword argument");
        }

        //this.seconds = kwargs.get("seconds");
        if (kwargs.get("seconds") != null && args.length == 2) {
            throw new org.python.exceptions.TypeError("Argument given by name ('seconds') and position (2)");
            //throw new org.python.exceptions.SyntaxError("positional argument follows keyword argument");
        }

        this.microseconds = kwargs.get("microseconds");
        if (kwargs.get("microseconds")!= null && args.length ==3) {
            throw new org.python.exceptions.TypeError("Argument given by name ('microseconds') and position (3)");
            //throw new org.python.exceptions.SyntaxError("positional argument follows keyword argument");
        }
        if(args.length==3){
            this.days = args[0];
            this.seconds = args[1];
            this.microseconds = args[2];
        }
        else if (args.length==2){
            this.days = args[0];
            this.seconds = args[1];
            this.microseconds = org.python.types.Int.getInt(0);

        }
        else if (args.length==1){
            this.days = args[0];
            this.seconds = org.python.types.Int.getInt(0);
            this.microseconds = org.python.types.Int.getInt(0);

        }

        if(kwargs.get("weeks") != null){
            long weeks = ((org.python.types.Int)kwargs.get("weeks")).value;
            //weeks = weeks*
            long day = ((org.python.types.Int)this.days).value;
            day = day + weeks*7;
            this.days =org.python.types.Int.getInt(day); //+ org.python.types.Int.getInt(day);
          }

           if(kwargs.get("hours") != null){
          long hours = ((org.python.types.Int)kwargs.get("hours")).value;
          long second = ((org.python.types.Int)this.seconds).value;
          second = second + hours*3600;
          this.seconds = org.python.types.Int.getInt(second);
          }

          // A minute is converted to 60 seconds.
          if(kwargs.get("minutes") != null){
          long minutes = ((org.python.types.Int)kwargs.get("minutes")).value;
          long minute = ((org.python.types.Int)this.seconds).value;
          minute = minute+ minutes*60;
          this.seconds = org.python.types.Int.getInt(minute);
          //this.seconds = org.python.types.Int.getInt(minutes*60);
          }

          // A millisecond is converted to 1000 microseconds.
          if(kwargs.get("milliseconds") != null){
          long millisecond = ((org.python.types.Int)kwargs.get("milliseconds")).value;
          long mili = ((org.python.types.Int)this.microseconds).value;
          mili = mili+ millisecond*1000;
          this.microseconds = org.python.types.Int.getInt(mili);
          //this.microseconds = org.python.types.Int.getInt(millisecond*1000);
          }


    }
       } 
        //if(!kwargs.isEmpty()){

          // A week is converted to 7 days.
        /*  if(kwargs.get("weeks") != null){
            long weeks = ((org.python.types.Int)kwargs.get("weeks")).value;
            this.days = org.python.types.Int.getInt(weeks*7);
          }*/

          /*// An hour is converted to 3600 seconds.
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
          }*/

        
    
    }
    @org.python.Method()
    public  org.python.Object __min__(){
    org.python.Object[] args = {org.python.types.Int.getInt(-999999999),org.python.types.Int.getInt(0),org.python.types.Int.getInt(0)};
        //TimeDelta minDate = new TimeDelta(args, Collections.emptyMap());
        //minDate.days = org.python.types.Int.getInt(-999999999);
        //String returnStr = ""+ this.days;
        return new TimeDelta(args, Collections.emptyMap());
        //return new org.python.types.Str(returnStr);

    }
    
    @org.python.Method()
    public org.python.Object max(){
        this.days = this.min;
        String returnStr = ""+ this.days;
        //return this;
        return new org.python.types.Str(returnStr);

    }
    public org.python.types.Str __str__() {
        long dayslong = ((org.python.types.Int)this.days).value;
        String days = Long.toString(dayslong);
        /*while (year.length() < 4) {
            year = "0" + year;
        }*/
        //long hours = ((org.python.types.Int)this.hours).value;
        long seconds = ((org.python.types.Int)this.seconds).value;
        long microseconds = ((org.python.types.Int)this.microseconds).value;
        //long printSeconds = seconds % 3600;
        //long hours = (seconds  - printSeconds)/3600;
        String returnStr = days +" days, "  + "seconds: " + seconds + ", microseconds: " + microseconds;
        return new org.python.types.Str(returnStr);
    }

    @org.python.Method(
        __doc__ = ""
    )
    //we use this function for testing
    public static org.python.Object constant_4() {
        return org.python.types.Int.getInt(4);
    }
}
