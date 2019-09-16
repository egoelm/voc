package python;

@org.python.Module(
        __doc__ =
                "TODO"
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
    public static org.python.Object __name__ = new org.python.types.Str("time");
    @org.python.Attribute
    public static org.python.Object __package__ = new org.python.types.Str("");
    @org.python.Attribute
    public static org.python.Object __spec__ = org.python.types.NoneType.NONE;  // TODO
    public static org.python.types.Int altzone;*/


    @org.python.Method(
         __doc__ = "",
         args ={"number"}
    )
    public static org.python.Object floor(org.python.Object number) {
        if (number instanceof org.python.types.Int){
            return(number);
        }
        if (number instanceof org.python.types.Float) {
            double val = ((org.python.types.Float) number).value;
            return org.python.types.Int.getInt((int)Math.floor(val));
        }
        if (number instanceof org.python.types.Bool) {
            boolean val = ((org.python.types.Bool) number).value;
            return org.python.types.Int.getInt(val ? 1 : 0);
        }
        throw new org.python.exceptions.TypeError("must be real number, not "+ number.typeName());

    }

    @org.python.Method(
         __doc__ = "math.ceil(number) -> number" + 
                   "\n" +
                   "Return the cealing of number as float, " + 
                   "the smallest integer value greater than or equal to number.\n",
         args = {"number"}
    )
    public static org.python.Object ceil(org.python.Object number) {
        if (number instanceof org.python.types.Int){
            return(number);
        }
        if (number instanceof org.python.types.Float) {
            double val = ((org.python.types.Float) number).value; 
            return org.python.types.Int.getInt((int)Math.ceil(val));
        } 
        if (number instanceof org.python.types.Bool) {
            boolean val = ((org.python.types.Bool) number).value;
            return org.python.types.Int.getInt(val ? 1 : 0);
        }
        throw new org.python.exceptions.TypeError("must be real number, not "+ number.typeName());

    }

    @org.python.Method(
         __doc__ = "TODO",

         args = {"number"}
    )
    public static org.python.Object fabs(org.python.Object number) {
      if(number instanceof org.python.types.Float){
        double val = ((org.python.types.Float) number).value;
        ((org.python.types.Float) number).value = Math.abs(val);
        return number;
      }
      else if(number instanceof org.python.types.Int){
        long val = ((org.python.types.Int) number).value;
        ((org.python.types.Int) number).value = Math.abs(val);
        return number;
      }
      else{
        throw new org.python.exceptions.TypeError("Must be real number, not "+ number.typeName());
      }
    }

}
