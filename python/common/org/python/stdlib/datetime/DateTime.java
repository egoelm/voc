package org.python.stdlib.datetime;

public class DateTime extends org.python.types.Object {
    private final int YEAR_INDEX = 0;
    private final int MONTH_INDEX = 1;
    private final int DAY_INDEX = 2;
    private final int HOUR_INDEX = 3;
    private final int MINUTE_INDEX = 4;
    private final int SECOND_INDEX = 5;
    private final int MICROSECOND_INDEX = 6;
    
    private final int MIN_YEAR = 1;
    private final int MAX_YEAR = 9999;    

    private Long[] timeUnits = new Long[7];

    // @org.python.Method(
    //     __doc__ = "",
    //     default_args = {"year", "month", "day"}
    // )
    //TODO: add the opptional parametars

    public DateTime(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs) {
        super();
        String[] keys = {"year", "month", "day", "hour", "minute", "second", "microsecond"};
        boolean kwargsIsUsed = false;
        int keyIndex = 0;
        int argIndex = 0;

        for (String key : keys) {
            if (kwargs.get(key) != null) {
                this.timeUnits[keyIndex] = ((org.python.types.Int)kwargs.get(key)).value;
                kwargsIsUsed = true;
            }
            else if (args.length > argIndex) {
                if (kwargsIsUsed) throw new org.python.exceptions.SyntaxError("positional argument follows keyword argument, hellloooooo");
                this.timeUnits[keyIndex] = ((org.python.types.Int)args[argIndex]).value;
                argIndex++;
            }
            else if (keyIndex < 3) {
                throw new org.python.exceptions.TypeError("Required argument '" + keys[keyIndex] + "' (pos " + (keyIndex+1) + ") not found");
            }
            keyIndex++;
        }

        if (this.timeUnits[YEAR_INDEX] < MIN_YEAR || this.timeUnits[YEAR_INDEX] > MAX_YEAR) {
            throw new org.python.exceptions.ValueError("year " + this.timeUnits[YEAR_INDEX] + "is out of range");
        }

        if (this.timeUnits[MONTH_INDEX] < 1 || this.timeUnits[MONTH_INDEX] > 12) {
            throw new org.python.exceptions.ValueError("month " + this.timeUnits[MONTH_INDEX] + "is out of range");
        }
        // TODO 31 should be replaced with number of days in the given month and year
        if (this.timeUnits[DAY_INDEX] < 1 || this.timeUnits[DAY_INDEX] > 31) {
            throw new org.python.exceptions.ValueError("day " + this.timeUnits[DAY_INDEX] + "is out of range");
        }
        
        if (this.timeUnits[HOUR_INDEX] < 0 || this.timeUnits[HOUR_INDEX] > 24) {
            throw new org.python.exceptions.ValueError("hour " + this.timeUnits[HOUR_INDEX] + "is out of range");
        }

        if (this.timeUnits[MINUTE_INDEX] < 0 || this.timeUnits[MINUTE_INDEX] > 60) {
            throw new org.python.exceptions.ValueError("minute " + this.timeUnits[MINUTE_INDEX] + "is out of range");
        }

        if (this.timeUnits[SECOND_INDEX] < 0 || this.timeUnits[SECOND_INDEX] > 60) {
            throw new org.python.exceptions.ValueError("second " + this.timeUnits[SECOND_INDEX] + "is out of range");
        }

        if (this.timeUnits[MICROSECOND_INDEX] < 0 || this.timeUnits[MICROSECOND_INDEX] > 1000000) {
            throw new org.python.exceptions.ValueError("microsecond " + this.timeUnits[MICROSECOND_INDEX] + "is out of range");
        }
    }

    public org.python.types.Str __str__() {
        String year = Long.toString(this.timeUnits[YEAR_INDEX]);
        while (year.length() < 4) year = "0" + year;

        String month = Long.toString(this.timeUnits[MONTH_INDEX]);
        while (month.length() < 2) month = "0" + month;

        String day = Long.toString(this.timeUnits[DAY_INDEX]);
        while (day.length() < 2) day = "0" + day;

        String hour = this.timeUnits[HOUR_INDEX] != 0 ? Long.toString(this.timeUnits[HOUR_INDEX]) : "00";
        while (hour.length() < 2) hour = "0" + hour;

        String minute = this.timeUnits[MINUTE_INDEX] != 0 ? Long.toString(this.timeUnits[MINUTE_INDEX]) : "00";
        while (minute.length() < 2) minute = "0" + minute;

        String second = this.timeUnits[SECOND_INDEX] != 0 ? Long.toString(this.timeUnits[SECOND_INDEX]) : "00";
        while (second.length() < 2) second = "0" + second;

        String microsecond = this.timeUnits[MICROSECOND_INDEX] != 0 ? Long.toString(this.timeUnits[MICROSECOND_INDEX]) : "";
        while (microsecond.length() < 6 && microsecond.length() != 0) microsecond = "0" + microsecond;
        
        String returnStr = year + "-" + month + "-" + day + " " + hour + ":" + minute + ":" + second;

        returnStr += microsecond.length() > 0 ? "." + microsecond : "";
        return new org.python.types.Str(returnStr);
    }
}