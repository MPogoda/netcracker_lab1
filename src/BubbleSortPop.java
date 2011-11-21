package netcracker.lab1;

/**
 * Created by IntelliJ IDEA.
 * User: mpogoda
 * Date: 15/11/11
 * Time: 23:09
 * <p/>
 * Class that implements Bubble sort with greater element popping up.
 *
 * @author Michael Pogoda
 * @version 0.0.2
 */
public final class BubbleSortPop extends AbstractSort {
    /**
     * Sort elements in array, located between left&right indices
     * using bubble sort. Greater element is popping
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
            for (int i = left; i < right; ++i) {
                if (array[i] > array[i + 1]) {
                    final int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
}
