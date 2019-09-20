package org.python.stdlib.datetime;

public class TimeDelta extends org.python.types.Object {
    private org.python.types.Object days;
    private org.python.types.Object seconds;
    private org.python.types.Object microseconds;


    @org.python.Method(
        __doc__ = ""
    )
    public TimeDelta(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs)  { //gets kwargs to get by keyword yr,minth
        super();
        /*if(args.length < 0 && kwargs.size() < 0){
          this.days = (org.python.types.Object)0 ;
        }*/

        if(!kwargs.isEmpty()){
          // A week is converted to 7 days.
          long weeks = ((org.python.types.Int)kwargs.get("weeks")).value;
          this.days = org.python.types.Int.getInt(weeks*7);

          // An hour is converted to 3600 seconds.
          long hours = ((org.python.types.Int)kwargs.get("hours")).value;
          this.seconds = org.python.types.Int.getInt(hours*3600);

          // A minute is converted to 60 seconds.
          long minutes = ((org.python.types.Int)kwargs.get("minutes")).value;
          this.seconds = org.python.types.Int.getInt(minutes*60);

          // A millisecond is converted to 1000 microseconds.
          long millisecond = ((org.python.types.Int)kwargs.get("millisecond")).value;
          this.microseconds = org.python.types.Int.getInt(millisecond*1000);
        }

      /*  for (org.python.Object elem: args){
        System.out.println(elem);
        System.out.println(kwargs.get("year"));
        System.out.println(kwargs.get("month"));*/

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
