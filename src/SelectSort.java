package netcracker.lab1;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 15/11/11
 * Time: 17:19
 * <p/>
 * Select sort, always O(n^2)
 *
 * @author Michael Pogoda
 * @version 0.0.1
 */
public final class SelectSort extends AbstractSort {
    /**
     * Sort array using selectSort
     *
     * @param array array to be sorted
     * @param left  left bound
     * @param right right bound
     */
    @Override
    protected void sortHelper(int[] array, final int left, final int right) {
        for (int i = left; i < right; ++i) {
            int min = array[i];
            int pos = i;
            // find minimum element after current
            for (int j = i + 1; j <= right; ++j) {
                if (array[j] < min) {
                    min = array[j];
                    pos = j;
                }
            }
            // if there was element smaller than element we was looking for
            if (pos != i) {
                array[pos] = array[i];
                array[i] = min;
            }
        }
    }
}
