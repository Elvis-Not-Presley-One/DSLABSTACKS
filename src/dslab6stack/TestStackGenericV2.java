package dslab6stack;

/**
    Programmed by   Stephen Brower
    Inspired by     Michael Main
    Date Written    10/3/2014 - made tester generic
    Date Modified   10/12/2014 - changed to use stacks
    *               3/6/2019 - added extra pop

    Run this program using the following:
        RunTestStackWithCar.java
        RunTestStackWithInteger.java
        RunTestStackWithString.java
 * @param <E>
*/
public class TestStackGenericV2<E> {
    public void test(E[] testDataAdd, E additionalItemToAdd)
    {
        // creates a Stack
        Stack<E> myGenericStack = new Stack<E>();

        // holds an item removed
        E itemRemoved;

        int checkItem = 0;

        // show initial stack size
        displayStackSize("Display Stack Size on startup",myGenericStack, checkItem);

        // add some stuff to the stack
        System.out.println("\n===========\n<<Start Pushes:");
        for (E item : testDataAdd)
        {
            System.out.print("Pushing: " + item);
            myGenericStack.push(item);
            checkItem++;
            System.out.print(" \tpushed...now size is " + myGenericStack.size());
            if (checkItem == myGenericStack.size())
                System.out.println(" -good");
            else
                System.out.println(" no, expected " + checkItem + "\t\t<=== issue");
        }
        System.out.println("Stopped Pushing>>\n===========");

        // show stack size after adds
        displayStackSize("\nDisplay stack size after adds",myGenericStack, checkItem);

        // set index for checking to the end of the testDataAdd array
        checkItem = testDataAdd.length;

        System.out.print("\npop?");

        // remove 1 item
        try
        {
            itemRemoved = myGenericStack.pop();
            checkItem--;
            // display 1 item
            System.out.print("...popped: <" + itemRemoved
                        + "> exp:{" + testDataAdd[checkItem]
                        + "} \tsize: " + myGenericStack.size());
            if (itemRemoved.equals(testDataAdd[checkItem]) && checkItem == myGenericStack.size())
                System.out.println(" -good");
            else
                System.out.println(" exp:"+checkItem+"\t\t<=== issue");
        }
        catch (EmptyStack e)
        {
            System.out.println("Can't pop stack - empty\t\t<=== Issue");
        }


        // show stack size after 1 pop
        displayStackSize("Display stack size after 1 pop",myGenericStack, checkItem);

        // pop all
        System.out.println("\n===========\n<<Start popping:");
        while (myGenericStack.size() > 0)
        {
            System.out.print("pop?");

            // remove 1 item
            try
            {
                itemRemoved = myGenericStack.pop();
                checkItem--;
                // display 1 item
                System.out.print("...popped: <" + itemRemoved
                            + "> exp:{" + testDataAdd[checkItem]
                            + "} \tsize: " + myGenericStack.size());
                if (itemRemoved.equals(testDataAdd[checkItem])  && checkItem == myGenericStack.size())
                    System.out.println(" -good");
                else
                    System.out.println(" exp:"+checkItem+"\t\t<=== issue");
            }
            catch (EmptyStack e)
            {
                System.out.println("Can't pop stack - empty");
            }
        }
        System.out.println("Stopped Popping>>\n===========");

        // show stack size after poping all
        displayStackSize("Display stack size after pop all",myGenericStack, checkItem);

        System.out.print("\nattempt to remove item from empty stack:\npop?");

        try
        {
            itemRemoved = myGenericStack.pop();
            // display 1 item
            System.out.println("...popped: <" + itemRemoved
                        + "> expected EmptyStack Exception"
                        + " \tsize: " + myGenericStack.size()+"\t\t<==issue");
        }
        catch (EmptyStack e)
        {
            System.out.println(" - EmptyStack Exception - Can't pop stack  -good");
        }
        
        // show stack size after 1 additional pop
        displayStackSize("Display stack size after 1 pop",myGenericStack, checkItem);
        
        // push 1 item
        myGenericStack.push(additionalItemToAdd);
        
        // show stack size after 1 additional push
        displayStackSize("Display stack size after 1 additional push",myGenericStack, 1);
        
        System.out.print("\npop the additional item");

        // remove 1 item
        try
        {
            itemRemoved = myGenericStack.pop();
            // display 1 item
            System.out.print("...popped: <" + itemRemoved
                        + "> exp:{" + additionalItemToAdd
                        + "} \tsize: " + myGenericStack.size());
            if (itemRemoved.equals(additionalItemToAdd) && myGenericStack.size() == 0)
                System.out.println(" -good");
            else
                System.out.println(" exp:"+checkItem+"\t\t<=== issue");
        }
        catch (EmptyStack e)
        {
            System.out.println("Can't pop stack - empty\t\t<=== Issue");
        }
        
        // show stack size after 1 additional pop
        displayStackSize("Display stack size after 1 pop",myGenericStack, checkItem);
    }

    /**
        the displayBag method displays the linked bag
        @param heading a String to display before the bag
        @param aBag the LinkedBag<E> to display
    */
    private void displayStackSize(String heading, Stack<E> aStack, int expected)
    {
        System.out.println("\n" + heading);
        System.out.print("Size: " + aStack.size());
        if (expected == aStack.size())
            System.out.println(" -good");
        else
            System.out.println(" exp: " + expected+"\t\t<=== issue");


    }    
}
