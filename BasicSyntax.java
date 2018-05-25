public class MyClass()
{
    public int              myClassLevelVariable = 1;
    public final int        MY_CLASS_CONSTANT = 1;

    /* Comment */

    public void myMethod()
    {
        /*
         comment.
        */

        private int         myMethodLevelVariable;
        private final int   MY_METHOD_CONSTANT = 2;

        // Comment.

        myMethodLevelVariable = myClassLevelVariable + MY_METHOD_CONSTANT;  // Comment.
    }
}
