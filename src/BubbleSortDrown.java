package netcracker.lab1;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 15/11/11
 * Time: 23:22
 * <p/>
 * BubbleSort. The smaller element is drowning.
 *
 * @author Michael Pogoda
 * @version 0.1.1
 */
public final class BubbleSortDrown extends AbstractSort {
    /**
     * Sort elements in list, located between left&right indices
     * using bubble sort. Smaller element is drowning.
     *
     * @param list  list to be sorted
     * @param left  left bound
     * @param right right bound
     */
    @Override
    <Type extends Comparable<Type>>
    void sortHelper(@NotNull final ArrayList<Type> list, int left, final int right) {
        boolean swapped;

        do {
            // have we changed something
            swapped = false;

            // iterator moving right-to-left
            final ListIterator<Type> iterator = list.listIterator(right + 1);
            // current element
            Type current = iterator.previous();
            // element, located to the left
            Type previous;
            for (int i = right; i > left; --i) {
                previous = iterator.previous();
                // if left element greater than right
                if (previous.compareTo(current) == 1) {
                    Collections.swap(list, i - 1, i);
                    swapped = true;
                } else {
                    current = previous;
                }
            }
            ++left;
        } while (swapped);
    }
}
