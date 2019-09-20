package org.python.stdlib.datetime;

public class DateTime extends org.python.types.Object {
    private org.python.Object year;
    private org.python.Object month;
    private org.python.Object day;

    // @org.python.Method(
    //     __doc__ = "",
    //     default_args = {"year", "month", "day"}
    // )
    //TODO: add the opptional parametars

    public DateTime(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs) {
        super();
        this.year = kwargs.get("year");
        if (this.year != null && args.length > 0) {
            throw new org.python.exceptions.SyntaxError("positional argument follows keyword argument");
        }
        if (this.year == null && args.length > 0) {
            this.year = args[0];
        }
        if (this.year == null) {
            throw new org.python.exceptions.TypeError("Required argument 'year' (pos 1) not found");
        }
        
        this.month = kwargs.get("month");
        if (this.month != null && args.length > 1) {
            throw new org.python.exceptions.SyntaxError("positional argument follows keyword argument");
        }
        if (this.month == null && args.length > 1) {
            this.month = args[1];
        }
        if (this.month == null) {
            throw new org.python.exceptions.TypeError("Required argument 'month' (pos 2) not found");
        }

        this.day = kwargs.get("day");
        if (this.day != null && args.length > 2) {
            throw new org.python.exceptions.SyntaxError("positional argument follows keyword argument");
        }
        if (this.day == null && args.length > 2) {
            this.day = args[2];
        }
        if (this.day == null) {
            throw new org.python.exceptions.TypeError("Required argument 'day' (pos 3) not found");
        }
        //TODO
        //if datetime.MINYEAR <= year <= datetime.MAXYEAR
    }

    public org.python.types.Str __str__() {
        long yearLong = ((org.python.types.Int)this.year).value;
        String year = Long.toString(yearLong);
        while (year.length() < 4) {
            year = "0" + year;
        }
        long month = ((org.python.types.Int)this.month).value;
        long day = ((org.python.types.Int)this.day).value;
        String returnStr = year + "-" + month + "-" + day + " 00:00:00";
        return new org.python.types.Str(returnStr);
    }

    @org.python.Method(
        __doc__ = ""
    )
    //we use this function for testing
    public org.python.Object year() {
        return this.year;
    }
}