package netcracker.lab1;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 15/11/11
 * Time: 17:34
 * <p/>
 * Implements quick sort with pivot in them middle of array
 *
 * @author Michael Pogoda
 * @version 0.0.3
 */
public final class QuickSort extends AbstractSort {
    /**
     * Sort array using quickSort
     *
     * @param array array to be sorted
     * @param left  left bound
     * @param right right bound
     */
    @Override
    void sortHelper(int[] array, final int left, final int right) {
        int i = left;
        int j = right;
        int mid = array[(right + left) >> 1];

        while (i <= j) {
            while (array[i] < mid) ++i;
            while (array[j] > mid) --j;
            if (i <= j) {
                final int temp = array[j];
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
