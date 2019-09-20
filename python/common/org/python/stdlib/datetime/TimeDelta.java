package org.python.stdlib.datetime;

public class TimeDelta extends org.python.types.Object {
    private org.python.Object days;
    private org.python.Object seconds;
    private org.python.Object hours;
    private org.python.Object microseconds;

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
          this.days = kwargs.get("day");
          long weeks = ((org.python.types.Int)kwargs.get("weeks")).value;
          this.days = org.python.types.Int.getInt(weeks*7);

          // An hour is converted to 3600 seconds.
          this.hours = kwargs.get("hours");
          long hours = ((org.python.types.Int)kwargs.get("hours")).value;
          this.hours = org.python.types.Int.getInt(hours*3600);

          // A minute is converted to 60 seconds.
          this.seconds = kwargs.get("seconds");
          long minutes = ((org.python.types.Int)kwargs.get("minutes")).value;
          this.seconds = org.python.types.Int.getInt(minutes*60);

          // A millisecond is converted to 1000 microseconds.
          this.microseconds = kwargs.get("microseconds");
          long microseconds = ((org.python.types.Int)kwargs.get("microseconds")).value;
          this.microseconds = org.python.types.Int.getInt(microseconds*1000);
        }


      /*  for (org.python.Object elem: args){
        System.out.println(elem);
        System.out.println(kwargs.get("year"));
        System.out.println(kwargs.get("month"));*/

        //this.year = new java.util.  //new java.util.LinkedHashMap<org.python.Object, org.python.Object>();

    }
    

    public org.python.types.Str __str__() {
        long dayslong = ((org.python.types.Int)this.days).value;
        String days = Long.toString(dayslong);
        /*while (year.length() < 4) {
            year = "0" + year;
        }*/
        long hours = ((org.python.types.Int)this.hours).value;
       // long seconds = ((org.python.types.Int)this.seconds).value;
        //long microseconds = ((org.python.types.Int)this.microseconds).value;
        String returnStr =  "days: " + days + ", hours: " + hours + ", seconds: " + seconds + ", microseconds: " + microseconds;
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
