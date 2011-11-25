package netcracker.lab1;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 15/11/11
 * Time: 17:19
 * <p/>
 * Select sort, always O(n^2)
 *
 * @author Michael Pogoda
 * @version 0.3.1
 */
public final class SelectSort extends AbstractSort {
    /**
     * Sort array using selectSort
     *
     * @param <Type> instance of Comparable<Type>
     * @param list   list to be sorted
     * @param left   left bound
     * @param right  right bound
     */
    @Override
    <Type extends Comparable<Type>>
    void sortHelper(@NotNull final ArrayList<Type> list, int left, final int right) {

        final ListIterator<Type> iterator = list.listIterator(left);
        while (iterator.hasNext()) {

            Type min = iterator.next();
            int pos = left;
            // find minimum element after current
            final ListIterator<Type> iterator1 = list.listIterator(iterator.nextIndex());
            while (iterator1.hasNext()) {
                Type a;
                if ((a = iterator1.next()).compareTo(min) == -1) {
                    min = a;
                    pos = iterator1.previousIndex();
                }
            }
            // if there was element smaller than element we was looking for
            if (pos != left) {
                Collections.swap(list, left, pos);
            }
            ++left;
        }
    }
}
