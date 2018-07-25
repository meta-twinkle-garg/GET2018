package AbstractDataTypeIntSet;

public interface IntegerSet {
public boolean isMember(int x);
public int size();
public boolean isSubSet(IntSet s);
public IntSet complement();
public IntSet union(IntSet s1,IntSet s2);
}
