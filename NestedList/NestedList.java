
import java.util.List;

/**
 * Class nestedList is the implementation of nested list of integers. Following
 * operations are performed on nested list 1 sum of all elements 2 find largest
 * value from list 3 search element
 *
 * @author Twinkle Garg
 *
 */
public class NestedList implements NestedListInterface {

    private final List<List<Integer>> nestedList;

    /**
     * constructor initializes nested list
     * @param nestedList
     */
    public NestedList(List<List<Integer>> nestedList) {
        this.nestedList = nestedList;
    }

    /**
     * This method returns sum of all elements of nested list
     * @return sum
     */
    @Override
    public int getSum() {

        if (nestedList.isEmpty()) {
            throw new AssertionError("Empty list");
        }
        int sum = 0;
        for (int count = 0; count < nestedList.size(); count++) {
            for (int count2 = 0; count2 < nestedList.get(count).size(); count2++) {
                sum += nestedList.get(count).get(count2);
            }
        }
        return sum;
    }

    /**
     * This method returns largest value from nested list
     * @return largest value
     */
    @Override
    public int getLargestValue() {
        int maximum = nestedList.get(0).get(1);
        for (int count = 0; count < nestedList.size(); count++) {
            for (int count2 = 0; count2 < nestedList.get(count).size(); count2++) {
                if (nestedList.get(count).get(count2) > maximum) {
                    maximum = nestedList.get(count).get(count2);
                }
            }
        }
        return maximum;
    }

    /**
     * This method searches for a given value in nested list
     * @param value
     * @return true if present else false
     */
    @Override
    public boolean searchValue(int value) {

        for (int count = 0; count < nestedList.size(); count++) {
            for (int count2 = 0; count2 < nestedList.get(count).size(); count2++) {
                if (value == nestedList.get(count).get(count2)) {
                    return true;
                }
            }
        }
        return false;
    }

}
