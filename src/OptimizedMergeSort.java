package netcracker.lab1;

import org.jetbrains.annotations.NotNull;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 25/11/11
 * Time: 14:31
 * </p>
 * <p/>
 * Better implementation of MergeSort. Small array are sorted using BubbleSortPop
 *
 * @author Michael Pogoda
 * @version 0.1.5
 */
public class OptimizedMergeSort extends MergeSort {
    private final static int ARRAY_SIZE_FOR_BUBBLE = 25;

    /**
     * Sort array using optimized version of merge sort.
     * If array is smaller than ARRAY_SIZE_FOR_BUBBLE is sorted using bubble sort,
     * else it's sorted using original merge sort
     *
     * @param array  array to be sorted
     * @param left   left bound of array
     * @param right  right bound of array
     * @param <Type> any instance of Comparable<Type>
     */
    @Override
    <Type extends Comparable<Type>>
    void sortHelper(@NotNull final Type[] array, final int left, final int right) {
        if ((right - left) < ARRAY_SIZE_FOR_BUBBLE) {
            (new BubbleSortPop()).sortHelper(array, left, right);
        } else if (left < right) {
            final int mid = (left + right) >> 1;
            sortHelper(array, left, mid);
            sortHelper(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }
}
