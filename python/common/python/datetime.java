package python;

@org.python.Module(
        __doc__ =
                "TODO"
)
public class datetime extends org.python.types.Module {
    public datetime() {
        super();
    }

    static {
        TimeDelta = org.python.types.Type.pythonType(org.python.stdlib.datetime.TimeDelta.class);
        Date = org.python.types.Type.pythonType(org.python.stdlib.datetime.Date.class);
        DateTime = org.python.types.Type.pythonType(org.python.stdlib.datetime.DateTime.class);
    }

    @org.python.Attribute
    public static org.python.Object TimeDelta;
    public static org.python.Object Date;
    public static org.python.Object TimeDate;

    @org.python.Attribute()
    public static org.python.Object __file__ = new org.python.types.Str("python/common/python/datetime.java");
    @org.python.Attribute
    public static org.python.Object __loader__ = org.python.types.NoneType.NONE;  // TODO
    @org.python.Attribute
    public static org.python.Object __name__ = new org.python.types.Str("datetime");
    @org.python.Attribute
    public static org.python.Object __package__ = new org.python.types.Str("datetime");
    @org.python.Attribute()
    public static org.python.Object __path__;
    @org.python.Attribute
    public static org.python.Object __spec__ = org.python.types.NoneType.NONE;  // TODO
    @org.python.Attribute()
    public static org.python.Object _bootstrap;
    @org.python.Attribute()
    public static org.python.Object _imp;
}
