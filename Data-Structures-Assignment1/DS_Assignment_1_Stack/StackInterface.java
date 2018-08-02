
public interface StackInterface<GenericType> {
    
    public void push(GenericType value);
    public GenericType pop();
    public void display();
    public GenericType getTop();
    public boolean isEmpty();

}
