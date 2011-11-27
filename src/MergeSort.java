package netcracker.lab1;

import org.jetbrains.annotations.NotNull;

import static java.lang.System.arraycopy;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 15/11/11
 * Time: 17:25
 * <p/>
 * Merge sort. Recursive algorithm.
 *
 * @author Michael Pogoda
 * @version 0.5.5
 */
public class MergeSort extends AbstractSort {
    /**
     * Merge two sorted parts of array in one.
     *
     * @param <Type> instance of Comparable<Type>
     * @param array  array, where this sorted parts are located
     * @param left   the left bound of first part
     * @param middle the right bound of first part & the left bound of second part
     * @param right  the right bound of second part
     */
    @SuppressWarnings({"unchecked"})
    <Type extends Comparable<Type>>
    void merge(@NotNull final Type[] array, final int left, final int middle, final int right) {
        @NotNull final Type[] leftArray = (Type[]) new Comparable[middle - left + 1];
        @NotNull final Type[] rightArray = (Type[]) new Comparable[right - middle];

        arraycopy(array, left, leftArray, 0, middle - left + 1);
        arraycopy(array, middle + 1, rightArray, 0, right - middle);

        int i = 0; // current index of left part
        int j = 0; // current index of right part
        int k = left; // current index in resulting array
        while ((i <= (middle - left)) && (j < (right - middle))) {
            if (leftArray[i].compareTo(rightArray[j]) == -1) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        while (i <= (middle - left)) {
            array[k++] = leftArray[i++];
        }

        while (j < (right - middle)) {
            array[k++] = rightArray[j++];
        }
    }

    /**
     * Sort array using merge sort.
     * Array is divided in two parts, each part is sorted using this method,
     * and then these sorted parted are merged together
     *
     * @param array  array to be sorted
     * @param left   left bound of array
     * @param right  right bound of array
     * @param <Type> any instance of Comparable<Type>
     */
    @Override
    <Type extends Comparable<Type>>
    void sortHelper(@NotNull final Type[] array, final int left, final int right) {
        if (left < right) {
            final int mid = (left + right) >> 1;
            sortHelper(array, left, mid);
            sortHelper(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }
}
