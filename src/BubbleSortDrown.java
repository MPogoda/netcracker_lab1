package netcracker.lab1;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 15/11/11
 * Time: 23:22
 * <p/>
 * BubbleSort. The smaller element is drowning.
 *
 * @author Michael Pogoda
 * @version 0.0.1
 */
public final class BubbleSortDrown extends AbstractSort {
    /**
     * Sort elements in array, located between left&right indices
     * using bubble sort. Smaller element is drowning.
     *
     * @param array array to be sorted
     * @param left  left bound
     * @param right right bound
     */
    @Override
    protected void sortHelper(int[] array, final int left, final int right) {
        boolean swapped;

        do {
            swapped = false;

            for (int i = right; i > left; --i) {
                if (array[i - 1] > array[i]) {
                    final int temp = array[i - 1];
                    array[i - 1] = array[i];
                    array[i] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
}
