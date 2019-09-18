package org.python.stdlib.datetime;

public class DateTime extends org.python.types.Object {
    private org.python.Object year;
    //private org.python.Object month;
    //private org.python.Object day;

    @org.python.Method(
        __doc__ = "",
        args = {"year"}
        //TODO: default_args = {"a", "b"}
    )
    //TODO: add the opptional parametars
    //public DateTime(org.python.Object year, org.python.Object month, org.python.Object day) {
    public DateTime(org.python.Object year) {
        super();
        if (year instanceof org.python.types.Bool) {
            boolean booleanYear = ((org.python.types.Bool) year).value;
            this.year = org.python.types.Int.getInt(booleanYear ? 1 : 0);
        }
        else this.year = year;
        //TODO
        //if datetime.MINYEAR <= year <= datetime.MAXYEAR
    }

    @org.python.Method(
        __doc__ = ""
    )
    //we use this function for testing
    public org.python.Object year() {
        return this.year;
    }
}