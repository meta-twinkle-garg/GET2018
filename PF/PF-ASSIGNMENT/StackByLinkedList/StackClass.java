package stackLinkedList;

public class StackClass {
	final static int invalid = -999999;
    Node top = null;
 
    public boolean empty() {
        return top == null;
    }
 
    public void push(int n) {
        Node p = new Node(n);
        p.next = top;
        top = p;
    } 
 
    public int pop() {
        if (this.empty())
            return invalid; 
        int hold = top.data;
        top = top.next;
        return hold;
    } 
    
    public void display()
    {
        Node tempDisplay = top; 
        while (tempDisplay != null){
            System.out.println(tempDisplay.data);
            tempDisplay = tempDisplay.next;
        }
    }
    
    public int topValue() {
        if (empty())
        {
            System.out.printf("Stack is empty!");
            return invalid;
        }
        else
        {
            return top.data;
        }
    }    
}
