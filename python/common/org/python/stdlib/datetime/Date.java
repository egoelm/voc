package org.python.stdlib.datetime;

public class Date extends org.python.types.Object {
    private org.python.Object year;
    private org.python.Object month;
    private org.python.Object day;

    private final int MIN_YEAR = 1;

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
            //System.out.println("year = "+ this.year);


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
                if (1d<=((org.python.types.Int)  this.year).value && ((org.python.types.Int)  this.year).value<=9999d ) {
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
                    throw new org.python.exceptions.ValueError("year "+ args[0]+ " is out of range");
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
            System.out.println("hii");
            if (args.length ==2)
            {
                this.year=args[0];
                this.month=args[1];
            }
            System.out.println("----");
            System.out.println("month = "+ this.month);
            System.out.println("yr = "+ this.year);
            System.out.println("----");


            if (kwargs.get("year") != null){
                this.year=kwargs.get("year");
            } else if (args.length>0){
                this.year=args[0];
            }
            System.out.println("yr = "+ this.year);

            if (kwargs.get("month") != null){
                this.month=kwargs.get("month");
            }
            System.out.println("month = "+ this.month);
            if (kwargs.get("day") != null){
                this.day=kwargs.get("day") ;
            }

            System.out.println("day = "+ this.day);



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


    @org.python.Method(
        __doc__ = "returns year"
    )
    public org.python.types.Str year() {
        return new org.python.types.Str(this.year +"");
    }

    @org.python.Method(
        __doc__ = "returns month"
    )
    public org.python.types.Str month() {
        return new org.python.types.Str(this.month +"");
    }

    @org.python.Method(
        __doc__ = "returns day"
    )
    public org.python.types.Str day() {
        return new org.python.types.Str(this.day +"");
    }


    @org.python.Method(
        __doc__ = "DOES nothing right now; will return datetime.date.min == datetime.date(1, 1, 1)"
    )
    public org.python.Object min()  {
        //int i=1;
        //org.python.Object a  = (org.python.Object) i;
        //org.python.Object c =  new Date(a,a,a);
        this.day=org.python.types.NoneType.NONE; //.put(1); //
        this.month= org.python.types.NoneType.NONE;
        this.year= org.python.types.NoneType.NONE;
        return this;
    }
}
