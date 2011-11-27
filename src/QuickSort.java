package netcracker.lab1;

import org.jetbrains.annotations.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 15/11/11
 * Time: 17:34
 * <p/>
 * Implements quick sort with pivot in them middle of array
 *
 * @author Michael Pogoda
 * @version 0.4.3
 */
public final class QuickSort extends AbstractSort {

    /**
     * Simply implementation of quicksort.
     * Divide array in two parts: one with elements less than pivot and
     * one with elements greater that it
     *
     * @param array  array to be sorted
     * @param left   left bound
     * @param right  right bound
     * @param <Type> any instance of Comparable<Type>
     */
    @Override
    <Type extends Comparable<Type>>
    void sortHelper(@NotNull final Type[] array, final int left, final int right) {
        int i = left;
        int j = right;
        final Type mid = array[(right + left) >> 1];

        while (i <= j) {
            while (array[i].compareTo(mid) == -1) ++i;
            while (array[j].compareTo(mid) == 1) --j;
            if (i <= j) {
                final Type temp = array[j];
                array[j--] = array[i];
                array[i++] = temp;
            }
        }

        if (left < (i - 1)) {
            sortHelper(array, left, i - 1);
        }
        if (i < right) {
            sortHelper(array, i, right);
        }

    }
}