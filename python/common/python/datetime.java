package python;

@org.python.Module(
        __doc__ =
                "TODO"
)
public class datetime extends org.python.types.Module {
    public datetime() {
        super();
    }

@org.python.Method(
         __doc__ = "TODO",
         args = {"time"}
    )
    public static org.python.Object timeDelta(org.python.Object time) {
        
            return time
        }
        
@org.python.Method(
         __doc__ = "TODO",
         args = {"time"}
    )
    public static org.python.Object date(org.python.Object time) {
        
            return time
        }

@org.python.Method(
         __doc__ = "TODO",
         args = {"time"}
    )
    public static org.python.Object dateTime(org.python.Object time) {
        
            return time
        }