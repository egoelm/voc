package org.python.types;


@org.python.Module(
        __doc__ =
                "floor()"
)
public class math extends org.python.types.Module {
    public math() {
        super();
    }

    public static org.python.Object _STRUCT_TM_ITEMS;

    @org.python.Attribute
    public static org.python.Object __file__ = new org.python.types.Str("python/common/python/math.java");
    /*@org.python.Attribute
    public static org.python.Object __loader__ = org.python.types.NoneType.NONE;  // TODO
    @org.python.Attribute
    public static org.python.Object __name__ = new org.python.types.Str("math");
    @org.python.Attribute
    public static org.python.Object __package__ = new org.python.types.Str("");
    @org.python.Attribute
    public static org.python.Object __spec__ = org.python.types.NoneType.NONE;  // TODO
    public static org.python.types.Int altzone;*/



    @org.python.Method(
            __doc__ = "floor(number)\n" +
                    "\n" +
                    "Returns floor(number).  The argument may be\n" +
                    ".\n",
            args = {"num"}
    )

    public static org.python.Object floor(org.python.Object num) {
         //  org.python.types.Float(0);
        if (num instanceof org.python.types.Int)
            {    return(num);}
        if (num instanceof org.python.types.Float)
            { double val =  ((org.python.types.Float) num).value;
             return  new org.python.types.Float(Math.floor(val));
             }
        if (num instanceof org.python.types.Bool)
           {boolean val = ((org.python.types.Bool)num).value;
           return org.python.types.Int.getInt(val ? 1 : 0);
           }
         throw new org.python.exceptions.TypeError("Must be a number, boolean or float");

    }


    @org.python.Method(
         __doc__ = "TODO"
    )
    public static org.python.Object ceil() {
        return org.python.types.Int.getInt(4);
    }
    @org.python.Method(
         __doc__ = "TODO"
    )
    public static org.python.Object fabs() {
        return org.python.types.Int.getInt(4);
    }
    
}
