package netcracker.lab1;

import org.jetbrains.annotations.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 15/11/11
 * Time: 23:22
 * <p/>
 * BubbleSort. The smaller element is drowning.
 *
 * @author Michael Pogoda
 * @version 0.4.1
 */
public class BubbleSortDrown extends AbstractSort {

    /**
     * Static implementation of bubble sort algorithm
     * Sort elements in array, located between left&right indices
     * using bubble sort. Smaller element is drowning.
     *
     * @param <Type> any Comparable<Type> instance
     * @param array  array to be sorted
     * @param left   left bound
     * @param right  right bound
     */
    @Override
    <Type extends Comparable<Type>>
    void sortHelper(@NotNull final Type[] array, int left, final int right) {
        boolean swapped;

        do {
            swapped = false; // have changed something in array?
            Type current = array[right];
            Type previous;

            for (int i = right; i > left; --i) {
                previous = array[i - 1];
                if (previous.compareTo(current) == 1) {
                    array[i - 1] = current;
                    array[i] = previous;
                    swapped = true;
                } else {
                    current = previous;
                }
            }
            ++left;
        } while (swapped);
    }
}
