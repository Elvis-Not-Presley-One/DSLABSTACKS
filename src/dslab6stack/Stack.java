package dslab6stack;

/**
 *
 * @author Tyler Elvis, Angelo Martino Group 6
 * @param <E>
 */
public class Stack<E> 
{

    private Node<E> top;
    private int numElements;

    /**
     * the Stack Constructor allows for var to be created on inlzation 
     * 
     * Pram top 
     * Pram numElements
     */
    public Stack() 
    {
        top = null;
        numElements = 0;
    }

    /**
     * The push() method pushes an element into the stack 
     * 
     * @param element being added 
     */
    public void push(E element) 
    {
        top = new Node<E>(element, top);
        numElements++;
    }

    /**
     * The pop method removes an element from the stack 
     * 
     * @return the value of the top of the stack 
     * @throws EmptyStack 
     */
    public E pop() throws EmptyStack 
    {
        E returnValue;
        if (top == null) 
        {
            throw new EmptyStack();
        } 
        else 
        {
            returnValue = top.getData();
            top = top.getNext();
            numElements--;
        }
        return returnValue;
    }

    /**
     * The size method gets the size of the stack 
     * 
     * @return the number of elements in the stack 
     */
    public int size() 
    {
        return numElements;
    }

}
