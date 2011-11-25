package netcracker.lab1;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.ListIterator;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 15/11/11
 * Time: 23:09
 * <p/>
 * Class that implements Bubble sort with greater element popping up.
 *
 * @author Michael Pogoda
 * @version 0.1.2
 */
public final class BubbleSortPop extends AbstractSort {
    /**
     * Sort elements in list, located between left&right indices
     * using bubble sort. Greater element is popping
     *
     * @param list  list to be sorted
     * @param left  left bound
     * @param right right bound
     */
    @Override
    <Type extends Comparable<Type>>
    void sortHelper(@NotNull final ArrayList<Type> list, final int left, int right) {
        boolean swapped;

        do {
            swapped = false;

            final ListIterator<Type> iterator = list.listIterator(left);
            Type current = iterator.next();
            Type next;

            for (int i = left; i < right; ++i) {
                next = iterator.next();
                if (current.compareTo(next) == 1) {
                    Collections.swap(list, i, i + 1);
                    swapped = true;
                } else {
                    current = next;
                }
            }
            --right; // we don't have to look @ this element cause it's on its place
        } while (swapped);
    }
}
