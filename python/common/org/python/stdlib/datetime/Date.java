package org.python.stdlib.datetime;

public class Date extends org.python.types.Object {
    private org.python.Object year;
    private org.python.Object month;
    private org.python.Object day;

    @org.python.Method(
        __doc__ = ""
    )
    public Date(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs)  { //gets kwargs to get by keyword yr,month

        super();

        if (args.length + kwargs.size() == 3 ) {
            if (args.length ==3){
                //int c=((Integer) args[0]).intValue();
                //double val = ((org.python.types.Int)  args[0]).value;
                //int cc= org.python.types.Int.getInt((int)args[0]);
                if (args[0] instanceof org.python.types.Int && args[1] instanceof org.python.types.Int &&args[2] instanceof org.python.types.Int ){
                if (1d<=((org.python.types.Int)  args[0]).value && ((org.python.types.Int)  args[0]).value<=9999d ) {
                    if (1d <= ((org.python.types.Int) args[1]).value && ((org.python.types.Int) args[1]).value <= 12d) {
                        if (1d <= ((org.python.types.Int) args[2]).value && ((org.python.types.Int) args[2]).value <= 31d) {
                            //TODO check leap year (so max day=29 for month=2),
                            // and correct max no. of days for each month
                            this.year = args[0];
                            this.month = args[1];
                            this.day = args[2];

                            //System.out.println(min<=((Integer) args[0]).intValue());
                        } else {
                            throw new org.python.exceptions.ValueError("day is out of range for month");
                        }
                    } else {
                        throw new org.python.exceptions.ValueError("month must be in 1..12");
                    }
                }else{
                            throw new org.python.exceptions.ValueError("year "+ args[0]+ " is out of range");
                }
            }
            }
            else if (kwargs.size() == 3){

                if (kwargs.get("year") instanceof org.python.types.Int && kwargs.get("month") instanceof org.python.types.Int &&kwargs.get("day") instanceof org.python.types.Int ) {
                    if (1d <= ((org.python.types.Int) kwargs.get("year")).value && ((org.python.types.Int) kwargs.get("year")).value <= 9999d) {
                        if (1d <= ((org.python.types.Int) kwargs.get("month")).value && ((org.python.types.Int) kwargs.get("month")).value <= 12d) {
                            if (1d <= ((org.python.types.Int) args[2]).value && ((org.python.types.Int) args[0]).value <= 31d) {
                                //TODO check leap year (so max day=29 for month=2),
                                // and correct max no. of days for each month
                                this.year = kwargs.get("year");
                                this.month = kwargs.get("month");
                                this.day = kwargs.get("day");


                            } else {

                                throw new org.python.exceptions.ValueError("day is out of range for month");
                            }
                        } else {

                            throw new org.python.exceptions.ValueError("month must be in 1..12");
                        }
                    } else {
                        throw new org.python.exceptions.ValueError("year " + args[0] + " is out of range");
                    }
                }}


           // for (org.python.Object elem : args) {
            //    System.out.println(elem);
            //}
           // System.out.println(kwargs.get("year"));
           // System.out.println(kwargs.get("month"));
        }


    }

    @org.python.Method(
            __doc__ = "Stringifies the object to be printed out"
    )
    public org.python.types.Str __repr__() {

        return new org.python.types.Str(this.year + "-" + this.month + "-" + this.day);
    }
    
    @org.python.Method(
        __doc__ = ""
    )
    //we use this function for testing
    public static org.python.Object constant_4() {
        return org.python.types.Int.getInt(4);
    }
}
