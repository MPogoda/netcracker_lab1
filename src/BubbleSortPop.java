package netcracker.lab1;

import org.jetbrains.annotations.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 15/11/11
 * Time: 23:09
 * <p/>
 * Class that implements Bubble sort with greater element popping up.
 *
 * @author Michael Pogoda
 * @version 0.4.2
 */
public class BubbleSortPop extends AbstractSort {
    /**
     * Sort array using bubble sort algorithm with greater element popping up
     *
     * @param array  array to be sorted
     * @param left   left bound
     * @param right  right bound
     * @param <Type> any Comparable<Type> instance
     */
    <Type extends Comparable<Type>>
    void sortHelper(@NotNull final Type[] array, final int left, int right) {
        boolean swapped; // have we changed something?

        do {
            swapped = false;

            Type current = array[left];
            Type next;

            for (int i = left; i < right; ++i) {
                next = array[i + 1];
                if (current.compareTo(next) == 1) {
                    array[i] = next;
                    array[i + 1] = current;
                    swapped = true;
                } else {
                    current = next;
                }
            }
            --right;
        } while (swapped);
    }
}
