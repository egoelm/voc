package org.python.stdlib.datetime;

import java.time.LocalTime;
import java.util.Collections;

import org.python.Object;

public class Date extends org.python.types.Object {
    //private org.python.Object year;
    //private org.python.Object month;
    //private org.python.Object day;

    @org.python.Attribute
    public org.python.Object year= __year__();

    @org.python.Attribute
    public org.python.Object month= __month__();

    @org.python.Attribute
    public org.python.Object day= __day__(); //= org.python.types.Int.getInt(-999999999);

    @org.python.Attribute
    public static final org.python.Object min = __min__();

    @org.python.Attribute
    public static final org.python.Object max = __max__();

    @org.python.Attribute
    public static org.python.Object resolution = __resolution__();

    @org.python.Method(
        __doc__ = ""
    )
    public Date(org.python.Object[] args, java.util.Map<java.lang.String, org.python.Object> kwargs)  { //gets kwargs to get by keyword yr,month

        super();

        if (args.length + kwargs.size() > 3 ) {
            int val = args.length + kwargs.size();
            throw new org.python.exceptions.TypeError("function takes at most 3 arguments (" + val + " given)");
        }

        if (args.length + kwargs.size() == 3 ) {
            if (kwargs.get("year") != null && args.length==2){
                throw new org.python.exceptions.SyntaxError("positional argument follows keyword argument");
            } else if (kwargs.get("month") != null && args.length==2){
                throw new org.python.exceptions.SyntaxError("positional argument follows keyword argument");
                //this would pass: dt.date(day=1,1,1) how to check position of kwarg?
            }
            if (kwargs.get("year") != null){
                this.year=kwargs.get("year");
            } else{
                this.year=args[0];
            }

            //System.out.println("==========");
            //System.out.println("year = "+ this.year);
            //System.out.println("==========");

            if (kwargs.get("month") != null){
                this.month=kwargs.get("month");
            } else{
                this.month=args[1];
            }
            //System.out.println("month = "+ this.month);

            if (kwargs.get("day") != null){
                this.day=kwargs.get("day");
            } else{
                this.day=args[2];
            }
            //System.out.println("day = "+ this.day);


            if ((this.year instanceof org.python.types.Int ) && //||this.year instanceof org.python.types.Bool
                (this.month instanceof org.python.types.Int) && //||this.month instanceof org.python.types.Bool
                (this.day instanceof org.python.types.Int )){ //||this.day instanceof org.python.types.Bool
                //if (this.year instanceof org.python.types.Bool){this.year=(Integer)1;}
                //System.out.println("=====here=====");
                if (1<=((org.python.types.Int)  this.year).value && ((org.python.types.Int)  this.year).value<=9999 ) {

                    if (1d <= ((org.python.types.Int) this.month).value && ((org.python.types.Int) this.month).value <= 12d) {
                        if (1d <= ((org.python.types.Int) this.day).value && ((org.python.types.Int) this.day).value <= 31d) {
                            //TODO check leap year (so max day=29 for month=2),
                            // and correct max no. of days for each month

                        } else {
                            throw new org.python.exceptions.ValueError("day is out of range for month");
                        }
                    } else {
                        throw new org.python.exceptions.ValueError("month must be in 1..12");
                    }
                }else{
                    //System.out.println("=====h YEA__R ere=====");
                    throw new org.python.exceptions.ValueError("year "+ this.year+ " is out of range");
                }
            }else{
                if (!(this.year instanceof org.python.types.Int )){
                    throw new org.python.exceptions.TypeError("integer argument expected, got "+ this.year.typeName());
                }
                if (!(this.month instanceof org.python.types.Int )){
                    throw new org.python.exceptions.TypeError("integer argument expected, got "+ this.month.typeName());
                }
                if (!(this.day instanceof org.python.types.Int )){
                    throw new org.python.exceptions.TypeError("integer argument expected, got "+ this.day.typeName());
                }

            }

        }

        if (args.length + kwargs.size() == 2 ) {
            //System.out.println("hii");
            if (args.length ==2)
            {
                this.year=args[0];
                this.month=args[1];
            }
            //System.out.println("----");
            //System.out.println("month = "+ this.month);
            //System.out.println("yr = "+ this.year);
            //System.out.println("----");


            if (kwargs.get("year") != null){
                this.year=kwargs.get("year");
            } else if (args.length>0){
                this.year=args[0];
            }
            //System.out.println("yr = "+ this.year);

            if (kwargs.get("month") != null){
                this.month=kwargs.get("month");
            }
            //System.out.println("month = "+ this.month);
            if (kwargs.get("day") != null){
                this.day=kwargs.get("day") ;
            }

            //System.out.println("day = "+ this.day);



            if (! (this.year instanceof org.python.types.Int) && this.year !=null ){
                throw new org.python.exceptions.TypeError("integer argument expected, got "+ this.year.typeName());
            }

            if (kwargs.get("year")!=null && args.length>0){
                throw new org.python.exceptions.SyntaxError("positional argument follows keyword argument");
            }

            if (! (this.month instanceof org.python.types.Int) && this.month !=null ){
                throw new org.python.exceptions.TypeError("integer argument expected, got "+ this.month.typeName());
            }

            if (kwargs.get("year")!=null && kwargs.get("day")!=null){
                throw new org.python.exceptions.TypeError("function missing required argument 'month' (pos 2)");
            }
            if (kwargs.get("year")!=null && kwargs.get("month")!=null){
                throw new org.python.exceptions.TypeError("function missing required argument 'day' (pos 3)");
            }



        }

        if (args.length + kwargs.size() == 1 ) {
            if (kwargs.get("year") != null){
                this.year=kwargs.get("year");
            } else if (args.length>0){
                this.year=args[0];
            }
            //dt.date(10000) does not complain >9999, just says month is missing;
            //dt.date(99992, month=13) also doesn;t complaing about bounds

            if (kwargs.get("month") != null){
                this.month=kwargs.get("month");
            }

            if (kwargs.get("day") != null){
                this.day=kwargs.get("day") ;
            }

            if (!(this.year instanceof org.python.types.Int) && this.year !=null){
                throw new org.python.exceptions.TypeError("integer argument expected, got "+ this.year.typeName());

            }
            if (this.year!=null){
                throw new org.python.exceptions.TypeError("function missing required argument 'month' (pos 2)");

            }
            if (this.month!=null || this.day!=null){
                throw new org.python.exceptions.TypeError("function missing required argument 'year' (pos 1)");
            }

            //throw new org.python.exceptions.TypeError("function missing required argument 'day' (pos 3)");
            //System.out.println("0=" +args[0]);
            //System.out.println("  1= "+args[1]);

        }

    }

    @org.python.Method(
        __doc__ = "Stringifies the object to be printed out"
    )
    public org.python.types.Str __repr__(){
        
        String year = this.year + "";
        while (year.length() < 4)
            year = "0" + year;

        String month = this.month + "";
        while (month.length() < 2)
            month = "0" + month;

        String day = this.day + "";
        while (day.length() < 2)
            day = "0" + day;

        return new org.python.types.Str(year + "-" + month + "-" + day);
    }

    @org.python.Method(
        __doc__ = ""
    )
    //we use this function for testing
    public static org.python.Object constant_4() {
        return org.python.types.Int.getInt(4);
    }



    @org.python.Method(
        __doc__ = "returns year"
    )
    public org.python.types.Str __year__() {
        return new org.python.types.Str(this.year +"");
    }

    @org.python.Method(
        __doc__ = "returns month"
    )
    public org.python.types.Str __month__() {
        return new org.python.types.Str(this.month +"");
    }

    @org.python.Method(
        __doc__ = "returns day"
    )
    public org.python.types.Str __day__() {
        return new org.python.types.Str(this.day +"");
    }


    @org.python.Method(
        __doc__ = "DOES nothing right now; will return datetime.date.min == datetime.date(1, 1, 1)"
    )
    private static org.python.Object __min__()  {

        org.python.types.Int day= org.python.types.Int.getInt(1);
        org.python.types.Int month= org.python.types.Int.getInt(1);
        org.python.types.Int year= org.python.types.Int.getInt(1);

        org.python.Object[] args = {year, month, day};
        return new Date(args, Collections.emptyMap());

    }

    @org.python.Method(
        __doc__ = "DOES nothing right now; will return datetime.date.max == datetime.date(9999, 12, 31)"
    )
    private static org.python.Object __max__()  {
        
        org.python.types.Int day= org.python.types.Int.getInt(31);
        org.python.types.Int month= org.python.types.Int.getInt(12);
        org.python.types.Int year= org.python.types.Int.getInt(9999);

        org.python.Object[] args = {year, month, day};
        return new Date(args, Collections.emptyMap());

    }

    @org.python.Method(
        __doc__ = "DOES NOT WORK The smallest possible differens between non-equal date objects, will return datetime.date.resolution == datetime.timedelta(days=1)"
    )
    private static org.python.Object __resolution__()  {
        org.python.Object[] args = {org.python.types.Int.getInt(1)};
        return new TimeDelta(args, Collections.emptyMap());

    }

    @org.python.Method(
        __doc__ = "Implementation of dates class function today()" + 
                  "which returns todays date on the form yyyy-mm-dd"
    )
    public static org.python.Object today(){
        java.time.LocalDateTime today = java.time.LocalDateTime.now();
        int y  = today.getYear();
        int m = today.getMonthValue();
        int d   =  today.getDayOfMonth();

        org.python.Object[] args = {org.python.types.Int.getInt(y), org.python.types.Int.getInt(m), org.python.types.Int.getInt(d)};
        return new Date(args, Collections.emptyMap());
    }
    @org.python.Method(
        __doc__ = "Implementation of date´s instance function ctime() "
    )
    public org.python.Object ctime(){

        String[] monthList = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        double monthNum = ((org.python.types.Int)this.month).value;
        String monthStr = monthList[(int)monthNum-1];
        
        String[] weekdayList = {"Mon","Tue","Wed","Thu","Fri","Sat","Sun"};
        double weekdayNum = ((org.python.types.Int)weekday()).value;
        String weekdayStr = weekdayList[(int)weekdayNum];

        return new org.python.types.Str(weekdayStr + " " + monthStr + "  " + this.day + " 00:00:00 " + this.year);
    }


    @org.python.Method(
        __doc__ = "Implementation of date´s instance function weekday()" + 
                  "which returns an int representing the weekday of a " + 
                  "date specified in date object on the form: Monday = 0," + 
                  "Tuesday = 1, Wednesday = 2, Thursday = 3, Friday = 4," +
                  "Saturday = 5 and Sunday = 6"
    )
    public org.python.Object weekday(){
        double y = ((org.python.types.Int) this.year).value;
        double m = ((org.python.types.Int) this.month).value;
        double d = ((org.python.types.Int) this.day).value;

        java.util.Date myCalendar = new java.util.GregorianCalendar((int)y, (int)m-1, (int)d).getTime();
        java.util.Calendar c = java.util.Calendar.getInstance();
        c.setTime(myCalendar);
        int day  = c.get(java.util.Calendar.DAY_OF_WEEK);
        int[] convertToPython = {6,0,1,2,3,4,5};
        return org.python.types.Int.getInt(convertToPython[day-1]);

    }
}
