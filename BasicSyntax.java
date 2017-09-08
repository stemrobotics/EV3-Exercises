public class MyClass()
{
    int              myClassLevelVariable = 1;
    static final int MY_CLASS_CONSTANT = 1;

    /* Comment */

    public void myMethod()
    {
        /*
         comment.
        */

        int              myMethodLevelVariable;
        static final int MY_METHOD_CONSTANT = 2;

        // Comment.

        myMethodLevelVariable = myClassLevelVariable + MY_METHOD_CONSTANT;  // Comment.
    }
}
