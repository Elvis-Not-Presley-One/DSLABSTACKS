package dslab6stack;

/**
 * EmptyStack exception for Stack
 * NOTE: Java has a built-in exception for Java's built-in Stack
 *       https://docs.oracle.com/javase/7/docs/api/java/util/EmptyStackException.html
 * But since we are using our own Stack, we will use our own exception
 * @author Stephen T. Brower<stephen.brower@raritanval.edu>
 * updated by Linda Yang
 */
public class EmptyStack  extends Exception
{
   /**
    *  No-arg constructor
    */
   public EmptyStack()
   {
      super("Error: Stack is empty. cannot pop stack");
   }
}
