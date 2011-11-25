package netcracker.lab1;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 15/11/11
 * Time: 17:34
 * <p/>
 * Implements quick sort with pivot in them middle of array
 *
 * @author Michael Pogoda
 * @version 0.3.3
 */
public final class QuickSort extends AbstractSort {
    /**
     * Sort list using quickSort
     *
     * @param <Type> Instance of Comparable<Type>
     * @param list   list to be sorted
     * @param left   left bound
     * @param right  right bound
     */
    @Override
    <Type extends Comparable<Type>>
    void sortHelper(@NotNull final ArrayList<Type> list, final int left, final int right) {

        final ListIterator<Type> leftIterator = list.listIterator(left);
        final ListIterator<Type> rightIterator = list.listIterator(right + 1);
        int i = left;
        int j = right;
        final Type mid = list.get((right + left) >> 1);

        while (i <= j) {
            while (leftIterator.next().compareTo(mid) == -1) ++i;
            while (rightIterator.previous().compareTo(mid) == 1) --j;
            if (i <= j) {
                Collections.swap(list, i++, j--);
            }
        }

        if (left < (i - 1)) {
            sortHelper(list, left, i - 1);
        }
        if (i < right) {
            sortHelper(list, i, right);
        }
    }
}
