import java.util.ArrayList;
/**
 * Created by Cree on 01/12/2016.
 */
public class SortedArrayList<E extends Comparable<E>> extends ArrayList<E>{

    public boolean add(E e) {
        int insertionPoint = this.searchForInsertionPoint(e);
        if (insertionPoint < 0) {
            return false;
        }
        super.add(insertionPoint, e);
        return true;
    }

    private int searchForInsertionPoint(E element) {
        int closest = 0;
        for (int i = 0; i < this.size(); i++) {
            int comparison = this.get(i).compareTo(element);
            if (comparison > 0) {
                closest = i;
                break;
            }
            closest = i+1;
        }
        return closest;
    }


}
