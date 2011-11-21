package netcracker.lab1;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 15/11/11
 * Time: 17:25
 * <p/>
 * Merge sort. Recursive algorithm.
 *
 * @author Michael Pogoda
 * @version 0.0.5
 */
public final class MergeSort extends AbstractSort {
    /**
     * Merge two sorted arrays in one.
     *
     * @param array  Input&Output array
     * @param left   the left bound of first array
     * @param middle the right bound of first array & the left bound of second array
     * @param right  the right bound of second array
     */
    private void merge(int[] array, final int left, final int middle, final int right) {
        int[] temp = new int[right - left + 1];

        System.arraycopy(array, left, temp, 0, right - left + 1);

        int i = 0;
        int j = middle + 1 - left;
        int k = left;
        while ((i <= (middle - left)) && (j <= (right - left))) {
            if (temp[i] <= temp[j]) {
                array[k++] = temp[i++];
            } else {
                array[k++] = temp[j++];
            }
        }

        while (i <= (middle - left)) {
            array[k++] = temp[i++];
        }
    }

    /**
     * Sort array using Merge sort.
     * Divide array
     *
     * @param array array to be sorted
     * @param left  left bound
     * @param right right bound
     */
    @Override
    void sortHelper(int[] array, final int left, final int right) {
        if (left < right) {
            final int mid = (left + right) >> 1;
            sortHelper(array, left, mid);
            sortHelper(array, mid + 1, right);
            merge(array, left, mid, right);
        }
    }
}
